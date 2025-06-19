package Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore, consumerSemaphore;
    Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore){
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
//        a producer should always keep on producing

        while(true){
//            if(store.getItems().size() < store.getMaxSize()){
            try {
                producerSemaphore.acquire(); // try to acquire a lock
                    store.addItem(new Object());
                consumerSemaphore.release(); // we then release producer and allow consumer to consume
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
