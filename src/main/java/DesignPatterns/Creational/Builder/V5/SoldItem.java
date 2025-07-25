package DesignPatterns.Creational.Builder.V5;

public class SoldItem {
    // 1. Make fields final to ensure Immutability and Thread Safety - SoldItem class is the target immutable object. Its purpose is to
    // represent a fully constructed, read-only object. Once created, it should not allow any changes to its state.
    // Making all its fields final ensures this immutability without additional Synchronization.
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

    // static method of the `SoldItem` class to get the builder for constructing `SoldItem` objects
    // 5. Enforcing mandatory fields in the SoldItem object
    //    - the builder constructor (`SoldItemBuilder`) enforces passing(minimum) these two parameters during builder instantiation
    public static SoldItemBuilder getBuilder(int id, String name){
        return new SoldItemBuilder(id, name);
    }
    // Copy-builder for “modify one or many field” without mutating original
//    public SoldItemBuilder toBuilder() {
//        return new SoldItemBuilder(this.id, this.name) // id and name remains immutable
//                .setPrice(this.price)
//                .setQuantity(this.quantity)
//                .setPrime(this.isPrime)
//                .setDiscount(this.discount)
//                .setPaymentMethod(this.paymentMethod);
//    }

    // 5. More Decoupling - Make Builder static inner class so that Builder can create the object
    //                      of SoldItemBuilder without an instance of SoldItem class
    // static inner class(nested or not) can access the private members of the containing class, soldItem
    public static class SoldItemBuilder {
        //6. By marking them mandatory fields final, the Builder ensures that these fields are initialized during the
        // builder’s creation and cannot change during the build process.
        // mandatory fields are absolutely required to create a valid instance of the target class, SoldItem
        private final int id;
        private final String name;
        // Optional
        private int price;
        private int quantity;
        private boolean isPrime;
        private double discount;
        private String paymentMethod;

        // 7. Builder Constructor enforces mandatory fields at compile time, remove setters of name and id making it completely immutable
        private SoldItemBuilder(int id, String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("name must be non-null, non-empty");
            }
            this.id   = id;
            this.name = name;
        }

        // Loose coupling - btw soldItem and SoldItemBuilder
        public SoldItem build(){
            return new SoldItem(this);
        }

        // Method chaining - change all setters to return current BuilderObject
        public SoldItemBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public SoldItemBuilder setPrime(boolean isPrime) {
            this.isPrime = isPrime;
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
