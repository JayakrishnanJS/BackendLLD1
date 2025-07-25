package Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private final Store store;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore; // Controls access to critical sections

    Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
//        a producer should always keep on producing
        while(true){ //infinite loop
//            if(store.getItems().size() < store.getMaxSize()){
            try {
                producerSemaphore.acquire(); // try to acquire a lock
                //mutex.acquire();
                store.addItem(new Object());
                //mutex.release();
                consumerSemaphore.release(); // we then release producer and allow consumer to consume
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
