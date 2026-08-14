package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;

public class BankService {
    private final AccountRepository repository;

    public BankService(AccountRepository repository) {
        this.repository = repository;
    }

    public String openAccount() {
        int repositorySize = this.repository.getSize();
        int millions = repositorySize / 1000 / 1000 % 1000;
        int thousands = repositorySize / 1000 % 1000;
        int ones = repositorySize % 1000;
        String accountId = String.format(
            "%03d-%03d-%03d",
            millions,
            thousands,
            ones
        );

        Account account = new Account(accountId);
        this.repository.addAccount(account);

        return accountId;
    }

    public long getBalance(String AccountId) {
        Account account = this.repository.findAccountById(AccountId);
        return account.getBalance();
    }

    public void withdraw(String accountId, long amount) {
        Account account = this.repository.findAccountById(accountId);
        account.withdraw(amount);
    }

    public void deposit(String accountId, long amount) {
        Account account = this.repository.findAccountById(accountId);
        account.deposit(amount);
    }

    public void transfer(String fromAccountId, String toAccountId, long amount) {
        Account fromAccount = this.repository.findAccountById(fromAccountId);
        Account toAccount = this.repository.findAccountById(toAccountId);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
