package IntroToMultiThreading;

import java.util.ArrayList;
import java.util.List;

// 3. The Client class contains the main method
//    This is the entry point of the application and manages thread execution.
public class Client {
    public static void main(String[] args) {
        System.out.println("-------Threads execution with start()--------");
        // Creating an instance of HelloWorldPrinter(task class)
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();

        // Creating a new Thread object and passing the Runnable instance(task) to it
        Thread t = new Thread(helloWorldPrinter);

        // Starting the thread
        t.start();
        //- tells Java to run the thread asynchronously.
        //- This means the execution of the threads happens independently and does not wait for the previous thread to finish.

        System.out.println("-------Thread execution with run()--------");
        // Directly calling the run method (not recommended, runs on the current thread(main), does not run in a separate thread)
        helloWorldPrinter.run();

        // Printing main thread information


        System.out.println("Main is executing in " + Thread.currentThread().getName());

        // Loop to create and start multiple threads for NumberPrinter
        System.out.println("------- Multiple threads execution --------");
        for (int i = 1; i <= 100; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread t1 = new Thread(numberPrinter);
            t1.setName("Worker-" + i); // Set thread name for clarity
            t1.start(); // Each thread prints a different number - cannot guarantee order of numbers => Concurrent execution
            // Since start() is used instead of calling run() directly, multiple threads begin running simultaneously.
            // This can result in numbers being printed out in a random order rather than sequentially from 1 to 100.
            // The actual order depends on how the Java thread scheduler assigns CPU time.

            // Direct invocation; executes sequentially in the main thread - for sequential execution (1 to 100 in correct order)
            // NumberPrinter numberPrinter = new NumberPrinter(i);
            // numberPrinter.run();
        }
        System.out.println( "Without join(), this message prints in between t1(100) are executing.");

        // Make the main thread sleep for 3 seconds (3000 milliseconds)
        try {
            Thread.sleep(3000);
            System.out.println("Main thread is waiting for 3s for t1(100) threads to finish.");
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
        }

        System.out.println("Main thread resumes after sleeping.");

        System.out.println("------- Synchronization using Join() --------");
        // List to manage threads
        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(new NumberPrinter(i));
            thread.setName("Worker-" + i);
            threadList.add(thread); // Add threads to the list
            thread.start();
        }
        // Synchronous execution: The main thread or current thread that calls the `join()` method will wait until \
        // the thread it's joining is finished.
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + thread.getName());
            }
        }
        System.out.println( "Due to join(), this message prints after all threads have finished executing");
    }
}
