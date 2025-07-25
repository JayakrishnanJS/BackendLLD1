package DesignPatterns.Creational.Factory.V0;

import DesignPatterns.Creational.Factory.V0.Components.Button.Button;
import DesignPatterns.Creational.Factory.V0.Components.Button.AndroidButton;
import DesignPatterns.Creational.Factory.V0.Components.Button.IOSButton;
import DesignPatterns.Creational.Factory.V0.Components.Dropdown.Dropdown;
import DesignPatterns.Creational.Factory.V0.Components.Dropdown.AndroidDropdown;
import DesignPatterns.Creational.Factory.V0.Components.Dropdown.IOSDropdown;

import java.util.Scanner;

public class Client {
    // Pros :
    // 1. Simple and straightforward implementation.
    //
    // Cons :
    // 1. Adding a new platform requires modifying the existing code, which violates the Open/Closed Principle.
    // 2. Many if–else statements can lead to code that is hard to maintain and extend & read.
    // 3. Client code is tightly coupled with the creation logic of components.
    // 4. Client will need to modify the code to add new platforms, which is not ideal for scalability.
    // 5. Hard to maintain if object creation is repeated in multiple places.
    // 6. Difficult to test and mock in unit tests due to tight coupling.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String platform = scanner.nextLine();

        Button button;
        Dropdown dropdown;

        if (platform.equals("Android")) {
            button   = new AndroidButton();
            dropdown = new AndroidDropdown();
        } else if (platform.equals("iOS")) {
            button   = new IOSButton();
            dropdown = new IOSDropdown();
        } else {
            throw new IllegalArgumentException("Unknown platform: " + platform);
        }

        button.click();
        dropdown.showOptions();
    }
}
