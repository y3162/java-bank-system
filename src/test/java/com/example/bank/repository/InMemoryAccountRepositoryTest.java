package com.example.bank.repository;

import com.example.bank.exception.AccountAlreadyExistsException;
import com.example.bank.exception.AccountNotFoundException;
import com.example.bank.model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    void addedAccount() {
        Account account1 = new Account("0001");
        Account account2 = new Account("0001");
        AccountRepository repository = new InMemoryAccountRepository();
        repository.addAccount(account1);

        assertThrows(
            AccountAlreadyExistsException.class,
            () -> repository.addAccount(account2)
        );
    }

    @Test
    void nonExistentAccount() {
        Account account = new Account("0001");
        AccountRepository repository = new InMemoryAccountRepository();
        repository.addAccount(account);

        assertThrows(
            AccountNotFoundException.class,
            () -> repository.findAccountById("0002")
        );
    }
}
