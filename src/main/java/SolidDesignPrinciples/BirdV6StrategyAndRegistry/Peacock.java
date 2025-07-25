package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Peacock extends Bird implements Flyable {
    public Peacock() {
        super(FlyingBehaviourType.NONE); // Pass the type to parent
    }

    @Override
    public void fly() {
        System.out.println("Peacock is flying");
    }

    @Override
    public void makeSound() {
        System.out.println("EWEWEWEEWEWEW");
    }
}
