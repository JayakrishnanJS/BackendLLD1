package Concurrency4.ProducerConsumerSemaphore;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Store {
    private int maxSize;
    private ConcurrentLinkedQueue<Object> items;
    //protected static Semaphore mutex = new Semaphore(1);

    Store(int maxSize) {
        this.maxSize = maxSize;
//        arrayList is not made for concurrent access: Not a thread safe data structure
//        we should use a DS which is concurrent
        items = new ConcurrentLinkedQueue<>();
    }

    public void addItem(Object item){
        items.add(item);
        System.out.println("Producer "+ Thread.currentThread().getName() + " is producing the items : " + items.size());
    }

    public void removeItem(){
        items.poll();// Use poll() instead of remove(), which safely returns null if empty.
        System.out.println("Consumer " + Thread.currentThread().getName() + " has consumed the item : " + items.size());
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ConcurrentLinkedQueue<Object> getItems() {
        return items;
    }

    public void setItems(ConcurrentLinkedQueue<Object> items) {
        this.items = items;
    }
}
