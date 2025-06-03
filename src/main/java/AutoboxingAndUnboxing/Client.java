package AutoboxingAndUnboxing;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        int num1 = 10;
        Integer obj1 = num1;  // autoboxing - The compiler converts num to Integer.valueOf(num) behind the scenes.
        System.out.println("Wrapper object: " + obj1);

        Integer obj2 = 20;
        int num2 = obj2;  // unboxing - The compiler converts obj to obj.intValue() behind the scenes.
        System.out.println("Primitive value: " + num2);

        // Use case: Collections like ArrayList store objects, not primitives, so autoboxing/unboxing lets you work seamlessly with them.
        ArrayList<Integer> list = new ArrayList<>();

        // Autoboxing: int → Integer
        list.add(100);
        list.add(200);

        // Unboxing: Integer → int
        int sum = list.get(0) + list.get(1);
        System.out.println("Sum: " + sum);
    }
}

/*
    1. Definition: Autoboxing is the automatic conversion that the Java compiler makes between primitive types (e.g., int, double) and their corresponding wrapper classes (Integer, Double, etc.).
        Unboxing is the reverse—automatically converting a wrapper object back to its primitive value.
            Wrapper Classes Involved: Each primitive type has a corresponding wrapper:
            boolean ↔ Boolean
            byte ↔ Byte
            char ↔ Character
            short ↔ Short
            int ↔ Integer
            long ↔ Long
            float ↔ Float
            double ↔ Double

    2. Compiler Rules:
        a. Autoboxing: Whenever a primitive is used in a context expecting its wrapper (e.g., assigning int to Integer), the compiler inserts Integer.valueOf(int).
        b. Unboxing: Whenever a wrapper object is used where a primitive is expected, the compiler inserts calls like Integer.intValue().
    3. Caching & Identity Caveat: For certain wrapper types (notably Boolean, Byte, Short, Integer, Long, and Character up to 127), Java caches instances. \
       Comparing two autoboxed values with == can yield true for small cached ranges but not outside them—developers should use .equals(...) when checking wrapper equality.
    4. Performance Considerations: Autoboxing/unboxing introduces hidden object creation (or lookup) and method calls.
       Excessive use—especially in tight loops—can incur performance overhead and increase garbage‐collection pressure compared to using primitives directly.
    5. Null‐Pointer Risk: Unboxing a null wrapper reference (e.g., attempting to convert a null Integer to int) results in a NullPointerException.
       Developers must ensure wrapper objects are non‐null before unboxing.

*/

