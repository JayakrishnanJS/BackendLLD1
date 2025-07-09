package DesignPatterns.SingleTon.V4;

public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    // 1. Constructor Hiding - private or protected
    private DatabaseConnectionPool(){

    }
    // 2. Global access point - static
    static DatabaseConnectionPool getInstance(){
        // 3. Double-Checked Locking - thread safety
        if (instance == null) {
            synchronized (DatabaseConnectionPool.class) {
                // 10 out of 1000 threads may enter here during application start and 1 will acquire lock and enter next if block
                // which is the critical section. The First thread creates a new instance.
                // After it releases lock, 2nd thread won't enter since instance is not null now.
                if (instance == null) { // even if there are a lot of calls to this method, one object will be shared across all functions.
                    instance = new DatabaseConnectionPool();
                }
            }
        }
        return instance;
    }
}/*
    Cons of Singleton
    1. Identifying requirement of it is difficult.
    2. Unit Testing is difficult(creating mocks)
*/