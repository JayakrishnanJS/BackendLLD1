package InventoryManagementSystem;

public class Item implements Comparable<Item>{
    private String id;
    private String name;
    private double price;
    private int quantity;
    private static int totalItems = 0;

    Item(String name, double price, int quantity){
        this.id = generateUniqueId();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private String generateUniqueId() {
        totalItems++;
        return "Item-" + totalItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private int getTotalItems(){
        return totalItems;
    }

    // internally sort by comparing 2 objects at a time: ItemObject1.compareTo(ItemObject2)
    @Override
    public int compareTo(Item other) {
        // first object: this object
        // second object: passed in argument
        // If -
        //     this object > argument object: return 1
        //     this object < argument object: return -1
        //     this object = argument object: return 0
        // If sorting is by price:
        if(this.price > other.price) {
            return 1;
        } else if(this.price < other.price) {
            return -1;
        }else{
            return 0;
        }
    }

    public String getId() {
        return id;
    }
}
