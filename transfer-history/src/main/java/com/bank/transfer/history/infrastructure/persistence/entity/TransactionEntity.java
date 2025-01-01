package com.bank.transfer.history.infrastructure.persistence.entity;

import com.bank.transfer.history.infrastructure.enums.TipoOperacaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
@Entity
public class TransactionEntity {
    @Id
    @UuidGenerator
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account_origin")
    private AccountEntity accountOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account_destination")
    private AccountEntity accountDestination;

    @Column(name = "last_modified_at")
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @Column(name="value",  columnDefinition="decimal", precision=15, scale=2)
    private BigDecimal value;

    @Enumerated(EnumType.STRING) // Ou EnumType.ORDINAL
    @Column(nullable = false)
    private TipoOperacaoEnum tipoOperacao;
}
