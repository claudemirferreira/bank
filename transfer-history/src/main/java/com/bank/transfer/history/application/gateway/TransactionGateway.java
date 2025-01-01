package com.bank.transfer.history.application.gateway;

import com.bank.transfer.history.domain.TransactionDomain;

public interface TransactionGateway {
    TransactionDomain save(TransactionDomain transactionDomain);
}
