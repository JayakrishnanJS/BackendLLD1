package Concurrency3.AdderSubtractorSyncMethods;

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
//- A synchronized method locks the entire method, ensuring only one thread can execute it at a time on the same object.
//- Here, the monitor lock is associated with the current object (`this`) for non-static synchronized methods.
//- For static synchronized methods, the monitor lock is associated with the class object.

