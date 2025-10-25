package DesignPatterns.Behavioural.Observer;

// Subject interface or Observable interface/ registry
// The Subject should be able to register, remove and notify Observers from its List.
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
