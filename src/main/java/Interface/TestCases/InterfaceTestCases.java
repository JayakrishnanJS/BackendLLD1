package Interface.TestCases;

public class InterfaceTestCases {

    /*
     * This class demonstrates seven different use cases of Java interfaces.
     * Each use case is encapsulated in a distinct static method (useCase1 … useCase7),
     * and the main method invokes them in sequence.
     * Explanatory comments before each method clarify the concept being shown.
     */

    // ------------------------------------------------------------------------
    // Use Case 1: Basic Interface Implementation
    // ------------------------------------------------------------------------
    // Concept: A class implements an interface by providing concrete implementations
    //          of its abstract methods. Here, Dog implements the Animal interface.
    interface Animal {
        void makeSound();
    }

    static class Dog implements Animal {
        @Override
        public void makeSound() {
            System.out.println("Dog says: Bark");
        }
    }

    public static void useCase1() {
        System.out.println("Use Case 1: Basic Interface Implementation");
        // Create an interface reference and assign it an instance of Dog.
        Animal dog = new Dog();
        dog.makeSound(); // Dynamic dispatch: Dog's makeSound() is called.
    }

    // ------------------------------------------------------------------------
    // Use Case 2: Multiple Interfaces
    // ------------------------------------------------------------------------
    // Concept: A class can implement more than one interface, which lets it promise
    //          to provide multiple sets of behavior. Duck implements both Flyable and Swimmable.
    interface Flyable {
        void fly();
    }

    interface Swimmable {
        void swim();
    }

    static class Duck implements Flyable, Swimmable {
        @Override
        public void fly() {
            System.out.println("Duck flies");
        }

        @Override
        public void swim() {
            System.out.println("Duck swims");
        }
    }

    public static void useCase2() {
        System.out.println("Use Case 2: Multiple Interfaces");
        Duck duck = new Duck(); // Duck can both fly and swim
        duck.fly();
        duck.swim();
    }

    // ------------------------------------------------------------------------
    // Use Case 3: Default Method in Interface
    // ------------------------------------------------------------------------
    // Concept: An interface can include a default method with an implementation.
    //          Classes implementing the interface inherit that method unless they override it.
    interface Logger {
        default void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    static class FileLogger implements Logger {
        // Inherits the default log() implementation from Logger.
        // No need to override if default behavior is desired.
    }

    static class CustomLogger implements Logger {
        @Override
        public void log(String message) {
            System.out.println("Custom Log: " + message); // Override default behavior
        }
    }

    public static void useCase3() {
        System.out.println("Use Case 3: Default Method in Interface");
        Logger fileLogger = new FileLogger();
        fileLogger.log("Default logger working");

        Logger customLogger = new CustomLogger();
        customLogger.log("Overridden logger working");
    }

    // ------------------------------------------------------------------------
    // Use Case 4: Interface Inheritance
    // ------------------------------------------------------------------------
    // Concept: An interface can extend another interface, adding more methods.
    //          Car extends Vehicle, so any class implementing Car must supply both start() and turnOnAC().
    interface Vehicle {
        void start();
    }

    interface Car extends Vehicle {
        void turnOnAC();
    }

    static class Sedan implements Car {
        @Override
        public void start() {
            System.out.println("Car started");
        }

        @Override
        public void turnOnAC() {
            System.out.println("AC is on");
        }
    }

    public static void useCase4() {
        System.out.println("Use Case 4: Interface Inheritance");
        Car myCar = new Sedan();
        myCar.start();
        myCar.turnOnAC();

        System.out.println("Using parent interface reference:");
        Vehicle vehicleRef = new Sedan();
        vehicleRef.start();
        // vehicleRef.turnOnAC(); // Compile-time error: Vehicle interface does not declare turnOnAC()
    }

    // ------------------------------------------------------------------------
    // Use Case 5: Marker Interface
    // ------------------------------------------------------------------------
    // Concept: A marker interface contains no methods. It marks a class as having some attribute.
    //          Here, Serializable is used purely as a tag. 'instanceof' can check for it at runtime.
    interface Serializable {}

    static class Data implements Serializable {
        // Class is “marked” as Serializable, even though no methods are defined in the interface.
    }

    static class NonSerializableData {
        // Not marked by Serializable.
    }

    public static void useCase5() {
        System.out.println("Use Case 5: Marker Interface");
        Data data = new Data();
        NonSerializableData nonData = new NonSerializableData();

        // Check at runtime whether objects implement the marker interface:
        System.out.println("Data is Serializable: " + (data instanceof Serializable));
        System.out.println("NonData is Serializable: " + (nonData instanceof Serializable));
    }

    // ------------------------------------------------------------------------
    // Use Case 6: Interface Reference to Concrete Class
    // ------------------------------------------------------------------------
    // Concept: An interface variable can hold a reference to any implementing class.
    //          To call subclass-specific methods, you must downcast safely (using instanceof).
    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing Circle");
        }

        public void extraMethod() {
            System.out.println("Circle-specific method");
        }
    }

    public static void useCase6() {
        System.out.println("Use Case 6: Interface Reference to Concrete Class");
        Shape shapeRef = new Circle(); // Upcasting: Circle → Shape
        shapeRef.draw();
        //shapeRef.extraMethod(); // cannot directly access circle methods from shape reference

        // To access Circle-specific methods, we check and downcast:
        if (shapeRef instanceof Circle) {
            ((Circle) shapeRef).extraMethod();
        }
    }

    // ------------------------------------------------------------------------
    // Use Case 7: Type Casting and instanceof with Interface
    // ------------------------------------------------------------------------
    // Concept: Use instanceof to check the actual type before downcasting to avoid ClassCastException.
    interface Printer {
        void print();
    }

    static class InkjetPrinter implements Printer {
        @Override
        public void print() {
            System.out.println("Inkjet printing...");
        }

        public void refillInk() {
            System.out.println("Refilling ink...");
        }
    }

    public static void useCase7() {
        System.out.println("Use Case 7: Type Casting and instanceof with Interface");
        Printer printer = new InkjetPrinter();
        printer.print();

        // Safe downcast after instanceof check:
        if (printer instanceof InkjetPrinter) {
            ((InkjetPrinter) printer).refillInk();
        }

        System.out.println("Invalid Cast Test:");
        try {
            // Unsafe cast: Printer is not a Circle, so this will throw ClassCastException:
            Circle notAPrinter = (Circle) printer;
        } catch (ClassCastException e) {
            System.out.println("Caught expected ClassCastException");
        }
    }

    // ------------------------------------------------------------------------
    // Main Method: Invoke all use case methods in sequence
    // ------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=== Interface Use Cases Demonstration ===\n");

        useCase1();
        System.out.println();

        useCase2();
        System.out.println();

        useCase3();
        System.out.println();

        useCase4();
        System.out.println();

        useCase5();
        System.out.println();

        useCase6();
        System.out.println();

        useCase7();
        System.out.println("\n=== End of Demonstration ===");
    }
}
