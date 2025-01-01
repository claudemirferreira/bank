package com.bank.transfer.history.infrastructure.controller;

import com.bank.transfer.history.application.usecases.CreateAccountUsecase;
import com.bank.transfer.history.infrastructure.controller.dto.request.AccountCreateRequest;
import com.bank.transfer.history.infrastructure.controller.dto.response.AccountCreateResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final CreateAccountUsecase createAccountUsecase;

    public AccountController(CreateAccountUsecase createAccountUsecase) {
        this.createAccountUsecase = createAccountUsecase;
    }

    @PostMapping
    public ResponseEntity<AccountCreateResponse> createCard(@Valid @RequestBody final AccountCreateRequest request) {
        final var newCard = createAccountUsecase.execute(request.number(), request.balance());
        return ResponseEntity.created(URI.create("/account/" + newCard.getNumber())).body(new AccountCreateResponse(
                newCard.getId(), newCard.getNumber(), newCard.getBalance()
        ));
    }

}
