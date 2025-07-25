package Concurrency3.AdderSubstractorAtomic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class   Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Value value = new Value();
        value.setVal(new AtomicInteger(0));

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

//- `AtomicInteger` is a class provided in the `java.util.concurrent.atomic` package that allows performing atomic operations
//   on an integer value. Atomic operations are operations that are executed atomically, meaning they are completed as a whole
//   without being interrupted, even in a multithreaded environment.
//- uses Compare and Swap algorithms for thread-safety
//- The key feature of `AtomicInteger` is that it eliminates the need to use explicit synchronization
//  (e.g., `synchronized` keyword) for common operations like incrementing, decrementing, or updating
//  integer values in a thread-safe manner.
//- But it is not a replacement for integer.

