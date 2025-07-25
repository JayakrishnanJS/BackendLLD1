package DesignPatterns.Creational.Factory.V2_Factory_Method;

import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.Button;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.Dropdown;

public abstract class Platform {
    // Factory methods
    public abstract Button   createButton();
    public abstract Dropdown createDropdown();
}
/**
 the creator and the factory are one and the same =>
 Platform is both the thing you work with and the thing that makes products.
 **/
