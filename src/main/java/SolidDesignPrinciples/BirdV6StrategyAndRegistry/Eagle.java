package SolidDesignPrinciples.BirdV6StrategyAndRegistry;

public class Eagle extends Bird implements Flyable {
//    FlyingBehaviour flyingBehaviour;
//    Eagle(){
//        flyingBehaviour = new HighFlying();
//    }
    Eagle(FlyingBehaviourType flyingBehaviourType){
        super(flyingBehaviourType);
        //flyingBehaviour = new HighFlying();
    }
    @Override
    public void fly() {
//        System.out.println("Flying High");
        flyingBehaviour.doFlying();
    }

    @Override
    public void makeSound() {

    }
}
