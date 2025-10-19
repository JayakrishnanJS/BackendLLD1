package DesignPatterns.Structural.Facade.V2;

public class AnalyticsService {
    public void recordOrder(String orderId, double amount) {
        System.out.printf("Recording analytics for order %s, amount ₹%.2f%n", orderId, amount);
    }
}
