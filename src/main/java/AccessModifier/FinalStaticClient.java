package AccessModifier;
/*
 * FinalStaticClient.java
 *
 * This file provides detailed notes on the usage of the 'final' and 'static' keywords in Java,
 * along with a working example.
 *
 * ------------- final -------------
 * 1. Final Variables: - cannot Re-assign
 *    - Declared with the keyword final, these variables can only be assigned once.
 *    - Example: final int MAX_COUNT = 100;
 *
 * 2. Final Methods: - cannot Override
 *    - Methods marked as final cannot be overridden in any subclass.
 *    - This is useful to preserve the original behavior.
 *
 * 3. Final Classes: - cannot Inherit
 *    - A class declared as final cannot be subclassed.
 *    - For example, java.lang.String is a final class.
 *
 * ------------- static -------------
 * 1. Static Variables:
 *    - Declared with the keyword static, these variables belong to the class, not to any instance.
 *    - All instances share the same value.
 *
 * 2. Static Methods:
 *    - These methods can be called without creating an instance of the class.
 *    - They can only access other static members directly.
 *
 * 3. Static Blocks:
 *    - Used for static initialization, executed when the class is first loaded.
 *
 * In the example below, we have a class StaticFinalExample that demonstrates:
 *   - A static final variable MAX_LIMIT representing a constant.
 *   - A final instance variable instanceId.
 *   - A static variable counter shared among all instances.
 *   - A final method showInfo() and a static method showMaxLimit().
 *
 * Run this application to see the output, which shows how many instances are created and
 * displays the constant.
 */
public class FinalStaticClient {
    public static void main(String[] args) {
        // Call the static method without having to create an instance.
        StaticFinalExample.showMaxLimit();

        // Create two instances with different final instance values.
        StaticFinalExample example1 = new StaticFinalExample(1);
        StaticFinalExample example2 = new StaticFinalExample(2);

        // Display information to see the behavior of final and static members.
        example1.showInfo();
        example2.showInfo();

        // `final` or Effectively Final in Lambda Functions
        // When working with lambda expressions or anonymous classes, any local variable used inside the lambda
        // must be declared as `final` or effectively final
        new StaticFinalExample(5).showScope();// showScope is not a static method
    }
}
