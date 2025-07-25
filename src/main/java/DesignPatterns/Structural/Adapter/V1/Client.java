package DesignPatterns.Structural.Adapter.V1;

import java.util.Scanner;
// - Structural patterns are design patterns that ease the design by identifying a simple
//   way to realize relationships between entities.
// - Structural patterns are concerned with how classes and objects are composed to
//   form larger structures.
// The adapter pattern is a structural pattern that allows objects with incompatible
// interfaces to collaborate.

// Adapter Design Pattern
// Adapter is a special object that converts the interface of one object so that another object can understand it.
// adapter wraps one of the objects to hide the complexity of conversion happening
// behind the scenes. The wrapped object isn’t even aware of the adapter.
// Working:
// 1. The adapter gets an interface, compatible with one of the existing objects.
// 2. Using this interface, the existing object can safely call the adapter’s methods.
// 3. Upon receiving a call, the adapter passes the request to the second object, but in a
//    format and order that the second object expects.

public class Client {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String bankName = scanner.nextLine();
        BankAPI bankAPI = BankAPIFactory.getBankAPIByName(bankName);// factory to instantiate adapter
        PhonePe phonePe = new PhonePe(bankAPI);
        phonePe.rechargeFastTag(100);
    }
}
// Pros:
// No violation of open closed principle, SRP


// Components of Adapter Design Pattern:
// 1. Target Interface: BankAPI
// 2. Adaptee: ICICBankAPI
// 3. Adapter: ICICBankAdapter
// 4. Client: PhonePe

// When to use Adapter Design Pattern:
// - When you want to use an existing class but its interface does not match the one you need.
// - When you want to create a bridge between two incompatible interfaces.