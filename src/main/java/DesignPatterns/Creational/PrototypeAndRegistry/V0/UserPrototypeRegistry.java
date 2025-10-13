package DesignPatterns.Creational.PrototypeAndRegistry.V0;

public interface UserPrototypeRegistry {

    void addPrototype(User user);

    User getPrototype(UserType type);

    User clone(UserType type);
}