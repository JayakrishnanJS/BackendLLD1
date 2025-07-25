package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button;

public class IOSButton implements Button {
    @Override
    public void click() {
        System.out.println("IOS Button clicked");
    }
}
