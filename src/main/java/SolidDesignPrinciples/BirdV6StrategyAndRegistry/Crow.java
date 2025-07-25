package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Crow extends Bird implements Flyable {
    public Crow(FlyingBehaviourType flyingBehaviourType) {
        super(flyingBehaviourType);
    }

    @Override
    public void fly() {
        System.out.println("Flying Low");
    }

    @Override
    public void makeSound() {

    }
}
