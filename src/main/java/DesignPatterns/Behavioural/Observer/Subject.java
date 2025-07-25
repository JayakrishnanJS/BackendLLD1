package DesignPatterns.Behavioural.Observer;

// The Subject should be able to register, remove and notify Observers from its List.
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
