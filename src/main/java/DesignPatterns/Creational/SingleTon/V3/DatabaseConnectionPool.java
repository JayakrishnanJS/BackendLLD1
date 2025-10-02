package DesignPatterns.Creational.SingleTon.V3;

public class DatabaseConnectionPool {
    // 1. Thread-safety: Eager initialization creates the instance
    //    at class loading time. This is inherently thread-safe.
    private static final DatabaseConnectionPool instance = new DatabaseConnectionPool();

    // 2. Constructor Hiding - private so no other class can instantiate
    private DatabaseConnectionPool(){ }

    // 3. Global access point
    static DatabaseConnectionPool getInstance(){
        return instance;
    }
}
/*
Eager Initialization Singleton:
--------------------------------
Pros:
- Simple and thread-safe (instance created at class load time).
- No synchronization overhead on getInstance().

Cons:
a. Slower application startup (object is created immediately).
b. Wasteful if the instance is never used.
c. No flexibility for custom configuration (e.g., needing external
   parameters before creating the instance).
*/
