package DesignPatterns.SingleTon.V4;

public class TestDatabaseConnectionPool {

    public static void main(String[] args) {
        /*  Create multiple threads to check if singleton instance is shared:
            All threads should print the same instance address (e.g., `DatabaseConnectionPool@15db9742`), which confirms
            that the class is following the singleton pattern. If the output shows different addresses, the singleton
            implementation is incorrect. */
        Runnable task = () -> {
            DatabaseConnectionPool instance = DatabaseConnectionPool.getInstance();
            System.out.println("Instance: " + instance + " | Thread: " + Thread.currentThread().getName());
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        // Also check with main thread
        DatabaseConnectionPool mainInstance = DatabaseConnectionPool.getInstance();
        System.out.println("Main thread instance: " + mainInstance);
    }
}