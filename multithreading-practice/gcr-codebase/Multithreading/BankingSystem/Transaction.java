package BankingSystem;

public class Transaction implements Runnable {
    BankAccount bankAccount;
    int amount;
    String customerName;

    public Transaction(BankAccount bankAccount, String customerName, int amount){
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        bankAccount.withdraw(customerName, amount);
    }
}
