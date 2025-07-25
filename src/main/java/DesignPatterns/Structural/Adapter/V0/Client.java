package DesignPatterns.Structural.Adapter.V0;

public class Client {
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe();
        phonePe.rechargeFastTag(100);
        phonePe.rechargeFastTag(1000);
    }
}
// Cons :
// 1. ICICI bank and Yes bank apis have diff method names => Switching banks violates SRP and OCP
// 2. using concrete classes instead of interfaces. This makes our code tightly coupled.