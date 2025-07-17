package Collection;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        // 1. Create a HashSet
        Set<String> set = new HashSet<>();

        // 2. Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Duplicate, will not be added

        // 3. Print all elements (unordered)
        System.out.println("Set: " + set); // e.g. [Orange, Apple, Banana]

        // 4. Check if an element exists
        System.out.println("Contains Apple? " + set.contains("Apple")); // true
        System.out.println("Contains Grape? " + set.contains("Grape")); // false

        // 5. Remove an element
        set.remove("Banana");

        // 6. Size of the set
        System.out.println("Size: " + set.size());

        // 7. Is the set empty?
        System.out.println("Is Empty? " + set.isEmpty());

        // 8. Iterate using for-each loop
        for (String fruit : set) {
            System.out.println("Fruit: " + fruit);
        }

        // 9. Iterate using Iterator
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterating: " + iterator.next());
        }

        // 10. Clear the set
        set.clear();
        System.out.println("Cleared. Is Empty now? " + set.isEmpty());

        // 11. toArray()
        Object[] objArray = set.toArray();
        System.out.println("11. toArray(): " + Arrays.toString(objArray));

        // 12. toArray(T[] a)
        String[] strArray = set.toArray(new String[0]);
        System.out.println("12. toArray(T[] a): " + Arrays.toString(strArray));

        // 13. containsAll(Collection<?> c)
        boolean hasAll = set.containsAll(List.of("A", "B"));
        System.out.println("13. containsAll([A, B]): " + hasAll);

        // 14. addAll(Collection<? extends E> c)
        boolean addedAll = set.addAll(List.of("D", "E"));
        System.out.println("14. addAll([D, E]): " + addedAll);
        System.out.println("    Set after addAll: " + set);

        // 15. retainAll(Collection<?> c)
        boolean retained = set.retainAll(List.of("A", "D", "Z"));
        System.out.println("15. retainAll([A, D, Z]): " + retained);
        System.out.println("    Set after retainAll: " + set);

        // 16. removeAll(Collection<?> c)
        boolean removed = set.removeAll(List.of("A", "Z"));
        System.out.println("16. removeAll([A, Z]): " + removed);
        System.out.println("    Set after removeAll: " + set);

        // 17. clone()
        HashSet<String> original = new HashSet<>();
        original.add("apple");

        @SuppressWarnings("unchecked")
        HashSet<String> cloned = (HashSet<String>) original.clone(); // doesnt work with Set
        System.out.println(cloned);
    }
}
