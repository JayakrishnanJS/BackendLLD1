package Concurrency3.AdderSubtractorSynchronizedBlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Value value = new Value();
        value.setVal(0);

        // Directly pass shared Object - value to Adder and Subtractor classes which have sync blocks
        // which takes the value object as parameter to synchronize execution.
        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Void> adderFuture = executorService.submit(adder);
        Future<Void> subtractorFuture = executorService.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(value.getVal());
    }
}

// adding and subtracting order can change due to Context switching done by CPU Scheduler

// A synchronized block allows you to synchronize only a portion of a method(Critical section), rather than the entire method.
// => here all the classes or methods sharing the object value should have separate blocks.

// Implicit locking is done using a monitor(intrinsic lock) for the object.
// Once a thread enters a synchronized section, all other threads trying to access it must wait until the lock is released.
// Automatically releases the lock if an exception occurs or the thread leaves the synchronized block.
// No control over thread scheduling. There's no way to control fairness or thread waiting priorities.

/* Various approaches of Synchronized Blocks:

1. Instance-Level Synchronization (`synchronized (this)`):
    - Locking on `this` works when synchronizing instance methods or non-static variables.
    - It is unsuitable for static methods or variables, as static members belong to the class, not to any instance.

                    synchronized (this) { // Use this for instance-level synchronization. }

2. Dedicated Lock Object:
    - Sometimes, we use a private object to synchronize part of the code. This approach is useful when
      finer-grained control over locking is needed.

                    private final Object lock = new Object();
                    synchronized(lock) { // Use this for precise synchronization control. }

3. Class-Level Synchronization (`synchronized (ClassName.class)`):
    - Locks on the `Class` object apply to all static resources for that class and ensure thread safety for static
      members, regardless of how many threads or class instances are active.

                    synchronized (DatabaseConnectionPool.class) { // Class-level lock

    - `ClassName.class` is a reference to the Class object for the class `ClassName`.
    - This is a part of Java's reflection API and allows you to access metadata and perform operations related
    to the `Class` of your code.

*/