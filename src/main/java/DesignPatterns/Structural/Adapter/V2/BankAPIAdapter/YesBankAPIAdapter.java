package DesignPatterns.Structural.Adapter.V2.BankAPIAdapter;

import DesignPatterns.Structural.Adapter.V2.BankAPI;
import DesignPatterns.Structural.Adapter.V2.BankAPIs.YesBankAPI;
import DesignPatterns.Structural.Adapter.V2.BankAPIs.YesBankTransactionStatus;
import DesignPatterns.Structural.Adapter.V2.TransactionStatus;

public class YesBankAPIAdapter implements BankAPI {
    private YesBankAPI yesBankAPI = new YesBankAPI();
    @Override
    public int checkBalance() {
        return yesBankAPI.getBalance();
    }

    @Override
    public void transferMoney(int amount) {
        yesBankAPI.transfer(amount);
    }

    @Override
    public TransactionStatus getTransactionStatus(String txnId) {
        return fromYesBank(
                yesBankAPI.checkTransactionStatus(txnId));
    }

    // static utility method to convert YesBankTransactionStatus to TransactionStatus
    public static TransactionStatus fromYesBank(YesBankTransactionStatus status) {
        switch (status) {
            case SUCCESS: return TransactionStatus.SUCCESS;
            case FAILED: return TransactionStatus.FAILED;
            case IN_PROGRESS: return TransactionStatus.PENDING;
            default: throw new IllegalArgumentException("Unknown status: " + status);
        }
    }
}
