package IntroToMultiThreading;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        // 1. NEW
        Runnable dummyRunnable = () -> {};
        Thread newThread = new Thread(dummyRunnable);
        System.out.println("NEW Thread State: " + newThread.getState()); // NEW

        // 2. RUNNABLE
        Thread runnableThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // Busy-wait to stay RUNNABLE
            }
        });
        runnableThread.start();
        Thread.sleep(100); // Give the thread time to start
        System.out.println("RUNNABLE Thread State: " + runnableThread.getState()); // RUNNABLE

        // 3. BLOCKED
        Object lock = new Object();

        Thread blockingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000); // Hold the lock for a while
                } catch (InterruptedException ignored) {} // Exception is ignored, no action is taken
            }
        });

        Thread blockedThread = new Thread(() -> {
            synchronized (lock) {
                // Will not acquire lock until blockingThread releases it
            }
        });

        blockingThread.start();
        Thread.sleep(100); // Ensure the first thread holds the lock
        blockedThread.start();
        Thread.sleep(100); // Give it a moment to try acquiring the lock
        System.out.println("BLOCKED Thread State: " + blockedThread.getState()); // BLOCKED

        // 4. WAITING
        Thread waitingThread = new Thread(() -> {
            try {
                blockingThread.join(); // Waits indefinitely until blockingThread finishes
            } catch (InterruptedException ignored) {}
        });

        waitingThread.start();
        Thread.sleep(100);
        System.out.println("WAITING Thread State: " + waitingThread.getState()); // WAITING

        // 5. TIMED_WAITING
        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(3000); // Sleep for some time
            } catch (InterruptedException ignored) {}
        });

        timedWaitingThread.start();
        Thread.sleep(100);
        System.out.println("TIMED_WAITING Thread State: " + timedWaitingThread.getState()); // TIMED_WAITING

        // 6. TERMINATED
        Thread terminatedThread = new Thread(() -> {
            System.out.println("Thread is running and will finish quickly.");
        });

        terminatedThread.start();
        terminatedThread.join(); // Wait until it's done
        System.out.println("TERMINATED Thread State: " + terminatedThread.getState()); // TERMINATED

        // Cleanup
        runnableThread.interrupt();
        // The interrupt() method does not forcibly stop a thread.
        // It simply sets the interrupted flag, signaling that the thread should wrap up.
        // It’s up to the thread to check that flag (via Thread.interrupted() or isInterrupted()) and exit gracefully.
    }
}
/*
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running from anonymous class");
            }
        };
        Thread t = new Thread(runnable);
        t.start();

// we can simplify separate class(HelloWorldPrinter) or anonymous class(above) by using lambda expression

        Runnable runnable = () -> {
            System.out.println("Running from lambda");
        };
        Thread t = new Thread(runnable);
        t.start();

*/

/*
    () -> {
        // code to run
     }
() → No parameters (since Runnable.run() takes none)
-> → Arrow separates parameters from the body
{} → The body of the method, just like inside run()

 */

// 1. Blocked - A thread cannot proceed because it is waiting for access to a synchronized resource.
//      As soon as the thread holding the lock releases it, one of the threads in the `BLOCKED`
//      state will acquire the lock and move to the RUNNABLE state.
// 2. Waiting - A thread enters the WAITING state when it is waiting indefinitely for another thread
//              to signal it or to perform some specific action.
//    - It occurs due to usage of specific methods like:
//        - `Object.wait()`
//        - `Thread.join()`
//        - `LockSupport.park()`
//    - The thread voluntarily relinquishes control and waits for a notification or action from another thread.
//    - A thread in the `WAITING` state will not automatically resume; it must be explicitly signaled
//    (e.g., via `notify()`, `notifyAll()`, or the completion of a `join()`) to return to the RUNNABLE state.