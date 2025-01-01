package com.bank.transfer.history.infrastructure.controller;

import com.bank.transfer.history.application.usecases.CreateTransactionUsecase;
import com.bank.transfer.history.infrastructure.controller.dto.request.TransactionCreateRequest;
import com.bank.transfer.history.infrastructure.controller.dto.response.TransactionCreateResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final CreateTransactionUsecase createTransactionUsecase;

    public TransactionController(CreateTransactionUsecase createTransactionUsecase) {
        this.createTransactionUsecase = createTransactionUsecase;
    }

    @PostMapping
    public ResponseEntity<TransactionCreateResponse> create(@Valid @RequestBody final TransactionCreateRequest request) {
        final var newTransactionDomain = createTransactionUsecase.execute(
                request.accountNumberOrigin(),
                request.accountNumberDestination(),
                request.transactionAmount(),
                request.description(),
                request.dateOperation()
        );

        return ResponseEntity.created(URI.create("/transaction/" + newTransactionDomain.getId())).body(
                new TransactionCreateResponse(
                        newTransactionDomain.getId(),
                        newTransactionDomain.getAccountDomainOrigin(),
                        newTransactionDomain.getAccountDomainDestination(),
                        newTransactionDomain.getDescription(),
                        newTransactionDomain.getLastModifiedAt(),
                        newTransactionDomain.getValue(),
                        newTransactionDomain.getTipoOperacao()
                ));
    }

}
