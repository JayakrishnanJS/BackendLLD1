package Concurrency2.ThreadPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.concurrent.Executors;

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
            // execute(command): Primarily designed for executing `Runnable` tasks.
            // Return type: void

            // Create a task to generate a number (Callable implementation).
            // Each task returns an integer result when executed.
            NumberGenerator numberGenerator = new NumberGenerator(i);

            // Submit the NumberGenerator task to the executor.
            // submit(task): Designed for executing both `Runnable` and `Callable` tasks.
            // The submit method returns a Future object, which allows getting the result of the task.
            // A `Future` allows you to retrieve the result of an asynchronous task once it has completed.
            Future<Integer> number = executorService.submit(numberGenerator);

            // Retrieve the result of the submitted Callable task (blocks until the task is finished).
            Integer x = number.get();

            // Returns `true` if the task is complete; otherwise, returns `false`
            if (number.isDone()) {
                System.out.println("Number Generator Task completed! by "+ Thread.currentThread().getName() + " thread, Result: " + x);
            } else {
                System.out.println("Task is still running...");
            }
        }
/*  The Future interface has a method called cancel that can be used to cancel a task.
    The cancel method takes a boolean parameter.
    If the boolean parameter is true, the task is cancelled even if the task is already running.
    If the boolean parameter is false, the task is cancelled only if the task is not running.
*/
        Future<Integer> future =
                executorService.submit(() -> {
                    try {
                        Thread.sleep(2000); // Simulate a long-running task
                        System.out.println("Task finished");
                    } catch (InterruptedException e) {
                        System.out.println("Task was interrupted!");
                    }
                return 2 + 3;
        });
        Thread.sleep(100);
        boolean tryToCancel = future.cancel(false); // Try to cancel but don't interrupt
        //System.out.println("Cancellation attempt status: " + tryToCancel);
        boolean mustCancel = future.cancel(true);
        System.out.println("Cancellation attempt status: " + mustCancel); // interrupt
        // Check if the task is done or canceled
        if (future.isCancelled()) {
            System.out.println("Task was successfully canceled.");
        } else {
            System.out.println("Task was already completed or currently running.");
        }

        // Schedule tasks with newScheduledThreadPool()
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable task1 = () -> System.out.println("Task1 executed at: " + LocalDateTime.now().format(formatter));
        Runnable task2 = () -> System.out.println("Task2 executed at: " + LocalDateTime.now().format(formatter));
        Runnable task3 = () -> System.out.println("Task3 executed at: " + LocalDateTime.now().format(formatter));

        // 1. Schedule a task to run after an initial delay of 2 seconds
        executor.schedule(task1, 2, TimeUnit.SECONDS);

        // 2. Schedule a task at a fixed rate: executes every 3 seconds, starting after an initial delay of 1 second
        executor.scheduleAtFixedRate(task2, 1, 3, TimeUnit.SECONDS);

        // 3. Schedule a task with a fixed delay: starts 4 seconds after the previous execution finishes
        executor.scheduleWithFixedDelay(task3, 1, 4, TimeUnit.SECONDS);

        // Shut down the executor gracefully after 15 seconds - from the start of the application.
        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
            System.out.println("Shutting down executor...");
            executor.shutdown();
        }, 15, TimeUnit.SECONDS);
        // SingleThreadScheduledExecutor() -Tasks are guaranteed to execute sequentially, and no more than one task will
        // be active at any given time

        // Best practice: Shutdown the executor service to release the resources properly.
        executorService.shutdown();
        // executorService.awaitTermination(5, TimeUnit.SECONDS);
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
