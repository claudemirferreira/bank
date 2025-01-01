package com.bank.transfer_amount.infrastructure.controller.dto.request;

import java.math.BigDecimal;

public record AccountTransfeRequest(
        String numberOrigin,
        String numberDestination,
        BigDecimal amount,
        String description
) {
}
