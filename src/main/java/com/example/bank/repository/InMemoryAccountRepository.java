package com.example.bank.repository;

import com.example.bank.model.Account;
import com.example.bank.exception.AccountAlreadyExistsException;
import com.example.bank.exception.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
    private final Map<String, Account> accountMap;

    public InMemoryAccountRepository() {
        accountMap = new HashMap<>();
    }

    @Override
    public void addAccount(Account account) {
        String accountId = account.getAccountId();
        if (accountMap.containsKey(accountId)) {
            throw new AccountAlreadyExistsException();
        }
        accountMap.put(accountId, account);
    }

    @Override
    public Account findAccountById(String accountId) {
        Account account = accountMap.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public int getSize() {
        return this.accountMap.size();
    }
}
