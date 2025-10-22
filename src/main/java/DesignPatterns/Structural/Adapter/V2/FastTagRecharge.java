package DesignPatterns.Structural.Adapter.V2;

public class FastTagRecharge {
    public boolean recharge(int amount, BankAPI bankAPI){
        if(bankAPI.checkBalance() > amount){
            System.out.println("Successful!");
            return true;
        }
        System.out.println(bankAPI.getTransactionStatus("transaction_id"));
        return false;
    }
}
