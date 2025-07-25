package DesignPatterns.Behavioural.Strategy.V3;

public class GoogleLogin implements LoginStrategy {
    @Override
    public void login() {
        System.out.println("Logging in via Google");
    }
}
