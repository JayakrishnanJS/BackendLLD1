package DesignPatterns.Behavioural.Strategy.V2;

public class UsernameLogin implements LoginStrategy {
    public void login(){
        System.out.println("Logging in via Username password");
    }
}
