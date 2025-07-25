package Interface.Usecase1;

public class Client {
    public static void main(String[] args) {
        // Email Notification Demo
        Notifier emailNotifier = new EmailNotifier(); // Polymorphism
        NotificationService emailService = new NotificationService(emailNotifier);
        emailService.notifyUser("Welcome to the platform!");

        // SMS Notification Demo
        Notifier smsNotifier = new SMSNotifier();
        NotificationService smsService = new NotificationService(smsNotifier);
        smsService.notifyUser("Your OTP is 123456");

        // Anonymous Class Demo
        Notifier pushNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("Sending Push Notification: " + message);
            }
        };
        //Notifier pushNotifier = message -> System.out.println("Sending Push Notification: " + message);
        NotificationService pushService = new NotificationService(pushNotifier);
        pushService.notifyUser("You have a new friend request");
    }
}
//- An anonymous class does not have a name and is defined directly inline where it's needed.
//- It is often used to implement an interface or extend a class when a full class definition is unnecessary
//- It must provide the implementation for all the abstract methods of the interface or class.

//- Lambda expressions can only be used with functional interfaces.
//- A functional interface, like `Notifier` here, is an interface with exactly one abstract method.
//- `message` is the single parameter of the `send` method in the `Notifier` interface.
// - The arrow operator `->` separates the parameter(s) from the body of the lambda expression.
//    (parameters) -> { body }