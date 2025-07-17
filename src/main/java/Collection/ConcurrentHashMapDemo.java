package Collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        // 1. Create a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> cmap = new ConcurrentHashMap<>();
        System.out.println("1. Initial: " + cmap);

        // 2. put(K, V)
        cmap.put("A", 1);
        cmap.put("B", 2);
        System.out.println("2. After put: " + cmap);

        // 3. get(Object key)
        System.out.println("3. get('A'): " + cmap.get("A"));

        // 4. putIfAbsent(K, V)
        cmap.putIfAbsent("B", 5);
        cmap.putIfAbsent("C", 3);
        System.out.println("4. After putIfAbsent: " + cmap);

        // 5. remove(Object key)
        cmap.remove("A");
        System.out.println("5. After remove('A'): " + cmap);

        // 6. replace(K, V)
        cmap.replace("B", 20);
        System.out.println("6. After replace('B',20): " + cmap);

        // 7. computeIfPresent(K, BiFunction)
        cmap.computeIfPresent("C", (k, v) -> v * 10);
        System.out.println("7. After computeIfPresent('C'): " + cmap);

        // 8. computeIfAbsent(K, Function)
        cmap.computeIfAbsent("D", k -> 4);
        System.out.println("8. After computeIfAbsent('D'): " + cmap);

        // 9. merge(K, V, BiFunction)
        cmap.merge("D", 6, Integer::sum);
        System.out.println("9. After merge('D',6): " + cmap);

        // 10. forEach(BiConsumer)
        System.out.println("10. forEach print:");
        cmap.forEach((k, v) -> System.out.println("   " + k + " -> " + v));

        // 11. mappingCount()
        System.out.println("11. mappingCount: " + cmap.mappingCount());

        // 12. LongAdder counter(thread safe) example using forEach
        LongAdder adder = new LongAdder();
        cmap.forEach((k, v) -> adder.add(v));
        System.out.println("12. Sum of values (LongAdder): " + adder.sum());
    }
}
