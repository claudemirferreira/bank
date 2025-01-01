package com.bank.transfer_amount.infrastructure.controller.dto.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionCreateRequest(
        String accountNumberOrigin,
        String accountNumberDestination,
        BigDecimal transactionAmount,
        String description,
        OffsetDateTime dateOperation) {
}
