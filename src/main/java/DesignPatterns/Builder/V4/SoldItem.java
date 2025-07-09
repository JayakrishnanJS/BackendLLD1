package DesignPatterns.Builder.V4;

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
        this.id = soldItemBuilder.getId();
        this.name = soldItemBuilder.getName();
        this.price = soldItemBuilder.getPrice();
        this.quantity = soldItemBuilder.getQuantity();
        this.isPrime = soldItemBuilder.isPrime();
        this.discount = soldItemBuilder.getDiscount();
        this.paymentMethod = soldItemBuilder.getPaymentMethod();
    }

    /*
        3. Overwork from client to initialize builder is reduced
            The Original class is taking the responsibility of providing the builder.
            static means the method belongs to the SoldItem class and can be called without creating an object of the
            SoldItem class.
    */
    public static SoldItemBuilder getBuilder(){
        return new SoldItemBuilder();
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