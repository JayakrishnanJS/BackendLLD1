package DesignPatterns.Creational.Builder.V4;

public class SoldItemBuilder {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private boolean isPrime;
    private double discount;
    private String paymentMethod;

    // 1. Loose coupling - btw soldItem and SoldItemBuilder since builder takes responsibility for initialization of SoldItem
    // builds the SoldItem object, using the data that has been set in the SoldItemBuilder.
    // It creates a new object of the SoldItem class by passing the current SoldItemBuilder
    // instance (this) to the SoldItem constructor.
    public SoldItem build(){
        return new SoldItem(this);
    }

    // 2. Method chaining - change all setters to return current BuilderObject
    public SoldItemBuilder setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public SoldItemBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public SoldItemBuilder setPrime(boolean prime) {
        isPrime = prime;
        return this;
    }

    public SoldItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SoldItemBuilder setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public SoldItemBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public SoldItemBuilder setQuantity(int quantity) {
        if(quantity < 5){
            throw new IllegalArgumentException("Quantity must be greater than 5");
        }
        this.quantity = quantity;
        return this;
    }

    public double getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public String getName() {
        return name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}