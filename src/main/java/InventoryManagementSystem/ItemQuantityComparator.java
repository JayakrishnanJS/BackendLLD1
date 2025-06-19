package InventoryManagementSystem;

import java.util.Comparator;

public class ItemQuantityComparator<T extends Item> implements Comparator<Item> {
    // <T extends Item> => a generic comparator that works for any subclass of Item class
    // compare takes both the objects to be compared since this is a separate class. In Items class, compareTo is used since the current object is
    // already present in that class
    @Override
    public int compare(Item o1, Item o2) {
        // if we want to sort by descending order of Quantity
        // o1 should come after o2 in descending order => returns 1
        // o1 should come before o2 in descending order => returns -1
        // both have equal quantity => return 0
        if(o1.getQuantity() < o2.getQuantity()){
            return 1;
        }else if (o1.getQuantity() > o2.getQuantity()){
            return -1;
        }
        return 0;
    }
}

/*
In a descending order sort, the `compare` method should:
- Return 1 if the first object is smaller.
- Return -1 if the first object is larger.
- Return 0 if both are equal.

In an ascending order sort, the `compare` method should:
- Return -1 if the first object is smaller.
- Return 1 if the first object is larger.
- Return 0 if both are equal.
 */
