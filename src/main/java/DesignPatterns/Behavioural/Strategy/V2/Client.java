package DesignPatterns.Behavioural.Strategy.V2;

import java.util.Scanner;

public class Client {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter your choice for login : ");
        String choice1 = scanner.nextLine();

        // pick the strategy
        LoginStrategy strategy = LoginStrategyFactory.getLoginStrategy(choice1);

        // wrap it in context
        LoginContext context = new LoginContext(strategy);

        // perform login
        context.login();
        System.out.println();

        // Switch to 'otp based' login at runtime - if google login route is failing, it should be possible to switch to another strategy
        String choice2 = scanner.nextLine();
        context.setStrategy(LoginStrategyFactory.getLoginStrategy(choice2));
        context.login();
        System.out.println();
    }
}
/**
     Strategy design pattern is a behavioral design pattern that enables selecting an algorithm/strategy at runtime.
     It defines a family of algorithms, encapsulates each one, and makes them interchangeable.

     When to use Strategy Pattern ?
     1. When you have multiple algorithms for a specific task, and you want to choose one at runtime.
     2. When you want to avoid using multiple conditional statements (if-else or switch-case) to select an algorithm.
     3. When you want to decouple the algorithm from the client code, allowing for easier maintenance and extension.

     Component of Strategy Pattern
     1. Context: The class that uses the strategy.
     2. Strategy: An interface that defines a family of algorithms.
     3. Concrete Strategy: Classes that implement the Strategy interface, providing specific implementations of the algorithms.

     Impl:
     1. Strategy interface – defines the common login operation.
     2. Concrete Strategy classes – implement the login algorithms.
     3. Context class - maintains a reference to a Strategy object and defines an interface
                        strategy = how to log in, context = when and around login.
     4. Factory – encapsulates creation of strategies.
     5. Client – picks and invokes a strategy via the factory.
**/
