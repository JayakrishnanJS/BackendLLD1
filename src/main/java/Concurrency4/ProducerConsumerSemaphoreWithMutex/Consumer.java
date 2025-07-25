package Concurrency4.ProducerConsumerSemaphoreWithMutex;

public class Consumer implements Runnable{
    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.removeItem();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // exit or clean up -if least one process is wrong, we need to stop
        }
    }
}