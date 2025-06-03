package Polymorphism;

public class CompileTimePoly {
    // Class demonstrating compile-time polymorphism
    // 1) Different number of parameters
    public int sum(int a, int b) {
        return a + b;
    }
    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    // 2) Different types (same number)
    public double sum(double a, double b) {
        return a + b;
    }
    public long sum(long a, long b) {
        return a + b;
    }

    // 3) Different order
    public String concat(String s, int n) {
        return s + n;
    }
    public String concat(int n, String s) {
        return n + s;
    }

    // Return type alone cannot distinguish two overloaded methods.
    //    double add(int a, int b) { // ❌ Compile-time error
    //        return a + b;
    //    }
}


/*
* Method Overloading in Java allows a class to have more than one method with the same name but different signatures.
* It’s a form of compile‐time (static) polymorphism: the compiler selects which version to invoke based on the arguments you pass.

    1. What Is a Method Signature?
        A method’s signature comprises:
            a. Method name
            b. Parameter list (order, number, and types of parameters)

        Note: The return type, throws clauses, or access modifiers (public, protected, etc.) are not part of the signature for overloading purposes. Two methods that differ only by return type (but share the same name and parameter list) are not considered overloaded; the compiler will complain.

    2. Rules for Overloading
        1. Same Name, Different Signature:
            At least one of the following must differ:
                a. Number of parameters (e.g. (int, int) vs. (int, int, int))
                b. Type of parameters (e.g. (int, double) vs. (double, int))
                c. Order of types (e.g. (String, int) vs. (int, String))

        2. Return Type Irrelevant:
            int compute(int a) { ... }
            double compute(int a) { ... } // ❌ does NOT compile (same signature)
            You cannot overload by return type alone.

    3. Varargs and Autoboxing:
        You can overload methods that use varargs or rely on autoboxing/unboxing, but beware of ambiguity.
            Example:
            void log(int... nums) { … }
            void log(Integer x) { … }
            If you call log(5), the compiler picks log(Integer) (exact match) over log(int...).

    4. Checked Exceptions Don’t Affect Overload:
        void save(String s) throws IOException { … }
        void save(String s) throws SQLException { … }
        Both still share signature save(String), so this is not valid overloading. To overload, change parameter list.
* */