package com.bank.transfer.history.application.usecases;

import com.bank.transfer.history.domain.AccountDomain;

import java.math.BigDecimal;

public interface CreateAccountUsecase {

    AccountDomain execute(String accountNumber,
                          BigDecimal balance);
}
