package DesignPatterns.Structural.Facade.V0;

public class ShippingService {
    public void addToShippingQueue(String orderId) {
        System.out.printf("Adding order %s to shipping queue%n", orderId);
    }
}
