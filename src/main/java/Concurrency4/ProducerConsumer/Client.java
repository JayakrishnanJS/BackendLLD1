package Concurrency4.ProducerConsumer;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5);

        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store);
            new Thread(producer).start();
        }

        for(int i = 0; i < 20; i++){
            Consumer consumer = new Consumer(store);
            new Thread(consumer).start();
        }
    }
}

// not using Callable since producer or constructor need not return anything
// not using Executor service - since i need all 20 consumers and 8 producers to work at same time.
// In the `main` method, 8 producer threads are created, attempting to add items to the `Store`.
// - Simultaneously, 20 consumer threads are created, trying to remove items from the `Store`.
// - With 8 producers but 20 consumers, the consumers may deplete the shared resource (`Store`) faster than the producers can refill it.

// So after a point of time -
// java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 7
// The `removeItem` method is designed to remove the last item in the `items` list (`items.size() - 1`),
// which means that, under certain conditions, it could be accessed when `items.size()` is `0`.
// This leads to an invalid index (`-1`) being calculated.
// This situation is possible because there is no synchronization mechanism to prevent operations
// like `addItem` and `removeItem` from being invoked simultaneously by multiple threads.