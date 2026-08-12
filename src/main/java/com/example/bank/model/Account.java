package com.example.bank.model;

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
}
