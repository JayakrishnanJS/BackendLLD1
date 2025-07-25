package DesignPatterns.Creational.SingleTon.V2;

public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    // 1. Constructor Hiding - private or protected
    private DatabaseConnectionPool(){

    }
    // 2. Global access point - static
    // 3. Thread-safety - synchronized keyword
    static synchronized DatabaseConnectionPool getInstance(){
        if(instance == null) { // even if there are a lot of calls to this method, one object will be shared across all functions.
            // but 10 out of 1000 threads may enter during application start and one by one they acquire lock and create 10
            // objects while others wait in queue
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }
}/*
Pblm: few out of all threads(may be 10 out of 1000) still create objects individually
    If two threads call the getInstance() method at the same time, both threads will check if the
    instance variable is null. Both threads will find that the instance variable is null. Both threads
    will wait for the lock to be released. Once the lock is released, one thread will create a new instance
    of the Database class. The other thread will wait for the lock to be released. Once the lock is
    released, it will create a new instance of the Database class. This will result in two
    instances of the Database class.
*/