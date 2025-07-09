package DesignPatterns.Builder.V3;

public class SoldItem {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private boolean isPrime;
    private double discount;
    private String paymentMethod;


     SoldItem(SoldItemBuilder soldItemBuilder) {
        // validations can be done over here also
        // Even if the builder allows invalid values to be set, the `SoldItem` constructor acts as a final safeguard
        // to ensure that only valid objects are created.
        this.id = soldItemBuilder.getId();
        this.name = soldItemBuilder.getName();
        this.price = soldItemBuilder.getPrice();
        this.quantity = soldItemBuilder.getQuantity();
        this.isPrime = soldItemBuilder.isPrime();
        this.discount = soldItemBuilder.getDiscount();
        this.paymentMethod = soldItemBuilder.getPaymentMethod();
        // Gets the values of params(id, name...) from builder and assigns it to the SoldItem instance.
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