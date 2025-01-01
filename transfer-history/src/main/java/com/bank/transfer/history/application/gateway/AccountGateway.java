package com.bank.transfer.history.application.gateway;

import com.bank.transfer.history.domain.AccountDomain;

public interface AccountGateway {
    AccountDomain findByNumber(String number);
    AccountDomain salvar(AccountDomain accountDomain);
}
