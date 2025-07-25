package DesignPatterns.Behavioural.Strategy.V1;

public class UsernameLogin implements LoginStrategy {
    public void login(){
        System.out.println("Logging in via Username password");
    }
}
