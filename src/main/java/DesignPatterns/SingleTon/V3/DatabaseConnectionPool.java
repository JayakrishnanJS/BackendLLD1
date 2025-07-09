package DesignPatterns.SingleTon.V3;

public class DatabaseConnectionPool {
    // 3. Thread-safety - Eager initialisation
    private static DatabaseConnectionPool instance = new DatabaseConnectionPool();
    // 1. Constructor Hiding - private or protected
    private DatabaseConnectionPool(){

    }
    // 2. Global access point - static
    static synchronized DatabaseConnectionPool getInstance(){
        return instance;
    }
}/*
        a. Performance issue: Increases application start time because the object is created when a class is initialized
        b. If this shared object is not required, this is useless.
        c. Custom configuration - we need some information from a third party and initialize DB constructor based on that,
                                  but here object is created before constructor initialisation and hence custom configuration
                                  is not possible
*/