package Collection;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        // 1. Create and put — put(K, V)
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        System.out.println("1. After put: " + map);

        // 2. putIfAbsent(K, V)
        map.putIfAbsent(2, "Apricot");
        map.putIfAbsent(4, "Dates");
        System.out.println("2. After putIfAbsent: " + map);

        // 3. get(Object key)
        System.out.println("3. get(3): " + map.get(3));

        // 4. getOrDefault(K, Default)
        System.out.println("4. getOrDefault(5, 'Default'): " +
                map.getOrDefault(5, "Default"));

        // 5. containsKey(Object key)
        System.out.println("5. containsKey(2)? " + map.containsKey(2));

        // 6. containsValue(Object value)
        System.out.println("6. containsValue('Cherry')? " +
                map.containsValue("Cherry"));

        // 7. size()
        System.out.println("7. size(): " + map.size());

        // 8. isEmpty()
        System.out.println("8. isEmpty()? " + map.isEmpty());

        // 9. remove(K key)
        System.out.println("9. remove(1): " + map.remove(1));
        System.out.println("   After remove: " + map);

        // 10. putAll(Map<? extends K,? extends V> m)
        Map<Integer, String> another = Map.of(5, "Elderberry", 6, "Fig");
        // HashMap<Integer,String> dec = (HashMap<Integer, String>) Map.of(5, "Elderberry", 6, "Fig") // need cast for hashmap
        map.putAll(another);
        System.out.println("10. After putAll: " + map);

        // 11. replace(K, V)
        map.replace(2, "Blueberry");
        System.out.println("11. After replace(2): " + map);

        // 12. replace(K, oldVal, newVal) - if K and oldVal doesn't match, replace won't happen
        boolean replaced = map.replace(3, "Cherry", "Cranberry");
        System.out.println("12. replace(3 'Cherry'→'Cranberry')? " + replaced);
        System.out.println("    Map now: " + map);

        // 13. replaceAll(BiFunction)
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println("13. After replaceAll(toUpperCase): " + map);

        // 14. compute(K, BiFunction)
        map.compute(5, (k, v) -> v + " Pie");
        System.out.println("14. compute(5): " + map);

        // 15. computeIfAbsent(K, Function)
        map.computeIfAbsent(7, k -> "Grape");
        System.out.println("15. computeIfAbsent(7): " + map);

        // 16. computeIfPresent(K, BiFunction)
        map.computeIfPresent(6, (k, v) -> v + " Jam");
        System.out.println("16. computeIfPresent(6): " + map);

        // 17. merge(K, V, BiFunction)
        map.merge(7, " Juice", (oldV, newV) -> oldV + newV);
        System.out.println("17. merge(7, ' Juice'): " + map);

        // 18. keySet() - returns set of keys
        System.out.println("18. keySet(): " + map.keySet());

        // 19. values() - returns set of values
        System.out.println("19. values(): " + map.values());

        // 20. entrySet() - returns set of mappings contained in this map
        System.out.println("20. entrySet(): " + map.entrySet());

        // 21. EntrySet with enhanced for-loop (efficient for key + value)
        System.out.println("21. EntrySet with enhanced for-loop:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 22. KeySet with enhanced for-loop (only keys)
        System.out.println("2. KeySet with enhanced for-loop:");
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // 23. Values collection (only values)
        System.out.println("23. Values collection:");
        for (String value : map.values()) {
            System.out.println(value);
        }

        // 24. Iterator on entrySet (allows removal during iteration)
        System.out.println("24. Iterator on entrySet:");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
            if (entry.getKey() == 2) {
                it.remove();  // safe way to remove
            }
        }
        System.out.println("After removal: " + map);

        // 25. forEach(BiConsumer)
        System.out.println("25. forEach:");
        map.forEach((k, v) -> System.out.println("  " + k + " -> " + v));

        // 26. Stream API iteration
        map.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        // 27. clear()
        map.clear();
        System.out.println("27. After clear(): " + map);

        // 28. clone() - doesn't work for map
        HashMap<Integer, String> original = new HashMap<>();
        original.put(1, "Apple");
        original.put(2, "Banana");
        @SuppressWarnings("unchecked")
        HashMap<Integer, String> copy = (HashMap<Integer, String>) original.clone();
        System.out.println("28. clone(): " + copy);
    }
}
