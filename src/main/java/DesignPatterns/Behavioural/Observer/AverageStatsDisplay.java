package DesignPatterns.Behavioural.Observer;

public class AverageStatsDisplay implements Observer, Display {
    private float temperature;
    private float humidity;
    private float pressure;

    // aggregation relationship with Subject
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    // Dynamic self registration mechanism - is a way for the `AverageStatsDisplay` object (observer) to register itself
    // with a `Subject` (observable object). This means the `AverageStatsDisplay` instance informs the `Subject` that
    // it wants to receive updates whenever the `Subject's` state changes
    public void registerWithSubject(){
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Average data : " + temperature + "\t" + humidity + "\t" + pressure);
    }
}
