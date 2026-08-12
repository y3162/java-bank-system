package com.example.bank.repository;

import com.example.bank.model.Account;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<String, Account> accountMap;

    public InMemoryAccountRepository() {
        accountMap = new HashMap<String, Account>();
    }

    @Override
    public void addAccount(Account account) {
        String accountId = account.getAccountId();
        accountMap.put(accountId, account);
    }

    @Override
    public Account findAccountById(String accountId) {
        Account account = accountMap.get(accountId);
        return account;
    }
}
