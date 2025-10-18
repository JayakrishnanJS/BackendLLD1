package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public class AndroidHomeScreen extends HomeScreen {

    public AndroidHomeScreen(Button button, Dropdown dropdown) {
        super(button, dropdown);
    }

    @Override
    public void render() {
        System.out.println("Rendering Android Home Screen...");
    }

    @Override
    public void applyTheme() {
        System.out.println("Applying Android Home screen theme...");
        dropdown.showOptions();
        button.click();
    }
}
