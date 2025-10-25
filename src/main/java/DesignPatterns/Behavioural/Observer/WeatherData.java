package DesignPatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

//  Observable Interface or Subject Interface implementation or Publisher
//  The WeatherData is the core class which maintains the List of Observers and notifies them whenever there is a change in its state
public class WeatherData implements Subject {
    //AverageStatsDisplay averageStatsDisplay;
    //CurrentStatsDisplay currentStatsDisplay;
    //ForecastDisplay forecastDisplay;
    //we are passing the List of Observers instead of using Association of class objects directly bcz if a new Observer
    //comes, we should not violate OCP(not modifyWeatherData) and SRP(not responsibility of WeatherData)
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Informing everyone about the change");
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // whenever the setMeasurements is called, I will notify my observers
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        System.out.println("Weather Data has changed!");
        notifyObservers();
    }
}
