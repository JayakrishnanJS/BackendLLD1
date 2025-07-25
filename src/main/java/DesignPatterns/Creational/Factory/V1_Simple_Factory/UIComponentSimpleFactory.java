package DesignPatterns.Creational.Factory.V1_Simple_Factory;

import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Button.AndroidButton;
import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Button.IOSButton;
import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Dropdown.Dropdown;
import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Dropdown.AndroidDropdown;
import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Dropdown.IOSDropdown;

public class UIComponentSimpleFactory {
    // Simple Factory
    public static Button createButton(String platform) {
        if (platform.equals("Android")) {
            return new AndroidButton();
        } else if (platform.equals("iOS")) {
            return new IOSButton();
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }

    public static Dropdown createDropdown(String platform) {
        if (platform.equals("Android")) {
            return new AndroidDropdown();
        } else if (platform.equals("iOS")) {
            return new IOSDropdown();
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }
}
