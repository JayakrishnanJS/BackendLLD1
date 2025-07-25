# Why ReentrantLock Has an Edge

The specific advantage mentioned—a thread re-acquiring a lock it already holds—is not possible with:

- **`synchronized` blocks/methods**: These do support reentrancy, but you can’t customize fairness, timeouts, try-lock behavior, or interruptibility.
- **`Semaphore`**: This is not reentrant at all. If a thread acquires a permit, it can’t assume it still holds it for nested acquisitions—it must explicitly manage counts.

---

## 🧠 Quick Comparison

| **Mechanism**     | **Supports Reentrancy** | **Fairness Control** | **Timeout Locking** | **Interruptible Lock** |
|--------------------|-------------------------|-----------------------|----------------------|-------------------------|
| `synchronized`     | ✅ Yes                 | ❌ No                | ❌ No               | ❌ No                  |
| `Semaphore`        | ❌ No                  | ✅ Yes (optional)     | ✅ Yes              | ✅ Yes                 |
| `ReentrantLock`    | ✅ Yes                 | ✅ Yes                | ✅ Yes              | ✅ Yes                 |

---

### Think of it Like Multiple Bird Calls in the Forest:
- **`synchronized`**: One bird per perch, always in the same order, no choice.
- **`Semaphore`**: First-come, first-serve feeder spots—you must grab fresh tokens.
- **`ReentrantLock`**: Flexible nesting access—your hornbill can return to the same nest zone multiple times without squawking at itself. 🐦🔁

---

## Semaphore vs Reentrant Lock

### Demonstration: Semaphore Deadlock vs. ReentrantLock Reentrancy

### 1. Semaphore Deadlocks on Nested `acquire()`

#### Code Example:
```java
import java.util.concurrent.Semaphore;

public class SemaphoreDeadlockDemo {
    private static final Semaphore sem = new Semaphore(1);

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread attempting first acquire");
                sem.acquire();              // acquires the only permit
                System.out.println("Thread got first permit");

                System.out.println("Thread attempting second acquire");
                sem.acquire();              // blocks here—no permits left!
                System.out.println("This line is never reached");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                sem.release();              // only one release happens if ever reached
            }
        });

        t.start();
    }
}
```

#### **What Happens?**
1. The thread grabs the sole permit on the first `acquire()`.
2. On the second `acquire()`, the pool is empty and the thread blocks indefinitely—waiting for a permit **it already holds**.
3. This results in **deadlock**, as the same thread waits for a fresh permit while holding the only available one.

---

### 2. ReentrantLock Allows Nested Locking

#### Code Example:
```java
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread attempting first lock()");
            lock.lock();                    // acquires the lock
            System.out.println("Thread got first lock");

            System.out.println("Thread attempting nested lock()");
            lock.lock();                    // re-enters—same thread, no blocking
            System.out.println("Thread got nested lock");

            // Must call unlock() twice to fully release:
            lock.unlock();
            lock.unlock();
            System.out.println("Thread released both locks");
        });

        t.start();
    }
}
```

#### **Why This Works:**
- **ReentrantLock** keeps an acquisition count per thread.
- The same thread can call `lock()` multiple times **without blocking**.
- Only when the acquisition count drops to zero (after matching `unlock()` calls), is the lock freed for other threads.

---

## 🧠 Key Takeaway

- **`Semaphore`** treats every `acquire()` as a brand-new permit withdrawal, even for the same thread—leading to **self-deadlock** on nested calls.
- **`ReentrantLock`** tracks ownership and allows the same thread to re-acquire the lock **safely**, simplifying recursive or nested locking requirements.

# Fairness and Key Features Across Locking Mechanisms

When choosing between `synchronized`, `Semaphore`, and `ReentrantLock`, it helps to map out how you control fairness and the additional locking capabilities each provides.

---

## 1. Fairness Control

### **`synchronized`**
- **Fairness:** No user-configurable fairness.
- **Behavior:** JVM grants the monitor in an unspecified order. New contenders can “barge” in front of waiting threads.

### **`Semaphore`**
- **Constructor:** `new Semaphore(permits, fair)`
    - `fair = true` → Threads acquire permits in FIFO order.
    - `fair = false` → Permit granting is unpredictable but slightly faster.

### **`ReentrantLock`**
- **Constructor:** `new ReentrantLock(fair)`
    - `fair = true` → Longest-waiting thread gets the lock next.
    - `fair = false` (default) → May favor “barging” for higher throughput under low contention.

---

## 2. Remaining Capabilities

| **Feature**                        | **`synchronized`**   | **`Semaphore`**          | **`ReentrantLock`**              |
|-------------------------------------|-----------------------|---------------------------|-----------------------------------|
| **Reentrancy**                     | ✅ (same thread)      | ❌ (no ownership)         | ✅ (hold count)                   |
| **Fairness tuning**                | ❌                   | ✅ via constructor         | ✅ via constructor                |
| **Try-acquire without blocking**   | ❌                   | ✅ `tryAcquire()`          | ✅ `tryLock()`                    |
| **Timed-acquire / timed-wait**     | ❌                   | ✅ `tryAcquire(timeout)`   | ✅ `tryLock(timeout)` / `await(timeout)` |
| **Interruptible acquisition**      | ❌                   | ✅ `acquireInterruptibly()`| ✅ `lockInterruptibly()`          |
| **Multiple condition-predicates**  | ❌ (one implicit)    | ❌                        | ✅ via `newCondition()`           |

---

## Why These Matter

1. **Fairness**
    - Prevents starvation in highly contended scenarios.

2. **Try-acquire and Timed Waits**
    - Enables you to fail fast or back off, which is critical for high-availability systems.

3. **Interruptible Locks**
    - Helps you write responsive code that can cancel or shut down cleanly.

4. **Multiple Conditions**
    - Lets you segregate `notFull` vs. `notEmpty` (as done in producer-consumer patterns) without relying on extra semaphores.