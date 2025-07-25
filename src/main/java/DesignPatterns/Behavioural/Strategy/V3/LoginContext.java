package DesignPatterns.Behavioural.Strategy.V3;

//  context class maintains a reference to a Strategy object and defines an interface that lets the strategy access its data.
public class LoginContext {
    private LoginStrategy loginStrategy;

    public LoginContext(LoginStrategy loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    public void login() {
        System.out.println("Starting login process...");
        long startTime = System.currentTimeMillis();

        loginStrategy.login();  // delegate to chosen strategy

        long endTime = System.currentTimeMillis();
        System.out.println("Login finished in " + (endTime - startTime) + " ms.");
    }

    // To change Strategy runtime:
//    public void setStrategy(LoginStrategy loginStrategy) {
//        this.loginStrategy = loginStrategy;
//    }

    public void setStrategy(LoginContext loginContext) {
        this.loginStrategy = loginContext.loginStrategy;
    }
}

/**
    🎯 Why use LoginContext?
        Even though your strategy.login() can be directly used, LoginContext:
            a. You get separation of concerns: strategy = how to log in, context = when and around login.
            b. Centralizes logic if you need to add pre/post actions later (e.g., logging, session tracking).
            c. Makes your design open for extension.
            d. Is good design practice in real-world enterprise codebases.
 **/