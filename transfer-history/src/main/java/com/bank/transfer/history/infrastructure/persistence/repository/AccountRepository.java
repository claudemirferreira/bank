package com.bank.transfer.history.infrastructure.persistence.repository;

import com.bank.transfer.history.infrastructure.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
    Optional<AccountEntity> findByNumber(String number);
}
