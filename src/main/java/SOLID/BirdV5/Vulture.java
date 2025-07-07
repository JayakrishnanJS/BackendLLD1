package SOLID.BirdV5;

import SOLID.BirdV3.Movable;

public class Vulture extends Bird implements Movable {
    @Override
    public void fly() {
        System.out.println("Flying High");
    }

    @Override
    public void makeSound() {

    }
}
