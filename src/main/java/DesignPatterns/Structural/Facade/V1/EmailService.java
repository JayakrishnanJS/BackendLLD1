package DesignPatterns.Structural.Facade.V1;

public class EmailService {
    public void sendConfirmation(String orderId) {
        System.out.printf("Sending confirmation email for order %s%n", orderId);
    }
}
