package Collection;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> birds = new ArrayList<>();

        // 1. add(E e) → Adds an element to the end
        birds.add("Hornbill");
        birds.add("Peafowl");
        birds.add("Woodpecker");

        // 2. add(int index, E element) → Inserts at specific position
        birds.add(1, "Kingfisher"); // Insert before Peafowl

        // 3. get(int index) → Access element at index
        System.out.println("Bird at index 2: " + birds.get(2));

        // 4. remove(int index) → Remove by position
        birds.remove(0); // Removes "Hornbill"

        // 5. remove(Object o) → Remove by object
        birds.remove("Woodpecker");
        // for integer object -> list.remove(Integer.valueOf(1))

        // 6. set(int index, E element) → Replace element at index
        birds.set(1, "Bulbul"); // Replace Peafowl with Bulbul

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
        ArrayList<Integer> nums = new ArrayList<>(List.of(10, 20, 30));
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
        ArrayList<String> newBirds = new ArrayList<>(List.of("Eagle", "Sparrow"));
        birds.addAll(newBirds);

        // 15. removeAll() -> Removes all matching elements
        birds.removeAll(List.of("hen","crow"));

        // 16. retainAll() -> Keeps only owl
        birds.retainAll(List.of("owl")); // size = 1

        // 17. ensureCapacity() -> Prepares list to hold 100 elements
        birds.ensureCapacity(100);

        // 18. trimToSize() - Shrinks capacity to current size
        birds.trimToSize();
        System.out.println(birds.size()); // 1
        birds.add("parrot");
        birds.add("peacock");
        birds.add("pigeon");
        birds.add("swan");
        birds.add("duck");
        System.out.println(birds.size()); // 6
        // 17 and 18 doesn't work with List, only works with ArrayList

        // 19. sort() -> Alphabetical order
        Collections.sort(birds);
        System.out.println(birds);

        // 20. shuffle() -> Randomizes order
        Collections.shuffle(birds);
        System.out.println(birds);

        // 21. reverse() -> Reverses order
        Collections.reverse(birds);
        System.out.println(birds);

        // 22. Enhanced for-loop
        for (String b : birds) {
            System.out.println(b);         // Enhanced for-loop
        }

        // 23. Functional loop
        birds.forEach(System.out::println);

        // 24. Iterator
        Iterator<String> iterator = birds.iterator();
        while (iterator.hasNext()) {
            String bird = iterator.next();
            System.out.println(bird);
        }
        // 25. subList(int fromIndex, int toIndex)
        // Sublist from index 1 to 4
        List<String> flyingBirds = birds.subList(1, 5);
        System.out.println("Original List: " + birds);
        System.out.println("Flying Birds Sublist: " + flyingBirds);
    }
}
