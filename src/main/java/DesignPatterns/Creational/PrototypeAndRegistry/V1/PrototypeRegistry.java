package DesignPatterns.Creational.PrototypeAndRegistry.V1;

public interface PrototypeRegistry {
    Student get(StudentType key);
    void add(StudentType key, Student prototype);
    void removeStudent(StudentType key);
    int getRegisteredCount();
    Student clone(StudentType key);
}
