package com.bank.transfer_amount.infrastructure.gateways;


import com.bank.transfer_amount.application.excerption.AccountNotFoundException;
import com.bank.transfer_amount.application.gateway.AccountGateway;
import com.bank.transfer_amount.domain.AccountDomain;
import com.bank.transfer_amount.infrastructure.persistence.entity.AccountEntity;
import com.bank.transfer_amount.infrastructure.persistence.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AccountRepositoryGateway implements AccountGateway {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountRepositoryGateway(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDomain findByNumber(String number) {
        var entity = accountRepository.findByNumber(number).orElseThrow(() -> new AccountNotFoundException("..."));
        return modelMapper.map(entity, AccountDomain.class);
    }

    @Override
    public AccountDomain salvar(AccountDomain accountDomain) {
        var entity = modelMapper.map(accountDomain, AccountEntity.class);
        accountRepository.save(entity);
        return modelMapper.map(entity, AccountDomain.class);
    }

}
