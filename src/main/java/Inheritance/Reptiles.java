package Inheritance;

public class Reptiles extends Animal{
    String type;

    // 1️⃣ Default constructor
    Reptiles() {
        // Implicit call: super(); → calls Animal's default constructor
        System.out.println("Default Constructor");
    }

    // 2️⃣ Parameterized constructor
    Reptiles(String type) {
        // Implicit call: super(); → again, calls Animal's default constructor
        this.type = type;
        System.out.println("Reptiles constructor called with type: " + type);
    }
}