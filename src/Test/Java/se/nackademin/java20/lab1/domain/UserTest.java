package se.nackademin.java20.lab1.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

    User user = new User("Sara", "830208");

    @Test
    void addAccount() {
        user.addAccount(new Account(12345,user));
        assertEquals(user.getAccounts().size(), 1);
        assertEquals(user.getAccounts().get(0).getAccountNumber(), 12345);
    }
}