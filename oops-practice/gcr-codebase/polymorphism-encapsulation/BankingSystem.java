
import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

abstract class BankAccount {
    
    private String accountNumber;
    private String holderName;
    private double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Error: Initial balance cannot be negative.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: $" + amount);
        } else {
            System.out.println("Transaction Failed: Insufficient funds or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public String getAccountNumber() { 
    	return accountNumber; 
    }
    public String getHolderName() { 
    	return holderName; 
    }
    public double getBalance() { 
    	return balance; 
    } 
    public void displayInfo() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holderName);
        System.out.println("Current Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {

    private double interestRate;

    SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.interestRate = 0.05; // 5% Interest Rate
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
    @Override
    public void applyForLoan(double amount) {
        double maxLoan = calculateLoanEligibility();
        if (amount <= maxLoan) {
            System.out.println("Loan Approved: $" + amount);
        } else {
            System.out.println("Loan Denied: Request exceeds limit of $" + maxLoan);
        }
    }
}

class CurrentAccount extends BankAccount implements Loanable {

    CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    @Override
    public double calculateInterest() {
        return 0.0;
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= -1000) {
            super.withdraw(amount); 
        } else {
             System.out.println("Overdraft Limit Exceeded.");
        }
    }
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
    @Override
    public void applyForLoan(double amount) {
        double maxLoan = calculateLoanEligibility();
        System.out.println("Processing Business Loan Application...");
        if (amount <= maxLoan) {
            System.out.println("Business Loan Approved: $" + amount);
        } else {
            System.out.println("Loan Denied. Max limit: $" + maxLoan);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        SavingsAccount sa = new SavingsAccount("SA-101", "Rajat", 5000);
        CurrentAccount ca = new CurrentAccount("CA-202", "Gautam", 20000);
        accounts.add(sa);
        accounts.add(ca);
        for (BankAccount acc : accounts) {
            acc.displayInfo();
            acc.deposit(1000);
            double interest = acc.calculateInterest();
            System.out.println("Projected Annual Interest: $" + interest);
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Max Loan Eligibility: $" + loanAcc.calculateLoanEligibility());
                loanAcc.applyForLoan(10000);
            }
        }
    }
}