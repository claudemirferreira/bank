package com.bank.transfer_amount.infrastructure.gateways;

import com.bank.transfer_amount.application.gateway.TransactionGateway;
import com.bank.transfer_amount.domain.TransactionDomain;
import com.bank.transfer_amount.infrastructure.persistence.entity.TransactionEntity;
import com.bank.transfer_amount.infrastructure.persistence.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryGateway implements TransactionGateway {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionRepositoryGateway(
            TransactionRepository transactionRepository,
            ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionDomain save(TransactionDomain transactionDomain) {
        var transactionSaved = this.transactionRepository.save(modelMapper.map(transactionDomain, TransactionEntity.class));
        return modelMapper.map(transactionSaved, TransactionDomain.class);
    }

}
