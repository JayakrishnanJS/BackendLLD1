package Concurrency3.Volatile;

public class Client {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        System.out.println("Shared resource flag initially: " + sharedResource.getFlag());

        Thread t1 = new Thread(() -> {
            // 2s after starting t1, toggle flag to true
            try {
                Thread.sleep(2000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            sharedResource.toggleFlag();
            System.out.println("After 2s shared resource flag set to true by thread t1: " + sharedResource.getFlag());
        });

        Thread t2 = new Thread(() -> {
            while (!sharedResource.getFlag()) {
                // busy-wait loop prevents `t2` from proceeding until it detects the change.
                // => the above check runs before 2s and this reads value of flag from its thread local cache
                // => this loop never complete and below print statement is not reachable, code runs infinitely
            }
            //System.out.println("Before 2s shared resource flag is false in thread local cache, so t2 reads : " + sharedResource.getFlag());
            System.out.println("since flag is volatile, t2 reads it from main(heap) memory , so t2 is : " + sharedResource.getFlag());
        });
        t1.start();
        t2.start();
    }
}
/*
* Using the `volatile` keyword guarantees that all reads and writes to the `volatile` variable
  bypass thread-local caching and happen directly to/from the main memory.
  This ensures that changes made by one thread are immediately visible to other threads.
  Otherwise, it takes some time to update the latest changes to main memory from the thread-local cache, which causes error.

* Volatile doesn't guarantee atomicity or synchronization. It provides memory consistency for this variables value across threads.

* When to use volatile:
    When a variable is used to track the state of a shared resource, such as counter or a flag.
    When a variable is used to communicate between threads.
* When not use volatile:
    When the variable is used by single thread.
    When a variable is used to store a large amount of data.
*/