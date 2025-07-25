package DesignPatterns.Behavioural.Observer;

public class WeatherStation {
    public static void main(String[] args) {

        System.out.println("----- With no Observer -----");
        WeatherData weatherData = new WeatherData();
        weatherData.setMeasurements(30.5f, 50.6f , 90.2f);

        System.out.println("----- With 3 Observers -----");
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        AverageStatsDisplay averageStatsDisplay = new AverageStatsDisplay();
        CurrentStatsDisplay currentStatsDisplay = new CurrentStatsDisplay();

        weatherData.registerObserver(forecastDisplay);
        weatherData.registerObserver(averageStatsDisplay);
        weatherData.registerObserver(currentStatsDisplay);

        weatherData.setMeasurements(30.5f, 50.6f , 90.2f);

        System.out.println("----- With 2 Observers, after removing one -----");
        weatherData.removeObserver(averageStatsDisplay);
        weatherData.setMeasurements(30.5f, 50.6f , 90.2f);

        System.out.println("----- Self Registering of removed Observer -----");
        //`Subject` is the observable that holds the state (in this case, `WeatherData`).
        //`Observers` are the components that listen for changes in the `Subject`
        // e.g., `AverageStatsDisplay`, `ForecastDisplay`, `CurrentStatsDisplay`
        // By executing below two lines, the `averageStatsDisplay` begins listening for updates from the
        // `weatherData` object. This means whenever `weatherData`'s state changes (e.g., through `setMeasurements`),
        // the `averageStatsDisplay` will be notified and updated.

        averageStatsDisplay.setSubject(weatherData);
        averageStatsDisplay.registerWithSubject();

        System.out.println("----- Again With 3 Observers -----");
        weatherData.setMeasurements(30.5f, 50.6f , 90.2f);

    }
}
/**
     Observer Design Pattern is used to create a one-to-many dependency between objects so that when one object changes
     state, all its dependents are notified and updated automatically.

     When to use Observer Pattern ?
     - When an object (subject) needs to notify multiple objects (observers) about changes in its state.
     - When the number of observers is not fixed and can change dynamically.

     Components of Observer Pattern:
     1. Observable Interface => Subject: The object that holds the state and notifies observers about changes.
     2. Observer Interface => Observer: The object that wants to be notified about changes in the subject's state.
     3. ConcreteSubject: A concrete implementation of the subject that maintains a list of observers and notifies them.
     4. ConcreteObserver: A concrete implementation of the observer that reacts to notifications from the subject.
     5. Client - The client is responsible for creating the subject and the observers. The
                  client is also responsible for registering the observers with the subject.
 **/