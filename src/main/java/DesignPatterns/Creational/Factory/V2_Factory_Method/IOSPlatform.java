package DesignPatterns.Creational.Factory.V2_Factory_Method;

import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.Button;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.IOSButton;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.Dropdown;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.IOSDropdown;

public class IOSPlatform extends Platform {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new IOSDropdown();
    }
}
