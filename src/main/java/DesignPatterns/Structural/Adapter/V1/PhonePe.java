package DesignPatterns.Structural.Adapter.V1;

public class PhonePe {
    private FastTagRecharge fastTagRecharge;
    private PhonePeLoan phonePeLoan;
    private BankAPI bankAPI;

    public PhonePe(BankAPI bankAPI) {
        this.fastTagRecharge = new FastTagRecharge();
        this.phonePeLoan = new PhonePeLoan();
        this.bankAPI = bankAPI;
    }

    public boolean rechargeFastTag(int amount){
        return fastTagRecharge.recharge(amount, bankAPI);
    }

    public boolean availLoan(int amount){
        if(phonePeLoan.checkLoanEligibility(amount, bankAPI)){
            System.out.println("Let's disburse the loan");
            return true;
        } else {
            System.out.println("Sorry, you don't have enough money");
        }
        return false;
    }
}
