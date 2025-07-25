package Inheritance;

public class Animal {
    String name;
    private int animalID;

    // no-argument constructor
    Animal(){
        name = "Animal";
        animalID = 2;
        System.out.println("Animal constructor called.");
    }

    void eat(){
        System.out.println("Animal is eating.");
    }
}
