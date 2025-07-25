package Concurrency4.ProducerConsumerSemaphoreWithMutex;

class Producer implements Runnable {
    private final Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.addItem(new Object());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // exit or clean up
        }
    }
}

