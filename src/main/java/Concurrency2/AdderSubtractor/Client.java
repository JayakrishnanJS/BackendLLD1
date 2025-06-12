package Concurrency2.AdderSubtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // This Adder Subtractor is to visualize Synchronization problem, which is explained in concurrency3
        Value value = new Value();
        value.setVal(0);

        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Void> adderFuture = executorService.submit(adder);
        Future<Void> subtractorFuture = executorService.submit(subtractor);

        adderFuture.get(); // future.get() waits till both get completed
        subtractorFuture.get();

        System.out.println(value.getVal());
    }
}

// Expected output is Zero, but due to not handling mutual exclusion of threads, output is wrong.