package com.iquestgroup.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AccountTest {
    private static Account account;

    @BeforeAll
    static void setup() {
        account = new Account("Owner", 123L, 12.5F);
    }

    @Test
    void negativeDeposit() {
        boolean negativeDepositResult = account.deposit(-100.0F);
        Assertions.assertEquals(false, negativeDepositResult);
    }

    @Test
    void deposit() {
        boolean depositResult = account.deposit(100.0F);
        Assertions.assertEquals(true, depositResult);
    }

    @Test
    void withdrawWithBothAmountAndFeePositiveAndPositiveBalance() {
        boolean withdrawResult = account.withdraw(10.0F, 1.0F);
        Assertions.assertEquals(true, withdrawResult);
    }

    @Test
    void withdrawWithBothAmountAndFeePositiveAndNegativeBalance() {
        boolean withdrawResult = account.withdraw(100.0F, 1.0F);
        Assertions.assertEquals(false, withdrawResult);
    }

    @Test
    void withdrawWithAmountPositiveAndFeeNegative() {
        boolean withdrawResult = account.withdraw(100.0F, -1.0F);
        Assertions.assertEquals(false, withdrawResult);
    }

    @Test
    void withdrawWithAmountNegativeAndFeePositive() {
        boolean withdrawResult = account.withdraw(-100.0F, 1.0F);
        Assertions.assertEquals(false, withdrawResult);
    }

    @Test
    void withdrawWithBothAmountAndFeeNegative() {
        boolean withdrawResult = account.withdraw(-100.0F, -1.0F);
        Assertions.assertEquals(false, withdrawResult);
    }

    @Test
    void addInterest() {
        float accountBalanceBeforeAddingTheInterest = account.getBalance();
        account.addInterest();
        Assertions.assertTrue(accountBalanceBeforeAddingTheInterest < account.getBalance());
    }

    @Test
    void verifyAccountNumber() {
        Assertions.assertEquals(123L, account.getAccountNumber());
    }
}
