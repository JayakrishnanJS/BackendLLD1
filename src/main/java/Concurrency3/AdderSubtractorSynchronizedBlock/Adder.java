package Concurrency3.AdderSubtractorSynchronizedBlock;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;
    Adder(Value value) {
        this.value = value;
    }
    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 100; i++){
            synchronized (value){
                System.out.println("Adding " + i);
                value.setVal(value.getVal() + i);
            }
        }
        return null;
    }
}
