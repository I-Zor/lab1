package se.nackademin.java20.lab1.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account = new Account();

    @Test
    public void balanceShouldBeZeroWhenNewAccountIsMade (){

        double expected = 0;
        double actual = account.getCurrentBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void balanceShouldBe100whenDeposit (){

        double expected = 100;
        double actual = account.deposit(100);

        assertEquals(expected, actual);
    }

    @Test
    public void balanceShouldBe50WhenWithdraw (){

        double expected = 50;
        account.deposit(100);
        double actual = account.withdraw(50);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowErrorWhenWithdrawBiggerThanBalance (){

        account.deposit(100);

        assertThrows(IllegalStateException.class, () ->
                account.withdraw(200));
    }

}