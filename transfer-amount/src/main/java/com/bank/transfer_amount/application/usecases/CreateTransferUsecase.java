package com.bank.transfer_amount.application.usecases;

import com.bank.transfer_amount.domain.TransactionDomain;

import java.math.BigDecimal;

public interface CreateTransferUsecase {

    TransactionDomain execute(String numberOrigin,
                              String numberDestination,
                              BigDecimal amount,
                              String description);
}
