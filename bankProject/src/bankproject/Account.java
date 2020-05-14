package bankproject;

public class Account {
    
   private double balance ;
   private int accountId;
   private int customerId;
   static int accountIdCounter;
   //private enum AccountType { Normal, CheckingAccount, SavingAccount, LoanAccount }  
    
   public Account(double balance, int custid ) {
       this.balance = balance;
       this.accountId = accountIdCounter ++;
       this.customerId = custid;
       //this.acctype = AccountType.Normal;
   }
    
    
    public void depusit (double amount) {
        this.balance += amount;
    } 
    
    public void withDraw (double amount){
        this.balance-=amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
