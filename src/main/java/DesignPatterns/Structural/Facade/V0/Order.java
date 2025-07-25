package DesignPatterns.Structural.Facade.V0;

public class Order {
    private final String orderId;
    private final double amount;

    // Direct subsystem dependencies:
    private final PaymentGateway  paymentGateway  = new PaymentGateway();
    private final Inventory       inventory       = new Inventory();
    private final EmailService    emailService    = new EmailService();
    private final ShippingService shippingService = new ShippingService();
    private final AnalyticsService analyticsService = new AnalyticsService();

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount  = amount;
    }

    /**
     * No facade: Order does everything itself.
     */
    public void checkout() {
        System.out.printf("Order %s: beginning checkout for ₹%.2f%n", orderId, amount);

        paymentGateway.charge(orderId, amount);
        inventory.update(orderId);
        emailService.sendConfirmation(orderId);
        shippingService.addToShippingQueue(orderId);
        analyticsService.recordOrder(orderId, amount);

        System.out.printf("Order %s: checkout complete%n", orderId);
    }
}
