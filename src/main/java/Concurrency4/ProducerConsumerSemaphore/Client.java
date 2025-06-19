package Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);

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

// Working:

// Each producer thread:
// - Produces an item.
// - Acquires a permit from `producerSemaphore`. If permits are exhausted (the store is full), the producer will block until a consumer consumes an item, making space in the store.
// - Releases a permit to `consumerSemaphore`, signaling that an item is now ready for consumption.

// Each consumer thread:
// - Consumes an item.
// - Acquires a permit from `consumerSemaphore`. If no items are available (permits are `0`), the consumer will block until a producer produces an item and releases a permit.
// - Releases a permit to `producerSemaphore` to indicate that space is now available in the store.
