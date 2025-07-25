package DesignPatterns.Behavioural.Strategy.V0;

public class UsernameLogin implements LoginStrategy {
    public void login(){
        System.out.println("Logging in via Username password");
    }
}
