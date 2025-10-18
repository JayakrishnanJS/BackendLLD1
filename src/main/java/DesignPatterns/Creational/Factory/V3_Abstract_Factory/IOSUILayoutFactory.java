package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Button.IOSButton;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Components.Dropdown.IOSDropdown;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen.HomeScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen.IOSHomeScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen.IOSLockScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen.LockScreen;

public class IOSUILayoutFactory implements UILayoutFactory {
    @Override
    public HomeScreen createHomeScreen() {
        return new IOSHomeScreen(new IOSButton(), new IOSDropdown());
    }

    @Override
    public LockScreen createLockScreen() {
        return new IOSLockScreen(new IOSButton(), new IOSDropdown());
    }
}
