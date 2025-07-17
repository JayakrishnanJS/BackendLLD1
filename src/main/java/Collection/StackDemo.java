package Collection;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> books = new Stack<>();

        // 1. push(E item) → Adds item to the top of the stack
        books.push("Harry Potter");
        books.push("Lord of the Rings");
        books.push("Game of Thrones"); // the last added book appears on top of stack
        System.out.println("Stack after push: " + books); // [Harry Potter, Lord of the Rings, Game of Thrones]

        // 2. pop() → Removes and returns the top item
        String topBook = books.pop();
        System.out.println("Popped book: " + topBook); // Game of Thrones
        System.out.println("Stack after pop: " + books); // [Harry Potter, Lord of the Rings]

        // 3. peek() → Returns the top item without removing
        System.out.println("Top book: " + books.peek()); // Lord of the Rings - last added element

        // 4. empty() → Checks if the stack is empty
        System.out.println("Is stack empty? " + books.empty()); // false

        // 5. search(Object o) → Returns 1-based position from top of stack; -1 if not found
        System.out.println("Position of 'Harry Potter': " + books.search("Harry Potter")); // 2
        System.out.println("Position of 'Game of Thrones': " + books.search("Game of Thrones")); // -1

        // Extra operations from Vector (since Stack extends Vector)
        // 6. size() → Number of elements
        System.out.println("Total books: " + books.size());

        // 7. get(int index) → Get element at index (Vector method)
        System.out.println("Book at index 0: " + books.get(0)); // Harry Potter - first added element

        // 8. set(int index, E element) → Replace at index
        books.set(0, "Hobbit");
        System.out.println("After set: " + books); // [Hobbit, Lord of the Rings]

        // 9. contains(Object o) → Checks if element exists
        System.out.println("Contains Hobbit? " + books.contains("Hobbit")); // true

        // 10. clear() → Removes all elements
        books.clear();
        System.out.println("Stack after clear: " + books); // []

        // 11. isEmpty() → Same as empty()
        System.out.println("Is stack empty after clear? " + books.isEmpty()); // true
    }
}
