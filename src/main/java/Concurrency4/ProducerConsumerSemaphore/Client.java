package Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);

        //Semaphore mutex = new Semaphore(1);
        Semaphore producerSemaphore = new Semaphore(store.getMaxSize());
        // - permits producers to create and add up to `store.getMaxSize()` items without waiting.
        // - Every time a producer produces an item, it will call `acquire()`, reducing the available permits.
        //   Once the store is full (i.e., `producerSemaphore` has 0 permits), producers will block until permits
        //   are added back when a consumer removes items.

        Semaphore consumerSemaphore = new Semaphore(0);
        //- It begins with `0` permits, meaning consumers will block until an item is produced.
        //- Each time a producer creates an item (and adds it to the store), it releases a permit to `consumerSemaphore`.
        // This allows one waiting consumer to access the item

        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store, producerSemaphore, consumerSemaphore);
            new Thread(producer).start();
        }

        for(int i = 0; i < 20; i++){
            Consumer consumer = new Consumer(store, producerSemaphore , consumerSemaphore);
            new Thread(consumer).start();
        }
    }
}

// Semaphores are concurrency tools used to limit the number of threads that can access a shared resource at the same time.
// Semaphore has two primary operations:
// - `acquire()`: Decreases the available permits. If no permits are available, the calling thread blocks until one becomes available.
// - `release()`: Increases the available permits, possibly unblocking a waiting thread.
// Use Semaphore when multiple threads need to be allowed at the critical section,
// But here there is another issue; ArrayList is not synchronized. It is not thread safe
// When multiple producers say 3 try to read store size and say each reads 4, everyone
// will increment it with one; the store size becomes 7, although the max size allowed is 5(say).
// => Concurrent data structures are needed - hardware + CAS(compare and swap) algorithms
/*
 * - Mutex Locks allow only 1 thread in the critical section while Semaphores can allow multiple
 *   threads in the critical section at the same time
 * - Semaphores can be used to solve adder-subtractor problem as well as producer-consumer problem
 */

// Working:

// Each producer thread:
// - Produces an item.
// - Acquires a permit from `producerSemaphore`. If permits are exhausted (the store is full), the producer will block until a consumer consumes an item, making space in the store.
// - Releases a permit to `consumerSemaphore`, signaling that an item is now ready for consumption.

// Each consumer thread:
// - Consumes an item.
// - Acquires a permit from `consumerSemaphore`. If no items are available (permits are `0`), the consumer will block until a producer produces an item and releases a permit.
// - Releases a permit to `producerSemaphore` to indicate that space is now available in the store.

/**
 a. A semaphore is not inherently a lock, it’s a permit counter.
     You initialize it with a number of permits (e.g. N).
     acquire() decrements the count (blocking if it would go negative).
     release() increments the count (waking a waiter if there is one).

 b. When you use a semaphore with 1 permit, it behaves like a mutual‑exclusion lock (a “binary semaphore”).
     Only one thread can hold that permit at a time, so the semaphore enforces exclusive access to whatever
     you wrap between acquire() and release().

 c. When you use a semaphore with >1 permits, it lets up to that many threads enter the “protected area” simultaneously.
    It’s not a lock in the classic sense—multiple threads can hold permits at once, so they can all proceed in parallel
    until the permit count is exhausted.

 d. Semaphores do not automatically protect a particular code block
    You still need to bracket your critical work with acquire()/release().
    If you have shared mutable data, you may need an additional mutex to protect multi‑step operations even if
    you use a counting semaphore to limit concurrency.

 Pblms:

    Producer Thread-7 is producing the items : 2
    Producer Thread-4 is producing the items : 2
    Consumer Thread-9 has consumed the item : 2
    Consumer Thread-9 has consumed the item : 0
    Consumer Thread-21 has consumed the item : 1

The primary cause could be:
        1. Race Condition: Multiple threads might be modifying or interacting with a shared resource (
                           e.g., a counter or list) at the same time without proper synchronization
                           mechanisms (e.g., locks). This could lead to inconsistent or unexpected output.
        2. Lack of Mutual Exclusion: Shared resources are accessed/modified by multiple threads without
                                     ensuring thread-safe access.
        3. ConcurrentLinkedQueue is thread safe for a single operation.
            Atomic multi‑step sequences are two separate operations:
                Step 1: add the item
                Step 2: read the size and print
            Even though each step alone is thread safe, another thread can sneak in between those steps.
        => That’s why we need a mutex to ensure that both steps happen together before anyone else can run.
        => When working with multiple threads in a producer-consumer system, safe access to shared data
           is critical to avoid such runtime issues.
 **/