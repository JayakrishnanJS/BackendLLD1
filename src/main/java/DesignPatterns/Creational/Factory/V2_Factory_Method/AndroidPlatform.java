package DesignPatterns.Creational.Factory.V2_Factory_Method;

import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.AndroidButton;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.Button;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.AndroidDropdown;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.Dropdown;

public class AndroidPlatform extends Platform {

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
