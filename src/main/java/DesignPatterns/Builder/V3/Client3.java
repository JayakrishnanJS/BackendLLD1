package DesignPatterns.Builder.V3;

public class Client3 {
    public static void main(String[] args) {

        // 1. Builder Initialization
        SoldItemBuilder soldItemBuilder = new SoldItemBuilder();
        /* a `SoldItem` object is fully initialized with all properties populated as per the builder's configuration.
           The builder allows flexibility for creating `SoldItem` objects without requiring multiple constructors in
           the `SoldItem` class.*/

        // 2. Setting Properties on the Builder - setters of Builder used for creating immutable objects
        soldItemBuilder.setId(1);
        soldItemBuilder.setName("SomeItem");
        soldItemBuilder.setPrice(100);
        soldItemBuilder.setQuantity(10);
        soldItemBuilder.setDiscount(.2);
        soldItemBuilder.setPrime(true);

        // 3.Creating a SoldItem(new instance) from the Builder
        SoldItem soldItem = new SoldItem(soldItemBuilder);
        // It has a constructor that accepts a `SoldItemBuilder` and initializes its fields from the respective properties
        // in the builder.
    }
}

/*

Builder is a creational design pattern that lets you construct complex objects step by
step. The pattern allows you to produce different types and representations of an
object using the same construction code.

1. The builder class (`SoldItemBuilder`) is used to configure property values like `id`, `name`, `price`, `quantity`,
   `discount`, and `isPrime`. These values represent data that will be encapsulated in a `SoldItem` object.
2. `SoldItem` is a class that has a constructor capable of accepting a `SoldItemBuilder` object and initializing
    its own fields using the builder's property values.
3. The builder pattern offers the benefit of separating the construction of an object (through the builder)
   from its representation (the `SoldItem` object).

Working:
1. `SoldItemBuilder` collects all the data needed for a `SoldItem` object.
2. Each property (e.g., `id`, `name`, etc.) is set using `SoldItemBuilder`'s setter methods.
3. Once all properties are set, the builder is passed to the `SoldItem` constructor.
4. The `SoldItem` constructor initializes its fields using the values from the builder.

*/

/*
1. Lack of Method Chaining in the Builder:
    - the builder's setters are used individually in separate lines.
    - makes the code less expressive, and forces the user to write repetitive lines to configure the object.
2. No Separation of Concerns: Tight coupling
    - Delegating the initialization responsibility to the `SoldItem` constructor couples the `SoldItem` class and
      the builder more tightly than necessary
3. Builder may produce incomplete or invalid instances if the user forgets to set a required property (e.g., `id` or `price`).
4. Over work for Client to initialize builder
*/