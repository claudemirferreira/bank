package com.bank.transfer_amount.infrastructure.persistence.repository;

import com.bank.transfer_amount.infrastructure.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID> {
}
