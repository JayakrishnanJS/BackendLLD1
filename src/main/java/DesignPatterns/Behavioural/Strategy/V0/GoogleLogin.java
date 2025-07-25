package DesignPatterns.Behavioural.Strategy.V0;

public class GoogleLogin implements LoginStrategy{
    @Override
    public void login() {
        System.out.println("Logging in via Google");
    }
}
