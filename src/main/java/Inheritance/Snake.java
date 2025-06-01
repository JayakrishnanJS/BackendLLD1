package Inheritance;

public class Snake extends Reptiles {
    String species;

    Snake(String type, String species) {
        super(type); // Call Reptiles' constructor with `type` instead of default constructor of Reptiles
        this.species = species;
        System.out.println("Snake constructor called with species: " + species);
    }
}