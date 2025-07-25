package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Sparrow extends Bird implements Flyable {
   //FlyingBehaviour flyingBehaviour; // added to Bird
    Sparrow(FlyingBehaviourType flyingBehaviourType){
        super(flyingBehaviourType);// can be low or high
        // this.flyingBehaviour = new LowFlying();
        //this.flyingBehaviour = flyingBehaviour;
        //this.flyingBehaviour = FlyingBehaviourFactory.createFlyingBehaviourByType(flyingBehaviourType);
    }
    @Override
    public void makeSound() {

    }

    @Override
    public void fly() {
//        System.out.println("Flying Low");
        //lowFlying.flyLow();
        flyingBehaviour.doFlying();
    }

    public FlyingBehaviour getFlyingBehaviour() {
        return flyingBehaviour;
    }

//    public void setFlyingBehaviour(FlyingBehaviour flyingBehaviour) {
//        this.flyingBehaviour = flyingBehaviour;
//    }
    public void setFlyingBehaviour(FlyingBehaviourType flyingBehaviourType) {
        this.flyingBehaviour = FlyingBehaviourFactory.createFlyingBehaviourByType(flyingBehaviourType);
    }
}
