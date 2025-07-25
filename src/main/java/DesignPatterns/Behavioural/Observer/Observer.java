package DesignPatterns.Behavioural.Observer;

// all the Observer who listens to the update must implement this interface, instead of depending on WeatherData class
public interface Observer {
    void update(float temp, float humidity, float pressure);
}
