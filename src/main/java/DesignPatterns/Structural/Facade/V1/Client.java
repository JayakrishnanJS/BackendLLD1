package DesignPatterns.Structural.Facade.V1;

public class Client {
    public static void main(String[] args) {
        Order order = new Order("ABC123", 2599.99);
        order.checkout();
    }
}
/**
 A facade is an object that provides a simplified interface to a larger body of code,
 such as a class library, a framework, or any other complex set of classes.
 The facade provides a simple interface to the Class. The facade is a single point of entry to the Class.

 The Facade pattern suggests that you wrap a complex subsystem with a simpler interface.
 The Facade pattern provides a higher-level interface that makes the subsystem easier to
 use.
 The Facade pattern is implemented by simply creating a new class that encapsulates
 the complex logic of the existing classes. For our example above, we will move the
 complex logic to a new class called OrderProcessor.
 **/
