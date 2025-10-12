package DesignPatterns.Creational.PrototypeAndRegistry;

import java.util.EnumMap;
import java.util.Map;
// Registry's job should just be storing and retrieving objects.
// create all templates in registry
// "DataScience" => template
// "Devops" => template

// the set of student templates is fully known at compile time and unlikely to grow at runtime
// Student Registry will be created as a Singleton object, it will be created only once, if it is an enum class
// so by below 2 lines - we automatically get:
//  a. A single global instance (StudentRegistry.INSTANCE)
//  b. No extra boilerplate for locking or serialization

public enum StudentRegistry implements  PrototypeRegistry{
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

        INSTANCE is an enum constant, which acts like a public static final variable. The value of this variable is a reference to an object—specifically, the single instance of the StudentRegistry class.
        In Java, every enum constant is an object of its enum type.
        So, INSTANCE is:
        A constant (its name).
        Its value is a reference to an object (the one and only instance of StudentRegistry).
        When you write StudentRegistry.INSTANCE, you are accessing this single object.

        The JVM decides to initialize the StudentRegistry class.
        It sees the enum constant INSTANCE needs to be created.
        To create this object, the JVM invokes the private constructor StudentRegistry().
        Only after the constructor completes successfully is the newly created object assigned to the static, final field INSTANCE.
     */
    // A map to hold student information
    // EnumMap requires that the keys be of a specific Enum type (Enum<K>), which limits its use but ensures type safety.
    // The keys in the map are maintained in the order in which the Enum constants are declared. This is different from
    // most other Map implementations, such as HashMap, which do not guarantee a specific order.
    // Neither the key nor the class parameter can be null. If you attempt to add a null key or use a null enum class
    // in the constructor, the code will throw a NullPointerException.
    private final Map<StudentType, Student> registry;

    // Static block for automatic, one-time initialization.
    static {
        StudentTemplateInitializer.initializeTemplates();
    }

    // Constructor for initializing the map (runs once with the Singleton instance)
    private StudentRegistry() {
        registry = new EnumMap<>(StudentType.class);
    }
    /**
     * Register a new prototype under the given enum key.
     */
    @Override
    public synchronized void add(StudentType key, Student prototype) {
        if (key == null || prototype == null) {
            throw new IllegalArgumentException("Key and prototype cannot be null");
        }
        registry.put(key, prototype);
    }
    /**
     * Retrieve a fresh copy of the prototype for the given enum key.
     */
    @Override
    public synchronized Student get(StudentType key) {
        Student proto = registry.get(key);
        if (proto == null) {
            throw new IllegalArgumentException("No template registered for key: " + key);
        }
        return proto.copy();
    }

    // Method to remove a student
    @Override
    public synchronized void removeStudent(StudentType key) {
        registry.remove(key);
    }

    // Method to get the count of registered students
    @Override
    public synchronized int getRegisteredCount() {
        return registry.size();
    }
}

/*
Using EnumMap here is an excellent choice for several reasons:
1. High Performance: EnumMap is a specialized Map implementation designed exclusively for enum keys. Internally,
   it is represented as a simple array. This makes operations like get() and put() extremely fast, often faster than
   HashMap because there is no need to calculate hash codes or handle collisions.
2. Type Safety: The constructor new EnumMap<>(StudentType.class) ensures that the map can only accept keys of type
   StudentType. This provides strong compile-time and runtime safety, preventing you from accidentally using an incorrect key type.
3. Memory Efficiency: Because it uses an internal array sized to the number of constants in the enum, EnumMap is very
   compact and uses less memory than a HashMap for the same number of entries.
4. Natural Ordering: The map is ordered based on the natural declaration order of the constants in the
   StudentType enum (DEVOPS, DATASCIENCE, SOFTWARE). While not critical for this specific implementation,
   it provides predictable iteration order.
*/