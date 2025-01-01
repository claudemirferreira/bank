package com.bank.transfer_amount.application.usecases;


import com.bank.transfer_amount.domain.AccountDomain;

import java.math.BigDecimal;

public interface CreateAccountUsecase {

    AccountDomain execute(String accountNumber,
                          BigDecimal balance);
}
