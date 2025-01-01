package com.bank.transfer.history.application.usecases.impl;

import com.bank.transfer.history.application.usecases.CreateAccountUsecase;
import com.bank.transfer.history.domain.AccountDomain;
import com.bank.transfer.history.infrastructure.gateways.AccountRepositoryGateway;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateAccountUsecaseImpl implements CreateAccountUsecase {

    private final AccountRepositoryGateway accountRepositoryGateway;

    public CreateAccountUsecaseImpl(AccountRepositoryGateway accountRepositoryGateway) {
        this.accountRepositoryGateway = accountRepositoryGateway;
    }

    @Override
    public AccountDomain execute(String cardNumber, BigDecimal balance) {
        return accountRepositoryGateway.salvar(AccountDomain
                .builder()
                .number(cardNumber)
                .balance(balance)
                .build());
    }
}
