package SolidDesignPrinciples.BirdV5;

public class Vulture extends Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Flying High");
    }

    @Override
    public void makeSound() {

    }
}
