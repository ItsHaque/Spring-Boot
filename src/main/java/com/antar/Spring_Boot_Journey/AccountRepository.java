package com.antar.Spring_Boot_Journey;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {
    private List<AccountRequest> accountList = new ArrayList<AccountRequest>();
    public AccountRepository() {}

    public void save(AccountRequest account){
        accountList.add(account);
    }

    public List<AccountRequest> findAll(){
        return accountList;
    }

    public AccountRequest findByAccountNumber(int accountNumber){
        for(int i=0; i<accountList.size(); ++i){
            if(accountList.get(i).getAccountNumber() == accountNumber)
                return accountList.get(i);
        }
        return new AccountRequest(-1,-1);//indicating no account exists with given account number.
    }
}
