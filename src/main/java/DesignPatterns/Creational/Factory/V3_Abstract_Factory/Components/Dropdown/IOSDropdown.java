package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown;

public class IOSDropdown implements Dropdown {
    @Override
    public void showOptions() {
        System.out.println("Options from IOS Dropdown");
    }
}
