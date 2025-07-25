package SolidDesignPrinciples.BirdV5;

import java.util.List;

public class Client {

    public static void doSomething(List<Flyable> birds){
        for(Flyable bird : birds) {
            bird.fly();
        }
    }

    public static void main(String[] args) {
        Bird b = new Pegion();
        Pegion b1 = new Pegion();
        Flyable f = new Pegion();

        // If there comes a bird which can do both flying, inject the dependency along with the object
        Sparrow sp = new Sparrow(new LowFlying()); // dependency injection - loose coupling
        sp.fly();
        sp.setFlyingBehaviour(new HighFlying());
        sp.fly();
    }
}
/*
The principle of dependency inversion refers to the decoupling of software modules.
DIP: > High-level modules should not depend on low-level modules. Both should depend on abstractions.
     > Abstractions should not depend on details. Details should depend on abstractions.
- our `LowFlying` and `HighFlying` classes are likely implementing a common abstraction or interface,
  such as `FlyingBehaviour`. This abstraction decouples the `Sparrow` class from specific flying behavior implementations.
- Instead of `Sparrow` creating or hardcoding an instance of `LowFlying` or `HighFlying` internally, you pass the \
  desired behavior as an abstraction (likely via a constructor or a setter).

*/

// PhonePe : YesBank => RBI said , yes bank you can't support transactions anymore
// PhonePe => <<BankAPI>> methods => Yes Bank Implemented these methods