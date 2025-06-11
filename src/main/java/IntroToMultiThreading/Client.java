package IntroToMultiThreading;

// 3. The Client class contains the main method
//    This is the entry point of the application and manages thread execution.
public class Client {
    public static void main(String[] args) {
        // Creating an instance of HelloWorldPrinter
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();

        // Creating a Thread object and passing the Runnable instance to it
        Thread t = new Thread(helloWorldPrinter);

        // Starting the thread
        t.start();
        //- tells Java to run the thread asynchronously.
        //- This means the execution of the threads happens independently and does not wait for the previous thread to finish.


        // Directly calling the run method (not recommended, does not run in a separate thread)
        helloWorldPrinter.run();

        // Printing main thread information
        System.out.println("Main is executing in " + Thread.currentThread().getName());

        // Loop to create and start multiple threads for NumberPrinter
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
    }
}
