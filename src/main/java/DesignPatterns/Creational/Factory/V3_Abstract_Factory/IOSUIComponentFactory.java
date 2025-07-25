package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.IOSButton;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.IOSDropdown;

public class IOSUIComponentFactory implements UIComponentFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }
    @Override
    public Dropdown createDropdown() {
        return new IOSDropdown();
    }
}
