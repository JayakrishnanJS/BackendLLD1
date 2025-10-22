package DesignPatterns.Structural.Adapter.V2;

public interface BankAPI {
    int checkBalance();
    void transferMoney(int amount);
    TransactionStatus getTransactionStatus(String txnId); // unified as String
}
