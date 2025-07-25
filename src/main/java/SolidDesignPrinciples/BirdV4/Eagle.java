package SolidDesignPrinciples.BirdV4;

public class Eagle extends Bird implements Flyable {
    HighFlying highFlying; // composition - design principle of composing an object using one or more other objects to provide functionality.
    Eagle(){
        highFlying = new HighFlying();
    }
    @Override
    public void fly() {
//        System.out.println("Flying High");
        highFlying.flyHigh();
    }

    @Override
    public void makeSound() {

    }
}
