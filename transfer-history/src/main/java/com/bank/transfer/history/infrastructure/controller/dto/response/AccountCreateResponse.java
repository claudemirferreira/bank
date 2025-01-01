package com.bank.transfer.history.infrastructure.controller.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountCreateResponse(
        UUID id,
        String number,
        BigDecimal balance) {
}
