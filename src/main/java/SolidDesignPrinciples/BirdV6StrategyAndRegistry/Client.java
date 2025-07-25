package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

import java.util.List;
import java.util.Scanner;

import static SolidDesignPrinciples.BirdV6StrategyAndRegistry.FlyingBehaviourType.HIGH;
import static SolidDesignPrinciples.BirdV6StrategyAndRegistry.FlyingBehaviourType.LOW;
import static java.lang.String.valueOf;

public class Client {

    public static void doSomething(List<Flyable> birds){
        for(Flyable bird : birds) {
            bird.fly();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // If there comes a bird which can do both flying, inject the dependency along with the object
        // Sparrow sp = new Sparrow(new LowFlying()); // dependency injection - loose coupling
        // Constructor of sparrow can take ENUM directly or by methodName.ENUM
        System.out.println("Injured Sparrow");
        Sparrow sp = new Sparrow(FlyingBehaviourType.NONE);
        System.out.println(sp.canFlyOrNot());

        System.out.println("Normal Sparrow");
        sp = new Sparrow(LOW);
        System.out.println(sp.canFlyOrNot());
        sp.fly();

        //sp.setFlyingBehaviour(new HighFlying());
        System.out.println("Enter FlyingBehaviourType: LOW/HIGH"); // cannot take NONE since sparrow has fly() method
        sp.setFlyingBehaviour(FlyingBehaviourType.valueOf((sc.nextLine()).toUpperCase())); // here wrapping is required, cant take ENUM directly
        sp.fly();

        // Earlier I cannot create a Penguin with FlyingBehaviourType as NONE, since each bird subclasses where having it
        // only for those birds which can fly, I moved it to parent Bird and all child birds can use super to pass
        // flyingBehaviourType. e.g, iam setting it as NONE in Penguin Constructor call
        System.out.println("Penguin");
        Bird pg = new Penguin();
        System.out.println(pg.getFlyingBehaviourType());
        System.out.println(pg.canFlyOrNot());
    }
}
/*
    Used Strategy and Factory design pattern to remove hardcoded object instantiation by client
*/
