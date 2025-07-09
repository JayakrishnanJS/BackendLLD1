package DesignPatterns.Builder.V5;

public class Client5 {
    public static void main(String[] args) {
        try {
            // Using the Builder to create a SoldItem object:
            // If the constructor of `SoldItem` class is private,  then it suggests that the `SoldItem` class uses
            // the Builder Design Pattern to restrict direct instantiation and allow object creation through the
            // `SoldItemBuilder` class.
            SoldItem soldItem = new SoldItem.SoldItemBuilder()
                    .setId(1)
                    .setName("Laptop")
                    .setPrice(1000)
                    .setQuantity(10)  // Valid quantity > 5
                    .setPrime(true)
                    .setDiscount(10.5)
                    .setPaymentMethod("Credit Card")
                    .build();

            // Print details of the SoldItem
            System.out.println("SoldItem Details:");
            System.out.println("ID: " + soldItem.getId());
            System.out.println("Name: " + soldItem.getName());
            System.out.println("Price: " + soldItem.getPrice());
            System.out.println("Quantity: " + soldItem.getQuantity());
            System.out.println("Prime: " + soldItem.isPrime());
            System.out.println("Discount: " + soldItem.getDiscount());
            System.out.println("Payment Method: " + soldItem.getPaymentMethod());
//  If we want to update a field of an Object, we get a new Object copy with updated fields.
//  Not suggested since it affects immutability of Builder patterm
//            // Print original SoldItem details
//            System.out.println("Original SoldItem Quantity: " + soldItem.toBuilder().build().getQuantity());
//
//            // Update the quantity
//            SoldItem updatedSoldItem = soldItem.toBuilder()
//                    .setQuantity(15) // Update the value here
//                    .build();
//
//            // Print updated SoldItem details
//            System.out.println("Updated SoldItem Quantity: " + updatedSoldItem.toBuilder().build());

            // Attempt to create a SoldItem with invalid quantity (trigger exception)
            System.out.println("\nAttempting to create a SoldItem with invalid quantity...");
            SoldItem invalidSoldItem = new SoldItem.SoldItemBuilder()
                    .setId(2)
                    .setName("Smartphone")
                    .setPrice(800)
                    .setQuantity(3)  // Invalid quantity < 5
                    .setPrime(false)
                    .setDiscount(5.0)
                    .setPaymentMethod("Debit Card")
                    .build();

        } catch (IllegalArgumentException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }
}
