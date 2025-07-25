package DesignPatterns.Creational.Factory.V0.Components.Dropdown;

public class IOSDropdown implements Dropdown {
    @Override
    public void showOptions() {
        System.out.println("Options from IOS Dropdown");
    }
}
