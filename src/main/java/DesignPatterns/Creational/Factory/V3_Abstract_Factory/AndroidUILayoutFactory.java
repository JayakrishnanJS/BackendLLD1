package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.AndroidButton;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.AndroidDropdown;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen.AndroidHomeScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen.HomeScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen.AndroidLockScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen.LockScreen;

public class AndroidUILayoutFactory implements UILayoutFactory {
    @Override
    public HomeScreen createHomeScreen() {
        return new AndroidHomeScreen(new AndroidButton(), new AndroidDropdown());
    }

    @Override
    public LockScreen createLockScreen() {
        return new AndroidLockScreen(new AndroidButton(), new AndroidDropdown());
    }
}
