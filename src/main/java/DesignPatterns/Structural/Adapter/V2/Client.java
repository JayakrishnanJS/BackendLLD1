package DesignPatterns.Structural.Adapter.V2;

import java.util.Scanner;

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
// YesBankTransactionStatus enum used by Yes bank to show transaction status
// ICICIBankTransactionStatus return String to show transaction status
// So for better adaptability we can create our own enum TransactionStatus and use it in BankAPI interface
// and let adapters convert their respective bank transaction status to our TransactionStatus enum
// This will make our code more loosely coupled and adaptable to changes in bank APIs.



