package DesignPatterns.PrototypeAndRegistry;

import java.util.EnumMap;
import java.util.Map;
// Registry's job should just be storing and retrieving objects.
// create all templates in registry
// "DataScience" => template
// "Devops" => template

// the set of student templates is fully known at compile time and unlikely to grow at runtime
// Student Registry will be created as a Singleton object, it will be created only once
// so by below 2 lines - we automatically get:
//  a. A single global instance (StudentRegistry.INSTANCE)
//  b. No extra boilerplate for locking or serialization

public enum StudentRegistry {
    INSTANCE; // Singleton instance
    /*
    declaring your registry as an enum guarantees a single instance, for these reasons:
    1. One “INSTANCE” Only
        Java guarantees that each enum constant is instantiated exactly once, when the class is loaded.
        There’s no way (via reflection or deserialization) to create additional copies of an enum constant.

    2. Thread‑Safe Initialization
        The JVM handles enum instantiation at class‑load time in a thread‑safe manner, so you don’t need any
        synchronized blocks or volatile flags.

    3. Serialization Safety
        Enums have built‑in serialization handling: when you deserialize an enum, you always get back the exact
        same constant, never a new object.
     */
    // A map to hold student information
    // EnumMap requires that the keys be of a specific Enum type (Enum<K>), which limits its use but ensures type safety.
    // The keys in the map are maintained in the order in which the Enum constants are declared. This is different from
    // most other Map implementations, such as HashMap, which do not guarantee a specific order.
    // Neither the key nor the class parameter can be null. If you attempt to add a null key or use a null enum class
    // in the constructor, the code will throw a NullPointerException.
    private final Map<StudentType, Student> registry;

    // Constructor for initializing the map (runs once with the Singleton instance)
    private StudentRegistry() {
        registry = new EnumMap<>(StudentType.class);
    }
    /**
     * Register a new prototype under the given enum key.
     */
    public void add(StudentType key, Student prototype) {
        if (key == null || prototype == null) {
            throw new IllegalArgumentException("Key and prototype cannot be null");
        }
        registry.put(key, prototype);
    }
    /**
     * Retrieve a fresh copy of the prototype for the given enum key.
     */
    public Student get(StudentType key) {
        Student proto = registry.get(key);
        if (proto == null) {
            throw new IllegalArgumentException("No template registered for key: " + key);
        }
        return proto.copy();
    }

    // Method to remove a student
    public void removeStudent(int id) {
        registry.remove(id);
    }

    // Method to get the count of registered students
    public int getRegisteredCount() {
        return registry.size();
    }
}
// The unchecked warning in Java occurs during compile time*  when the compiler cannot guarantee the _type safety_
// of an operation involving generics. This is usually due to Java’s type erasure mechanism, where all generic type
// information is removed at runtime to ensure backward compatibility with older Java versions.