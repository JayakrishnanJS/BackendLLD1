package AccessModifier;
/*
 * StaticFinalExample.java
 *
 * This class demonstrates the use of the 'final' and 'static' keywords in Java.
 *
 * - MAX_LIMIT is a static final variable: A constant available to all instances.
 * - instanceId is a final instance variable: It is set once during construction and never changes.
 * - counter is a static variable: Shared by all instances to count how many objects have been created.
 * - showInfo() is a final method: It cannot be overridden in any subclass.
 * - showMaxLimit() is a static method: It belongs to the class and can be called without an instance.
 */
public class StaticFinalExample {
    // A static final variable: a constant value shared by all instances.
    public static final int MAX_LIMIT = 100;

    // A final instance variable: must be initialized once (here in the constructor).
    public final int instanceId;

    // A static variable: shared among all instances.
    public static int counter = 0;

    // Constructor to initialize the final instance variable and increment the counter.
    public StaticFinalExample(int id) {
        this.instanceId = id;
        counter++;
    }

    // A final method that displays the instance ID and total number of instances.
    public final void showInfo() {
        System.out.println("Instance ID: " + instanceId);
        System.out.println("Total instances: " + counter);
    }

    // A static method that displays the constant MAX_LIMIT.
    public static void showMaxLimit() {
        System.out.println("The max limit is " + MAX_LIMIT);
    }
}
