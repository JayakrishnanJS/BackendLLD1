package DesignPatterns.Creational.Builder.V3;

public class SoldItemBuilder {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private boolean isPrime;
    private double discount;
    private String paymentMethod;

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        // validations
        if(quantity < 5){
            throw new IllegalArgumentException("Quantity must be greater than 5");
        }
        this.quantity = quantity;
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