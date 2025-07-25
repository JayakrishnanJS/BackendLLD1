package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Puffin extends Bird implements Flyable, Swimmable {
    public Puffin(FlyingBehaviourType flyingBehaviourType) {
        super(flyingBehaviourType);
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
