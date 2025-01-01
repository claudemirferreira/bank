package com.bank.transfer_amount.infrastructure.controller;

import com.bank.transfer_amount.application.usecases.CreateAccountUsecase;
import com.bank.transfer_amount.application.usecases.CreateTransferUsecase;
import com.bank.transfer_amount.infrastructure.controller.dto.request.AccountCreateRequest;
import com.bank.transfer_amount.infrastructure.controller.dto.request.AccountTransfeRequest;
import com.bank.transfer_amount.infrastructure.controller.dto.response.AccountCreateResponse;
import com.bank.transfer_amount.infrastructure.controller.dto.response.TransactionCreateResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final CreateAccountUsecase createAccountUsecase;
    private final CreateTransferUsecase createTransferUsecase;

    public AccountController(CreateAccountUsecase createAccountUsecase, CreateTransferUsecase createTransferUsecase) {
        this.createAccountUsecase = createAccountUsecase;
        this.createTransferUsecase = createTransferUsecase;
    }

    @PostMapping
    public ResponseEntity<AccountCreateResponse> create(@Valid @RequestBody final AccountCreateRequest request) {
        final var newCard = createAccountUsecase.execute(request.number(), request.balance());
        return ResponseEntity.created(URI.create("/account/" + newCard.getNumber())).body(new AccountCreateResponse(newCard.getId(), newCard.getNumber(), newCard.getBalance()));
    }

    @PutMapping(value = "/transfer")
    public ResponseEntity<TransactionCreateResponse> transfer(@Valid @RequestBody final AccountTransfeRequest request) {
        final var newTransaction = createTransferUsecase.execute(request.numberOrigin(), request.numberDestination(), request.amount(), request.description()

        );
        return ResponseEntity.created(URI.create("/account/" + newTransaction.getId())).body(new TransactionCreateResponse(newTransaction.getAccountDomainOrigin(), newTransaction.getAccountDomainDestination(), newTransaction.getDescription(), newTransaction.getLastModifiedAt(), newTransaction.getValue(), newTransaction.getTipoOperacao()));
    }

}
