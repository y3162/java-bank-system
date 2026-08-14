package com.example.bank.service;

import static org.junit.Assert.assertEquals;

import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.InMemoryAccountRepository;

import org.junit.jupiter.api.Test;

public class BankServiceTest {
    @Test
    void openingAccount() {
        AccountRepository repository = new InMemoryAccountRepository();
        BankService service = new BankService(repository);

        String accountId0 = service.openAccount();
        String accountId1 = service.openAccount();
        assertEquals("000-000-000", accountId0);
        assertEquals("000-000-001", accountId1);
    }

    @Test
    void transferingFound() {
        AccountRepository repository = new InMemoryAccountRepository();
        BankService service = new BankService(repository);

        String accountId0 = service.openAccount();
        String accountId1 = service.openAccount();

        service.deposit(accountId0, 1000);
        service.deposit(accountId1, 1000);
        service.transfer(accountId0, accountId1, 300);
        assertEquals(700, service.getBalance(accountId0));
        assertEquals(1300, service.getBalance(accountId1));
    }
}
