package bankproject;

import java.util.Calendar;

public class SavingAccount extends Account  {
    private final double interstrate;
    private Calendar renewableDate;
    double oldAmount;

    public SavingAccount(double interstrate, double balance, int customerId) {
        super (balance, customerId);
        this.renewableDate=Calendar.getInstance(); 
        this.renewableDate.add(Calendar.MONTH, 1);
        this.interstrate = interstrate;
        this.oldAmount = balance;
    }

    public double getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(double oldAmount) {
        this.oldAmount = oldAmount;
    }
    
    public void setRenewableDate(Calendar renewableDate) {
        this.renewableDate = renewableDate;
    }

    public Calendar getRenewableDate() {
        return renewableDate;
    }
    
    public void depositRate(double amount){
        double amountDeposited = amount * (1+this.interstrate);
        super.depusit(amountDeposited);
    }
    
    // do this function monthly check how to do that
    public void depositMonthly(){
        if (Calendar.getInstance().compareTo(this.getRenewableDate()) >= 0){
            //deposit with old rate
            this.depositRate(this.getOldAmount());
            //renew date
            Calendar newRenewableDate = this.getRenewableDate();
            newRenewableDate.add(Calendar.MONTH,1);
            this.setRenewableDate(newRenewableDate);
            // renew old amount
            this.setOldAmount(super.getBalance()); 
        }
    }
    
}
