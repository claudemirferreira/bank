package com.bank.transfer_amount.infrastructure.controller.dto.response;


import com.bank.transfer_amount.domain.AccountDomain;
import com.bank.transfer_amount.infrastructure.enums.TipoOperacaoEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionCreateResponse(
        AccountDomain accountDomainOrigin,
        AccountDomain accountDomainDestination,
        String description,
        OffsetDateTime lastModifiedAt,
        BigDecimal value,
        TipoOperacaoEnum tipoOperacao) {
}
