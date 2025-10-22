package DesignPatterns.Structural.Adapter.V2.BankAPIs;

public class YesBankAPI {
    public int getBalance(){
        System.out.println("Yes Bank is checking the balance");
        return 100;
    }

    public void transfer(int amount){
        System.out.println("Money has been transferred via Yes Bank");
    }

    // method returning enum
    public YesBankTransactionStatus checkTransactionStatus(String txnId) {
        System.out.println("Yes Bank checking transaction status for: " + txnId);
        return YesBankTransactionStatus.SUCCESS; // returning enum
    }
}
