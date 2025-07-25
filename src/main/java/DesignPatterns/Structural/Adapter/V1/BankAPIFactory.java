package DesignPatterns.Structural.Adapter.V1;

import DesignPatterns.Structural.Adapter.V1.BankAPIAdapter.ICICIBankAdapter;
import DesignPatterns.Structural.Adapter.V1.BankAPIAdapter.YesBankAPIAdapter;

public class BankAPIFactory {
    public static BankAPI getBankAPIByName(String bankName) {
        BankAPI bankAPI = null;
        if(bankName.equals("ICICI")){
            bankAPI = new ICICIBankAdapter();
        } else if(bankName.equals("YesBank")){
            bankAPI = new YesBankAPIAdapter();
        }
        return bankAPI;
    }
}
