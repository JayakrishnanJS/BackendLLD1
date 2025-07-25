package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class FlyingBehaviourFactory {

    public static FlyingBehaviour createFlyingBehaviourByType(FlyingBehaviourType flyingBehaviourType){
        FlyingBehaviour flyingBehaviour = null;
        if(flyingBehaviourType == FlyingBehaviourType.LOW){
            flyingBehaviour = new LowFlying();
        } else if(flyingBehaviourType == FlyingBehaviourType.HIGH){
            flyingBehaviour = new HighFlying();
        }
        return flyingBehaviour;
    }
}
