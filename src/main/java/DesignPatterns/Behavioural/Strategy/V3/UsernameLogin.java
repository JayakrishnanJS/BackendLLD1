package DesignPatterns.Behavioural.Strategy.V3;

public class UsernameLogin implements LoginStrategy {
    public void login(){
        System.out.println("Logging in via Username password");
    }
}
