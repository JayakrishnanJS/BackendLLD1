package Inheritance;

public class Client {
    public static void main(String[] args) {
        System.out.println("--------------- Inheritance ---------------");
        Animal animal = new Animal();
        Mammals mammals = new Mammals();
        Dog dog = new Dog();
        //mammals.animalID = 10;  You cannot access private data members of parent class, use setters and getters to access

        System.out.println("--------------- Test Constructor overloading using super(...) ---------------");
        dog.eat();
        Snake python = new Snake("Cold-blooded", "Python");

        System.out.println("--------------- Test Constructor telescoping using this(...) ---------------");
        Frog frog = new Frog();
        System.out.println("");
    }
}
/*
 - Inheritance is the mechanism that allows one class to acquire all the properties from
   another class by inheriting the class. We call the inheriting class a child class and
   the inherited class as the superclass or parent class.
 - Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

 Types of inheritance
 There are four types of inheritance:
 - Single - A single inheritance is when a class can have only one parent class.
 - Multilevel - A multilevel inheritance is when a class can have multiple parent
                classes at different levels.
 - Hierarchical - When two or more classes inherits a single class, it is known
                  as hierarchical inheritance.
 - Multiple - When a class can have multiple parent classes, it is known as
              multiple inheritance.

 - Diamond problem: In multiple inheritance one class inherits the properties of multiple classes. In
                    other words, in multiple inheritance we can have one child class and n number of
                    parent classes. Java does not support multiple inheritance (with classes).
*/

/*
 Constructor Chaining: Constructor chaining is the process of calling one constructor from another constructor, either
                        within the same class using this(...), or from a parent class using super(...), during object creation.

    1. super(...) - Initializing inherited fields in subclasses(Constructor Overloading)
    2. this(...) - Telescoping constructors - refer to a design pattern where multiple constructors in the same class
                    call each other using this(...) to avoid code duplication.
 */

/* use of super():
    Animal → Mammal → Dog
    Creating a Dog instance triggers a cascade of constructor calls:
        Dog’s constructor invokes Mammal’s via super(…),
        Mammal’s constructor then invokes Animal’s in turn.
    This top-to-bottom sequence ensures each level of the inheritance chain is fully initialized.
    The super(...) call in a subclass delegates initialization to its immediate parent constructor.

   use of this():

 */