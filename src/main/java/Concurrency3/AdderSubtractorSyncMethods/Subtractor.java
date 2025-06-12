package Concurrency3.AdderSubtractorSyncMethods;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value value;
    Subtractor(Value value) {
        this.value = value;
    }
    @Override
    public Void call() throws Exception {

        for(int i = 1; i <= 100; i ++){
                System.out.println("Subtracting : " + i);
                value.incrementBy(-i);
        }
        return null;
    }
}
