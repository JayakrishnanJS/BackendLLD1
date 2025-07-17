package Collection;

import java.util.*;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 1. add(E e)
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Banana"); // duplicate won't be added
        System.out.println("1. After add: " + set);

        // 2. remove(Object o)
        set.remove("Banana");
        System.out.println("2. After remove: " + set);

        // 3. contains(Object o)
        System.out.println("3. Contains 'Apple'? " + set.contains("Apple"));

        // 4. isEmpty()
        System.out.println("4. Is empty? " + set.isEmpty());

        // 5. size()
        System.out.println("5. Size: " + set.size());

        // 6. clear()
        LinkedHashSet<String> temp = new LinkedHashSet<>(set); // backup
        set.clear();
        System.out.println("6. After clear: " + set);

        // 7. addAll(Collection<? extends E>)
        set.addAll(temp);
        System.out.println("7. After addAll: " + set);

        // 8. containsAll(Collection<?> c)
        System.out.println("8. Contains all ['Apple', 'Cherry']? " +
                set.containsAll(Arrays.asList("Apple", "Cherry")));

        // 9. retainAll(Collection<?> c)
        set.retainAll(Arrays.asList("Apple"));
        System.out.println("9. After retainAll: " + set);

        // 10. removeAll(Collection<?> c)
        set.add("Mango");
        set.removeAll(Arrays.asList("Apple"));
        System.out.println("10. After removeAll: " + set);

        // 11. toArray()
        Object[] arr = set.toArray();
        System.out.println("11. toArray(): " + Arrays.toString(arr));

        // 12. <T> T[] toArray(T[] a)
        String[] strArr = set.toArray(new String[0]);
        System.out.println("12. toArray(T[]): " + Arrays.toString(strArr));

        // 13. clone()
        LinkedHashSet<String> cloned = (LinkedHashSet<String>) set.clone();
        System.out.println("13. Cloned set: " + cloned);
    }
}
