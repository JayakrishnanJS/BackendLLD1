package SolidDesignPrinciples.BirdV3;

import java.util.List;

public class Client {

    public static void doSomething(List<Movable> birds){
        for(Movable bird : birds) {
            bird.fly();
            bird.swim();
        }
    }

    public static void main(String[] args) {
        Bird bird = new Pegion();
        Movable movablePegion = new Pegion();
        Pegion pegion = new Pegion();
        pegion.fly();
        //pegion.swim(); // incorrect behavior
        pegion.makeSound();
        Movable puffinBird = new Puffin();
        System.out.println();
        puffinBird.swim();
        puffinBird.fly();
    }
}

/*
- LSP: a derived class must be able to replace its base class without causing unexpected behavior.
- abstract classes and interfaces are likely used to define shared behaviors across all bird types
- an abstract `Bird` base class defines general bird behaviors like `makeSound()` and properties like
  `name` and `age`.
- Specific bird behaviors, such as `fly()` or `dance()`, are represented by separate interfaces
  (e.g., `Movable`, `Danceable`).
- Subclasses like `Peacock`, `Penguin`, or `Crow` must implement these behaviors in a manner
   that satisfies the expectations of the parent type.
- If a `Bird` is expected to have a `makeSound()` method, every subclass of `Bird` will honor that
  contract, ensuring it can be substituted without breaking functionality.
- Multiple Inheritance and polymorphism are achieved through these Interfaces and Abstract classes.
*/

/*
Here the Movable interface has 2 methods fly() and swim(), but most of the Birds cannot implement these 2 together
This problem is solved By ISP
*/
