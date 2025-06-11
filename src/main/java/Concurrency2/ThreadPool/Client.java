package Concurrency2.ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Create a cached thread pool using the Executors utility.
        // A cached thread pool creates new threads if all existing threads are busy,
        // and it reuses idle threads to improve performance and reduce overhead.
        ExecutorService executorService = Executors.newCachedThreadPool();

        // -------------------or------------------
        // Creates a pool with exactly 10 threads.
        // If there are more than 10 tasks submitted simultaneously, the remaining tasks will wait in a queue.
        // Once a thread completes its current task, it picks up the next task from the queue.
        // This limits resource usage and prevents excessive thread creation
        // ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Loop to submit tasks to the thread pool.
        for (int i = 0; i < 100; i++) {

            if (i == 80) { // use 80000 with i < 10000000 to visualize Executors
                System.out.println(); // put debugger here
            }

            // Create a task to print the current number (Runnable implementation).
            // This task will print the number on a separate thread when executed.
            NumberPrinter numberPrinter = new NumberPrinter(i);

            // Submit the NumberPrinter task to the executor for asynchronous execution.
            executorService.execute(numberPrinter);

            // Create a task to generate a number (Callable implementation).
            // Each task returns an integer result when executed.
            NumberGenerator numberGenerator = new NumberGenerator(i);

            // Submit the NumberGenerator task to the executor.
            // The submit method returns a Future object, which allows getting the result of the task.
            // A `Future` allows you to retrieve the result of an asynchronous task once it has completed.
            Future<Integer> number = executorService.submit(numberGenerator);

            // Retrieve the result of the submitted Callable task (blocks until the task is finished).
            Integer x = number.get();

            // Returns `true` if the task is complete; otherwise, returns `false`
            if (number.isDone()) {
                System.out.println("Task completed!");
            } else {
                System.out.println("Task is still running...");
            }
        }

        // Best practice: Shutdown the executor service to release the resources properly.
        executorService.shutdown();
        System.out.println("Finished all threads");
    }
}

// ExecutorService explanation:
// - Directly creating new threads for task execution (e.g., calculating or printing) is not efficient and
//   can lead to issues like thread management overhead, resource exhaustion, and poor scalability.
// - A fixed thread pool does not allow creating more threads than its predefined size.
//   Once the pool is full, tasks must wait for an available thread.
// - A cached thread pool creates new threads only when needed (when no idle threads are available),
//   and it reuses existing idle threads when possible. This reduces overhead and improves scalability.
// - The executor service is responsible for managing threads, ensuring efficient thread reuse,
//   and providing options for both one-time and repeated task execution.
