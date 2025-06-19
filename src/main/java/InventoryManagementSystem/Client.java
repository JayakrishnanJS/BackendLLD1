package InventoryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Test items and its sorting
        List<Item> items = new ArrayList<>();
        items.add(new Book("Ramayan", 1000, 10, "Valmiki"));
        items.add(new Clothing("Shirt", 200, 20, "S"));
        items.add(new Electronics("Iphone", 50000, 30, 1));
        System.out.println("------------ Unsorted Items ------------------");
        for(Item item : items){
            System.out.println(item.getName() + " : " + item.getPrice());
        }
        // The `Comparable` interface is necessary for sorting to define the natural ordering of `Item` objects
        Collections.sort(items);
        System.out.println("--------- Sorted Items ------------------");
        for(Item item : items){
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        electronicsInventory.addItem(new Electronics("Iphone", 50000, 30, 1));
        electronicsInventory.addItem(new Electronics("Samsung", 30000, 20, 2));
        electronicsInventory.addItem(new Electronics("Huawei", 20000, 10, 3));
        System.out.println("------------ Electronics Inventory ------------------");
        for(Item item : electronicsInventory.getAllItems()){
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        Inventory<Clothing> clothingInventory = new Inventory<>();
        clothingInventory.addItem(new Clothing("Shirt", 200, 20, "S"));
        clothingInventory.addItem(new Clothing("Pants", 100, 10, "M"));
        clothingInventory.addItem(new Clothing("Shoes", 50, 5, "L"));
        System.out.println("------------ Clothing Inventory ------------------");
        for(Item item : clothingInventory.getAllItems()){
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        Inventory<Book> bookInventory = new Inventory<>();
        bookInventory.addItem(new Book("Ramayan", 1000, 10, "Valmiki"));
        bookInventory.addItem(new Book("The Great Gatsby", 2000, 20, "<NAME>"));
        bookInventory.addItem(new Book("The Hunger Games", 3000, 30, "<NAME>"));
        System.out.println("------------ Book Inventory ------------------");
        for(Item item : bookInventory.getAllItems()){
            System.out.println(item.getName() + " : " + item.getPrice());
        }
        // the items added to the `items` list at the beginning of the code are not by default part of the specific inventories
        // unless we explicitly add them.
        System.out.println();

        // Recently viewed items
        RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();

        Item book1 = new Book("Ramayan", 1000, 10, "Valmiki");
        Item book2 = new Book("The Great Gatsby", 2000, 20, "F. Scott Fitzgerald");
        Item clothing1 = new Clothing("Shirt", 200, 20, "M");
        Item clothing2 = new Clothing("Jacket", 300, 15, "L");
        Item electronic1 = new Electronics("Iphone", 50000, 30, 1);
        Item electronic2 = new Electronics("Laptop", 80000, 10, 2);

        recentlyViewedItems.addRecentlyViewedItem(book1);
        recentlyViewedItems.addRecentlyViewedItem(clothing1);
        recentlyViewedItems.addRecentlyViewedItem(electronic1);
        recentlyViewedItems.addRecentlyViewedItem(book2);
        recentlyViewedItems.addRecentlyViewedItem(clothing2);
        recentlyViewedItems.addRecentlyViewedItem(electronic2);

        // Adding some items again to test recently viewed item position
        recentlyViewedItems.addRecentlyViewedItem(clothing1);
        recentlyViewedItems.addRecentlyViewedItem(book1);

        System.out.println("------------ Recently Viewed Items ------------------");
        for (Item item : recentlyViewedItems.getRecentlyViewedItems()) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        System.out.println("------------ default order of items defined in custom comparator of items class ------------------");
        Collections.sort(items);
        for(Item item : items){
            System.out.println(item.getName() + " : " + item.getPrice());
        }
        System.out.println("------------ Comparator sorting by descending order of Quantity defined in ItemQuantityComparator------------------");
        Collections.sort(items, new ItemQuantityComparator());
        for(Item item : items){
            System.out.println(item.getName() + " : " + item.getQuantity());
        }

        System.out.println("------------ Checking creating and processing orders ------------------");
        Order order1 = new Order("1", true);
        Order order2 = new Order("2", false);
        Order order3 = new Order("3", true);
        Order order4 = new Order("4", false);
        Order order5 = new Order("5", true);

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(order1);
        orderProcessor.addOrder(order2);
        orderProcessor.addOrder(order3);
        orderProcessor.addOrder(order4);
        orderProcessor.addOrder(order5);

        while(orderProcessor.getSize() > 0){
            orderProcessor.processOrder();
        }

        System.out.println("------------ Comparator sorting by ascending order of Price defined in ItemPriceComparator------------------");
        Collections.sort(items, new ItemPriceComparator());
        for(Item item : items){
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        System.out.println("------------ Test Filtering by price ------------------");
        List<Electronics> filteredByPrice = electronicsInventory.filterByPriceRange(20000, 40000);
        for(Electronics filtered : filteredByPrice){
            System.out.println(filtered.getName() + " : " + filtered.getPrice());
        }

        System.out.println("------------ Test Filtering by availability ------------------");
        List<Electronics> availableItems = electronicsInventory.filterByAvailability();
        for(Electronics available : availableItems){
            System.out.println(available.getName() + " : " + available.getPrice());
        }

        System.out.println("------------ Sort items ------------------");
        List<Electronics> sortedItems = electronicsInventory.sortItems(new ItemPriceComparator());
        for(Electronics sorted : sortedItems){
            System.out.println(sorted.getName() + " : " + sorted.getPrice());
        }

        System.out.println("------------ Customer Wish List ------------------");
        // Add duplicate items and verify that only unique items are stored.
        CustomerWishList wishList = new CustomerWishList();
        wishList.addItemToWishList(book1);
        wishList.addItemToWishList(book2);
        wishList.addItemToWishList(book2);
        wishList.addItemToWishList(clothing1);
        wishList.addItemToWishList(clothing2);
        wishList.addItemToWishList(clothing2);
        wishList.addItemToWishList(clothing1);
        wishList.addItemToWishList(book1);

        wishList.displayWishList();
    }
}
