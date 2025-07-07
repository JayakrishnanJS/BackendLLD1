package SOLID.BirdV5;

public class Sparrow extends Bird implements Flyable {
    FlyingBehaviour flyingBehaviour;
    Sparrow(FlyingBehaviour flyingBehaviour){
//        this.flyingBehaviour = new LowFlying();
        this.flyingBehaviour = flyingBehaviour;
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

    public void setFlyingBehaviour(FlyingBehaviour flyingBehaviour) {
        this.flyingBehaviour = flyingBehaviour;
    }
}
