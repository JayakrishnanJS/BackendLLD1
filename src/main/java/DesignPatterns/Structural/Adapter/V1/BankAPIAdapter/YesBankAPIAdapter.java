package DesignPatterns.Structural.Adapter.V1.BankAPIAdapter;

import DesignPatterns.Structural.Adapter.V1.BankAPI;
import DesignPatterns.Structural.Adapter.V1.BankAPIs.YesBankAPI;

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
}
