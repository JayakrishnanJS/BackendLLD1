package DesignPatterns.Structural.Adapter.V2.BankAPIs;

public class ICICIBankAPI {
    public int balanceCheck(){
        System.out.println("ICICI Bank is checking the balance");
        return 100;
    }

    public void moneyTransfer(int amount){
        System.out.println("Money has been transferred via ICICI Bank");
    }

    // method returning String
    public String getTransactionStatus(String txnId) {
        System.out.println("ICICI Bank checking transaction status for: " + txnId);
        return "SUCCESS"; // returning String instead of enum
    }
}
