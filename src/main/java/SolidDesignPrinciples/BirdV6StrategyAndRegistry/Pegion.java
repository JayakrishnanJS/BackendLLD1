package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Pegion extends Bird implements Flyable {
    public Pegion(FlyingBehaviourType flyingBehaviourType) {
        super(flyingBehaviourType);
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void fly() {
        System.out.println("Flying Low");
    }
}
