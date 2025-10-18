package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public abstract class LockScreen {

    protected final Button button;
    protected final Dropdown dropdown;

    // Constructor injects abstract products
    public LockScreen(Button button, Dropdown dropdown) {
        this.button = button;
        this.dropdown = dropdown;
    }

    // Abstract methods for concrete LockScreens to implement
    public abstract void render();
    public abstract void applyTheme();
}
