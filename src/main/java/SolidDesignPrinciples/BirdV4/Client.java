package SolidDesignPrinciples.BirdV4;

import SolidDesignPrinciples.BirdV3.Sparrow;

import java.util.List;

public class Client {

    public static void doSomething(List<Flyable> birds){
        for(Flyable bird : birds) {
            bird.fly();
        }
    }

    public static void main(String[] args) {
        Bird b = new Pegion();
        Pegion p = new Pegion();
        p.fly();
        //p.swim(); // not possible for Pegion to swim
        Flyable f = new Pegion();
        Puffin birdWhichCanSwimAndFly = new Puffin();
        birdWhichCanSwimAndFly.eat();
        birdWhichCanSwimAndFly.makeSound();
        birdWhichCanSwimAndFly.fly();
        birdWhichCanSwimAndFly.swim();

        System.out.println("---------------");
        Sparrow sp = new Sparrow();
        sp.setName("Sparrow");
        sp.fly();
        sp.eat();
        Eagle e = new Eagle();
        e.setName("Eagle");
        e.fly();
        e.eat();
        System.out.println();
    }
}
/*
Interface Segregation Principle (ISP): "Keep interfaces as light as possible" or "Interfaces should have as few methods as possible."
Interface Segregation was demonstrated when we split behaviors into separate interfaces rather than having one big interface.
For example, instead of having one interface with both fly() and swim():

interface Movable {
    fly();
    swim();
}

We segregated into:

interface Flyable {
    fly();
}
interface Swimmable {
    swim();
}

This way:
Birds that can only fly implement just Flyable
Birds that can only swim implement just Swimmable
Birds that do both can implement both interfaces
This follows ISP by keeping interfaces light and focused on specific behaviors
*/

/*
- Flyable can be further classified as lowFlying and highFlying, to satisfy OCP and SRP we need to implement these 2 behaviors as 2 classes.
  We use composition relation by declaring particular object of these 2 classes to respective Bird subclasses which show Flyable behavior
  Eagle - HighFlying, Sparrow - LowFlying
  But if there are 60 birds in which 20 can low-fly and 40 can high-fly, 20 of these have the same code duplicated and the other
  60 has the same code => Code duplication is too much
  Dependency Inversion can be used to solve this
*/
