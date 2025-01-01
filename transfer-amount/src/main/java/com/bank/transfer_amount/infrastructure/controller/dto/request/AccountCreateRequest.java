package com.bank.transfer_amount.infrastructure.controller.dto.request;

import java.math.BigDecimal;

public record AccountCreateRequest(
        String number,
        BigDecimal balance
) {
}
