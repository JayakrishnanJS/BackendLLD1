package Inheritance;

public class Client {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Mammals mammals = new Mammals();
        Dog dog = new Dog();
        //mammals.animalID = 10;  You cannot access private data members of parent class, use setters and getters to access

            //ConstructorChaining
            // Animal->Mammals->Dog (Top to Bottom)
            // When you initialize dog (child class), constructors of parents are called first
            // Constructor of Animal->Mammals->Dog is called in the same order when you create (call constructor of Dog) dog object.

        dog.eat();
        Snake python = new Snake("Cold-blooded", "Python");
        Frog frog = new Frog();
        System.out.println("");
    }
}
