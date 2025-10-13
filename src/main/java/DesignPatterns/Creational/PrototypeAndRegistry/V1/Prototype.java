package DesignPatterns.Creational.PrototypeAndRegistry.V1;

// whoever wants to support copy should implement this interface
public interface Prototype<T> {
    T copy();
}
