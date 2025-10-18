package DesignPatterns.Creational.Factory.V3_Abstract_Factory;

import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.HomeScreen.HomeScreen;
import DesignPatterns.Creational.Factory.V3_Abstract_Factory.Layouts.LockScreen.LockScreen;

public interface UILayoutFactory {
    HomeScreen createHomeScreen();
    LockScreen createLockScreen();
}
