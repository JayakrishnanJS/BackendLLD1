package Collection;

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        // 1. Create and put — sorted by key
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "Cherry");
        map.put(1, "Apple");
        map.put(2, "Banana");
        System.out.println("1. After put (sorted): " + map);

        // 2. putIfAbsent / get / getOrDefault
        map.putIfAbsent(2, "Apricot");
        System.out.println("2. putIfAbsent(2): " + map);
        System.out.println("3. get(1): " + map.get(1));
        System.out.println("4. getOrDefault(5,'Default'): " + map.getOrDefault(5, "Default"));

        // 3. containsKey / containsValue / size / isEmpty
        System.out.println("5. containsKey(3)? " + map.containsKey(3));
        System.out.println("6. containsValue('Banana')? " + map.containsValue("Banana"));
        System.out.println("7. size(): " + map.size());
        System.out.println("8. isEmpty()? " + map.isEmpty());

        // 4. remove / putAll
        System.out.println("9. remove(1): " + map.remove(1));
        Map<Integer, String> other = Map.of(4, "Dates", 5, "Elderberry");
        map.putAll(other);
        System.out.println("10. After putAll: " + map);

        // 5. replace / replaceAll
        map.replace(2, "Blueberry");
        System.out.println("11. replace(2): " + map);
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println("12. replaceAll(toUpperCase): " + map);

        // 6. compute variants and merge
        map.compute(4, (k, v) -> v + " Pie");
        map.computeIfAbsent(6, k -> "Fig");
        map.computeIfPresent(5, (k, v) -> v + " Jam");
        map.merge(6, " Juice", String::concat);
        System.out.println("13. After compute/merge: " + map);

        // 7. NavigableSet views: firstKey, lastKey
        System.out.println("14. firstKey(): " + map.firstKey());
        System.out.println("15. lastKey(): " + map.lastKey());

        // 8. headMap / tailMap / subMap
        System.out.println("16. headMap(4): " + map.headMap(4));   // keys < 4
        System.out.println("17. tailMap(4): " + map.tailMap(4));   // keys >= 4
        System.out.println("18. subMap(2, 6): " + map.subMap(2, 6)); // 2 ≤ key < 6

        // 9. keySet / values / entrySet
        System.out.println("19. keySet(): " + map.keySet());
        System.out.println("20. values(): " + map.values());
        System.out.println("21. entrySet(): " + map.entrySet());

        // 10. Iteration (4 ways)
        System.out.println("22. entrySet for-each:");
        for (Map.Entry<Integer, String> e : map.entrySet()) System.out.println("   " + e);

        System.out.println("23. keySet for-each:");
        for (Integer k : map.keySet()) System.out.println("   " + k + " -> " + map.get(k));

        System.out.println("24. Iterator on entrySet:");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) System.out.println("   " + it.next());

        System.out.println("25. forEach(BiConsumer):");
        map.forEach((k, v) -> System.out.println("   " + k + " -> " + v));

        // 11. descendingMap()
        System.out.println("26. descendingMap(): " + map.descendingMap());

        // 12. clear & clone
        map.clear();
        System.out.println("27. After clear(): " + map);
        @SuppressWarnings("unchecked")
        TreeMap<Integer, String> cloned = (TreeMap<Integer, String>) new TreeMap<>(other).clone();
        System.out.println("28. clone(): " + cloned);
    }
}
