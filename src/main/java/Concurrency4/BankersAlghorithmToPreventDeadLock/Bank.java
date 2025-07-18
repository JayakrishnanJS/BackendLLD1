package Concurrency4.BankersAlghorithmToPreventDeadLock;

import java.util.Arrays;

public class Bank {
    private final int PROCESS_COUNT;
    private final int RESOURCE_COUNT;
    private int[] available;    // Cash on hand
    private int[][] maximum;    // Credit limit per customer
    private int[][] allocation; // What each customer has borrowed
    private int[][] need;       // Remaining credit need

    public Bank(int[] available, int[][] maximum) {
        this.PROCESS_COUNT  = maximum.length;
        this.RESOURCE_COUNT = available.length;
        this.available      = Arrays.copyOf(available, RESOURCE_COUNT);
        this.maximum        = new int[PROCESS_COUNT][RESOURCE_COUNT];
        this.allocation     = new int[PROCESS_COUNT][RESOURCE_COUNT];
        this.need           = new int[PROCESS_COUNT][RESOURCE_COUNT];

        for (int i = 0; i < PROCESS_COUNT; i++) {
            System.arraycopy(maximum[i], 0, this.maximum[i], 0, RESOURCE_COUNT);
            Arrays.fill(this.allocation[i], 0);
            System.arraycopy(maximum[i], 0, this.need[i], 0, RESOURCE_COUNT);
        }
    }

    public synchronized boolean requestLoan(int customerId, int[] request) {
        System.out.printf("Customer %d requests %s | Available: %s | Need: %s%n",
                customerId,
                Arrays.toString(request),
                Arrays.toString(available),
                Arrays.toString(need[customerId])
        );

        // Quick check
        for (int j = 0; j < RESOURCE_COUNT; j++) {
            if (request[j] > need[customerId][j] || request[j] > available[j]) {
                System.out.println(" → DENIED (exceeds need or bank cash)");
                return false;
            }
        }

        // Tentative allocate
        for (int j = 0; j < RESOURCE_COUNT; j++) {
            available[j]      -= request[j];
            allocation[customerId][j] += request[j];
            need[customerId][j]      -= request[j];
        }

        // Safety check
        if (isSafe()) {
            System.out.println(" → GRANTED");
            return true;
        }

        // Rollback
        for (int j = 0; j < RESOURCE_COUNT; j++) {
            available[j]      += request[j];
            allocation[customerId][j] -= request[j];
            need[customerId][j]      += request[j];
        }
        System.out.println(" → DENIED (unsafe state)");
        return false;
    }

    public synchronized void releaseAll(int customerId) {
        System.out.printf("Customer %d repays %s → ",
                customerId, Arrays.toString(allocation[customerId]));
        for (int j = 0; j < RESOURCE_COUNT; j++) {
            available[j] += allocation[customerId][j];
            allocation[customerId][j] = 0;
        }
        System.out.printf("Bank cash now %s%n", Arrays.toString(available));
    }

    private boolean isSafe() {
        int[] work      = Arrays.copyOf(available, RESOURCE_COUNT);
        boolean[] finish = new boolean[PROCESS_COUNT];
        int doneCount   = 0;

        while (doneCount < PROCESS_COUNT) {
            boolean progressed = false;
            for (int i = 0; i < PROCESS_COUNT; i++) {
                if (!finish[i]) {
                    boolean canFinish = true;
                    for (int j = 0; j < RESOURCE_COUNT; j++) {
                        if (need[i][j] > work[j]) {
                            canFinish = false;
                            break;
                        }
                    }
                    if (canFinish) {
                        for (int j = 0; j < RESOURCE_COUNT; j++) {
                            work[j] += allocation[i][j];
                        }
                        finish[i] = true;
                        doneCount++;
                        progressed = true;
                    }
                }
            }
            if (!progressed) return false;
        }
        return true;
    }

    /** Snapshot of remaining need for a customer */
    public synchronized int[] getNeed(int customerId) {
        return Arrays.copyOf(need[customerId], RESOURCE_COUNT);
    }
}
