package bankproject;

import java.util.Calendar;

public class LoanAccount extends Account {
    double princiableLoanAmount, interestRate;
    int monthDuration;
    Calendar dateOfIncreasingAmount;

    public LoanAccount(double princiableLoanAmount, double interestRate, int monthDuration, int customerId) {
        super(0, customerId);
        this.princiableLoanAmount = princiableLoanAmount;
        this.interestRate = interestRate;
        this.monthDuration = monthDuration;
        this.dateOfIncreasingAmount=Calendar.getInstance(); 
        this.dateOfIncreasingAmount.add(Calendar.MONTH, monthDuration);
    }

    public Calendar getDateOfIncreasingAmount() {
        return dateOfIncreasingAmount;
    }

    public void setDateOfIncreasingAmount(Calendar dateOfIncreasingAmount) {
        this.dateOfIncreasingAmount = dateOfIncreasingAmount;
    }
    
    
    public double getPrinciableLoanAmount() {
        return princiableLoanAmount;
    }

    public void setPrinciableLoanAmount(double princiableLoanAmount) {
        this.princiableLoanAmount = princiableLoanAmount;
    }
 
    public void increaseAmountRate() {
        this.setPrinciableLoanAmount(this.getPrinciableLoanAmount()*(1+this.interestRate));
    }
    
    public void depositLoadAmount (double amount){
        if (amount >= this.getPrinciableLoanAmount()){
            double deduceAmount = amount - this.getPrinciableLoanAmount();
            this.setPrinciableLoanAmount(0);
            super.depusit(deduceAmount);
        } else {
            this.setPrinciableLoanAmount(this.getPrinciableLoanAmount()-amount);
        }
    }
    
    public void applyAmountRate(){
        //call montthly
        if (Calendar.getInstance().compareTo(this.getDateOfIncreasingAmount()) >= 0){
            this.increaseAmountRate();
            Calendar newRenewableDate = this.getDateOfIncreasingAmount();
            newRenewableDate.add(Calendar.MONTH,1);
            this.setDateOfIncreasingAmount(newRenewableDate);
        }
    }

}
