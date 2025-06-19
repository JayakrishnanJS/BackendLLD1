package InventoryManagementSystem;

public class Clothing extends Item {
    private String size;
    Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }
}
