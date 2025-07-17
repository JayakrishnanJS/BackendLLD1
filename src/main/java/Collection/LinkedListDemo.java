package Collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> birds = new LinkedList<>();

        // 1. add(E e) → Adds an element to the end
        birds.add("Hornbill");
        birds.add("Peafowl");
        birds.add("Woodpecker");
        System.out.println(birds);

        // 2. add(int index, E element) → Inserts at specific position
        birds.add(1, "Kingfisher"); // Insert before Peafowl
        System.out.println(birds);

        // 3. get(int index) → Access element at index
        System.out.println("Bird at index 2: " + birds.get(2));

        // 4. remove(int index) → Remove by position
        birds.remove(0); // Removes "Hornbill"
        System.out.println(birds);

        // 5. remove(Object o) → Remove by object
        birds.remove("Woodpecker");
        System.out.println(birds);
        // for integer object -> list.remove(Integer.valueOf(1))

        // 6. set(int index, E element) → Replace element at index
        birds.set(1, "Bulbul"); // Replace Peafowl with Bulbul
        System.out.println(birds);

        // 7. size() → Returns number of elements
        System.out.println("Total birds: " + birds.size());

        // 8. contains(Object o) → Checks if present
        System.out.println("Contains Kingfisher? " + birds.contains("Kingfisher"));

        // 9. indexOf(Object o) → First occurrence
        birds.add("Bulbul");
        System.out.println("First Bulbul at: " + birds.indexOf("Bulbul"));

        // 10. lastIndexOf(Object o) → Last occurrence
        System.out.println("Last Bulbul at: " + birds.lastIndexOf("Bulbul"));

        // 11. isEmpty() → Is the list empty?
        System.out.println("Is bird list empty? " + birds.isEmpty());

        // 12. clear() → Removes all elements
        birds.clear();
        System.out.println("Cleared list: " + birds);

        // 13. toArray() → Convert to array
        LinkedList<Integer> nums = new LinkedList<>(List.of(10, 20, 30));
        Object[] array = nums.toArray();
        System.out.println("Array content:");
        for (Object num : array) {
            System.out.println(num);
        }
        birds.add("crow");
        birds.add("cuckoo");
        birds.add("hen");
        birds.add("hawk");
        birds.add("owl");
        String[] strArr = birds.toArray(new String[0]); // Typed conversion
        for (String bird : strArr) {
            System.out.println(bird);
        }

        // 14. addAll() -> Adds all from another collection
        LinkedList<String> newBirds = new LinkedList<>(List.of("Eagle", "Sparrow"));
        birds.addAll(newBirds);

        // 15. removeAll() -> Removes all matching elements
        birds.removeAll(List.of("hen","crow"));

        // 16. retainAll() -> Keeps only owl
        birds.retainAll(List.of("owl")); // size = 1
        System.out.println(birds.size()); // 1

        birds.add("parrot");
        birds.add("peacock");
        birds.add("pigeon");
        birds.add("swan");
        birds.add("duck");

        // 17. sort() -> Alphabetical order
        Collections.sort(birds);
        System.out.println(birds);

        // 18. shuffle() -> Randomizes order
        Collections.shuffle(birds);
        System.out.println(birds);

        // 19. reverse() -> Reverses order
        Collections.reverse(birds);
        System.out.println(birds);

        // 20. Enhanced for-loop
        for (String b : birds) {
            System.out.println(b);         // Enhanced for-loop
        }

        // 21. Functional loop
        birds.forEach(System.out::println);

        // 22. Iterator
        Iterator<String> iterator = birds.iterator();
        while (iterator.hasNext()) {
            String bird = iterator.next();
            System.out.println(bird);
        }

        // 23. subList(int fromIndex, int toIndex)
        // Sublist from index 1 to 4
        LinkedList<String> flyingBirds = new LinkedList<>(birds.subList(1, 5));
        System.out.println("Original List: " + birds);
        System.out.println("Flying Birds Sublist: " + flyingBirds);

        // 24. addFirst(E e) → Inserts at the front
        birds.addFirst("Kingfisher");
        System.out.println("After addFirst: " + birds);

        // 25. addLast(E e) → Inserts at the end (same as add(E))
        birds.addLast("Woodpecker");
        System.out.println("After addLast: " + birds);

        // 26. getFirst() → Retrieves (but does not remove) the first element
        System.out.println("First bird: " + birds.getFirst());

        // 27. getLast() → Retrieves (but does not remove) the last element
        System.out.println("Last bird: " + birds.getLast());

        // 28. removeFirst() → Removes and returns the first element
        String removedFirst = birds.removeFirst();
        System.out.println("Removed first (" + removedFirst + "): " + birds);

        // 29. removeLast() → Removes and returns the last element
        String removedLast = birds.removeLast();
        System.out.println("Removed last (" + removedLast + "): " + birds);

        // 30. offerFirst(E e) → Inserts at front, returns boolean (for Deque compatibility)
        boolean offeredFront = birds.offerFirst("Parakeet");
        System.out.println("Offered at front? " + offeredFront + ": " + birds);

        // 31. offerLast(E e) → Inserts at end, returns boolean
        boolean offeredLast = birds.offerLast("Falcon");
        System.out.println("Offered at end? " + offeredLast + ": " + birds);

        // 32. peekFirst() → Retrieves but does not remove first, returns null if empty
        System.out.println("Peek first: " + birds.peekFirst());

        // 33. peekLast() → Retrieves but does not remove last, returns null if empty
        System.out.println("Peek last: " + birds.peekLast());

        // 34. pollFirst() → Retrieves and removes first, returns null if empty
        System.out.println("Poll first: " + birds.pollFirst() + "; now: " + birds);

        // 35. pollLast() → Retrieves and removes last, returns null if empty
        System.out.println("Poll last: " + birds.pollLast() + "; now: " + birds);

        // 36. push(E e) → Pushes element onto “stack” front
        birds.push("Swan");
        System.out.println("After push: " + birds);

        // 37. pop() → Pops (removes and returns) the first element (stack behavior)
        System.out.println("Popped: " + birds.pop() + "; now: " + birds);

    }
}
