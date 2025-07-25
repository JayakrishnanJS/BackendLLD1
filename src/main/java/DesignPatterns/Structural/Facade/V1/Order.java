package DesignPatterns.Structural.Facade.V1;

public class Order {
    private final String orderId;
    private final double amount;
    private final OrderProcessor processor = new OrderProcessor();

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount  = amount;
    }

    /**
     * Client-facing method: all the real work is delegated to the facade.
     */
    public void checkout() {
        System.out.printf("Order %s: beginning checkout for ₹%.2f%n", orderId, amount);
        processor.processOrder(orderId, amount);
        System.out.printf("Order %s: checkout complete%n", orderId);
    }
}
