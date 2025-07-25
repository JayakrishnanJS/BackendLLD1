package AccessModifier;
/*
  StaticFinalExample.java
 
  This class demonstrates the use of the 'final' and 'static' keywords in Java.
 
  - MAX_LIMIT is a static final variable: A constant available to all instances.
  - instanceId is a final instance variable: It is set once during construction and never changes.
  - counter is a static variable: Shared by all instances to count how many objects have been created.
  - showInfo() is a final method: It cannot be overridden in any subclass.
  - showMaxLimit() is a static method: It belongs to the class and can be called without an instance.
 */
public class StaticFinalExample{
    // A static final variable: a constant value shared by all instances.
    public static final int MAX_LIMIT = 100;
    // A `static final` variable must be initialized either:
    //        - At the time of declaration, or
    //        - In a static block.
    //    - If not, it results in a compilation error.
//    public static final int MAX; // Blank final static
//    static {
//        MAX = 100; // Correct initialization
//    }

    // A final instance variable: must be initialized once (here in the constructor).
    public final int instanceId;

    // A static variable: shared among all instances.
    public static int counter = 0;

    // A `static final` variable must get assigned a constant expression (value known at compile-time).
    // non-constant initialization will cause runtime issues.
    //public static final int RANDOM = new java.util.Random().nextInt(100); // Not compile-time constant


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

    // A `private` method in a class is already implicitly final because it cannot be overridden in a subclass.
    //  However, explicitly declaring it as `final` is redundant but not an error.
    private final void display() { // Redundant use of final
        System.out.println("This is already final.");
    }

    private static String staticMessage = "Hello, from static scope!";
    private String instanceMessage = "Hello, from instance scope!";

    public void showScope() {
        String localMessage = "Hello, from local scope!"; // Effectively final

        Runnable task = () -> {
            System.out.println(staticMessage); // Static variable (no need to be final)
            System.out.println(instanceMessage); // Instance variable (no need to be final)
            System.out.println(localMessage); // Local variable (must be final or effectively final)
        };

        //localMessage = "now Iam not effectively final";
        Thread thread = new Thread(task);
        thread.start();
    }
    // Summary of Rules for `final` with Lambdas:
//            1. Local variables used inside a lambda must be final or effectively final. This ensures they are not modified after being captured by the lambda.
//            2. Instance variables and static variables do not need to be final since their lifetime is tied to the object or class.
//            3. Final references to mutable objects allow modifying the object's internal state but not reassigning the reference.
//            4. Effectively final variables simplify lambda usage as you don’t need to explicitly declare variables as final, provided they are only assigned once.
//            5. Lambda functions allow combining variables from multiple scopes (local, instance, static).


    // A static method that displays the constant MAX_LIMIT.
    public static void showMaxLimit() {
        // System.out.println("Instance ID: " + instanceId);
        // java: non-static variable instanceId cannot be referenced from a static context
        // Static methods can only access static variables and other static methods.
        System.out.println("The max limit is " + MAX_LIMIT);

        //  `final` array or mutable object reference can't point to a new array/ mutable object,
        //  but the contents of the array or mutable object can still be modified.
        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // Allowed because it's modifying the object
        // sb = new StringBuilder("New String"); // ERROR: Cannot reassign final reference
    }
//    final StringBuilder sb = new StringBuilder("Hello");
//    sb.append(" World"); // syntax error
//
//    final StringBuilder sb = new StringBuilder("Hello");
//    {
//        sb.append(" World"); // works inside initializer block
//    }
}
// In Java, executable statements, such as method calls (`sb.append(" World");`), must be inside a method, constructor, or initializer block
//  if a statement is written directly in the class body where only declarations and initializations are allowed. This is causing a syntax error.