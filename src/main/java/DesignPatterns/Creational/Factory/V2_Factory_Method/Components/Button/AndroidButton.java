package DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button;

public class AndroidButton implements Button {
    @Override
    public void click() {
        System.out.println("Android button clicked");
    }
}
