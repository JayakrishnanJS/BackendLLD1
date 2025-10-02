package DesignPatterns.Creational.SingleTon.V4;

public class DatabaseConnectionPool {
    // 1. Needs to be volatile to prevent instruction reordering issues
    private static volatile DatabaseConnectionPool instance;

    // 2. Constructor Hiding - private or protected
    private DatabaseConnectionPool(){ }

    // 3. Global access point - static
    static DatabaseConnectionPool getInstance(){
        // 4. Double-checked locking
        // First check (without lock) - avoids synchronization
        if (instance == null) {
            synchronized (DatabaseConnectionPool.class) {
                // Second check (with lock) - ensures only one instance is created
                if (instance == null) {
                    instance = new DatabaseConnectionPool();
                }
            }
        }
        return instance;
    }
}
/*
Effect:
- Only one instance is created (safe, with volatile).
- Synchronization happens only on the first initialization.
- lazy initialization (instance created only when needed).
- Double-checked locking reduces the overhead of acquiring a lock by first checking
  the locking criterion (instance == null) without actually acquiring the lock.
  Only if the check indicates that the locking is required does the actual lock proceed.
- After the instance is created, getInstance() runs without locking,
  so this is faster than method-level synchronization.
*/
/*
    Cons of Singleton
    1. Identifying requirement of it is difficult.
    2. Unit Testing is difficult(creating mocks)
*/

/*
 Note: In modern Java (Java 5 and later), the volatile keyword ensures that multiple threads
 see a consistent value for the instance variable, preventing issues related to instruction
 reordering.

If you don’t use volatile on instance:
--------------------------------------
private static DatabaseConnectionPool instance; // no volatile

The JVM and CPU are allowed to reorder instructions for optimization.
Creating an object with new DatabaseConnectionPool() happens in three steps:
1. Allocate memory for the object.
2. Initialize the object (run constructor).
3. Assign the reference to instance.

Problem:
- Steps 2 and 3 can be reordered.
- Another thread may see instance as non-null before the constructor finishes.

Example of the bug:
- Thread A enters getInstance(), sees instance == null.
- Thread A allocates memory and assigns instance (step 3 happens before step 2).
- Thread B calls getInstance(), sees instance != null, and returns it.
- But the object is only partially constructed.
- Thread B ends up using a broken or inconsistent object.

With volatile:
--------------
private static volatile DatabaseConnectionPool instance;

- volatile prevents instruction reordering.
- Ensures visibility: a write by one thread is immediately seen by others.
- When instance is assigned, the object is guaranteed to be fully constructed
  and safely visible to all threads.

Alternative: Using Enum to implement Singleton (simplest and most effective way)
     public enum DatabaseConnectionPool {
         INSTANCE;
         // other methods can be added here
     }

Enum Singleton:
---------------
Pros:
1. Simplicity – very few lines of code.
2. Thread-safety guaranteed – JVM ensures only one instance.
3. Serialization-safe – no need for readResolve().
4. Reflection-safe – cannot break the singleton via reflection.
5. Minimal boilerplate – no volatile, synchronized, or inner classes.

Cons:
1. No lazy initialization – instance is created when the enum class is loaded.
   This may waste resources if the singleton is heavy and not always used.
2. No inheritance – enums cannot extend other classes (but can implement interfaces).

Usage in production:
- Yes, used when the singleton is lightweight.
- Recommended by Joshua Bloch (Effective Java).
- Avoid for heavy objects like real DB pools where lazy init (V5/V6) is preferred.
*/

