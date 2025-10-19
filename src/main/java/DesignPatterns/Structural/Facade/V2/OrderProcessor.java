package DesignPatterns.Structural.Facade.V2;

public class OrderProcessor {
    private final PaymentGatewayImpl paymentGateway;
    private final Inventory        inventory;
    private final EmailService     emailService;
    private final ShippingService  shippingService;
    private final AnalyticsService analyticsService;

    // Loose coupling solution: Use constructor injection and factory method:
    public OrderProcessor(PaymentGatewayImpl paymentGateway,
                          Inventory inventory,
                          EmailService emailService,
                          ShippingService shippingService,
                          AnalyticsService analyticsService) {
        this.paymentGateway   = paymentGateway;
        this.inventory        = inventory;
        this.emailService     = emailService;
        this.shippingService  = shippingService;
        this.analyticsService = analyticsService;
    }

    /**
     * 1. Facade method that hides all the complex subsystem calls.
     */
    public void processOrder(String orderId, double amount) {
        paymentGateway.charge(orderId, amount);
        inventory.update(orderId);
        emailService.sendConfirmation(orderId);
        shippingService.addToShippingQueue(orderId);
        analyticsService.recordOrder(orderId, amount);
    }
    // 2. Factory method for fully initialized processor
    public static OrderProcessor createDefault() {
        return new OrderProcessor(
                new PaymentGatewayImpl(),
                new Inventory(),
                new EmailService(),
                new ShippingService(),
                new AnalyticsService()
        );
    }

}
