package com.example.bank.repository;

import com.example.bank.model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InMemoryAccountRepositoryTest {
    @Test
    void addAndFind() {
        Account account = new Account("0001");
        AccountRepository repository = new InMemoryAccountRepository();
        repository.addAccount(account);

        Account foundAccound = repository.findAccountById("0001");
        assertEquals(account, foundAccound);
    }
}
