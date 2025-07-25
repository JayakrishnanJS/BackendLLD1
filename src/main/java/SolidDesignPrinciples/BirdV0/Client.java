package SolidDesignPrinciples.BirdV0;

public class Client {
    public static void main(String[] args) {

        Bird b1 = new Bird();
        b1.setAge(10);
        b1.setName("b1");
        b1.setType("Peacock");

        b1.eat();

        b1.makeSound();

        Bird b2 = new Bird();
        b2.setAge(10);
        b2.setName("b1");
        b2.setType("Crow");

        b2.eat();

        b2.makeSound();
    }
}
// Violates SRP and OCP
/*
 SRP: Bird class tries to manage multiple unrelated responsibilities within a single class, which can lead to
    coupling and increased maintenance difficulty
    some birds cannot fly, some need to swim which makes bird class handle multiple responsibilities.
OCP: makeSound() method tries to handle sounds for every possible bird type by manually checking
     `type` through an if-else chain. If a new bird species with a
     new sound needs to be added, you would need to:
        - Modify this method.
        - Maintain increasing complexity as more bird types/sounds are added.
- This makes the class difficult to maintain and highly prone to errors when extended.
- Reason to change? If new bird sounds or types are introduced, the `Bird` class must be changed.
 */
