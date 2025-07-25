package Concurrency3.AdderSubtractorLock;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value value; // Shared resource
    private Lock lock; // Declaration of a Lock reference

    Subtractor(Value value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 10000; i++) {
            lock.lock();
            System.out.println("Subtracting : " + i);
            value.setVal(value.getVal() - i); // Critical section: modifying the shared resource
            lock.unlock();
        }
        return null;
    }
}