package Collection;

import java.util.HashSet;
import java.util.Set;

public class SetCustomClassDemo {
    public static void main(String[] args) {
        Set<Person> person = new HashSet<>();
        person.add(new Person(1,"JayaKrishnan J S",27));
        person.add(new Person(2,"Jeeva K S",28));
        person.add(new Person(1,"JayaKrishnan JS",27)); // duplicate
        Person p = new Person(3,"Kokil",27);
        person.add(p);
        Person p1 = p;
        person.add(p1); // duplicate
        System.out.println(person.size());
        System.out.println(person);
    }
}
/*
behind the scenes HashSet will:
1. Call hashCode() on your Person to figure out which bucket to put it in.
2. If that bucket is empty, it just stores the object.
3. If there’s already one or more objects in that same bucket (because they hashed to the same value),
   it will then call equals() on your new object, comparing it to each existing object in the bucket,
   to see if it’s “the same.”
   a. If equals() returns true for any existing object, the new one is considered a duplicate and is not added.
   b. If equals() returns false for all, it adds the new object to that bucket (as a “collision” entry).

Note: if hashCode() is present, but not equals(); we might get both objects into the same bucket (good), but duplication
      cannot be avoided.
*/