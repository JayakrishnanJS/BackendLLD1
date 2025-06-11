package IntroToMultiThreading;

// 2. The NumberPrinter class also implements Runnable
//    This class prints a number along with the thread name.
public class NumberPrinter implements Runnable {
    private final int noToPrint;

    // Constructor to initialize the number to print
    NumberPrinter(int noToPrint) {
        this.noToPrint = noToPrint;
    }

    void print(){
        System.out.println("Number : " + noToPrint + " Thread : " + Thread.currentThread().getName());
    }


    // The run method executes when the thread starts
    @Override
    public void run() {
        print();
    }
}
// run method doesn't take any argument and cannot return any value.
