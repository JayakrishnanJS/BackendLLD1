package SOLID.BirdV3;

public class Peacock extends Bird implements Movable {
    @Override
    public void fly() {
        System.out.println("Peacock is flying");
    }

    @Override
    public void swim() {

    }

    @Override
    public void makeSound() {
        System.out.println("EWEWEWEEWEWEW");
    }
}
