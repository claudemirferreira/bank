package com.bank.transfer.history.infrastructure.controller;

import com.bank.transfer.history.application.excerption.InsufficientFoundsException;
import com.bank.transfer.history.infrastructure.enums.TransactionErrorsEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {

    private final View error;

    public RequestExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler(InsufficientFoundsException.class)
    public ResponseEntity<Object> handleHttpMessageInsufficientFounds(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, TransactionErrorsEnum.INSUFFICIENT_FOUNDS.getKey(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

}
