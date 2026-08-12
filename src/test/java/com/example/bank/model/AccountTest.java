package com.example.bank.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void accountInitializedWithZeroBalance() {
        Account account = new Account("0001");

        assertEquals("0001", account.getAccountId());
        assertEquals(0, account.getBalance());
    }
}
