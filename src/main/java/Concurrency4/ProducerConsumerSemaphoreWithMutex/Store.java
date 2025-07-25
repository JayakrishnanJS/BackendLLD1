package Concurrency4.ProducerConsumerSemaphoreWithMutex;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

// synchronization logic will be managed completely by Store
public class Store {
    private int maxSize;
    private ConcurrentLinkedQueue<Object> items = new ConcurrentLinkedQueue<>();

    // 1 permit for mutual exclusion (mutex)
    private final Semaphore mutex = new Semaphore(1);
    // Counts free slots: starts at maxSize, producers block when 0
    private final Semaphore emptySlots;
    // Counts available items: starts at 0, consumers block when 0
    private final Semaphore availableItems;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.emptySlots = new Semaphore(maxSize); // producers blocked when full
        this.availableItems = new Semaphore(0); // consumers blocked when empty
    }

    /**
     * Blocks if the store is full, then adds an item under mutual exclusion,
     * and signals consumers that an item is available.
     */
    public void addItem(Object item) throws InterruptedException {
        emptySlots.acquire();    // wait for a free slot
        mutex.acquire();         // enter critical section
        try {
            items.add(item);
            System.out.println("Producer "
                    + Thread.currentThread().getName()
                    + " produced, size: " + items.size());
        } finally {
            mutex.release();     // leave critical section
        }
        availableItems.release(); // signal a waiting consumer
    }

    /**
     * Blocks if the store is empty, then removes an item under mutual exclusion,
     * and signals producers that a slot is free.
     * Better alignment with collection semantics
     * Most queue‑like APIs (Queue.poll()) return the element they remove.
     * This makes the method reusable if later we need to examine or pass along the object.
     */
    public Object removeItem() throws InterruptedException {
        availableItems.acquire(); // wait for an available item
        mutex.acquire();          // enter critical section
        Object item;
        try {
            item = items.poll();  // safe remove
            System.out.println("Consumer "+ Thread.currentThread().getName()+ " consumed, size: " + items.size());
        } finally {     // Always release your mutex in a finally block - this runs no matter what, preventing deadlock
            mutex.release();      // leave critical section
        }
        emptySlots.release();     // signal a waiting producer
        return item;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ConcurrentLinkedQueue<Object> getItems() {
        return items;
    }

    public void setItems(ConcurrentLinkedQueue<Object> items) {
        this.items = items;
    }
}
/**
✅ Why You Should Encapsulate Semaphore Logic in Store
    1. Clean Responsibilities: Producer and Consumer should only produce or consume.
                               They shouldn't handle synchronization details.
                               This keeps your code cleaner and more testable.

    2. Prevent Misuse: If producers/consumers handle semaphores themselves, it's easy
                       to accidentally miss a release(), causing deadlocks or thread starvation.

    3. Singleton Control: Letting the Store manage its own mutex and semaphores keeps all
                          concurrency control in one place. Clients just call store.addItem(...)
                          and store.removeItem().
**/
