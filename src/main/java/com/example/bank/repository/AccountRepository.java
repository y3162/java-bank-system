package com.example.bank.repository;

import com.example.bank.model.Account;

public interface AccountRepository {
    void addAccount(Account account);
    Account findAccountById(String accountId);
    int getSize();
}
