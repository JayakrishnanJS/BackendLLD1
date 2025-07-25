package DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Button;

public class AndroidButton implements Button {
    @Override
    public void click() {
        System.out.println("Android button clicked");
    }
}
