package com.antar.Spring_Boot_Journey;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountServices services;

    public AccountController(AccountServices services){
        this.services =services;
    }

    @PostMapping("/accounts")
    public AccountRequest create(@RequestBody AccountRequest account){
        return services.createAccount(account);
    }

    @GetMapping("/accounts")
    public List<AccountRequest> getAllAccount(){
        return services.getAllAccounts();
    }

    @GetMapping("/accounts/{accountNumber}")
    public AccountRequest getAccount(@PathVariable int accountNumber){
        return services.getAccount(accountNumber);
    }
}
