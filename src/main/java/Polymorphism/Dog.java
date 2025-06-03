package Polymorphism;

public class Dog extends Animal {

   /* When you override a method, the return type in the subclass must be:
        a. Exactly the same as the superclass method’s return type, or
        b. A subclass of that return type (covariant).
    */

    @Override
    void speak() {
        System.out.println("Dog barks");
    }

    @Override
    Dog eat(){ // Dog is a covariant subclass of Animal, so eat() method can be overrided
        System.out.println("Dog eats");
        return null;
    }

    void wagTail() {
        System.out.println("Dog wags tail");
    }

    // Overriding a private method (doesn't work)
    // @Override
    private void sayHi() {
        System.out.println("Dog says hi");
    }

}
