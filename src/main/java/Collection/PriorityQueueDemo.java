package Collection;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        // Default: Min-heap for natural ordering (alphabetical/numerical ascending)
        PriorityQueue<String> pq = new PriorityQueue<>();

        // 1. add(E e) → Inserts element into priority queue
        pq.add("Banana");
        pq.add("Apple");
        pq.add("Mango");
        pq.add("Orange");
        System.out.println("After add: " + pq); // Internally ordered in natural sort order (not sorted for printing)

        // 2. offer(E e) → Same as add(), returns false if capacity restrictions exist
        pq.offer("Grapes");
        System.out.println("After offer: " + pq);

        // 3. peek() → View the head (smallest/priority element) without removing
        System.out.println("Peek (head): " + pq.peek()); // Apple

        // 4. element() → Like peek(), but throws exception if empty
        System.out.println("Head using element(): " + pq.element()); // Apple

        // 5. poll() → Removes and returns the head (priority element), or null if empty
        System.out.println("Polled: " + pq.poll()); // Removes Apple
        System.out.println("After poll: " + pq);

        // 6. remove() → Removes and returns head; throws if empty
        System.out.println("Removed: " + pq.remove()); // Removes Banana
        System.out.println("After remove: " + pq);

        // 7. contains(Object o) → Check if element exists
        System.out.println("Contains Mango? " + pq.contains("Mango")); // true

        // 8. size() → Number of elements
        System.out.println("Size: " + pq.size()); // 3

        // 9. isEmpty() → Checks if queue is empty
        System.out.println("Is empty? " + pq.isEmpty());

        // 10. clear() → Remove all elements
        pq.clear();
        System.out.println("After clear: " + pq); // []

        // 11. peek/poll on empty queue (safe)
        System.out.println("Peek empty: " + pq.peek()); // null
        System.out.println("Poll empty: " + pq.poll()); // null

        // 12. element/remove on empty queue (throws)
        try {
            System.out.println("Element on empty: " + pq.element());
        } catch (Exception e) {
            System.out.println("Exception from element(): " + e);
        }

        try {
            System.out.println("Remove on empty: " + pq.remove());
        } catch (Exception e) {
            System.out.println("Exception from remove(): " + e);
        }

        // 13. Custom comparator for max-heap (reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        System.out.println("Max Heap: " + maxHeap); // Head is 30
        System.out.println("Max value (poll): " + maxHeap.poll()); // 30
        System.out.println("After poll: " + maxHeap); // [20, 10]

        // 14. Custom class (Person) with comparator
        PriorityQueue<Person> people = new PriorityQueue<>((p1, p2) -> p1.getAge() - p2.getAge());
        people.add(new Person(1,"Alice", 30));
        people.add(new Person(2, "Bob", 25));
        people.add(new Person(3, "Charlie", 35));
        System.out.println("Youngest person: " + people.peek()); // Bob
        // Comparator.comparingInt(Person::getAge) can also be used
        // Comparator.comparing(Person::getAge) - // Drawback in performance: If `getAge()` returns an `int`
        // (a primitive type), it will need to be boxed into an `Integer`,
    }
}
