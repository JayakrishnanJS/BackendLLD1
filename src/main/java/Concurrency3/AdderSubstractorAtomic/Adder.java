package Concurrency3.AdderSubstractorAtomic;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    Adder(Value value) {
        this.value = value;
    }
    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 10000; i ++){
            value.getVal().addAndGet(i);
        }
        return null;
    }
}
// value.getVal().addAndGet(i);
// is a concise and efficient way to atomically update a shared integer value in a multithreaded program.
// It avoids synchronization overhead