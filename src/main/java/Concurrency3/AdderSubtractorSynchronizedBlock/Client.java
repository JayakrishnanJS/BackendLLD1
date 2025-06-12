package Concurrency3.AdderSubtractorSynchronizedBlock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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