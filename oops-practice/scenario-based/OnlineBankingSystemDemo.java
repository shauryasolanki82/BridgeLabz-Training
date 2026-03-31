import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class Transaction {
    private final String txId;
    private final LocalDateTime time;
    private final String type;          // DEPOSIT / WITHDRAW / TRANSFER
    private final double amount;
    private final String note;

    public Transaction(String txId, String type, double amount, String note) {
        this.txId = txId;
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.time = LocalDateTime.now();
    }

    public String getTxId() { return txId; }
    public LocalDateTime getTime() { return time; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getNote() { return note; }

    @Override
    public String toString() {
        return txId + " | " + time + " | " + type + " | " + amount + " | " + note;
    }
}

abstract class Account {
    private final String accountNo;
    private final String holderName;
    protected double balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String accountNo, String holderName, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = openingBalance;
        addTx("OPEN", openingBalance, "Account opened");
    }

    public String getAccountNo() { return accountNo; }
    public String getHolderName() { return holderName; }

    public synchronized double getBalance() { // Balance check (thread-safe)
        return balance;
    }

    public List<Transaction> getTransactionHistory() { // Read-only copy
        return new ArrayList<>(history);
    }

    protected void addTx(String type, double amount, String note) {
        history.add(new Transaction(UUID.randomUUID().toString(), type, amount, note));
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be > 0");
        balance += amount;
        addTx("DEPOSIT", amount, "Cash deposit");
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw amount must be > 0");
        if (!canWithdraw(amount)) {
            throw new InsufficientBalanceException("Insufficient balance for withdraw. Needed: " + amount
                    + ", Available: " + balance);
        }
        balance -= amount;
        addTx("WITHDRAW", amount, "Cash withdraw");
    }

    // Overridden by subclasses (polymorphic rule)
    protected boolean canWithdraw(double amount) {
        return balance >= amount;
    }

    // Polymorphism: different interest calculation
    public abstract double calculateAnnualInterest();
}

class SavingsAccount extends Account {
    private final double annualInterestRate; // e.g., 0.04 for 4%

    public SavingsAccount(String accountNo, String holderName, double openingBalance, double annualInterestRate) {
        super(accountNo, holderName, openingBalance);
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public double calculateAnnualInterest() {
        return getBalance() * annualInterestRate;
    }
}

class CurrentAccount extends Account {
    private final double overdraftLimit; // allowed extra negative spending

    public CurrentAccount(String accountNo, String holderName, double openingBalance, double overdraftLimit) {
        super(accountNo, holderName, openingBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    protected boolean canWithdraw(double amount) {
        // can go down to -overdraftLimit
        return (balance - amount) >= (-overdraftLimit);
    }

    @Override
    public double calculateAnnualInterest() {
        // Typically current account has no interest; keep it 0 for this mini version
        return 0.0;
    }
}

interface BankService {
    void createAccount(Account account);                 // Create
    Account getAccount(String accountNo);                // Read
    double checkBalance(String accountNo);               // Read
    void transfer(String fromAcc, String toAcc, double amount) throws InsufficientBalanceException; // Update
    List<Transaction> getTransactionHistory(String accountNo); // Read
}

class BankServiceImpl implements BankService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public void createAccount(Account account) {
        accounts.put(account.getAccountNo(), account);
    }

    @Override
    public Account getAccount(String accountNo) {
        return accounts.get(accountNo);
    }

    @Override
    public double checkBalance(String accountNo) {
        Account acc = getAccountOrThrow(accountNo);
        return acc.getBalance();
    }

    @Override
    public List<Transaction> getTransactionHistory(String accountNo) {
        Account acc = getAccountOrThrow(accountNo);
        return acc.getTransactionHistory();
    }

    @Override
    public void transfer(String fromAccNo, String toAccNo, double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException("Transfer amount must be > 0");

        Account from = getAccountOrThrow(fromAccNo);
        Account to = getAccountOrThrow(toAccNo);

        // Avoid deadlock: always lock in consistent order
        Account firstLock = from.getAccountNo().compareTo(to.getAccountNo()) < 0 ? from : to;
        Account secondLock = firstLock == from ? to : from;

        synchronized (firstLock) {
            synchronized (secondLock) {
                // withdraw + deposit is an atomic transfer now
                from.withdraw(amount);
                to.deposit(amount);

                // Record transfer transactions for traceability
                from.addTx("TRANSFER", amount, "To " + toAccNo);
                to.addTx("TRANSFER", amount, "From " + fromAccNo);
            }
        }
    }

    private Account getAccountOrThrow(String accountNo) {
        Account acc = accounts.get(accountNo);
        if (acc == null) throw new IllegalArgumentException("Account not found: " + accountNo);
        return acc;
    }
}

public class OnlineBankingSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        BankService bank = new BankServiceImpl();

        // Account creation (CRUD - Create) - changed demo values
        bank.createAccount(new SavingsAccount("SA-5010", "Neha", 12000, 0.035));  // 3.5% interest
        bank.createAccount(new CurrentAccount("CA-8802", "Arjun", 1500, 2500));   // higher overdraft

        // Concurrent transfers (Multithreading) - changed demo values
        Runnable t1 = () -> {
            try {
                bank.transfer("SA-5010", "CA-8802", 2200);
            } catch (Exception e) {
                System.out.println("T1 failed: " + e.getMessage());
            }
        };

        Runnable t2 = () -> {
            try {
                bank.transfer("CA-8802", "SA-5010", 1800);
            } catch (Exception e) {
                System.out.println("T2 failed: " + e.getMessage());
            }
        };

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        // Balance check (CRUD - Read)
        System.out.println("Balance SA-5010: " + bank.checkBalance("SA-5010"));
        System.out.println("Balance CA-8802: " + bank.checkBalance("CA-8802"));

        // Polymorphism: interest calculation differs by account type
        Account a1 = bank.getAccount("SA-5010");
        Account a2 = bank.getAccount("CA-8802");
        System.out.println("Annual interest SA-5010: " + a1.calculateAnnualInterest());
        System.out.println("Annual interest CA-8802: " + a2.calculateAnnualInterest());

        // Transaction history (CRUD - Read)
        System.out.println("\nTransaction History SA-5010:");
        for (Transaction tx : bank.getTransactionHistory("SA-5010")) {
            System.out.println(tx);
        }

        System.out.println("\nTransaction History CA-8802:");
        for (Transaction tx : bank.getTransactionHistory("CA-8802")) {
            System.out.println(tx);
        }
    }
}