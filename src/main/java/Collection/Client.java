package Collection;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        // 1. Various Collections
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();
        List<Integer> stack = new Stack<>();

        Set<Integer> set = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        Map<String , Integer> map = new HashMap<>();
        Map<String , Integer> map2 = new TreeMap<>();
        Map<String , Integer> map3 = new LinkedHashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new PriorityQueue<>();
        Queue<Integer> queue3 = new ArrayDeque<>();

        // 2. see IteratorMethodsExample

        // 3. Hashmap with Custom Objects
        // Create a HashMap with Person objects as keys
        Map<Person, String> personMap = new HashMap<>();
        // Add entries
        Person person1 = new Person(1, "Alice", 25);
        Person person2 = new Person(2, "Bob", 30);
        personMap.put(person1, "Employee");
        personMap.put(person2, "Manager");
        // Retrieve values using Person objects as keys
        String keyToLookup = personMap.get(person1);
        System.out.println("Position for " + person1 + ": " + keyToLookup);

        // 4. CollectionInterfaceDemo
    }
}
