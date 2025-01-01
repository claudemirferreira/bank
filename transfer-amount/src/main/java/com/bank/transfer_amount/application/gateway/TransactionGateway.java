package com.bank.transfer_amount.application.gateway;

import com.bank.transfer_amount.domain.TransactionDomain;

public interface TransactionGateway {
    TransactionDomain save(TransactionDomain transactionDomain);
}
