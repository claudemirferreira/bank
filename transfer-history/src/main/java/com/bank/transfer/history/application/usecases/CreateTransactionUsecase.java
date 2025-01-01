package com.bank.transfer.history.application.usecases;

import com.bank.transfer.history.domain.TransactionDomain;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface CreateTransactionUsecase {

    TransactionDomain execute(String accountNumberOrigin,
                              String accountNumberdestination,
                              BigDecimal transactionAmount,
                              String description,
                              OffsetDateTime dateOperation);
}
