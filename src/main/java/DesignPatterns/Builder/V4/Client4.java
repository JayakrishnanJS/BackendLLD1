package DesignPatterns.Builder.V4;

public class Client4 {
    public static void main(String[] args) {

//        SoldItemBuilder soldItemBuilder = new SoldItemBuilder();
        // Method Chaining enabled us to set an Object step by step with less complexity
        SoldItem soldItem =
                SoldItem
                        .getBuilder() // initialize new builder
                        .setId(1) // set and return object to next setter of builder
                        .setName("SoldItem")
                        .setPrice(100)
                        .setQuantity(10)
                        .setDiscount(0.2)
                        .setPrime(true)
                        .build(); // create new SoldItem instance and copy builder data to it

//        soldItemBuilder.setId(1);
//        soldItemBuilder.setName("SomeItem");
//        soldItemBuilder.setPrice(100);
//        soldItemBuilder.setQuantity(10);
//        soldItemBuilder.setDiscount(.2);
//        soldItemBuilder.setPrime(true);

//        SoldItem soldItem = new SoldItem(soldItemBuilder);


    }
}

// A common goal of the builder pattern is to create immutable objects, ensuring the created object remains consistent and thread-safe.
// Pblm here: No proper encapsulation and immutability: attributes are not final, constructor is not private














