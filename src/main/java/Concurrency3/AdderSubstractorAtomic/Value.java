package Concurrency3.AdderSubstractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
    private AtomicInteger val;

    public AtomicInteger getVal() {
        return val;
    }

    public void setVal(AtomicInteger val) {
        this.val = new AtomicInteger();
    }
}
