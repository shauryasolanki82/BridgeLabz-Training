package scenario_based.digital_wallet_system;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private double amount;
    private String type;
    private Date date;

    public Transaction(double amount, String type) {
        this.transactionId = "TXN" + (int)(Math.random() * 10000);
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "[" + date + "] " + type + ": $" + amount + " (ID: " + transactionId + ")";
    }
}
