package InventoryManagementSystem;

import java.util.Comparator;

    public class ItemPriceComparator<T extends Item> implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            // if we want to sort by ascending order of price
            // o1 should come after o2 in ascending order => returns -1
            // o1 should come before o2 in ascending order => returns 1
            // both have equal quantity => return 0
            if(o1.getPrice() < o2.getPrice()){
                return -1;
            }else if (o1.getPrice() > o2.getPrice()){
                return 1;
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
