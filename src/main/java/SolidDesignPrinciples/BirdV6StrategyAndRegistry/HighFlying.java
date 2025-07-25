package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class HighFlying implements FlyingBehaviour {
    @Override
    public void doFlying() {
        System.out.println("Flying High");
    }
}
