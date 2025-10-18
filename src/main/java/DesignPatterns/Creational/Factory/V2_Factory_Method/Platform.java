package DesignPatterns.Creational.Factory.V2_Factory_Method;

import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Button.Button;
import DesignPatterns.Creational.Factory.V2_Factory_Method.Components.Dropdown.Dropdown;

public abstract class Platform {
    // Factory methods (to be overridden by subclasses)
    public abstract Button   createButton();
    public abstract Dropdown createDropdown();

    // Other responsibilities (workflow logic)
    public void renderUI() {
        Button button = createButton();     // uses factory method
        Dropdown dropdown = createDropdown();

        button.click();                     // behavior of product
        dropdown.showOptions();
    }

    public void initializePlatform() {
        System.out.println("Initializing platform resources...");
    }
}

/**
 the creator and the factory are one and the same =>
 Platform is both the thing you work with and the thing that makes products.
 **/
