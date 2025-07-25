package Concurrency4.ProducerConsumerSemaphoreWithMutex;

import java.util.concurrent.Semaphore;

public class Client {
    // corrected main that uses the new, fully‑encapsulated Store API—no external semaphores,
    // no manual mutex, just clean producer/consumer threads:
    public static void main(String[] args) {
        Store store = new Store(5);
        //Semaphore mutex = new Semaphore(1);
        //Semaphore producerSemaphore = new Semaphore(store.getMaxSize());
        //Semaphore consumerSemaphore = new Semaphore(0);


        for(int i = 0; i < 8; i++){
            //Producer producer = new Producer(store, producerSemaphore, consumerSemaphore);
            //new Thread(producer).start();
            Producer producer = new Producer(store);
            new Thread(producer, "Producer-" + i).start();
        }

        for(int i = 0; i < 20; i++){
            //Consumer consumer = new Consumer(store, producerSemaphore, consumerSemaphore);
            //new Thread(consumer).start();
            Consumer consumer = new Consumer(store);
            new Thread(consumer, "Consumer-" + i).start();
        }
    }
}
/**
    Why this is “classic bounded buffer”:

    1. emptySlots starts at the buffer’s capacity; producers block when full.
    2. availableItems starts at 0; consumers block when empty.
    3. mutex (binary semaphore) ensures only one thread at a time manipulates the queue.
    4. try…finally around mutex.acquire()/release() guarantees you never deadlock if something
       inside the critical section throws.

    A finite‐size container (the “bounded buffer”) holds items produced by one or more producer threads
    and consumed by one or more consumer threads. Because it has limited capacity, producers must wait
    if it’s full, and consumers must wait if it’s empty.

    Role of mutex
    1. Guarantees Exclusive Access: Only one thread at a time can be inside the “critical section” that
       touches the queue. This prevents two producers (or a producer and a consumer) from simultaneously
       calling items.add(...) or items.poll().

    2. Prevents Race Conditions: Without mutual exclusion, you can get interleaved operations like:
        a. One thread reads size(), another thread modifies the queue, then the first thread proceeds
           with an incorrect assumption.
        b Two threads updating internal pointers or counters inside the queue at the same time,
          leading to corruption or lost elements.

    3. Keeps Queue Invariants Intact
        Most queue implementations (even thread‑safe ones like ConcurrentLinkedQueue) assume that
        single operations (add(), poll()) are atomic—but if you combine size checks plus removes/adds,
        you need a lock to make those multi‑step operations safe.
**/


/*
| Approach                                    | Use Case                                         | Thread Coordination | Fine‑grained Control | Ease of Use | Performance  | Strengths                                                  | Drawbacks                                                           |
| ------------------------------------------- | ------------------------------------------------ | ------------------- | -------------------- | ----------- | ------------ | ---------------------------------------------------------- | ------------------------------------------------------------------- |
| `synchronized` method                       | Entire‑method mutual exclusion                   | ❌                   | ❌                    | ✅           | 🟨 Medium    | Very simple, built‑in, no extra classes                    | Locks entire method, no timeout/interrupt, potential to over‑lock   |
| `synchronized` block                        | Critical‑section locking only                    | ❌                   | ✅                    | ✅           | 🟩 Better    | Limits lock scope, minimal boilerplate                     | No try‑lock or fairness options                                     |
| `wait()` / `notify()`                       | Low‑level thread signaling on object monitor     | ✅                   | 🟨 Medium            | 🟨 Complex  | 🟨 Medium    | Fine‑grained condition waiting, no extra classes           | Error‑prone (missed notify, lost wakeups), must use in synchronized |
| `ReentrantLock`                             | Advanced locking (tryLock, timed, interruptible) | ✅                   | ✅                    | 🟥 Verbose  | 🟩 High      | Supports fairness, tryLock, multiple `Condition`s          | More verbose than `synchronized`                                    |
| `ReadWriteLock`                             | Many readers, few writers                        | ✅                   | ✅                    | 🟨 Moderate | 🟩 High      | Maximizes concurrency for read‑heavy workloads             | Writers can starve readers or vice versa if misconfigured           |
| `Semaphore`                                 | Counting access control (permits for resources)  | ✅                   | ✅                    | 🟨 Moderate | 🟩 High      | Controls number of concurrent users, simple pattern        | No built‑in mutual exclusion on shared data                         |
| `BlockingQueue` (e.g. `ArrayBlockingQueue`) | Producer‑consumer queues, buffer management      | ✅                   | ✅                    | ✅           | 🟩 Very high | Built‑in blocking, thread‑safe, simple usage               | Fixed capacity must be chosen carefully                             |
| `CountDownLatch`                            | One‑time/one‑shot thread coordination            | ✅                   | ❌                    | ✅           | 🟩 High      | Simplest barrier for “wait for N to finish”                | Cannot be reset once count reaches zero                             |
| `CyclicBarrier`                             | Reusable barrier for N threads                   | ✅                   | ❌                    | ✅           | 🟩 High      | Automatically resets, supports barrier actions             | All parties must arrive; exceptions if one thread fails             |
| `Phaser`                                    | Dynamic, multi‑phase barriers                    | ✅                   | ✅                    | 🟨 Moderate | 🟩 High      | Like reusable `CountDownLatch` + `CyclicBarrier`           | More complex API                                                    |
| `ExecutorService` / Thread pools            | Managing worker threads & task queues            | ✅                   | ❌                    | ✅           | 🟩 Very high | Simplifies thread lifecycle, tuneable pool sizes           | Overhead of task submission, need to shut down cleanly              |
| `ScheduledExecutorService`                  | Delayed or periodic task execution               | ✅                   | ❌                    | ✅           | 🟩 Very high | Built‑in scheduling, no manual timer threads               | Limited flexibility vs. external schedulers                         |
| `CompletableFuture` / reactive streams      | Asynchronous callbacks and data flows            | ✅                   | ✅                    | 🟨 Moderate | 🟩 High      | Composable, non‑blocking pipelines                         | Learning curve, can obscure threading context                       |
| `StampedLock`                               | Optimistic read/write with version stamps        | ✅                   | ✅                    | 🟥 Verbose  | 🟩 Very high | Extremely fast for read‑heavy loads with infrequent writes | Complex to use correctly                                            |
*/