package Interface.Usecase1;

public interface Notifier {
    void send(String message);
}
// - Any class that implements the `Notifier` interface is required to provide an implementation for the `send` method,
//   ensuring it defines how the `message` will be sent

/*
- an interface is an abstract type that contains a collection of methods and
  constant variables.It can be thought of as a blueprint of behavior.
- used to achieve abstraction, polymorphism and multiple
  inheritances.
- It is similar to a class, but it cannot be instantiated.
- It can contain only constants, method signatures, default methods, static methods, and nested types.
- Method bodies exist only for default methods and static methods.

- we can’t instantiate interfaces directly
- an interface can be empty, with no methods or variables in it
- we can’t use the final word in the interface definition, as it will result in a compiler error
- all interface declarations should have the public or default access modifier; the abstract modifier will be added
  automatically by the compiler
- an interface method can’t be protected or final
- up until Java 9, interface methods could not be private; however, Java 9 introduced the possibility to define private methods in interfaces.
- interface variables are public, static, and final by definition; we’re not allowed to change their visibility
*/
