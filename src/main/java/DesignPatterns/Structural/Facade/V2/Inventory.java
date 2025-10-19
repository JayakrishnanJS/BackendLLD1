package DesignPatterns.Structural.Facade.V2;

public class Inventory {
    public void update(String orderId) {
        System.out.printf("Updating inventory for order %s%n", orderId);
    }
}
