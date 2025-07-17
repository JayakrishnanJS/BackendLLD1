package Collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 1. Create and put — maintains insertion order
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
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

        // 5. containsKey(Object key) / containsValue(Object value)
        System.out.println("5. containsKey(2)? " + map.containsKey(2));
        System.out.println("6. containsValue('Cherry')? " + map.containsValue("Cherry"));

        // 7. size() / isEmpty()
        System.out.println("7. size(): " + map.size());
        System.out.println("8. isEmpty()? " + map.isEmpty());

        // 9. remove(K key)
        System.out.println("9. remove(1): " + map.remove(1));
        System.out.println("   After remove: " + map);

        // 10. putAll(Map)
        Map<Integer, String> other = Map.of(5, "Elderberry", 6, "Fig");
        map.putAll(other);
        System.out.println("10. After putAll: " + map);

        // 11. replace(K, V) & replace(K, oldV, newV)
        map.replace(2, "Blueberry");
        boolean didReplace = map.replace(3, "Cherry", "Cranberry");
        System.out.println("11. After replace(2): " + map);
        System.out.println("12. replace(3 Cherry→Cranberry)? " + didReplace + " → " + map);

        // 12. replaceAll(BiFunction)
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println("13. After replaceAll(toUpperCase): " + map);

        // 13. compute / computeIfAbsent / computeIfPresent / merge
        map.compute(5, (k, v) -> v + " Pie");
        map.computeIfAbsent(7, k -> "Grape");
        map.computeIfPresent(6, (k, v) -> v + " Jam");
        map.merge(7, " Juice", String::concat);
        System.out.println("14. After compute/merge: " + map);

        // 14. keySet() / values() / entrySet()
        System.out.println("15. keySet(): " + map.keySet());
        System.out.println("16. values(): " + map.values());
        System.out.println("17. entrySet(): " + map.entrySet());

        // 15. Iteration: entrySet for-each
        System.out.println("18. entrySet for-each:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println("   " + e.getKey() + " -> " + e.getValue());
        }

        // 16. keySet for-each
        System.out.println("19. keySet for-each:");
        for (Integer k : map.keySet()) {
            System.out.println("   " + k + " -> " + map.get(k));
        }

        // 17. values for-each
        System.out.println("20. values for-each:");
        for (String v : map.values()) {
            System.out.println("   " + v);
        }

        // 18. Iterator on entrySet (supports removal)
        System.out.println("21. Iterator on entrySet:");
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> e = it.next();
            System.out.println("   " + e.getKey() + " => " + e.getValue());
            if (e.getKey() == 2) it.remove();
        }
        System.out.println("   After removal: " + map);

        // 19. forEach(BiConsumer)
        System.out.println("22. forEach:");
        map.forEach((k, v) -> System.out.println("   " + k + " -> " + v));

        // 20. Stream API
        System.out.println("23. Stream API:");
        map.entrySet().stream()
                .forEach(e -> System.out.println("   " + e.getKey() + " -> " + e.getValue()));

        // 21. clear()
        map.clear();
        System.out.println("24. After clear(): " + map);

        // 22. clone() (shallow copy)
        @SuppressWarnings("unchecked")
        LinkedHashMap<Integer, String> cloned =
                (LinkedHashMap<Integer, String>) new LinkedHashMap<>(other).clone();
        System.out.println("25. clone(): " + cloned);
    }
}
