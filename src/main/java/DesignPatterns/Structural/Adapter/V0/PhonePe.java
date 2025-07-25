package DesignPatterns.Structural.Adapter.V0;

import DesignPatterns.Structural.Adapter.V0.BankAPIs.YesBankAPI;

public class PhonePe {
    private FastTagRecharge fastTagRecharge;
    private PhonePeLoan phonePeLoan;
    private YesBankAPI yesBankAPI; // composition: has a - relationship

    public PhonePe() {
        this.fastTagRecharge = new FastTagRecharge();
        this.phonePeLoan = new PhonePeLoan();
        this.yesBankAPI = new YesBankAPI();
    }

    public boolean rechargeFastTag(int amount){
        return fastTagRecharge.recharge(amount, yesBankAPI);
    }

    public boolean availLoan(int amount){
        if(phonePeLoan.checkLoanEligibility(amount, yesBankAPI)){
            System.out.println("Let's disburse the loan");
            return true;
        } else {
            System.out.println("Sorry, you don't have enough money");
        }
        return false;
    }
}
