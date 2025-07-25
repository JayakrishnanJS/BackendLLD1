package Inheritance;

public class Amphibians extends Animal{
    // this() is used to call another constructor in the same class.
    // It must be the first statement in the constructor.
    // Useful for constructor chaining to reuse initialization logic.

    int amphibianID;
    String habitat;

    // 1) No-argument constructor
    public Amphibians() {
        super();
        // ↑ Implicitly calls Animal() even if you don’t write super().
        // Now that super() is explicit, it’s clear: “invoke Animal’s no-arg constructor.”
        System.out.println("Inside Amphibians(): no-arg body");
    }

    // 2) Single-parameter constructor
    public Amphibians(int id) {
        this();
        // ↑ Calls Amphibians() (the no-arg constructor), which in turn calls Animal().
        this.amphibianID = id;
        System.out.println("Inside Amphibians(int): amphibianID = " + id);
    }

    // 3) Two-parameter constructor (the “base” constructor)
    public Amphibians(int id, String habitat) {
        this(id);
        // ↑ Calls Amphibians(int), which calls Amphibians() → Animal().
        this.habitat = habitat;
        System.out.println("Inside Amphibians(int, String): amphibianID = "
                + id + ", habitat = " + habitat); // printed at last after executing above 2 constructors according to this()
    }

    void swim() {
        System.out.println("Amphibian swims in " + habitat);
    }
}
