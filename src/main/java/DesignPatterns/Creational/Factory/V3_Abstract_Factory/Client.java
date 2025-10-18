package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen.HomeScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen.LockScreen;

import java.util.Scanner;

public class Client {
    // - Abstract Factory Design Pattern is a creational design pattern that provides an interface
    //   for creating families of related or dependent objects without specifying their concrete classes.
    //   It promotes loose coupling by allowing the client code to work with abstract types rather
    //   than concrete implementations.

    // - cleanly separates factory (the family) from product creators, which can make it
    //   clearer when you have lots of products in each family or want to inject/mock factories independently.
    // Use: Creating families of related products, using composition.
    // Focus: Multiple related products, factory object decides all products. Abstract Factory is more scalable for families of products.
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

        // 1. Settings dialog
        //Imagine you want a small popup for app settings.
        //It might just need a Dropdown for language selection and a Button for “Save”.
        //You don’t need a full HomeScreen or LockScreen — just components.
        UIComponentFactory uiComponentFactory = PlatformFactory.getUIComponentFactory(platform);
        Button   button   = uiComponentFactory.createButton();
        Dropdown dropdown = uiComponentFactory.createDropdown();

        button.click();
        dropdown.showOptions();


        // 2. HomeScreen and LockScreen Layouts
        UILayoutFactory uiLayoutFactory = PlatformFactory.getUILayoutFactory(platform);
        // Create a consistent family of layouts for the chosen platform.
        // Create full layouts like HomeScreen and LockScreen, which internally use the same family
        // of components - buttons, dropdowns, etc.
        HomeScreen home = uiLayoutFactory.createHomeScreen();
        LockScreen lock = uiLayoutFactory.createLockScreen();

        home.applyTheme(); // use dropdown and button internally
        home.render();

        lock.applyTheme(); // use dropdown and button internally
        lock.render();
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

/*
/*
 * ============================
 * Factory Method vs Abstract Factory
 * ============================
 *
 * 🔹 Factory Method (V2)
 * - The "creator" (e.g., Platform) is itself a product with other responsibilities.
 * - Subclasses (AndroidPlatform, IOSPlatform) override factory methods
 *   like createButton() / createDropdown() to produce platform-specific components.
 * - Focus: on the *methods* that subclasses override.
 * - Abstract class contains both creation methods + other behaviors or data.
 * - Creation = via inheritance.
 * - Client depends on: abstract class (Platform).
 *
 * 🔹 Abstract Factory (V3)
 * - The "factory" (e.g., UIComponentFactory) exists solely to create families of products.
 * - Concrete factories (AndroidUIComponentFactory, IOSUIComponentFactory) ensure
 *   all created objects belong to the same family (Android / iOS).
 * - Focus: on the *factory object* itself.
 * - Abstract class or Interface contains only creation methods.
 * - Creation = via composition.
 * - Client depends on: factory interface (UIComponentFactory).


 Factory Method: Subclass decides what to create.
 Abstract Factory: Factory object decides, ensuring consistent product families.

 * ✅ Summary:
 * Factory Method → Class hierarchy decides *how* to create products.
 * Abstract Factory → Separate object dedicated *only* to creating consistent families of products.

Analogy:
Think of a family as a themed furniture set:

Abstract Factory: One shop gives you a table, chair, and sofa that all match in style (say “Scandinavian”).
→ Everything fits together = one family.

Factory Method: You might make each furniture piece yourself — still furniture, but no built-in guarantee that all match.
→ Each creation method is independent.

| Aspect            | Factory Method                                     | Abstract Factory                                      |
| ----------------- | -------------------------------------------------- | ----------------------------------------------------- |
| Who owns creation | A product class with other duties (e.g., Platform) | A separate, dedicated factory object                  |
| Purpose           | Creation is *one role*                             | Creation is the *only role*                           |
| Object’s identity | Represents something real (like iOS)               | Represents a factory itself                           |
| Example           | `IOSPlatform extends Platform`                     | `IOSUIComponentFactory implements UIComponentFactory` |


🔹 1️⃣ Platform is a real object with identity + behavior

        IOSPlatform represents iOS itself — it might also have behaviors like version info, theme, or platform-level logic.
        It just happens to know how to create UI components (createButton, createDropdown).
        So creation is one of its jobs, not its whole purpose.
        That’s why it fits the Factory Method pattern — creation via overridden methods in subclasses.

🔹 2️⃣ IOSUIComponentFactory exists only to create components

        It doesn’t “represent” iOS — it doesn’t have data or behavior about the platform.
        It’s solely dedicated to producing iOS-style UI elements.
        Its only identity = “I’m a factory for a consistent family of UI products.”
        That’s why it’s Abstract Factory — a whole object whose single purpose is creation, not general behavior.


| Aspect                          | Factory Method                            | Abstract Factory                                                        |
| ------------------------------- | ----------------------------------------- | ----------------------------------------------------------------------- |
| Level of abstraction            | Method-level                              | Object-level                                                            |
| Object responsible for creation | Subclass (via inheritance)                | Separate factory (via composition)                                      |
| Main focus                      | One product type                          | Family of related products                                              |
| Example in your text            | `Platform` (AndroidPlatform, iOSPlatform) | `UIComponentFactory` (AndroidUIComponentFactory, iOSUIComponentFactory) |


Quick Development Rules

    1. If creation belongs to a “real object” → Factory Method.
    2. If creation needs guaranteed consistency across multiple product types → Abstract Factory.
    3. If you want independent factories for testing, reuse, or swapping families → Abstract Factory.
    
    | Scenario                                                                 | Pattern          |
    | ------------------------------------------------------------------------ | ---------------- |
    | Car object knows how to build its own engine & wheels                    | Factory Method   |
    | You have a CarPartsSupplier that provides a matching engine + wheels set | Abstract Factory |

 */
