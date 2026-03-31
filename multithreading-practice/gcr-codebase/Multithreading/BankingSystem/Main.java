package BankingSystem;

public class Main {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount();
        Thread t1 = new Thread(new Transaction(bankAccount, "akash", 5000), "[customer-1]");
        Thread t2 = new Thread(new Transaction(bankAccount, "vikash", 500), "[customer-2]");
        Thread t3 = new Thread(new Transaction(bankAccount, "ram", 2000), "[customer-3]");
        Thread t4 = new Thread(new Transaction(bankAccount, "subhash", 2500), "[customer-4]");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }
}
