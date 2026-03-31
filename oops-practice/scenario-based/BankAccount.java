public class BankAccount {
    private final String accountNumber;
    private double balance;
    BankAccount(String accountNumber, double balance){
        this.accountNumber=accountNumber;
        setBalance(balance);
    }
    public void setBalance(double balance){
        if(balance>=0){
            this.balance=balance;
        }else{
            System.out.println("Balance cannot be negative");
        }
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
        }else{
            System.out.println("Amount must be positive");
        }
    }
    public void withdraw(double amount){
        if(balance>0 && balance>=amount){
            balance-=amount;
        }else{
            System.out.println("Insufficient balance");
        }
    }
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }


    public static void main(String[] args) {
        BankAccount user=new BankAccount("23151",88000);
        System.out.println("Account number: "+user.getAccountNumber());
        System.out.println("Account Balance: "+user.getBalance());
        user.deposit(20000);
        user.withdraw(90000);
        user.displayAccountInfo();
        user.balance=5000;
        user.deposit(-10);
    }
}