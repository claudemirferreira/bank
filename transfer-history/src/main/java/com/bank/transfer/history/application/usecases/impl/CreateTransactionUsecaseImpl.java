package com.bank.transfer.history.application.usecases.impl;

import com.bank.transfer.history.application.gateway.AccountGateway;
import com.bank.transfer.history.application.gateway.TransactionGateway;
import com.bank.transfer.history.application.usecases.CreateTransactionUsecase;
import com.bank.transfer.history.domain.AccountDomain;
import com.bank.transfer.history.domain.TransactionDomain;
import com.bank.transfer.history.infrastructure.enums.TipoOperacaoEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class CreateTransactionUsecaseImpl implements CreateTransactionUsecase {

    private final TransactionGateway transactionGateway;
    private final AccountGateway accountGateway;

    public CreateTransactionUsecaseImpl(TransactionGateway transactionGateway, AccountGateway accountGateway) {
        this.transactionGateway = transactionGateway;
        this.accountGateway = accountGateway;
    }


    @Override
    public TransactionDomain execute(String accountNumberOrigin,
                                     String accountNumberdestination,
                                     BigDecimal transactionAmount,
                                     String description,
                                     OffsetDateTime dateOperation) {
        AccountDomain origin = accountGateway.findByNumber(accountNumberOrigin);
        AccountDomain destiantion = accountGateway.findByNumber(accountNumberdestination);

        TransactionDomain transactionDomainOrigem = TransactionDomain
                .builder()
                .description(description)
                .value(transactionAmount)
                .accountDomainOrigin(origin)
                .accountDomainDestination(destiantion)
                .lastModifiedAt(dateOperation)
                .tipoOperacao(TipoOperacaoEnum.CREDIT)
                .build();
        this.transactionGateway.save(transactionDomainOrigem);

        TransactionDomain transactionDomainDestiantion = TransactionDomain
                .builder()
                .description(description)
                .value(transactionAmount)
                .accountDomainOrigin(destiantion)
                .accountDomainDestination(origin)
                .lastModifiedAt(dateOperation)
                .tipoOperacao(TipoOperacaoEnum.DEBIT)
                .build();
        this.transactionGateway.save(transactionDomainDestiantion);

        return transactionDomainOrigem;
    }


}
