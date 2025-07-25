package Concurrency4.ProducerConsumerWaitAndNotify;

import java.util.LinkedList;

public class Store {
    private final int maxSize;
    private final LinkedList<Object> items = new LinkedList<>();
    // can use ArrayList if store size is fixed.

    public Store(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void addItem(Object item) throws InterruptedException {
        while (items.size() == maxSize) {
            wait();
        }
        items.addLast(item);
        System.out.println("Producer " + Thread.currentThread().getName() +
                " added item, size=" + items.size());
        notifyAll();
    }

    public synchronized Object removeItem() throws InterruptedException {
        while (items.isEmpty()) {
            wait();
        }
        Object item = items.removeFirst();
        System.out.println("Consumer " + Thread.currentThread().getName() +
                " removed item, size=" + items.size());
        notifyAll();
        return item;
    }
}
/*
In these two methods, wait() and notifyAll()[from Object class] coordinate producers and consumers using the object’s intrinsic lock (the monitor).
1. Entering the critical section:
    Both methods are declared synchronized, so when a thread calls addItem or removeItem, it must first
    acquire the monitor lock on the Store instance. Only one thread at a time can hold that lock.
2. wait call():
        while (items.size() == maxSize) {
            wait();
        }

    a. Releases the monitor: wait() atomically releases the lock on this, letting other threads enter
                             addItem or removeItem.
    b. Enters the wait set: The calling thread is parked and won’t run again until it’s notified.
    c. When a waiting thread is woken, it re‑acquires the lock before returning from wait() and
       re‑checks the while condition.

       while (items.isEmpty()) {
            wait();
       }
    d. Consumers wait here when there’s nothing to remove.

3. Doing the Work
    Once past the while loop:
        a. addItem does items.addLast(item)
        b. removeItem does items.removeFirst()
    At this point the queue is in a valid state (not over‑full, not empty).

4. The notifyAll() Call
            notifyAll();
    a. Wakes all threads waiting on this monitor (both producers and consumers).
    b. Those threads will contend to re‑acquire the lock. Each one, upon reacquiring it,
       will re‑evaluate its while condition:
            1. A woken producer checks items.size() == maxSize again.
            2. A woken consumer checks items.isEmpty() again.
    c. Only threads whose condition is now false proceed; others go back to waiting.

Why notifyAll() and Not notify()?
    With multiple producers and multiple consumers, using notifyAll() ensures everyone gets
    a chance to re‑test their guard condition.
    A plain notify() might wake up a thread that still cannot proceed (
    e.g. waking another producer when the buffer is still full), leading to missed opportunities
    or deadlock if the right thread isn’t woken.

Visual Sequence
    Buffer full: producers call wait(), release lock → they sleep.
    Consumer removes: gets lock, removes item, calls notifyAll(), releases lock.
    Waiting producers wake: each re‑acquires lock, sees size < maxSize, proceeds to add.
And symmetrically for consumers when buffer is empty.

*/
