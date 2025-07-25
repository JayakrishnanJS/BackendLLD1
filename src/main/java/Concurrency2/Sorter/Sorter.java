package Concurrency2.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>>{
    private List<Integer> arrayToSort;
    private ExecutorService executor;

    Sorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executor = executorService;
    }

        // task : to sort an array using mergeSort
        // I can't pass the arguments
    @Override
    public List<Integer> call() throws Exception {
        // Base condition
        if(arrayToSort.size() <= 1) {
            return  arrayToSort;
        }

        int mid = arrayToSort.size() / 2;

        List<Integer> leftArray = arrayToSort.subList(0, mid);
        List<Integer> rightArray = arrayToSort.subList(mid, arrayToSort.size());

        // sort the leftArray in another thread
        Sorter leftArraySorter = new Sorter(leftArray, executor);
        Sorter rightArraySorter = new Sorter(rightArray, executor);

        // ExecutorService executorService = Executors.newFixedThreadPool(2);
        // if executorService object is not passed to Sorter and is defined inside Sorter, during every function call in recursion,
        // new thread pool is created - which is not a good practice

        Future<List<Integer>> leftArrayFuture =  executor.submit(leftArraySorter);
        Future<List<Integer>> rightArrayFuture = executor.submit(rightArraySorter);

        // we need to wait till both the left and right part get sorted before we merge
        List<Integer> sortedLeftArray = leftArrayFuture.get();
        List<Integer> sortedRightArray = rightArrayFuture.get();

        // merge these two sorted arrays
        System.out.println("Merging two arrays : ");
        System.out.println(sortedLeftArray);
        System.out.println(sortedRightArray);
        System.out.println("in thread : " + Thread.currentThread().getName());
        int i= 0;
        int j = 0;
        List<Integer> sortedArray = new ArrayList<>();

        while (i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if (sortedLeftArray.get(i) <= sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i += 1;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j += 1;
            }
        }
        while (i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i += 1;
        }
        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j += 1;
        }
        return sortedArray;
    }
}

// thread will be calling either run or call
// logic should be present inside this function