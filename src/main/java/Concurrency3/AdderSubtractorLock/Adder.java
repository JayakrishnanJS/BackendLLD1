package Concurrency3.AdderSubtractorLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value value; // Shared resource
    private Lock lock; // Declaration of a Lock reference

    Adder(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        // lock.lock(); // if lock and unlock is put outside loop first complete addition takes place and then subtraction
        for (int i = 1; i <= 10000; i++) { // Loop is thread-safe and doesn't need protection
            lock.lock(); // Acquire the lock before entering the critical section
            System.out.println("Adding : " + i);
            value.setVal(value.getVal() + i); // Critical section: modifying the shared resource
            lock.unlock(); // Release the lock to allow other threads to acquire it
        }
        // lock.unlock(); //
        return null;
    }
}