package InventoryManagementSystem;

import java.util.*;
import java.util.stream.*;

public class Client {
    public static void main(String[] args) {
        // Test items and its sorting
        List<Item> items = new ArrayList<>();
        items.add(new Book("Ramayan", 1000, 10, "Valmiki"));
        items.add(new Clothing("Shirt", 200, 20, "S"));
        items.add(new Electronics("Iphone", 50000, 30, 1));

        System.out.println(items.get(0).compareTo(items.get(1)));
        // compares the first object with the second object using the compareTo() method and prints the result.
        // The compareTo() method doesn't guarantee specific values like -1, 0, or 1. Instead, it provides:
        //        - A negative number if the first object is less than the second.
        //        - 0 if both objects are equal.
        //        - A positive number if the first object is greater than the second.
        // "apple".compareTo("banana")
        // results in a negative number because 'a' (in "apple") comes before 'b'
        // (in "banana") in alphabetic order(or Unicode value).
        // 97(a) - 98(b) = -1.

        System.out.println("------------ Unsorted Items ------------------");
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }
        // The `Comparable` interface is necessary for sorting to define the natural ordering of `Item` objects
        Collections.sort(items);
        System.out.println("--------- Sorted Items ------------------");
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        Inventory<Electronics> electronicsInventory = new Inventory<>();
        Electronics laptop =  null; // out of scope if we define inside try
        Electronics fan = null;
        try {
            electronicsInventory.addItem(new Electronics("Iphone", 50000, 30, 1));
            electronicsInventory.addItem(new Electronics("Samsung", 30000, 20, 2));
            electronicsInventory.addItem(new Electronics("Huawei", 20000, 10, 3));
            laptop = new Electronics("Laptop", 80000, 10, 2);
            electronicsInventory.addItem(laptop);
            fan = new Electronics("Fan", 10000, 5, 1);
            electronicsInventory.addItem(fan);
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        } finally {
            // typically used to execute cleanup code (like closing resources) after the `try` block and any `catch` blocks have been executed
            // the `finally` block executes regardless of whether:
            //                - An exception is thrown in the `try` block.
            //                - An exception is caught in the `catch` block.
            //                - No exception occurs.
            // Generally finally execute after try or catch. But `finally` does not execute in the following scenarios:
            //    - If the program terminates abruptly (e.g., `System.exit()` is called in the `try` or `catch` block).
            //    - If the JVM crashes.
            //    - If the thread executing the `try` block gets killed or interrupted.

            System.out.println("Closing the inventory");
        }
        System.out.println("------------ Remove an item using item object ------------------");
        System.out.println(laptop.getId());
        electronicsInventory.removeItem(laptop);
        System.out.println("------------ Remove an item using item id ------------------");
        System.out.println(fan.getId());
        electronicsInventory.removeItem(fan.getId());

        System.out.println("------------ Electronics Inventory ------------------");
        for (Item item : electronicsInventory.getAllItems()) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        Inventory<Clothing> clothingInventory = new Inventory<>();
        try {
            clothingInventory.addItem(new Clothing("Shirt", 200, 20, "S"));
            clothingInventory.addItem(new Clothing("Pants", 100, 10, "M"));
            clothingInventory.addItem(new Clothing("Shoes", 50, 5, "L"));
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------ Clothing Inventory ------------------");
        for (Item item : clothingInventory.getAllItems()) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        Inventory<Book> bookInventory = new Inventory<>();
        try {
            bookInventory.addItem(new Book("Ramayan", 1000, 10, "Valmiki"));
            bookInventory.addItem(new Book("The Great Gatsby", 2000, 20, "<NAME>"));
            bookInventory.addItem(new Book("The Hunger Games", 3000, 30, "<NAME>"));
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------ Book Inventory ------------------");
        for (Item item : bookInventory.getAllItems()) {
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
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }
        System.out.println("------------ Comparator sorting by descending order of Quantity defined in ItemQuantityComparator------------------");
        Collections.sort(items, new ItemQuantityComparator());
        for (Item item : items) {
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

        while (orderProcessor.getSize() > 0) {
            orderProcessor.processOrder();
        }

        System.out.println("------------ Comparator sorting by ascending order of Price defined in ItemPriceComparator------------------");
        Collections.sort(items, new ItemPriceComparator());
        for (Item item : items) {
            System.out.println(item.getName() + " : " + item.getPrice());
        }

        System.out.println("------------ Test Filtering by price ------------------");
        List<Electronics> filteredByPrice = electronicsInventory.filterByPriceRange(20000, 40000);
        for (Electronics filtered : filteredByPrice) {
            System.out.println(filtered.getName() + " : " + filtered.getPrice());
        }

        System.out.println("------------ Test Filtering by availability ------------------");
        List<Electronics> availableItems = electronicsInventory.filterByAvailability();
        for (Electronics available : availableItems) {
            System.out.println(available.getName() + " : " + available.getPrice());
        }

        System.out.println("------------ Sort items ------------------");
        List<Electronics> sortedItems = electronicsInventory.sortItems(new ItemPriceComparator());
        for (Electronics sorted : sortedItems) {
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
        for (Item item : wishList.getWishListItems()) {
            System.out.println(item.getName());
        }

        System.out.println("------------ Print all item IDs in the inventory using map ------------------");

        Inventory<Item> inventory = new Inventory<>();
        try {
            inventory.addItem(book1);
            inventory.addItem(book2);
            inventory.addItem(clothing1);
            inventory.addItem(clothing2);
            inventory.addItem(electronic1);
            inventory.addItem(electronic2);
            inventory.addItem(new Electronics("Motorola", 20000, 0, 1));
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        List<Item> itemsInInventory = inventory.getAllItems();
        System.out.println("Inventory size : " + itemsInInventory.size());

        itemsInInventory
                .stream()
                .map(item -> item.getId())
                .forEach(id -> System.out.println(id));

        System.out.println("-------------Create a list of item names in lowercase and print it--------");

        List<String> ans1 =
                itemsInInventory
                        .stream()
                        .map(item -> item.getName().toLowerCase())
                        .collect(Collectors.toList());
        System.out.println(ans1);

        System.out.println("---------------- Generate a list of the lengths of item names ----------");
        List<Integer> ans2 =
                itemsInInventory
                        .stream()
                        .map(item -> item.getName().length())
                        .collect(Collectors.toList());
        System.out.println(ans2);

        System.out.println("---------------- Find all items priced above 1000 and print their details. ----------");
        itemsInInventory
                .stream()
                .filter(item -> item.getPrice() > 1000)
                .forEach(item -> System.out.println(item.getName()));

        System.out.println("--------Check if any item in the inventory has a quantity of 0 using anyMatch--------");
        boolean isTrue =
                itemsInInventory
                        .stream()
                        .anyMatch(item -> item.getQuantity() == 0);
        System.out.println(isTrue);

        System.out.println("--------Verify that all items have a price greater than 0 using allMatch--------");
        boolean isTrueOrFalse =
                itemsInInventory
                        .stream()
                        .allMatch(item -> item.getPrice() > 0);
        System.out.println(isTrueOrFalse);

        System.out.println("--------Confirm that no item has a negative quantity using noneMatch--------");
        boolean isTrueOrFalse1 =
                itemsInInventory
                        .stream()
                        .noneMatch(item -> item.getQuantity() < 0);
        System.out.println(isTrueOrFalse1);

        System.out.println("--------Task 3--------");
        System.out.println("Filter items with a price greater than 1000 and a quantity greater than 0 (available stock).\n" +
                "Extract only the names of these items.\n" +
                "Remove duplicate names (if any).\n" +
                "Sort the names in alphabetical order.\n" +
                "Limit the result to the top 5 names.\n" +
                "Collect the final list into a List<String> and print it.\n");

        List<String> ans3 = itemsInInventory
                .stream()
                .filter(item -> item.getPrice() > 1000 && item.getQuantity() > 0)
                .map(item -> item.getName())
                .distinct()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
        //.forEach(System.out::println); // loop through list and print each element instead of storing it in a new list ans3
        //ans3.forEach(System.out::println);
        System.out.println(ans3);

        System.out.println("--------Task 4--------");
        // Reduce() is used to perform a reduction operation on the elements of a stream.
        // It combines the elements into a single result using a provided accumulator function.
        // While a `for loop` iterates through elements to perform operations, `reduce` is more like a
        // folding/accumulation operation: it takes two inputs (e.g., a current value and an accumulated result)
        // and applies a defined logic to produce a single value.

        //1. Initial Value Provided as the first argument to specify where reduction starts (e.g., `0` when summing).
        //2. Associative Function – Combines two elements into one (e.g., `Integer::sum` or a lambda expression like `(a, b) -> a * b`).
        //3. Parallel Processing – Works seamlessly in parallel streams.
        //4. Optional Result – If no initial value is provided and the stream is empty, `reduce` returns an `Optional` to handle the case of absent values.

        System.out.println("------Calculate the total quantity of all items in the inventory------");
        // reduce takes only one data type inside accumulator, here totalSum and quantity both are integer
        // The identity value acts as a default starting point for the reduction operation.
        // It ensures that the final result is always of a single type (`int` in this case).
        // quantity here takes its value from each element in the mapped stream,
        // i.e., the output of `.map(item -> item.getQuantity())`.
        int total1 = itemsInInventory
                .stream()
                .map(item -> item.getQuantity())
                .reduce(0, (totalSum, quantity) -> {
                    return totalSum + quantity;
                });
        System.out.println("Total quantity : " + total1);

        System.out.println("------Find the most expensive item using reduce------");
        // When `reduce` is used without an identity, the result of the reduction is wrapped in an `Optional`
        // because there's no guarantee that the stream will be non-empty.
        // If the stream is empty, `reduce` returns an empty `Optional`.
        // 1. Use an identity value to ensure a guaranteed result, but this doesn't work for mutable, non-primitive objects like `Item`.
        // So, `reduce` with identity isn't suitable here.

        Optional<Item> mostExpensiveitem =
                itemsInInventory
                        .stream()
                        .reduce((item1, item2) -> {
                            if (item1.getPrice() > item2.getPrice()) {
                                return item1;
                            }
                            return item2;
                        });
        //.ifPresent(item -> System.out.println("Most expensive item : " + item.getName()));
        // empty case can also be handled with `Optional` APIs like `ifPresent`, `orElse`, etc.
        System.out.println("Most expensive item : " + mostExpensiveitem.get().getName());

        System.out.println("------Concatenate all item names into a single comma-separated string ------");
        //String string = itemsInInventory
        Optional<String> string = itemsInInventory
                .stream()
                .map(item -> item.getName())
                //.reduce("", (concatenatedString, name) -> { // gives an unnecessary initial empty string
                .reduce((concatenatedString, name) -> {
                    concatenatedString = concatenatedString + ", " + name;
                    return concatenatedString;
                });
        System.out.println(string.get());

        System.out.println("Get all details about Items from inventory:");
        inventory.getAllItems().stream()
                .map(item -> "ID: " + item.getId() + ", Name: " + item.getName() + ", Quantity: "
                        + item.getQuantity() + ", Price: " + item.getPrice() + ", Type: " + item.getClass().getSimpleName())
                .forEach(System.out::println);

        System.out.println("------- Calculate total inventory value (using parallelStream) ---------");
        double totalInventoryValue = inventory.getAllItems()
                .parallelStream() // Process items in parallel to speed up computation for large inventories
                .mapToDouble(item -> item.getPrice() * item.getQuantity()) // Calculate the total value for each item
                .sum(); // Sum up all values
        // here mapping works in parallel, and once it is completed, summing is done in parallel.
        System.out.println("Total Inventory Value: " + totalInventoryValue);

        System.out.println("------  Task 5 ------");
        System.out.println("------  Create and use custom exceptions for domain-specific errors ------");
        System.out.println("Define an InvalidQuantityException to handle cases where an item’s quantity is set to a negative value.\n" +
                "Implement a DuplicateItemException for scenarios where an item with the same ID is added to the inventory.\n" +
                "Use these exceptions in addItem and updateItem methods of the Inventory class.\n" +
                "Create DuplicateItemException as unchecked and InvalidQuantityException as checked\n");

        System.out.println("------ Test Case 1: Add a valid item ------");
        Item item1 = new Book("Mahabharat", 1000, 10, "Veda Vyas");
        try {
            inventory.addItem(item1); // Valid: Should add the item
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------ Test Case 2: Add a duplicate item ------");
        try {
            inventory.addItem(item1); // Invalid: DuplicateItemException should be thrown
        } catch (DuplicateItemException e) { // unchecked exception - if not handled in catch
            // -> no compile time error, error is shown in console during runtime.
            System.out.println(e.getMessage());
        } catch (InvalidQuantityException e) { // checked exception - compile error, code won't execute if not handled in catch
            System.out.println(e.getMessage());
        }

        System.out.println("------ Test Case 3: Update a non-existent item ------");
        Item item21 = new Book("Harry Porter", 3000, 100, "JK Rowling"); // item is not added to inventory
        try {
            inventory.updateItem(item21); // Invalid: ItemNotFoundException should be thrown
            inventory.updateItem(null); // Invalid: IllegalArgumentException should be thrown
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------ Test Case 4: Add an invalid-quantity item ------");
        try {
            inventory.addItem(new Electronics("Oppo", 15000, -5, 1)); // Invalid: Negative quantity should throw InvalidQuantityException
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------  Task 6 ------");
        System.out.println("------  Goal: Practice throwing exceptions explicitly------");
        System.out.println("------  Modify the getItem(String id) method to throw an ItemNotFoundException if the item ID does not exist in the inventory ------");

        try {
            System.out.println(inventory.getItem("Item-15")); // Valid ID: Should print the item's address
            System.out.println(inventory.getItem("Item-25")); // Invalid ID: Should throw exception
            // Item with ID 'Item-22' does not exist in the inventory.
            System.out.println(inventory.getItem("Item-26")); // Won't execute this line since control is now with catch block
        } catch (ItemNotFoundException e) {
            // Handling the custom exception and displaying it as an error in the console.
            System.err.println(e.getMessage()); // the message will appear in red because `System.err` is the designated stream for error messages.
        } finally {
            System.out.println("Closing the inventory");
        }

        System.out.println("------- Task 7 -------");
        System.out.println("-------  Goal: Simulate inventory input and processing using try-with-resources-------");
        // Any resource used (like a file or a database connection) is automatically closed after the execution of the try block.
        // Using try-with-resources for a Scanner to simulate inventory input
        //Scanner scanner = null;
        try (Scanner scanner = new Scanner(System.in)) {
            //scanner = new Scanner(System.in);
            System.out.println("Enter Item Name: ");
            String itemName = scanner.nextLine();

            System.out.println("Enter Item Price: ");
            double itemPrice = scanner.nextDouble();

            System.out.println("Enter Item Quantity: ");
            int itemQuantity = scanner.nextInt();

            // Simulating Inventory Operation
            System.out.println("Item added to inventory:");
            System.out.println("Name: " + itemName + ", Price: " + itemPrice + ", Quantity: " + itemQuantity);
        } catch (Exception e) {
            System.err.println("An error occurred while processing inventory.");
        } /*
        finally {
           if (scanner != null) {
                scanner.close(); // Always close the resource in finally to avoid leaks
                System.out.println("Scanner closed.");
            }
        }
        */
        // all scanner relatedly commented lines and finally block is required if without try-with-resources
        System.out.println("Inventory processing completed successfully.");
    }
}
