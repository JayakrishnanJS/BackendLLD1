package DesignPatterns.Structural.Facade.V1;

public class Inventory {
    public void update(String orderId) {
        System.out.printf("Updating inventory for order %s%n", orderId);
    }
}
