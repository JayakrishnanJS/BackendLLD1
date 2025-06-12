package Concurrency3.AdderSubtractorLock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

// Create a shared Value object that will be accessed and modified by multiple threads
        Value value = new Value();
        value.setVal(0); // Initialize the shared value to 0

// Create a ReentrantLock instance for ensuring thread safety when accessing the shared value
        Lock lock = new ReentrantLock();

// Create an Adder task that will add numbers to the shared value
        Adder adder = new Adder(value, lock);

// Create a Subtractor task that will subtract numbers from the shared value
        Subtractor subtractor = new Subtractor(value, lock);

// Initialize an ExecutorService with a fixed thread pool of size 2
// This ensures up to two threads will run concurrently (one for the adder and one for the subtractor)
        ExecutorService executorService = Executors.newFixedThreadPool(2);

// Submit the Adder task to the executor service for asynchronous execution
        Future<Void> adderFuture = executorService.submit(adder);

// Submit the Subtractor task to the executor service for asynchronous execution
        Future<Void> subtractorFuture = executorService.submit(subtractor);

// Wait for the Adder task to complete before proceeding
// The call to `get()` blocks the current thread until the task is finished
        adderFuture.get();

// Wait for the Subtractor task to complete before proceeding
        subtractorFuture.get();

// Safely print the final value of the shared resource
// This will reflect changes made by both the Adder and Subtractor threads
        System.out.println(value.getVal());
    }
}
/*
 * Lock Mechanism Explanation:
 * ---------------------------
 * Purpose:
 * - Locks are used to synchronize threads and prevent race conditions when
 *   multiple threads access and modify shared resources in a concurrent environment.
 *
 * Key Features:
 * - Locking ensures mutual exclusion, meaning only one thread can execute
 *   the critical section (code accessing the shared resource) at a time.
 * - The Lock interface in Java offers better control unlike the implicit handling in `synchronized`.
 *   It allows manual lock acquisition and release, supports try-lock mechanisms, and
 *   provides interruptible locking.
 *
 * ReentrantLock:
 * - In this class, ReentrantLock is used to manage access to the shared `Value` object.
 * - ReentrantLock is reentrant, meaning the thread that owns the lock can re-acquire it
 *   without causing a deadlock.

 * How the Lock Mechanism Works:
 * -----------------------------
 * 1. A thread calls `lock.lock()` to acquire the lock.
 *    - If another thread holds the lock, the current thread waits until the lock becomes available.
 * 2. Once the lock is acquired, the thread enters the critical section and safely executes
 *    the code that modifies the shared resource.
 * 3. After the critical section is executed, the thread must release the lock by calling `lock.unlock()`.
 *    - The `try-finally` block ensures that the lock is always released, avoiding potential deadlocks.

 * Code Flow:
 * ----------
 * - The `lock.lock()` call is made before the critical section to ensure only one thread
 *   can access the shared resource (`value.getVal()` and `value.setVal()`) at a time.
 * - The critical section modifies the `value` object by adding numbers from 1 to 10,000.
 * - After the task is complete (or an exception occurs), the lock is released using `lock.unlock()`.

 * Example Code with Lock Mechanism:
 * ---------------------------------
 * lock.lock();           // Acquire the lock before entering the critical section
 * try {
 *     // Critical section: Safely modify the shared resource
 *     for (int i = 1; i <= 10000; i++) {
 *         value.setVal(value.getVal() + i);
 *     }
 * } finally {
 *     lock.unlock();     // Release the lock to allow other threads to access the resource
 * }

 * Benefits of Locks:
 * ------------------
 * - Prevents race conditions: Ensures only one thread modifies a resource at a time.
 * - Avoids data inconsistency: Guarantees thread-safe access to shared resources.
 * - Flexibility: Provides advanced features like try-lock, timed lock, and interruptible lock.
 */