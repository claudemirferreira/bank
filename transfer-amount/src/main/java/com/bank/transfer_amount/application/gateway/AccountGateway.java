package com.bank.transfer_amount.application.gateway;


import com.bank.transfer_amount.domain.AccountDomain;

public interface AccountGateway {
    AccountDomain findByNumber(String number);
    AccountDomain salvar(AccountDomain accountDomain);
}
