package bankproject;
public class CheckingAccount extends Account    {
    
    private double creditlimit ;
    private double availableLimit;
    
//    public CheckingAccount() {
//    //default construtcor no need for super
//        this.creditlimit = 50000;
//    }
    
    public CheckingAccount(double creditlimit, double balance, int customerId) {
        super(balance,customerId);
        this.creditlimit = creditlimit;
    }
    
    //Function that allows checks if has credit limit
    public boolean checkCreditLimit(){
        if (super.getBalance() > (- this.creditlimit)){
            if (super.getBalance() > 0){
                this.availableLimit = this.creditlimit;
            } else {
                this.availableLimit = (-this.creditlimit) - super.getBalance();
            }
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkAmount(double amount){
        if (super.getBalance() >= amount){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void withDraw (double amount){
        if (checkAmount(amount)){
            super.setBalance(super.getBalance()- amount);
        } else {
            if (this.checkCreditLimit()){
                //case true? can withdraw within limit
                if (super.getBalance()- amount >= (- this.availableLimit)){
                    super.setBalance(super.getBalance()- amount);
                } else {
                    //amount is larger than available amount
                }
                
            } else {
                //you reached the limit already
            }
        }
    }
}
