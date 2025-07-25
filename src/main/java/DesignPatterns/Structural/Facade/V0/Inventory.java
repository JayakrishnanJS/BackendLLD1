package DesignPatterns.Structural.Facade.V0;

public class Inventory {
    public void update(String orderId) {
        System.out.printf("Updating inventory for order %s%n", orderId);
    }
}
