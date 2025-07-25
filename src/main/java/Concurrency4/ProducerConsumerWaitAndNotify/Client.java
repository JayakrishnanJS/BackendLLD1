package Concurrency4.ProducerConsumerWaitAndNotify;

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
/*
| Criterion                 | Semaphore + Mutex                                                                                                                                                              | `wait()` / `notify()`                                                                                                                      |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------ |
| **Conceptual Model**      | Two primitives: a counting semaphore to gate access (e.g. “empty slots” or “available items”) and a separate mutex (binary semaphore or lock) to protect the critical section. | One monitor per object: threads call `wait()` to block and `notify()`/`notifyAll()` to wake peers, all under a single `synchronized` lock. |
| **Boilerplate**           | More lines of code: you must manage two semaphores + explicit `acquire()`/`release()` calls, plus a separate lock.                                                             | Fewer objects: just the intrinsic monitor. `synchronized`, `wait()`, `notifyAll()` all in one place.                                       |
| **Clarity of Intent**     | Semantically clear when you need both “counting” (e.g. rate‑limiting) and mutual exclusion.                                                                                    | Very clear when you have a single condition (“not full” or “not empty”)—the code reads almost like the problem statement.                  |
| **Error‑Proneness**       | Easy to forget a `release()` in a catch/finally, or to mix up which semaphore you’re touching.                                                                                 | Easy to forget to re‑check the guard in a loop, or to choose `notify()` vs. `notifyAll()`, but fewer objects to track.                     |
| **Flexibility**           | You can mix-and‑match—e.g. multiple semaphores for multiple resources, prioritized permits, timed acquires.                                                                    | Limited to the single monitor’s condition; you can build complex logic, but you’ll end up with nested `while` loops and multiple flags.    |
| **Performance**           | Semaphore operations have some queue management overhead, but can be very fast. Using a separate mutex lets you sometimes reduce contention (e.g. split locks).                | JVM’s `wait()`/`notify()` is implemented on top of `park()/unpark()` and is quite efficient; fewer objects means less GC overhead.         |
| **Fairness**              | Semaphores can be constructed with fairness (FIFO) if you need it.                                                                                                             | Intrinsic locks are unfair by default; you have no built‑in fairness guarantees.                                                           |
| **Use Cases**             | Best when you need exactly N concurrent “slots” plus mutual exclusion (e.g. database connection pool, rate limiter, multi‑resource access).                                    | Best when you have one “state condition” and want the simplest, lowest‑overhead blocking (e.g. single buffer full/empty).                  |
| **Shutdown & Interrupts** | You can use `tryAcquire(timeout)` or check interrupts more flexibly with semaphores.                                                                                           | `wait()` responds to `interrupt()`, but you can’t set timeouts without `wait(timeout)`, and managing spurious wake‑ups can be fiddly.      |

*/