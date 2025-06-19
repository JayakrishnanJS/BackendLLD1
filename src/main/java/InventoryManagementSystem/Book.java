package InventoryManagementSystem;

public class Book extends Item {
    private String author;
    Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
}
