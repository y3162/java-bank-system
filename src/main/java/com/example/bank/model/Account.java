package com.example.bank.model;

import com.example.bank.exception.InsufficientFundsException;

public class Account {
    private final String accountId;
    private long balance;

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public long getBalance() {
        return this.balance;
    }

    public void withdraw(long amount) {
        if (this.balance < amount) {
            throw new InsufficientFundsException();
        }
        this.balance -= amount;
    }

    public void deposit(long amount) {
        this.balance += amount;
    }
}
