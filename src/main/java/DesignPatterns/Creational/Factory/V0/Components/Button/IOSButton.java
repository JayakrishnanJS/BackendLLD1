package DesignPatterns.Creational.Factory.V0.Components.Button;

public class IOSButton implements Button {
    @Override
    public void click() {
        System.out.println("IOS Button clicked");
    }
}
