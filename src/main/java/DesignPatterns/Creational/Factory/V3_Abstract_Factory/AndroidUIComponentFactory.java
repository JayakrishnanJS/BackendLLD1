package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.AndroidButton;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.AndroidDropdown;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public class AndroidUIComponentFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }
    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
