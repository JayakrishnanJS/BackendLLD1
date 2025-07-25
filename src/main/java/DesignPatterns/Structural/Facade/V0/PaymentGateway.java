package DesignPatterns.Structural.Facade.V0;

public class PaymentGateway {
    public void charge(String orderId, double amount) {
        System.out.printf("Charging ₹%.2f for order %s via PaymentGateway%n", amount, orderId);
    }
}
