package DesignPatterns.Creational.PrototypeAndRegistry;

// whoever wants to support copy should implement this interface
public interface Prototype<T> {
    T copy();
}
