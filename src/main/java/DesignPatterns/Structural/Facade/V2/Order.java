package DesignPatterns.Structural.Facade.V2;

// Order Class
public class Order {
    private  final String orderId;
    private  final double amount;

    // has-a -> composition
    private final OrderProcessor processor;

    public Order(String orderId, double amount) {
        this.orderId  = orderId;
        this.amount   = amount;
        // Facade instance created internally via factory (uses OrderProcessor.createDefault())
        this.processor = OrderProcessor.createDefault();
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
