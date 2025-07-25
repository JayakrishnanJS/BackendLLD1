
package DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Dropdown;

public class AndroidDropdown implements Dropdown {
    @Override
    public void showOptions() {
        System.out.println("Options from Android Dropdown");
    }
}
