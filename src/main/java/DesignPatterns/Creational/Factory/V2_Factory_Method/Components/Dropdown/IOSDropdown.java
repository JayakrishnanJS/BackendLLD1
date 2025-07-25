package DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown;

public class IOSDropdown implements Dropdown {
    @Override
    public void showOptions() {
        System.out.println("Options from IOS Dropdown");
    }
}
