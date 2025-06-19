package Concurrency4.ProducerConsumerSync;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);


        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store);
            new Thread(producer).start();
        }

        for(int i = 0; i < 20; i++){
            Consumer consumer = new Consumer(store);
            new Thread(consumer).start();
        }
    }
}

// Here thread safety is ensured using synchronized blocks
// However, the core issue isn't with synchronization, but rather with resource contention and thread imbalance caused by the following key factors:
// Here I want more consumers and producers in the critical section at a time, and when store is empty we need to produce more
// So, along with locks we need a count
// Semaphores are locks with mutual exclusion along with count which executes and manages multiple threads at the critical section simultaneously
/**
 * --------------------
 * 1. Thread Imbalance:
 *    - The current implementation uses 8 producer threads and 20 consumer threads.
 *    - This creates a heavy imbalance, where consumers try to consume resources faster than producers can produce.
 *
 * 2. Limited Buffer Size:
 *    - The Store has a fixed buffer size of 5. With so many threads accessing it, there is frequent contention.
 *    - Producers often wait due to a full buffer, while consumers wait due to an empty buffer.
 *
 * 3. notifyAll() Impact:
 *    - On triggering notifyAll(), both producer and consumer threads are notified.
 *    - Because there are far more consumer threads, they dominate the waking threads, leading to producer starvation.
 *
 * 4. High Thread Overhead:
 *    - Launching 28 threads (8 producers + 20 consumers) adds resource overhead and worsens scheduling inefficiencies.
 *    - With excess consumers, the system spends time switching between waiting consumer threads unnecessarily.
 *
 * Why Synchronization Doesn't Solve the Problem:
 * ----------------------------------------------
 * While synchronization ensures thread safety, it cannot resolve issues caused by thread imbalance
 * (too many consumers compared to producers) and resource contention (a small buffer size with excessive threads).
 *
 * Suggested Fixes:
 * ----------------
 * 1. Reduce the number of consumer threads (e.g., balance 3 producers with 5 consumers).
 * 2. Use a thread pool (ExecutorService) to limit total threads and optimize thread handling.
 * 3. Increase the buffer size in the Store to allow for more items.
 * 4. Consider explicitly fair locking using ReentrantLock and Conditions for better fairness.
 * 5. Dynamically scale threads based on buffer utilization to balance producers and consumers.
 */

