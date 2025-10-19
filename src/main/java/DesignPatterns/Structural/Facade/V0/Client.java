package DesignPatterns.Structural.Facade.V0;

public class Client {
    public static void main(String[] args) {
        Order order = new Order("XYZ789", 1499.50);
        order.checkout();
    }
}
// Cons;
// 1. Order class is hard to test, since we need to mock all dependencies.
// 2. Order is not reusable.
// 3. Violate SRP and OCP
// 4. Hard to maintain or extend
// 5. tight coupled to the implementation of 3rd party apis or methods of other class.