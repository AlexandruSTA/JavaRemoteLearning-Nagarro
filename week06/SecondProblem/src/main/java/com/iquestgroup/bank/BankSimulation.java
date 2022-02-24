package com.iquestgroup.bank;

public class BankSimulation {

    public static void main(String[] args) {
        Account account = new Account("George", 1L, 100);

        account.withdraw(10, 0.2f);
        // The current value of balance is 89.8
        System.out.println("Your balance: " + account.getBalance());

        account.withdraw(10, 0.2f);
        // The current value of balance should be 79.6
        /*
        Squeezing infinitely many real numbers into a finite number of bits requires an approximate representation.
        Although there are infinitely many integers, in most programs the result of integer computations can be stored in 32 bits.

        In contrast, given any fixed number of bits, most calculations with real numbers will produce quantities that cannot be exactly represented using that many bits.
        Therefore the result of a floating-point calculation must often be rounded in order to fit back into its finite representation.
        This rounding error is the characteristic feature of floating-point computation.

        Source: https://stackoverflow.com/questions/16627813/why-is-comparing-floats-inconsistent-in-java
         */
        System.out.println("Your balance: " + account.getBalance());
    }
}
