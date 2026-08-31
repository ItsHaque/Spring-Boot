package com.antar.Spring_Boot_Journey;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServices {
    private final AccountRepository repository;
    public AccountServices(AccountRepository repository){
        this.repository =repository;
    }

    public AccountRequest createAccount(AccountRequest account){
        repository.save(account);
        return account;
    }

    public List<AccountRequest> getAllAccounts(){
        return repository.findAll();
    }

    public AccountRequest getAccount(int accountNumber){
        return repository.findByAccountNumber(accountNumber);
    }
}
