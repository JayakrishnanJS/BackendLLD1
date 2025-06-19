package InventoryManagementSystem;

import java.util.*;

// we want to have specific items only in Inventory, not all items in the market; also it could not be anything other than an item(e.g not animal or person)
// T is the itemType, which is an item of Item class or its subclasses.
public class Inventory <T extends Item>{
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) {
        items.put(item.getId(), item);
    }

    public void removeItem(T item) {
        items.remove(item.getId());
    }

    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    public T getItem(String itemId) {
        return items.get(itemId);
    }

    public List<T> getAllItems(){
        return new ArrayList<>(items.values()); //  copy hashmap values to a list
    }

    public List<T> filterByPriceRange(double minPrice, double maxPrice){
        List<T> filteredItems = new ArrayList<>();
        for(T item : items.values()){
            if(item.getPrice() >= minPrice && item.getPrice() <= maxPrice){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public List<T> filterByAvailability(){
        List<T> filteredItems = new ArrayList<>();
        for(T item : items.values()){
            if(item.getQuantity() > 0){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public List<T> sortItems(Comparator<T> comparator){
        List<T> sortedItems = new ArrayList<>(getAllItems());
        Collections.sort(sortedItems,comparator);
        return sortedItems;
    }
}

/*
Why do we need separate Inventory class when we have Items?
 1. Specialization
- The `Item` class can represent a general idea of an item, but the `Inventory` class can represent a specific type or context of an item,
  such as those that are being tracked in inventory.
- Example:
    - `Item` contains basic properties like `price` and functionality for comparing those items.
    - `Inventory` can add additional attributes or behavior specific to inventory management, such as stock quantity,
       restocking functionality, expiration status, or warehouse location.

  2. Abstraction and Organization
- The `Inventory` class provides organization-specific information and allows you to handle objects in the context of their role within a system.
- For example,
    - `Item`: Represents the basic product or item.
    - `Inventory`: Represents items that are being tracked in inventory.

- This abstraction helps in separating concerns and makes the codebase easier to maintain and extend.

- Example Use Case Without an `Inventory` Class:
  If everything were in the `Item` class, you might have unnecessary or unrelated functionality tied to the general `Item`,
  which would make the `Item` class bloated and less reusable for other cases
*/
