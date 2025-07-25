package DesignPatterns.Creational.Factory.V1_Simple_Factory;

import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Button.Button;
import DesignPatterns.Creational.Factory.V1_Simple_Factory.Components.Dropdown.Dropdown;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // A simple factory is a static method that returns an instance of a class. It is a static
        // method because it does not need to be instantiated. It is a factory because it creates
        // an instance of a class.
        // The complete steps to implement the simple factory pattern are:
        // 1. Factory class - Create a factory class that contains a static method for creating
        // objects.
        // 2. Conditional - Use a conditional statement to create the object based on the input.
        // 3. Request - Request an object from the factory class without having to know the class
        // of the object that will be returned.
        Scanner scanner = new Scanner(System.in);
        String platform = scanner.nextLine();

        Button button     = UIComponentSimpleFactory.createButton(platform);
        Dropdown dropdown = UIComponentSimpleFactory.createDropdown(platform);

        button.click();
        dropdown.showOptions();
    }
}
// Pros :
// 1. Moved the component creation logic to a separate factory class and decoupled it from the client code.

// Cons :
// 1. Still requires modification of the factory class to add new platform types, which violates the Open/Closed Principle.
// 2. Still has if–else statements, which can lead to code that is hard to maintain and extend.
