package DesignPatterns.Creational.PrototypeAndRegistry;

public interface PrototypeRegistry {
    Student get(StudentType key);
    void add(StudentType key, Student prototype);
    void removeStudent(StudentType key);
    int getRegisteredCount();
}
