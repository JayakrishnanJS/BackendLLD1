package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public class IOSHomeScreen extends HomeScreen {
    public IOSHomeScreen(Button button, Dropdown dropdown) {
        super(button, dropdown);
    }

    @Override
    public void render() {
        System.out.println("Rendering iOS Home Screen...");
    }

    @Override
    public void applyTheme() {
        System.out.println("Applying iOS Home screen theme...");
        dropdown.showOptions();
        button.click();
    }
}
