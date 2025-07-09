package DesignPatterns.Builder.V1;

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

    }

    /* Constructor 2 (Minimum) - id and item model name co-exist. If id can exist independently, use this.id = id
                                 and in Constructor 2, use this(id); this.name = name; and so on for other constructors*/
    public SoldItem(int id) {
        this(id, null);
    }

    // Constructor 3
    public SoldItem(int id, String name) {
        this(id, name, 0);
    }

    // Constructor 4
    public SoldItem(int id, String name, int price) {
        this(id, name, price, 0);
    }

    // Constructor 5
    public SoldItem(int id, String name, int price, int quantity) {
        this(id, name, price, quantity, false);
    }

    // Constructor 6
    public SoldItem(int id, String name, int price, int quantity, boolean isPrime) {
        this(id, name, price, quantity, isPrime, 0.0);
    }

    // Constructor 7
    public SoldItem(int id, String name, int price, int quantity, boolean isPrime, double discount) {
        this(id, name, price, quantity, isPrime, discount, null);
    }

    // Constructor 8 (Full)
    public SoldItem(int id, String name, int price, int quantity, boolean isPrime, double discount, String paymentMethod) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPrime = isPrime;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
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

