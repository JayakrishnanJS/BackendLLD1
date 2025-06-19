package InventoryManagementSystem;

import java.util.LinkedList;
import java.util.List;

public class RecentlyViewedItems {
    private LinkedList<Item> recentlyViewedItems;
    private Integer maxRecentlyViewedItemSize;
    public RecentlyViewedItems() {
        recentlyViewedItems = new LinkedList<>();
        maxRecentlyViewedItemSize = 5;
    }

    public void addRecentlyViewedItem(Item item) {
        // remove the current item if it is already in the list and add it to the latest node
        recentlyViewedItems.remove(item);
        recentlyViewedItems.add(item);
        // if adding a recent item exceeds List capacity, we should remove the First(old) item from the List
        if(recentlyViewedItems.size() > maxRecentlyViewedItemSize) {
            recentlyViewedItems.removeFirst();
        }
    }

    public List<Item> getRecentlyViewedItems() {
        return recentlyViewedItems;
    }
    // Since the method's return type is a `List<Item>` (an interface), external code that consumes this
    // method would see it as a `List`. However, the actual implementation of the list is still the `LinkedList`
    // that was initialized in the `RecentlyViewedItems` class
}
