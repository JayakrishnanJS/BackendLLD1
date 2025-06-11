package IntroToMultiThreading;

// 1. The HelloWorldPrinter class implements the Runnable interface that allows instances of this class to be run as separate threads.
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
