package com.antar.Spring_Boot_Journey;

public class AccountRequest {
    private int accountNumber;
    private double balance;

    public AccountRequest(){}

    public AccountRequest(int accountNumber, double balance) {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
