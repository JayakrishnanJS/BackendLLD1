package InventoryManagementSystem;

import java.util.*;

// we want to have specific items only in Inventory, not all items in the market; also it could not be anything other than an item(e.g not animal or person)
// T is the itemType, which is an item of Item class or its subclasses.
public class Inventory <T extends Item>{
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) throws InvalidQuantityException {
        if(item.getQuantity() < 0){
            // checked exception
            throw new InvalidQuantityException("Quantity less than zero is invalid");
        }

        if(items.containsKey(item.getId())){
            //System.out.println("Item with id " + item.getId() + " already exists in inventory");
            //return;
            // unchecked or runtime exception
            throw new DuplicateItemException("Item with id " + item.getId() + " already exists in inventory");
        }
        items.put(item.getId(), item); // Add the item to the inventory
    }

    public void removeItem(T item) {
        items.remove(item.getId());
    }

    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    public T getItem(String itemId) throws ItemNotFoundException {
        if (!items.containsKey(itemId)) {
            //System.out.println("Item with ID '" + itemId + "' does not exist in the inventory.");
            //return null; // Return null to indicate absence of the item

            // If the ID is not found, explicitly throwing the exception
            throw new ItemNotFoundException("Item with ID '" + itemId + "' does not exist in the inventory.");
        }
        return items.get(itemId); // Otherwise, return the item
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

    public void updateItem(T item) throws ItemNotFoundException{
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (item.getId() == null) {
            throw new IllegalArgumentException("Item ID cannot be null");
        }
        if(items.containsKey(item.getId())){
            items.put(item.getId(), item);
        }else{
            //System.out.println("Item with id " + item.getId() + " does not exist in inventory");
            throw new ItemNotFoundException("Item with id " + item.getId() + " does not exist in inventory");
        }
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
