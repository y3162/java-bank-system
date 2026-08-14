package com.example.bank.model;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.bank.exception.InsufficientFundsException;

public class AccountTest {
    @Test
    void accountInitializedWithZeroBalance() {
        Account account = new Account("0001");

        assertEquals("0001", account.getAccountId());
        assertEquals(0, account.getBalance());
    }

    @Test
    void deposit() {
        Account account = new Account("0001");
        account.deposit(1000);

        assertEquals(1000, account.getBalance());
    }

    @Test
    void withDraw() {
        Account account = new Account("0001");
        account.deposit(1000);
        
        account.withdraw(500);
        assertEquals(500, account.getBalance());

        assertThrows(
            InsufficientFundsException.class,
            () -> account.withdraw(1000)
        );
    }
}
