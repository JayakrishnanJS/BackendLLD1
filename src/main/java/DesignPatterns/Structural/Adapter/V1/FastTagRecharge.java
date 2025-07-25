package DesignPatterns.Structural.Adapter.V1;

public class FastTagRecharge {
    public boolean recharge(int amount, BankAPI bankAPI){
        if(bankAPI.checkBalance() > amount){
            System.out.println("Successful!");
            return true;
        }
        return false;
    }
}
