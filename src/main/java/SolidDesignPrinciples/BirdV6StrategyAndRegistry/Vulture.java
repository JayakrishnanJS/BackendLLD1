package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Vulture extends Bird implements Flyable {
    public Vulture(FlyingBehaviourType flyingBehaviourType) {
        super(flyingBehaviourType);
    }

    @Override
    public void fly() {
        System.out.println("Flying High");
    }

    @Override
    public void makeSound() {

    }
}
