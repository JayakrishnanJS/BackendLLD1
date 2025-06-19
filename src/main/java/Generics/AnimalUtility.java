package Generics;

import java.util.List;

public class AnimalUtility {
    public static <T extends Animal> List<T> printAnimalNames(List<T> animals) {
        T firstAnimal = animals.get(0);
        for (T animal : animals){
            System.out.println(animal.getName());
        }
        return animals; // return list having T datatype
    }
    // restricts the type parameter `T` to be either the `Animal` class itself or any of its subclasses (e.g., `Mammal`, `Dog`, `Cat`).
    // `List<T>` as its argument, which means it expects a list of objects of type `T`.
    // Since `T` is restricted to be a subclass of `Animal`, the list can only contain `Animal` instances or instances of its subclasses.

    // Bounds in Generics refer to the constraints that are applied on generic types or wildcards to make them more specific.
    // They help to restrict the range of types that can be used with a generic method or class
    // Handle Polymorphism in a type-safe way by providing support for bounds using wildcard
    // The `?` is a wildcard in generics, meaning it represents an unknown type.
    public static void printAnimal(List<? extends Animal> animals) {
        // ? extends wildcard allows you to use a type and its subclasses (upper bound).
        // - extends is used to read data from a collection or method when you know you need a
        //   general or parent type but are unsure about the specific subtype.
        // - Here the compiler is confident that every element in the list can be safely treated as an `Animal`
        // => write operations are not allowed to avoid potential conflict

        // Exception
        // animals.add(null);  // Allowed
        for (Animal animal : animals){
            System.out.println(animal.getName());
        }
    }
    void addSomeDogs(List<? super Dog> temp) {
        // ? super wildcard allows you to use a type and its superclasses (lower bound).
        // - super is used to insert data into a collection when you know you'll only add specific subtypes of a type.
        // - Only write operations are allowed since We can add/insert elements of type `Dog` or its subclasses into the list because the list is guaranteed to accept them
        temp.add(new Dog());
        // - we cannot safely read specific types other than `Object`, because the compiler cannot guarantee the actual type of the list
        // - Since the exact runtime type (e.g., `List<Animal>`, `List<Object>`) is unknown, the compiler forces you to only read elements as `Object`.
        Object obj = temp.get(0);  // Allowed
        // Dog dog = temp.get(0);  // Compilation error
    }

    // Use of Generic methods: The addSomeDogs method takes the responsibility of both the below methods

//    void addSomeDogsInAnimalsList(List<Animal> temp) {
//        temp.add(new Dog());
//    }

//    void addSomeDogs(List<Dog> temp) {
//        temp.add(new Dog());
//    }
}
