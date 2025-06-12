package Concurrency3.AdderSubtractorSyncMethods;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value value;
    Adder(Value value) {
        this.value = value;
    }
    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 100; i ++){
                System.out.println("Adding " + i);
                value.incrementBy(i);

        }
        return null;
    }
}
