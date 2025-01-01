package com.bank.transfer.history.infrastructure.controller.dto.response;

import com.bank.transfer.history.domain.AccountDomain;
import com.bank.transfer.history.infrastructure.enums.TipoOperacaoEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TransactionCreateResponse(
        UUID id,
        AccountDomain accountDomainOrigin,
        AccountDomain accountDomainDestination,
        String description,
        OffsetDateTime lastModifiedAt,
        BigDecimal value,
        TipoOperacaoEnum tipoOperacao) {
}
