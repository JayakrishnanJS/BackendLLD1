package InventoryManagementSystem;

public class Electronics extends Item {
    private int warranty;
    Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }
}
