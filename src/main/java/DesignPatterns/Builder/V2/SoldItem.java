package DesignPatterns.Builder.V2;

import java.util.HashMap;
import java.util.Map;

public class SoldItem {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private boolean isPrime;
    private double discount;
    private String paymentMethod;

    // Constructor using HashMap
    public SoldItem(Map<String, Object> params) {
        this.id = (int) params.getOrDefault("id", 0);
        this.name = (String) params.getOrDefault("name", "Unnamed");
        this.price = (int) params.getOrDefault("price", 0);
        this.quantity = (int) params.getOrDefault("quantity", 1);
        this.isPrime = (boolean) params.getOrDefault("isPrime", false);
        this.discount = (double) params.getOrDefault("discount", 0.0);
        this.paymentMethod = (String) params.getOrDefault("paymentMethod", "Cash");
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isPrime() { return isPrime; }
    public double getDiscount() { return discount; }
    public String getPaymentMethod() { return paymentMethod; }

}
/*
1. params is just a HashMap that stores values for the object's fields.
                public SoldItem(Map<String, Object> params) {
                    ...
                }

2. Think of it like a form where each field (like id, name, etc.) is a labeled box.
                params.put("id", 101);
                params.put("name", "Laptop");
    "id" maps to the value 101
    "name" maps to "Laptop"

3. getOrDefault(...)?
                this.name = (String) params.getOrDefault("name", "Unnamed");
    It tries to get a value from the map using the key (like "name").
    If that key is not in the map, it uses the default value instead (like "Unnamed").

4. Casting:
    Java stores everything in the map as Object (the parent of all classes). So we need to tell Java what type to expect.
    (int) params.getOrDefault("price", 0)
    This is called type casting. It's like telling Java this is the correct type. Wrong casting causes runtime error.
*/