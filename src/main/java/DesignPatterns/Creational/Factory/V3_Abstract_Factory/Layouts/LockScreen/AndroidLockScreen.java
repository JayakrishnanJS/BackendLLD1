package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public class AndroidLockScreen extends LockScreen {

    public AndroidLockScreen(Button button, Dropdown dropdown) {
        super(button, dropdown);
    }

    @Override
    public void render() {
        System.out.println("Rendering Android Lock Screen...");
    }

    @Override
    public void applyTheme() {
        System.out.println("Applying Android lock screen theme...");
        dropdown.showOptions();
        button.click();
    }
}
