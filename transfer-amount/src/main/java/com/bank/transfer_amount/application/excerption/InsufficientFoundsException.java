package com.bank.transfer_amount.application.excerption;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InsufficientFoundsException extends ResponseStatusException {

    public InsufficientFoundsException(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }

}
