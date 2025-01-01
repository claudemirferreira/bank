package com.bank.transfer.history.infrastructure.controller.dto.request;

import java.math.BigDecimal;

public record AccountCreateRequest(
        String number,
        BigDecimal balance) {
}
