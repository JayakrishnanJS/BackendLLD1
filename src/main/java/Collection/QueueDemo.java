package Collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();
        //Queue<String> tasks = new ArrayDeque<>(); // (low memory overhead(resizable array - CPU cached) compared to
                                                    // high memory overhead(nodes - value, previous, next pointers))

        // 1. add(E e) → Inserts element, throws exception if capacity full (not applicable for LinkedList)
        tasks.add("Task1");
        tasks.add("Task2");
        tasks.add("Task3");
        System.out.println("Queue after add: " + tasks); // [Task1, Task2, Task3]

        // 2. offer(E e) → Inserts element, returns false if fails (preferred over add)
        boolean success = tasks.offer("Task4");
        System.out.println("Offered Task4: " + success + " → " + tasks); // [Task1, Task2, Task3, Task4]

        // 3. peek() → Retrieves head without removing, returns null if empty
        System.out.println("Peek head: " + tasks.peek()); // Task1

        // 4. element() → Like peek(), but throws exception if empty
        System.out.println("Head element: " + tasks.element()); // Task1

        // 5. poll() → Retrieves and removes head, returns null if empty
        String polled = tasks.poll();
        System.out.println("Polled: " + polled + " → " + tasks); // Task1 removed → [Task2, Task3, Task4]

        // 6. remove() → Like poll(), but throws exception if empty
        String removed = tasks.remove();
        System.out.println("Removed: " + removed + " → " + tasks); // Task2 removed → [Task3, Task4]

        // 7. size() → Number of elements
        System.out.println("Size: " + tasks.size()); // 2

        // 8. contains(Object o) → Check if element exists
        System.out.println("Contains Task4? " + tasks.contains("Task4")); // true

        // 9. isEmpty() → Check if queue is empty
        System.out.println("Is queue empty? " + tasks.isEmpty()); // false

        // 10. clear() → Remove all elements
        tasks.clear();
        System.out.println("Queue after clear: " + tasks); // []

        // 11. peek/poll on empty queue (safe)
        System.out.println("Peek on empty: " + tasks.peek()); // null
        System.out.println("Poll on empty: " + tasks.poll()); // null

        // 12. element/remove on empty queue (throws)
        try {
            System.out.println("Element on empty: " + tasks.element());
        } catch (Exception e) {
            System.out.println("Exception from element(): " + e);
        }

        try {
            System.out.println("Remove on empty: " + tasks.remove());
        } catch (Exception e) {
            System.out.println("Exception from remove(): " + e);
        }
    }
}
