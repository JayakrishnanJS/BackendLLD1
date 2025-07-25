package DesignPatterns.Creational.Builder.V0;

public class SoldItem {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private boolean isPrime;
    private double discount;
    private String paymentMethod;

    // Constructor 1: No-arg constructor
    public SoldItem() {
        // Default values can remain or be explicitly set here
    }

    // Constructor 2: ID only
    public SoldItem(int id) {
        this.id = id;
    }

    // Constructor 3: ID and Name
    public SoldItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor 4: ID, Name, Price
    public SoldItem(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Constructor 5: ID, Name, Price, Quantity
    public SoldItem(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor 6: ID, Name, Price, Quantity, isPrime
    public SoldItem(int id, String name, int price, int quantity, boolean isPrime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPrime = isPrime;
    }

    // Constructor 7: ID, Name, Price, Quantity, isPrime, Discount
    public SoldItem(int id, String name, int price, int quantity, boolean isPrime, double discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPrime = isPrime;
        this.discount = discount;
    }

    // Constructor 8: Full constructor
    public SoldItem(int id, String name, int price, int quantity, boolean isPrime, double discount, String paymentMethod) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPrime = isPrime;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getPrice() { return price; }

    public int getQuantity() { return quantity; }

    public boolean isPrime() { return isPrime; }

    public double getDiscount() { return discount; }

    public String getPaymentMethod() { return paymentMethod; }
}
