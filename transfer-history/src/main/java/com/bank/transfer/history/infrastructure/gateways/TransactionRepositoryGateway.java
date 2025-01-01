package com.bank.transfer.history.infrastructure.gateways;

import com.bank.transfer.history.application.gateway.TransactionGateway;
import com.bank.transfer.history.domain.TransactionDomain;
import com.bank.transfer.history.infrastructure.persistence.entity.TransactionEntity;
import com.bank.transfer.history.infrastructure.persistence.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryGateway implements TransactionGateway {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionRepositoryGateway(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionDomain save(TransactionDomain transactionDomain) {
        var transactionSaved = transactionRepository.save(modelMapper.map(transactionDomain, TransactionEntity.class));
        return modelMapper.map(transactionSaved, TransactionDomain.class);
    }

}
