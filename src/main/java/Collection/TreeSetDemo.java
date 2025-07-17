package Collection;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        // 1. add(E e)
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);
        set.add(5); // duplicate ignored
        System.out.println("1. After add: " + set); // [5, 10, 15, 20]

        // 2. remove(Object o)
        set.remove(10);
        System.out.println("2. After remove 10: " + set); // [5, 15, 20]

        // 3. contains(Object o)
        System.out.println("3. Contains 15? " + set.contains(15)); // true

        // 4. size()
        System.out.println("4. Size: " + set.size()); // 3

        // 5. isEmpty()
        System.out.println("5. Is empty? " + set.isEmpty()); // false

        // 6. first(), last()
        System.out.println("6. First: " + set.first() + ", Last: " + set.last()); // 5, 20

        // 7. clear()
        TreeSet<Integer> backup = new TreeSet<>(set);
        set.clear();
        System.out.println("7. After clear: " + set); // []

        // 8. addAll(Collection)
        set.addAll(backup);
        System.out.println("8. After addAll: " + set); // [5, 15, 20]

        // 9. toArray()
        Object[] arr = set.toArray();
        System.out.println("9. toArray(): " + Arrays.toString(arr)); // [5, 15, 20]

        // 10. toArray(T[] a)
        Integer[] arr2 = set.toArray(new Integer[0]);
        System.out.println("10. toArray(T[]): " + Arrays.toString(arr2));

        // 11. clone()
        TreeSet<Integer> clone = (TreeSet<Integer>) set.clone();
        System.out.println("11. Clone: " + clone); // [5, 15, 20]

        // 12. headSet(E toElement)
        System.out.println("12. headSet(15): " + set.headSet(15)); // [5]

        // 13. tailSet(E fromElement)
        System.out.println("13. tailSet(15): " + set.tailSet(15)); // [15, 20]

        // 14. subSet(E from, E to)
        System.out.println("14. subSet(5, 20): " + set.subSet(5, 20)); // [5, 15]

        // 15. higher(E e), lower(E e)
        System.out.println("15. Higher than 15: " + set.higher(15)); // 20
        System.out.println("    Lower than 15: " + set.lower(15));  // 5

        // 16. ceiling(E e), floor(E e)
        System.out.println("16. Ceiling of 16: " + set.ceiling(16)); // 20
        System.out.println("    Floor of 16: " + set.floor(16));     // 15

        // 17. pollFirst(), pollLast()
        System.out.println("17. pollFirst(): " + set.pollFirst()); // removes 5
        System.out.println("    pollLast(): " + set.pollLast());   // removes 20
        System.out.println("    Set after polling: " + set); // [15]

        // 18. descendingSet()
        TreeSet<Integer> newSet = new TreeSet<>(Arrays.asList(10, 30, 20));
        System.out.println("18. Descending set: " + newSet.descendingSet()); // [30, 20, 10]
    }
}
