package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

// Abstract Factory
public interface UIComponentFactory {
    Button   createButton();
    Dropdown createDropdown();
}
/**
     Abstract Factory → UIComponentFactory
     Defines the family of products (buttons, dropdowns, menus, etc.).

     Concrete Factories → AndroidUIComponentFactory & IOSUIComponentFactory
     Implement UIComponentFactory and produce platform‑specific variants.

     Factory‐of‐Factories → PlatformFactory.getFactory(...)
     Chooses which concrete factory to return at runtime.
 **/