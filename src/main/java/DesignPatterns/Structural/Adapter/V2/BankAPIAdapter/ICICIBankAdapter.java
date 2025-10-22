package DesignPatterns.Structural.Adapter.V2.BankAPIAdapter;

import DesignPatterns.Structural.Adapter.V2.BankAPI;
import DesignPatterns.Structural.Adapter.V2.BankAPIs.ICICIBankAPI;
import DesignPatterns.Structural.Adapter.V2.TransactionStatus;

public class ICICIBankAdapter implements BankAPI {
    private ICICIBankAPI iciciBankAPI  = new ICICIBankAPI();
    @Override
    public int checkBalance() {
        return iciciBankAPI.balanceCheck();
    }

    @Override
    public void transferMoney(int amount) {
        iciciBankAPI.moneyTransfer(amount);
    }

    @Override
    public TransactionStatus getTransactionStatus(String txnId) {
        String status = iciciBankAPI.getTransactionStatus(txnId);
        // Convert String → Enum
        switch (status) {
            case "SUCCESS":
                return TransactionStatus.SUCCESS;
            case "FAILED":
                return TransactionStatus.FAILED;
            default:
                return TransactionStatus.PENDING;
        }
    }
}
