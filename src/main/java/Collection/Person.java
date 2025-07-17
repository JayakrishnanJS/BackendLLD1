package Collection;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //In Java, if two objects are "equal" according to the `equals()` method, they must
    // also have the same hash code (as returned by `hashCode()`).
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // The method assumes that `id` uniquely identifies a person
    // return true - added to the same bucket
    // return false - not added
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // 1. Check if the objects are the same reference
            return true;
        }
        if (obj == null) { // 2. Check if `obj` is null
            return false;
        }
        if (getClass() != obj.getClass()) { // 3. Check if the classes are the same
            return false;
        }
        // 4. after passing these checks, the `obj` is guaranteed to be a valid `Person` object,
        // and we can safely cast it to the `Person` type
        final Person other = (Person) obj;
        // 5. Compare unique identifiers (id)
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + '}';
    }
}