package Concurrency4.BankersAlghorithmToPreventDeadLock;

import java.util.Arrays;

public class BankingSimulation {
    public static void main(String[] args) throws InterruptedException {
        int[] available = {3, 3, 2};  
        int[][] maximum = {
            {7, 5, 3},
            {3, 2, 2},
            {9, 0, 2},
            {2, 2, 2},
            {4, 3, 3}
        };

        Bank bank = new Bank(available, maximum);
        Customer[] customers = new Customer[maximum.length];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(i, bank);
            customers[i].start();
        }

        for (Customer c : customers) {
            c.join();
        }

        System.out.println("All done. Bank ends with cash: " 
                           + Arrays.toString(bank.getNeed(0))); 
        // (or directly print bank.available if you expose it)
    }
}
