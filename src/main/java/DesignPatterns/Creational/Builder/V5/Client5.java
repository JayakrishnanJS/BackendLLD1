package DesignPatterns.Creational.Builder.V5;

public class Client5 {
    public static void main(String[] args) {
    // Creating a SoldItem object using the Builder Design Pattern.
    // The SoldItem class enforces the use of a Builder by keeping its constructor private.
    // The getBuilder method initializes immutable mandatory attributes (id and name).

        // 1) Create an original SoldItem via the new builder(...)
        SoldItem soldItem = SoldItem
                .getBuilder(1, "Laptop")
                .setPrice(1_000)
                .setQuantity(10)      // valid: ≥ 5
                .setPrime(true)       // mark as Prime
                .setDiscount(10.5)
                .setPaymentMethod("Credit Card")
                .build();
        System.out.println();

//        // Print original quantity
//        System.out.println("Original SoldItem Quantity: " + soldItem.getQuantity());
//
//        // 2) Use toBuilder() to create a modified copy
//        SoldItem updatedSoldItem = soldItem.toBuilder()
//                .quantity(15)      // update just the quantity
//                .build();
//
//        // Print updated quantity
//        System.out.println("Updated SoldItem Quantity: " + updatedSoldItem.getQuantity());

        // 3) Attempt to build an item with invalid quantity (< 5)
        try {
            SoldItem badItem = SoldItem
                    .getBuilder(2, "Smartphone")
                    .setPrice(500)
                    .setQuantity(3)    // too small—should trigger IllegalStateException
                    .build();
            // If we somehow get here, print its quantity
            System.out.println("BadItem Quantity: " + badItem.getQuantity());
        } catch (IllegalStateException e) {
            System.err.println("Failed to build SoldItem: " + e.getMessage());
        }
    }
}


// Builder design pattern is a creational design pattern that allows for the step-by-step construction of complex objects.
// It is particularly useful when an object requires many parameters, some of which are optional.

// Intent of the Builder Pattern:
// 1. To separate the construction of a complex object from its representation so that the same construction process
//    can create different representations.

// Structure of the Builder Pattern:
// 1. Builder: A class that constructs the object step by step.
// 2. Product: The complex object that is being built.
// 3. Client: The class that uses the Builder to create the object.
// 4. Director (optional): A class that defines the order in which to call the builder methods. In this case,
//                         we will not use a Director class as the client will directly use the Builder.