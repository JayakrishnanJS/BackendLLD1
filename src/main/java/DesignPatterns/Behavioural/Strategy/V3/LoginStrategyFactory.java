package DesignPatterns.Behavioural.Strategy.V3;

// cares only about how to perform a specific login algorithm.
public class LoginStrategyFactory {
    public static LoginStrategy getLoginStrategy(String choice){
        LoginStrategy loginStrategy = null;
        if(choice.equalsIgnoreCase("google")){
            loginStrategy = new GoogleLogin();
        } else if(choice.equalsIgnoreCase("otp")){
            loginStrategy = new OTPLogin();
        } else if(choice.equalsIgnoreCase("username")){
            loginStrategy = new UsernameLogin();
        }
        return loginStrategy;
    }

// cares only about when and in what environment to run it
    public static LoginContext getLoginContext(String choice){
        return new LoginContext(getLoginStrategy(choice));// return strategy wrapped in context
    }
}
