package Concurrency4.BankersAlghorithmToPreventDeadLock;

import java.util.Arrays;

public class BankingSimulation {
    public static void main(String[] args) throws InterruptedException {
        /*  In our Banker’s Algorithm simulation, we treat each resource type as a separate “cash” pool
            is simply an array literal of length 3. You can think of it as a 3-coordinate “vector” that tells the Bank
            how much of each cash/resource type it has on hand:
            available[0] = 3 → there are 3 units of resource 0
            available[1] = 3 → there are 3 units of resource 1
            available[2] = 2 → there are 2 units of resource 2
            In our bank-loan analogy those three slots might represent three denominations or categories of cash
            (say, $1, $5 and $10 bills), or simply three different resource classes
        */
        int[] available = {3, 3, 2};
        int[][] maximum   = {
                {7, 5, 3},
                {3, 2, 2},
                {9, 0, 2},
                {2, 2, 2},
                {4, 3, 3}
        };
        int[][] allocation = {
                {0, 1, 0},
                {2, 0, 0},
                {3, 0, 2},
                {2, 1, 1},
                {0, 0, 2}
        };

        Bank bank = new Bank(available, maximum, allocation);
        Customer[] customers = new Customer[maximum.length];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(i, bank);
            customers[i].start();
        }
        for (Customer c : customers) {
            c.join();
        }

        System.out.println("All done. Final bank cash: "
                + Arrays.toString(bank.getAvailable()));
    }
}
