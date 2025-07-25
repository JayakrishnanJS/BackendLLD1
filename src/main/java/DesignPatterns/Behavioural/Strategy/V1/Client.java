package DesignPatterns.Behavioural.Strategy.V1;

import java.util.Scanner;

public class Client {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter your choice for login : ");

//        String choice = scanner.nextLine();
//        LoginStrategy loginStrategy = null;
//        if(choice.equalsIgnoreCase("google")){
//            loginStrategy = new GoogleLogin();
//        } else if(choice.equalsIgnoreCase("otp")){
//            loginStrategy = new OTPLogin();
//        } else if(choice.equalsIgnoreCase("username")){
//            loginStrategy = new UsernameLogin();
//        }
        LoginStrategy loginStrategy = LoginStrategyFactory.getLoginStrategy(scanner.nextLine());
        loginStrategy.login();
    }
}
// Pros:
// 1. The Client is free from managing loginStrategy and various login object instantiation, just need to select strategy runtime
// 2. LoginStrategyFactory takes care of diff login objects

// Cons:
// 1. The Client cannot switch to a new Strategy in runtime.