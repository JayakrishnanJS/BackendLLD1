package DesignPatterns.Behavioural.Strategy.V2;

public class GoogleLogin implements LoginStrategy {
    @Override
    public void login() {
        System.out.println("Logging in via Google");
    }
}
