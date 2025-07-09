package DesignPatterns.Builder.V5;

public class SoldItem {
    // 1. Make fields final to ensure Immutability
    private final int id;
    private final String name;
    private final int price;
    private final int quantity;
    private final boolean isPrime;
    private final double discount;
    private final String paymentMethod;

    // 2. Encapsulation - make constructor private, remove setters(if exist)
    private SoldItem(SoldItemBuilder soldItemBuilder) {
        // validations can be done over here also
        // 3. Delete getters of Builer : we can directly access the builder's fields without needing the getter
        //                               methods like getId() or getName().
        this.id = soldItemBuilder.id;
        this.name = soldItemBuilder.name;
        this.price = soldItemBuilder.price;
        this.quantity = soldItemBuilder.quantity;
        this.isPrime = soldItemBuilder.isPrime;
        this.discount = soldItemBuilder.discount;
        this.paymentMethod = soldItemBuilder.paymentMethod;
    }
    // Getters of SoldItem class
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isPrime() { return isPrime; }
    public double getDiscount() { return discount; }
    public String getPaymentMethod() { return paymentMethod; }

//    // Add a method to return a builder prefilled with current values - creates new copy with updated field
//    protected SoldItemBuilder toBuilder() { // compromises immutability
//        return new SoldItemBuilder()
//                .setId(this.id)
//                .setName(this.name)
//                .setPrice(this.price)
//                .setQuantity(this.quantity)
//                .setPrime(this.isPrime)
//                .setDiscount(this.discount)
//                .setPaymentMethod(this.paymentMethod);
//    }

    // 4. More Decoupling - Make Builder static inner class so that it can create the instance
    //                      of SoldItem class without an object
    // static inner class(nested or not) can access the private members of the containing class, soldItem
    public static class SoldItemBuilder {
        private int id;
        private String name;
        private int price;
        private int quantity;
        private boolean isPrime;
        private double discount;
        private String paymentMethod;

        // Loose coupling - btw soldItem and SoldItemBuilder
        public SoldItem build(){
            return new SoldItem(this);
        }

        // Method chaining - change all setters to return current BuilderObject
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
    }
}
