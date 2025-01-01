package com.bank.transfer.history.domain;

import com.bank.transfer.history.infrastructure.enums.TipoOperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDomain {

    private UUID id;
    private AccountDomain accountDomainOrigin;
    private AccountDomain accountDomainDestination;
    private String description;
    private OffsetDateTime lastModifiedAt;
    private BigDecimal value;
    private TipoOperacaoEnum tipoOperacao;

}
