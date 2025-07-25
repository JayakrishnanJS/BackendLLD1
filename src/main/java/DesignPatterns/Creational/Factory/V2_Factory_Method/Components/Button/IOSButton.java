package DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button;

public class IOSButton implements Button {
    @Override
    public void click() {
        System.out.println("IOS Button clicked");
    }
}
