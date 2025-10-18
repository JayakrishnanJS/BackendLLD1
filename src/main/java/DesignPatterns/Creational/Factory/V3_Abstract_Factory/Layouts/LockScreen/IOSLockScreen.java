package DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.Dropdown;

public class IOSLockScreen extends LockScreen {

    public IOSLockScreen(Button button, Dropdown dropdown) {
        super(button, dropdown);
    }

    @Override
    public void render() {
        System.out.println("Rendering iOS Lock Screen...");
    }

    @Override
    public void applyTheme() {
        System.out.println("Applying iOS lock screen theme...");
        dropdown.showOptions();
        button.click();
    }
}
