package DesignPatterns.Creational.Factory.V2_Factory_Method;

import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.Button;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.Dropdown;
import java.util.Scanner;

public class Client {
    // - Factory method design pattern provides an interface for creating objects in a superclass,
    //   but allows subclasses to alter the type of objects that will be created.
    //   this method returns an instance of the class
    // - blurs the line between product and factory (each Platform is both).
    // Use: Creating one product at a time, using inheritance.
    // Focus: One product per method, subclass decides which product.

    // The complete steps to implement the factory method pattern are:
    // 1. Base factory interface - Create a factory class that contains a method for creating
    //    objects.
    // 2. Child factory class - Create a child class that extends the base factory class and
    //    overrides the factory method to create objects of its own type.
    // 3. Request - Request an object from the factory class without having to know the class
    //    of the object that will be returned.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String platformName = scanner.nextLine();

        Platform platform = PlatformFactory.getPlatform(platformName);

        // Client calls workflow methods on the creator
        platform.initializePlatform();   // other responsibility
        platform.renderUI();             // uses factory methods internally

        /*
        When the client calls platform.renderUI(), the base class logic runs. Inside renderUI(), the
        call to createButton() is dispatched to the subclass (AndroidPlatform).That’s the inheritance
        at work: the abstract base defines the workflow, and subclasses supply the concrete products.

        When you call platform.createButton() directly, only the subclass override runs
        (because the base class has no implementation). When you call a concrete method in
        the base class (like renderUI()), then the base class logic runs, and inside it,
        the subclass override is invoked.

        if above 2 methods are not provided in Platform class, this design pattern is
        Abstract Factory, not Factory Method(a creator class with other responsibilities).
        The client depends on a factory object, and variation comes from composition
        (injecting a different factory instance), not depend on extended subclasses.

        Alternatively, client can use factory methods directly in Abstract Factory pattern:
        Button   button   = platform.createButton();
        Dropdown dropdown = platform.createDropdown();

        button.click();
        dropdown.showOptions();
        */
    }
}

// Pros :
// 1. Decouples creation logic from client (SRP).
// 2. Adhere to Open/Closed: to add a platform, only change PlatformFactory.
// 3. Client has zero if/else—clean and easy to read.
// 4. Easy to test/mock PlatformFactory if needed.
// 5. Clear, consistent interface for all platforms; can be extended with platform subclasses.