package com.bank.transfer_amount.application.usecases.impl;


import com.bank.transfer_amount.application.excerption.InsufficientFoundsException;
import com.bank.transfer_amount.application.gateway.AccountGateway;
import com.bank.transfer_amount.application.usecases.CreateTransferUsecase;
import com.bank.transfer_amount.domain.AccountDomain;
import com.bank.transfer_amount.domain.TransactionDomain;
import com.bank.transfer_amount.infrastructure.enums.TipoOperacaoEnum;
import com.bank.transfer_amount.infrastructure.enums.TransactionErrorsEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class CreateTransferUsecaseImpl implements CreateTransferUsecase {

    private final AccountGateway accountGateway;

    public CreateTransferUsecaseImpl(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }


    @Override
    @Transactional
    public TransactionDomain execute(String numberOrigin,
                                     String numberDestination,
                                     BigDecimal amount,
                                     String description) {
        AccountDomain origin = accountGateway.findByNumber(numberOrigin);
        AccountDomain destiantion = accountGateway.findByNumber(numberDestination);

        origin.setBalance(subtractBalance(origin.getBalance(), amount));
        destiantion.setBalance(destiantion.getBalance().add(amount));

        accountGateway.salvar(destiantion);
        accountGateway.salvar(origin);

        return TransactionDomain.
                builder()
                .value(amount)
                .lastModifiedAt(OffsetDateTime.now())
                .tipoOperacao(TipoOperacaoEnum.DEBIT)
                .accountDomainOrigin(origin)
                .accountDomainDestination(destiantion)
                .description(description)
                .build();
    }

    private BigDecimal subtractBalance(final BigDecimal cardBalance, final BigDecimal transactionAmount) {
        return Optional.of(cardBalance.subtract(transactionAmount))
                .filter(balance -> balance.compareTo(BigDecimal.ZERO) >= 0)
                .orElseThrow(() -> new InsufficientFoundsException(TransactionErrorsEnum.INSUFFICIENT_FOUNDS.getKey()));
    }


}
