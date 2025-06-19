package Generics;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Pair pair = new Pair();
//        String, double
        pair.setFirst("Mohit");
        pair.setSecond(20.0);

//        No type safety
        pair.setFirst(125);

        GenericPair<String, Integer> indiaPop = new GenericPair<>();
        indiaPop.setFirst("India");
        indiaPop.setSecond(20);

//        1. Compile time type safety is present
//        indiaPop.setFirst(25);
//        Double d = indiaPop.getFirst();

//        you are allowed to not mention anything
//        this is for backward compatibility : Raw types
        GenericPair gp = new GenericPair();

//        2. Code Reusability - Generics allow the same class or method to be used for different data types without duplication.
//        tie S to String
        String d2  = GenericPair.doSomething("Mohit", "Sharma"); // data2 as string datatype
        // S = String, K = String
        // Output: "Mohit"
        // Returns: "Sharma"

        Integer d1 = GenericPair.<String, Integer>doSomething("Mohit", 2); // old format, data2 as integer datatype
        // S = String, K = Integer
        // Output: "Mohit"
        // Returns: 2

        Animal animal = new Animal();
        animal.setName("Animal1");
        Mammal mammal = new Mammal();
        mammal.setName("Mammal1");
        Dog dog = new Dog();
        dog.setName("Dog1");
        Cat cat = new Cat();
        cat.setName("Cat1");

//      3. Eliminating the Need for Type Casting
        List list1 = new ArrayList();  // Raw type - older java
        list1.add("String");
        String st1 = (String) list1.get(0);  // Manual casting

        List<String> list2 = new ArrayList<>();
        list2.add("String");
        String str2 = list2.get(0);  // No casting needed with Generics

        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(mammal);
        animals.add(dog);
        animals.add(cat);

        AnimalUtility.printAnimalNames(animals);


        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);

        AnimalUtility.printAnimalNames(dogs);
    }
}

/*
- Type safety ensures that operations in a programming language occur on compatible types.
  In simpler terms, it ensures that you're using data in the correct way to avoid type-related errors.
- Generics were introduced to address concerns with type safety and code clarity.
 * */