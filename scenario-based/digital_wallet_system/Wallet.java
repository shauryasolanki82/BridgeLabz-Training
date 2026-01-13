package scenario_based.digital_wallet_system;
import java.util.*;

public class Wallet {
    private String walletId;
    private double balance;
    private List<Transaction> transactionHistory;

    public Wallet(String walletId, double initialBalance) {
        this.walletId = walletId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        if(initialBalance > 0) addTransaction(initialBalance, "CREDIT");
    }

    public double getBalance() { return balance; }
    public String getWalletId() { return walletId; }

    public void deposit(double amount) {
        this.balance += amount;
        addTransaction(amount, "CREDIT");
        System.out.println("Deposited $" + amount + " to " + walletId);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Balance: $" + balance + ", Required: $" + amount);
        }
        this.balance -= amount;
        addTransaction(amount, "DEBIT");
    }

    private void addTransaction(double amount, String type) {
        transactionHistory.add(new Transaction(amount, type));
    }

    public void showHistory() {
        System.out.println(" History for " + walletId);
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }
}