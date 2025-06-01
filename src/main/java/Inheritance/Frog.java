package Inheritance;

public class Frog extends Amphibians{
    Frog(){
        super(3, "water"); // calls constructor in parent Amphibians with 2 parameters
        System.out.println("Frog Constructor");
    }
}
