package DesignPatterns.Creational.Factory.V2_Factory_Method;

import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.Button;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.Dropdown;
import java.util.Scanner;

public class Client {
    // - Factory method design pattern provides an interface for creating objects in a superclass,
    //   but allows subclasses to alter the type of objects that will be created.
    //   this method returns an instance of the class
    // - blurs the line between product and factory (each Platform is both).

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

        Button   button   = platform.createButton();
        Dropdown dropdown = platform.createDropdown();

        button.click();
        dropdown.showOptions();
    }
}

// Pros :
// 1. Decouples creation logic from client (SRP).
// 2. Adhere to Open/Closed: to add a platform, only change PlatformFactory.
// 3. Client has zero if/else—clean and easy to read.
// 4. Easy to test/mock PlatformFactory if needed.
// 5. Clear, consistent interface for all platforms; can be extended with platform subclasses.