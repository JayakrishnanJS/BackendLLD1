package DesignPatterns.Creational.SingleTon.V5;

public class TestDatabaseConnectionPool {

    public static void main(String[] args) throws InterruptedException {
        // Runnable task to get the singleton instance
        Runnable task = () -> {
            DatabaseConnectionPool instance = DatabaseConnectionPool.getInstance();
            System.out.println("Instance: " + instance + " | Thread: " + Thread.currentThread().getName());
        };

        // Create an array of threads
        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task, "Thread-" + (i + 1));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        // Check main thread instance
        DatabaseConnectionPool mainInstance = DatabaseConnectionPool.getInstance();
        System.out.println("Main thread instance: " + mainInstance);
    }
}

/*
Expected behavior:
- All threads (Thread-1 to Thread-10) should print the SAME instance address.
- The main thread should also print the same instance.
- If different addresses appear, singleton implementation is broken.
*/
