package Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private final Store store;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true){ // infinite loop
//           currSize =  2, Number of consumer on line 14 = 8
//            if(store.getItems().size() > 0){
//                store.removeItem();
//            }
            try {
                consumerSemaphore.acquire();
                //mutex.acquire();
                store.removeItem();
                //mutex.release();
                producerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
