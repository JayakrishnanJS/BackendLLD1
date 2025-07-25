package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;

import java.util.Scanner;

public class Client {
    // - Abstract Factory Design Pattern is a creational design pattern that provides an interface
    //   for creating families of related or dependent objects without specifying their concrete classes.
    //   It promotes loose coupling by allowing the client code to work with abstract types rather
    //   than concrete implementations.

    // - cleanly separates factory (the family) from product creators, which can make it
    //   clearer when you have lots of products in each family or want to inject/mock factories independently.
    /*
     1. Abstract product interface - Create an interface for the products that will be
        created by the factory.

     2. Concrete products - Create concrete classes that implement the product interface.

     3. Abstract factory interface - Create an interface for the abstract factory that will
        be used to create the products.

    4. Concrete factories - Create concrete classes that implement the abstract factory
        interface.

    5. Client code - Request an object from the factory class without having to know the
        class of the object that will be returned.

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String platform = scanner.nextLine();

        UIComponentFactory factory = PlatformFactory.getFactory(platform);
        Button   button   = factory.createButton();
        Dropdown dropdown = factory.createDropdown();

        button.click();
        dropdown.showOptions();
    }
}
// Pros :
// 1. Promotes loose coupling by allowing the client code to work with abstract types.
// 2. Easy to add new families of products without modifying existing code (OCP).
// 3. Clear separation of concerns; maintainable and extensible.
// 4. No if–else in Client; consistent interface for related objects.
// 5. Easier to test and mock due to separation.
// 6. Organizes related product families together; highly readable.
// 7. Supports runtime configuration of families without changing Client.