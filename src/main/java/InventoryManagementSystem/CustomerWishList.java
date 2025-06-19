package InventoryManagementSystem;

import java.util.HashSet;
import java.util.Set;

public class CustomerWishList {
    private Set<Item> wishList;

    public CustomerWishList() {
        this.wishList = new HashSet<>();
    }

    public void addItemToWishList(Item item) {
        wishList.add(item);
    }

    public void removeItemFromWishList(Item item) {
        wishList.remove(item);
    }

    public void displayWishList() {
        for (Item item : wishList) {
            System.out.println(item.getName());
        }
    }
}
