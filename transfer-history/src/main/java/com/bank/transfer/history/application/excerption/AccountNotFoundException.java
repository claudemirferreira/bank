package com.bank.transfer.history.application.excerption;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AccountNotFoundException extends ResponseStatusException {

    public AccountNotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }

}