package Concurrency2.AdderSubtractor;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    Adder(Value value) {
        this.value = value;
    }
    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 10000; i++){
            value.setVal(value.getVal() + i);
        }
        return null;
    }
}

/*

What Causes Synchronization Issues?
- Synchronization issues occur in a multithreaded environment when:
    1. Threads share a common resource (e.g., a shared variable or object).
    2. Mutual exclusion or synchronization mechanisms are not effectively used to manage access to the shared resource.
    3. Multiple threads simultaneously perform read/update/write cycles, leading to race conditions or data inconsistency.

Adder and Subtractor Scenario:
In a scenario where multiple threads act as adders or subtractors, synchronization issues will occur if:
- Both adders and subtractors operate on a shared variable (e.g., an integer) simultaneously.
- The shared variable is accessed and modified without synchronization.
        - If multiple threads call the `add()` or `subtract()` method at the same time, race conditions may occur because the `count += value` or `count -= value` operation involves:
        - Reading the current value of `count`.
        - Modifying it (adding or subtracting).
        - Writing the result back to `count`.
        - Without synchronization, two threads may read the same initial value, resulting in incorrect updates.

 */
