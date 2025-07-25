package IntroToMultiThreading;

// 1. The HelloWorldPrinter(task) class implements the Runnable interface that allows instances of this class to be run as separate threads.
public class HelloWorldPrinter implements Runnable {

    // Method to print the message along with the thread name
    void print() {
        System.out.println("Hello World is printed in " + Thread.currentThread().getName());
    }

    // The run method executes when the thread starts
    @Override
    public void run() {
        print();
    }
}

/*
  In Java's multi-threading model, every thread executes its task by invoking its `run()` method.
  However, we don't usually call the `run()` method directly.
  Instead, we use the `Thread` class to start a thread and execute the `run()` method indirectly.

  Why Not Call `run()` Directly?
    If you call `run()` directly, it behaves like a normal method call and executes in the current thread.
    To execute the code in a new thread, you use `Thread.start()` instead.
    The `start()` method creates a new thread and then internally calls the `run()` method.
*/
