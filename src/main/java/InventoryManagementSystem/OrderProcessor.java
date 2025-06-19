package InventoryManagementSystem;

import java.util.PriorityQueue;

public class OrderProcessor {
    PriorityQueue<Order> orderQueue;
    // we defined default ordering is by isExpress. If we want any other order we need to pass that comparator to Priority Queue
    public OrderProcessor() {
        orderQueue = new PriorityQueue<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }
    public void processOrder() {
        Order order = orderQueue.poll();
        System.out.println("Processing order: " + order.getOrderID());
    }

    public int getSize() {
        return orderQueue.size();
    }
}
