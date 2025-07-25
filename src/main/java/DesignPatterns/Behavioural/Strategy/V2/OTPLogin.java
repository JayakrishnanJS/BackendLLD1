package DesignPatterns.Behavioural.Strategy.V2;

public class OTPLogin implements LoginStrategy {
    public void login(){
        System.out.println("Loggin in via OTP");
    }
}
