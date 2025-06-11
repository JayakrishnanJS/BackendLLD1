package Concurrency2.Sorter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(8, 1 , 6 , 2 , 3 , 9 ,7 , 5);

        ExecutorService executorService = Executors.newCachedThreadPool();
        Sorter arraySorter = new Sorter(list, executorService);
        // pass the executorService object to create and manage all threads in a single thread pool
        Future<List<Integer>> sortedArrayFuture = executorService.submit(arraySorter);

        System.out.println(sortedArrayFuture.get());

    }
}
