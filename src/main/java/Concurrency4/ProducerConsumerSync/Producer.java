package Concurrency4.ProducerConsumerSync;

public class Producer implements Runnable{
    private Store store;

    Producer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
//  a producer should always keep on producing
        while(true){
            synchronized (store){
                if(store.getItems().size() < store.getMaxSize()){
                    store.addItem(new Object());
                }
            }
        }
    }
}
