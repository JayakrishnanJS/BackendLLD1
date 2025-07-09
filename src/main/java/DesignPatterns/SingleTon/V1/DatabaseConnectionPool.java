package DesignPatterns.SingleTon.V1;

public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    /* 1. Constructor Hiding - The constructor of the singleton class should be private or
    /     protected. This will prevent other classes from instantiating the singleton class.*/
    private DatabaseConnectionPool(){

    }
    /* 2. Global access point - The singleton class should provide a global access point to
       get the instance of the singleton class. This global access point should be static and
       should return the same instance of the singleton class every time it is called. If the
       instance does not exist, it should create the instance and then return it.*/
    static DatabaseConnectionPool getInstance(){
        if(instance == null) { // even if there are a lot of calls to this method, one object will be shared across all functions.
            instance = new DatabaseConnectionPool(); // Lazy Initialisation - creating object when someone asks for it(call getInstance())
        }
        return instance;
    }
}
/*
    Singleton - The singleton pattern is a software design pattern that restricts the instantiation of a
    class to one object. This is useful when exactly one object is needed to coordinate
    actions across the system.

    1. method should be static, otherwise we would need an object to call getInstance(), but the object creation
    responsibility is within the getInstance() method, so we cannot create an object for this method.
    2. if we are not checking instance == null, method call runs infinitely, since each time a new instance gets created

    But this won't work in a multithreaded environment, multiple threads enter the critical section simultaneously, and multiple
        instances of DB get created
*/
