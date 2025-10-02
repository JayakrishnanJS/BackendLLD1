package DesignPatterns.Creational.SingleTon.V2;

public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;

    // 1. Constructor Hiding - private or protected
    private DatabaseConnectionPool(){ }

    // 2. Global access point - static
    // 3. Thread-safety using synchronized method
    static synchronized DatabaseConnectionPool getInstance(){
        if(instance == null) {
            // First thread to enter creates the instance.
            // Because the whole method is synchronized, no two threads
            // can execute this block at the same time.
            instance = new DatabaseConnectionPool();
        }
        // Once created, all future calls just return the same instance.
        return instance;
    }
}
/*
Effect:
- Only one instance is created (safe).
- But every call to getInstance() is synchronized,
  which makes it slower after initialization.
*/
