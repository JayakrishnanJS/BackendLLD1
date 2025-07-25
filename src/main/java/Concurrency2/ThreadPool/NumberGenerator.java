package Concurrency2.ThreadPool;

import java.util.concurrent.Callable;

// takes the input number and generate multiple of 5
public class NumberGenerator implements Callable<Integer> {
    int input;

    NumberGenerator(int input) {
        this.input = input;
    }

    // The call method is the entry point for the task when executed by a thread.
    @Override
    public Integer call() throws Exception {
        return input * 5;
    }
    // call method can return any generic type, here Integer
}
