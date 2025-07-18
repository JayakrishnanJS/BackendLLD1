package Concurrency4.BankersAlghorithmToPreventDeadLock;

import java.util.Random;

public class Customer extends Thread {
    private final int id;
    private final Bank bank;
    private final Random rand = new Random();

    public Customer(int id, Bank bank) {
        this.id   = id;
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int[] currentNeed = bank.getNeed(id);
                int[] req = new int[currentNeed.length];
                for (int j = 0; j < req.length; j++) {
                    req[j] = rand.nextInt(currentNeed[j] + 1);
                }

                if (bank.requestLoan(id, req)) {
                    // Check if fully satisfied
                    boolean done = true;
                    for (int x : bank.getNeed(id)) {
                        if (x != 0) { done = false; break; }
                    }
                    if (done) {
                        Thread.sleep(300);      // simulate final work
                        bank.releaseAll(id);
                        System.out.printf("Customer %d DONE%n", id);
                        return;
                    }
                }
                Thread.sleep(300 + rand.nextInt(300)); // back off & retry
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
