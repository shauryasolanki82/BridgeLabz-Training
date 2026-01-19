package review;
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        System.out.println(message);
    }
}
class Account{
    String accountHolder;
    String branch;
    int accNumber;
    int balance;
    public Account(String accountHolder, String branch, int accNumber, int balance){
        this.accountHolder = accountHolder;
        this.branch = branch;
        this.accNumber = accNumber;
        this.balance = balance;
    }
    public void addBalance(int amount){
        balance += amount;
        System.out.println("Your amount is added");
        System.out.println("Your available balance is: "+ balance);
    }
    public void checkBalance(){
        System.out.println("Available balance is: "+balance);
    }
    public void widthrawl(int amount){
        try{
            if(balance < amount)
                InsufficientBalanceException("insufficient balance");
        }
        catch(Exception e){
        balance -= amount;
        System.out.println("You widthrawl: "+ amount);
        System.out.println("Your available balance is: "+ balance);
        }
        finally{
            System.out.println("your transaction complete");
        }
    }
    private void InsufficientBalanceException(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'InsufficientBalanceException'");
    }
}
class SavingsAccount extends Account{
    String accountHolder;
    String branch;
    int accNumber;
    int balance;
    public SavingsAccount(String accountHolder, String branch, int accNumber, int balance) {
        super(accountHolder, branch, accNumber, balance);
        this.accNumber = accNumber;
        this.accountHolder = accountHolder;
        this.branch = branch;
        this.balance = balance;
    }
    public void intrest(int rateOfIntrest){
        int currBalance;
        currBalance = balance + (balance*rateOfIntrest)/100;
        System.out.println(currBalance);
    }
}
class CurrentAccount extends Account{
    String accountHolder;
    String branch;
    int accNumber;
    int balance;
    public CurrentAccount(String accountHolder, String branch, int accNumber, int balance) {
        super(accountHolder, branch, accNumber, balance);
        this.accNumber = accNumber;
        this.accountHolder = accountHolder;
        this.branch = branch;
        this.balance = balance;
    }
    public void intrest(int rateOfIntrest){
        int currBalance;
        currBalance = balance + (balance*rateOfIntrest)/100;
        System.out.println(currBalance);
    }
}
public class OnlineBankingSystem {
    public static void main(String[] args) {
        Account acc = new Account("Shaurya", "Township", 1250, 10000);
        SavingsAccount savAcc = new SavingsAccount("subhash", "Township", 1251, 5000);
        CurrentAccount currAcc = new CurrentAccount("Vikash", "Township", 1252, 5000);
      acc.addBalance(5000);
        savAcc.intrest(10);
        currAcc.intrest(15);
    }
}
