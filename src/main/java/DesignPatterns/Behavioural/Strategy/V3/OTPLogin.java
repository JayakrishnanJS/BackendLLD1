package DesignPatterns.Behavioural.Strategy.V3;

public class OTPLogin implements LoginStrategy {
    public void login(){
        System.out.println("Loggin in via OTP");
    }
}
