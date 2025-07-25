package DesignPatterns.Creational.Factory.V0.Components.Button;

public class AndroidButton implements Button {
    @Override
    public void click() {
        System.out.println("Android button clicked");
    }
}
