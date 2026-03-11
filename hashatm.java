public class hashatm {
    private int accountnumber;
    private int pin;
    private double balance;
    private int transactions;
    public hashatm(int accountnumber,int pin,double balance){
        this.accountnumber=accountnumber;
        this.pin=pin;
        this.balance=balance;
        this.transactions=0;
    }
    public int getAccountNumber(){
        return accountnumber;
    }
    public double getBalance(){
        return balance;
    }
    public void setPin(int pin){
        this.pin=pin;
    }
    public int getPin(){
        return pin;
    }
    public int getTransactions(){
        return transactions;
    }
    public void deposit(double amount){
        balance+=amount;
        transactions++;
    } 
    public boolean withdraw(double amount){
        if(amount<=balance){
            balance -=amount;
            transactions++;
            return true;
        }
            return false;
        
    }


}

