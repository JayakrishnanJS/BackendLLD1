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

    1. Find the Critical Section in the code - pain point of shared data => portion of code where only one thread need to work and finish the task
    2. Check whether there is a Race Condition at the critical section - two or more threads entering the critical section at the same time.
    3. Preemptiveness - scheduler moves from one task to another task(context switching) before completing the first task.
    We cannot remove issue 1 and issue 3 to avoid sync issues, but we can manage issue 2.
    Mutual exclusion - ensure only 1 thread can access a shared resource at a given point of time.

    What Causes Synchronization Issues?
    - Synchronization issues occur in a multithreaded environment when:
        1. Threads share a common resource (e.g., a shared variable or object).
        2. Mutual exclusion or synchronization mechanisms are not effectively used to manage access to the shared resource.
        3. Multiple threads simultaneously perform read/update/write cycles, leading to race conditions or data inconsistency.

    Adder and Subtractor Scenario:
    In a scenario where multiple threads act as adders or subtractors, synchronization issues will occur if:
    - If both adder and subtractor operate on a shared variable (Value object) simultaneously, race conditions can occur.
    - A race condition happens when two or more threads try to read and modify the shared resource (`value`) concurrently, potentially leading to data inconsistency.
    - The shared variable is accessed and modified without synchronization.
            - If multiple threads call the `add()` or `subtract()` method at the same time, race conditions may occur because the `count += value` or `count -= value` operation involves:
            - Reading the current value of `count`.
            - Modifying it (adding or subtracting).
            - Writing the result back to `count`.
            - Without synchronization, two threads may read the same initial value, resulting in incorrect updates.

 */
