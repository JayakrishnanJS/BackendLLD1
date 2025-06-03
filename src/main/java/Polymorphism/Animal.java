package Polymorphism;

public class Animal {

    void speak() {
        System.out.println("Animal speaks");
    }

    Animal eat() {
        System.out.println("Animal eats");
        return null;
    }

    private void sayHi() {
        System.out.println("Animal says hi");
    }
}

/*
    Method Overriding enables a subclass to provide its own implementation for a method already defined in its superclass.
    This allows Java to decide at run time which method to invoke based on the actual object type, enabling runtime polymorphism.

    1. Same Method Signature:
        The overriding method must have the same name and exact parameter list as the method in the superclass.
        Changing parameter types or count creates an overload, not an override.

    2. Return Type Must Be Compatible (Covariant or Same):
        If the superclass method returns a type T, the subclass’s override can return any subtype of T (a covariant return), or return T exactly.

    3. Access Modifier Cannot Be More Restrictive:
        The subclass’s method must be at least as accessible as the superclass’s.
        Example: if the parent declares protected void eat(), the override may be protected void eat() or public void eat(), but not private void eat().

    4. Cannot Override final Methods:
        A method declared final in the superclass cannot be overridden by any subclass.

    5. Cannot Override static Methods:
        Static methods are class‐level, not instance‐level, so you can’t override them. If you declare a static method with the same signature, it’s called method hiding, not overriding.

    6. Exception Handling (Checked Exceptions):
        The overriding method cannot throw new or broader checked exceptions than the overridden method. It may:
            a. Throw the same checked exceptions,
            b. Throw a subset of them,
            c. Or throw no checked exceptions.
        Unchecked exceptions (subclasses of RuntimeException) are not restricted

*/
