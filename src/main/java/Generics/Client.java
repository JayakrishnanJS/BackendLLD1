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

        // 1. Compile time type safety is present
        // indiaPop.setFirst(25);
        // Double d = indiaPop.getFirst();

        // Raw types - we are not allowed to mention anything here, this is for backward compatibility(for older code)
        GenericPair gp = new GenericPair();

        // 2. Code Reusability - Generics allow the same class or method to be used for different
        // data types without duplication.
        // data2 as string datatype => S = String, K = String
        String dataStr  = GenericPair.doSomething("Mohit", "Sharma"); // print: "Mohit"
        System.out.println(dataStr); // Returns: "Sharma"


        // data2 as integer datatype( ~ old format) => S = String, K = Integer
        Integer dataInt = GenericPair.<String, Integer>doSomething("Mohit", 2); // print: "Mohit"
        System.out.println(dataInt); // Returns: 2

        // 3. Eliminating the Need for Type Casting
        List list1 = new ArrayList();  // Raw type - older java
        list1.add("String");
        String st1 = (String) list1.get(0);  // Manual casting

        List<String> list2 = new ArrayList<>();
        list2.add("String");
        String str2 = list2.get(0);  // No casting needed with Generics

        System.out.println("--------------- Test Generic method: Bound---------------");
        //- Polymorphism: The `animals` list and the `AnimalUtility` methods operate seamlessly because
        //  they work with base and derived types (like `Animal` and its subclasses).
        //- Generic: The use of generics in `AnimalUtility` methods allows them to handle lists
        //  of `Animal` and its subclasses/dog-related lists.

        // --- 1) Prepare a List<Animal> with mixed elements ---
        List<Animal> animals = new ArrayList<>();
        Animal a1 = new Animal();   a1.setName("Animal1");
        Mammal m1 = new Mammal();   m1.setName("Mammal1");
        Dog    d1 = new Dog();      d1.setName("Dog1");
        Cat    c1 = new Cat();      c1.setName("Cat1");
        animals.add(a1);
        animals.add(m1);
        animals.add(d1);
        animals.add(c1);

        System.out.println("Before any additions, animals contains:");
        AnimalUtility.printAnimalNames(animals);
        // Output: Animal1, Mammal1, Dog1, Cat1

        // --- 2) Use the lower‑bound wildcard to add more Dogs into that same List<Animal> ---
        //    addSomeDogs accepts List<? super Dog>, so List<Animal> is valid.
        AnimalUtility.addSomeDogs(animals, "Rover");
        System.out.println("\nAfter AnimalUtility.addSomeDogs(animals):");
        AnimalUtility.printAnimalNames(animals);
        // Output: Animal1, Mammal1, Dog1, Cat1, Dog(Rover)

        // --- 3) Show that you can also add directly in client because you know it's List<Animal> ---
        Dog d2 = new Dog();
        d2.setName("Tiger");
        animals.add(d2);   // legal because animals is List<Animal>
        System.out.println("\nAfter animals.add(new Dog(\"Tiger\")):");
        AnimalUtility.printAnimalNames(animals);
        // Output now includes Tiger at the end

        // --- 4) Prepare a pure List<Dog> and still use addSomeDogs ---
        List<Dog> dogList = new ArrayList<>();
        Dog d3 = new Dog();
        d3.setName("Fido");
        dogList.add(d3);
        System.out.println("\ndogList contains: " + d3.getName());
        AnimalUtility.printAnimalNames(dogList);

        // This works because List<Dog> is also List<? super Dog>
        AnimalUtility.addSomeDogs(dogList, "Rover2");
        System.out.println("\nDog list after AnimalUtility.addSomeDogs(dogList):");
        // We need to read back as Object or Dog:
        for (Dog d : dogList) {
            System.out.println("  " + d.getName());
        }
        // Output: Fido, Rover

        // --- 5) Demonstrate the upper‑bound wildcard for reading any subtype of Animal ---
        // printAnimalNames is declared <T extends Animal> List<T> printAnimalNames(List<T>)
        System.out.println("\nReading from both lists via printAnimalNames:");
        AnimalUtility.printAnimalNames(animals);   // List<Animal>
        AnimalUtility.printAnimalNames(dogList);   // List<Dog>

        // --- 6) Why List<? super Dog> cannot be passed to the reader directly ---
        List<? super Dog> superDogView = animals;
        // The following line would NOT compile:
        // AnimalUtility.printAnimalNames(superDogView);
        // because printAnimalNames expects a List<T extends Animal>, but superDogView is List<? super Dog>.
        // You’d have to cast or copy:
        // AnimalUtility.printAnimalNames((List<Animal>)superDogView);

        // -- 7) We cannot directly assign to Dog, because the element type is unknown beyond Object
        // Dog animal = superDogView.get(0); // ❌ compile‑time error
        System.out.println("\n---- we cannot safely read specific types other than `Object` ----");
        Object obj1 = superDogView.get(0);  // Animal
        Object obj2 = superDogView.get(2);  // Dog

        // Use a helper method to handle type checking and operations for both obj1 and obj2
        checkObject(obj1); // Not a Dog, it is: Animal
        checkObject(obj2); // Dog name: Dog1

        // 8) After adding and printing, pick out only the Dogs:
        System.out.println("\nFiltering out Dogs and making them bark:");
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog specificDog = (Dog) animal;
                // Now you can call Dog‑only methods:
                System.out.println(specificDog.getName() + " bark sounds like " + specificDog.bark());
            }
        }

    }

    // Define a helper method to check objects returned from AnimalUtility
    private static void checkObject(Object obj) {
        if (obj instanceof Dog) {
            Dog dog = (Dog) obj;
            System.out.println("Dog name: " + dog.getName());
            dog.bark();  // if bark() is available
        } else {
            System.out.println("Not a Dog, it is: " + obj.getClass().getSimpleName());
        }
    }
}

/*
- Type safety ensures that operations in a programming language occur on compatible types.
  In simpler terms, it ensures that you're using data in the correct way to avoid type-related errors.
- Generics were introduced to address concerns with type safety and code clarity.
*/