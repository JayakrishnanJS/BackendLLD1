package InventoryManagementSystem;

import java.util.HashSet;
import java.util.Set;

public class CustomerWishList {
    private Set<Item> items;

    public CustomerWishList() {
        this.items = new HashSet<>();
    }

    public void addItemToWishList(Item item) {
        items.add(item);
    }

    public Set<Item> getWishListItems() {
        return new HashSet<>(items);
    }

    public int getSize(){
        return items.size();
    }
}
