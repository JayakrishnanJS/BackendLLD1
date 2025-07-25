package DesignPatterns.Structural.Adapter.V0;

import DesignPatterns.Structural.Adapter.V0.BankAPIs.YesBankAPI;

public class FastTagRecharge {
    public boolean recharge(int amount, YesBankAPI yesBankAPI){
        if(yesBankAPI.getBalance() >= amount){
            System.out.println("Successful!");
            return true;
        }
        System.out.println("Sorry, you don't have enough money");
        return false;
    }
}
