package DesignPatterns.Structural.Facade.V1;

public class OrderProcessor {
    private final PaymentGateway   paymentGateway   = new PaymentGateway();
    private final Inventory        inventory        = new Inventory();
    private final EmailService     emailService     = new EmailService();
    private final ShippingService  shippingService  = new ShippingService();
    private final AnalyticsService analyticsService = new AnalyticsService();

    /**
     * Facade method that hides all the complex subsystem calls.
     */
    public void processOrder(String orderId, double amount) {
        paymentGateway.charge(orderId, amount);
        inventory.update(orderId);
        emailService.sendConfirmation(orderId);
        shippingService.addToShippingQueue(orderId);
        analyticsService.recordOrder(orderId, amount);
    }
}
