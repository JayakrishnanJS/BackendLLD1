package DesignPatterns.Structural.Adapter.V1.BankAPIAdapter;

import DesignPatterns.Structural.Adapter.V1.BankAPI;
import DesignPatterns.Structural.Adapter.V1.BankAPIs.ICICIBankAPI;

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
}
