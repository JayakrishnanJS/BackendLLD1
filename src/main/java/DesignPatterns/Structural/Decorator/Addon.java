package DesignPatterns.Structural.Decorator;

public abstract class Addon extends Beverage{
    // wrapper or decorator around another Beverage object - this facilitates chaining of multiple
    // decorators to wrap or extend behavior dynamically at runtime(dynamic composition).
    protected Beverage beverage;
    // constructor allows the Addon to wrap around the given Beverage instance (e.g., a base beverage like Decaf or
    // another previously wrapped Beverage object).
    public Addon(Beverage beverage) {
        this.beverage = beverage;
    }
}
