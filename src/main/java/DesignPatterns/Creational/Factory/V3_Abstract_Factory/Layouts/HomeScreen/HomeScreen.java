package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public abstract class HomeScreen {
    // Composition: HomeScreen depends on abstract products
    protected final Button button;
    protected final Dropdown dropdown;

    // Constructor injects the abstract products
    public HomeScreen(Button button, Dropdown dropdown) {
        this.button = button;
        this.dropdown = dropdown;
    }

    // Abstract methods to be implemented by concrete HomeScreens
    public abstract void render();
    public abstract void applyTheme();
}
