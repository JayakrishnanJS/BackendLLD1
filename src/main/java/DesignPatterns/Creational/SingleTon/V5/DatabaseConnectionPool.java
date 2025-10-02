package DesignPatterns.Creational.SingleTon.V5;

/* Bill Pugh Singleton Implementation
 -----------------------------------------------
 This approach uses a static inner helper class to hold the singleton instance.
 The instance is created only when the inner class is loaded, which happens
 when getInstance() is called for the first time. This ensures lazy initialization
 and thread safety without synchronization overhead.
 */
public class DatabaseConnectionPool {
    private DatabaseConnectionPool(){ }

    // Inner static class is loaded only when getInstance() is called
    private static class Holder {
        private static final DatabaseConnectionPool INSTANCE = new DatabaseConnectionPool();
    }

    static DatabaseConnectionPool getInstance(){
        return Holder.INSTANCE;
    }
}
/*
Effect:
- Lazy initialization.
- Safe by JVM class-loading guarantees.
- No need for synchronized or volatile.
- ✅ Cleanest and most modern solution.
*/

/*
How it works for 1000 threads:

1. Class Loading:
   - The static inner class 'Holder' is loaded only when getInstance() is first called.
   - JVM ensures class initialization is thread-safe: it happens only once, even if multiple threads access it simultaneously.

2. Lazy Initialization:
   - INSTANCE is created inside Holder when Holder is loaded.
   - Before any call to getInstance(), Holder is not loaded and INSTANCE is not created.

3. Multiple Threads:
   - Suppose 1000 threads call getInstance() at the same time.
   - JVM detects Holder is not loaded and triggers class initialization.
   - Only one thread executes Holder's class initializer (<clinit>) to create INSTANCE.
   - Other threads wait until class initialization completes.

4. Return Instance:
   - Once initialization is complete, all threads return the same INSTANCE.
   - INSTANCE is fully constructed before any thread accesses it.

5. Thread-Safety Guarantee:
   - No synchronization or volatile needed.
   - JVM ensures atomic class initialization and visibility.
   - No race conditions, no partially constructed object.
*/