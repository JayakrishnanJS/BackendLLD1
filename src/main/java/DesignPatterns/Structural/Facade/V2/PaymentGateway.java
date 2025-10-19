package DesignPatterns.Structural.Facade.V2;

// Subsystem Interfaces
interface PaymentGateway {
    void charge(String orderId, double amount);
}
