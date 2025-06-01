package Inheritance;

public class Dog extends Mammals{
    int dogID;
    int dogName;
    // If you don’t write any constructor, Java gives you a default constructor,
    // and when you instantiate a subclass, it automatically calls the parent constructor too.
    /*     Scenario	                                    What happens
    No constructor written at all	              Compiler inserts default () constructor
    Parent has no-arg constructor	              Child can call it automatically using super()
    Parent has only parameterized constructor	  Child must call it manually with arguments
    Constructor chaining	                      super() is called first (implicitly or explicitly), always before child constructor body
    */
    Dog(){
//        Animal();  // Java *automatically* calls super class constructors in order.
//        Mammals(); // before data member of Dog are initialized, constructor of Animal & Mammals are called automatically
//        super(); // refers to the immediate parent class automatically by java if there is a default or no-args constructor in parent class
        // we can also control whether we use parent's method or child's method using super.parent_method_name();
        super.sleep(); // Mammal's sleep function
        super.eat(); // Animal's eat function via Mammals (if not overridden in Mammals)
        eat();// Call Dog’s own overridden `eat()` method
        sleep(); // Dog's inherited or own `sleep()` method
        dogID = super.mammalID; // Access Mammals’ field using `super`
        dogName = 10;
    }

    void bark(){
        System.out.println("Dogs bark !!");
    }

    void eat(){
        super.eat(); // calls the closest ancestor where eat() is present - This will call Mammals' `eat()` if present, else Animal’s
        System.out.println("Dog is eating.");
    }
}
