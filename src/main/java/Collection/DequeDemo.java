package Collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // 1. addFirst(E e) → Insert at front
        deque.addFirst("A");
        deque.addFirst("B");
        System.out.println("After addFirst: " + deque); // [B, A]

        // 2. addLast(E e) → Insert at rear (same as add/offer)
        deque.addLast("C");
        System.out.println("After addLast: " + deque); // [B, A, C]

        // 3. offerFirst(E e) → Same as addFirst but returns false on failure
        deque.offerFirst("D");
        System.out.println("After offerFirst: " + deque); // [D, B, A, C]

        // 4. offerLast(E e) → Same as addLast
        deque.offerLast("E");
        System.out.println("After offerLast: " + deque); // [D, B, A, C, E]

        // 5. peekFirst() → View front without removing
        System.out.println("peekFirst: " + deque.peekFirst()); // D

        // 6. peekLast() → View rear without removing
        System.out.println("peekLast: " + deque.peekLast()); // E

        // 7. getFirst() → Like peekFirst but throws exception if empty
        System.out.println("getFirst: " + deque.getFirst());

        // 8. getLast() → Like peekLast but throws if empty
        System.out.println("getLast: " + deque.getLast());

        // 9. pollFirst() → Remove and return front, or null if empty
        System.out.println("pollFirst: " + deque.pollFirst()); // D removed
        System.out.println("After pollFirst: " + deque); // [B, A, C, E]

        // 10. pollLast() → Remove and return rear, or null if empty
        System.out.println("pollLast: " + deque.pollLast()); // E removed
        System.out.println("After pollLast: " + deque); // [B, A, C]

        // 11. removeFirst() → Remove front, throws exception if empty
        System.out.println("removeFirst: " + deque.removeFirst()); // B
        System.out.println("After removeFirst: " + deque); // [A, C]

        // 12. removeLast() → Remove rear, throws if empty
        System.out.println("removeLast: " + deque.removeLast()); // C
        System.out.println("After removeLast: " + deque); // [A]

        // 13. push(E e) → Stack push (adds to front)
        deque.push("X");
        deque.push("Y");
        System.out.println("After push (stack behavior): " + deque); // [Y, X, A]

        // 14. pop() → Stack pop (removes from front)
        System.out.println("Popped: " + deque.pop()); // Y
        System.out.println("After pop: " + deque); // [X, A]

        // 15. contains(Object o)
        System.out.println("Contains 'A'? " + deque.contains("A")); // true

        // 16. size()
        System.out.println("Size: " + deque.size()); // 2

        // 17. isEmpty()
        System.out.println("Is empty? " + deque.isEmpty()); // false

        // 18. clear()
        deque.clear();
        System.out.println("After clear: " + deque); // []

        // 19. peek/poll after clear (returns null)
        System.out.println("peekFirst: " + deque.peekFirst()); // null
        System.out.println("pollLast: " + deque.pollLast()); // null

        // 20. remove/get on empty → throws exception
        try {
            deque.removeFirst();
        } catch (Exception e) {
            System.out.println("removeFirst exception: " + e);
        }

        try {
            deque.getLast();
        } catch (Exception e) {
            System.out.println("getLast exception: " + e);
        }
    }
}
