package se.nackademin.java20.lab1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    User user = new User("Sara", "830208");
    Account account;

    @BeforeEach
    public void newAccount(){
        account = new Account(12345, user);
    }
   

    @Test
    public void checkCurrentBalanceWhenOpenAccount(){
        assertEquals(account.getCurrentBalance(), 0);
    }
    
    @Test
    public void testDeposit(){
        account.deposit(100);
        assertEquals(account.getCurrentBalance(), 100);
    }

    @Test
    public void testWithdraw(){
        account.deposit(100);
        account.withdraw(50);
        assertEquals(account.getCurrentBalance(), 50);
    }

    @Test
    public void withdrawLargerThenBalance(){
        account.deposit(100);
        assertThrows(IllegalStateException.class, () -> account.withdraw(200));
    }

}