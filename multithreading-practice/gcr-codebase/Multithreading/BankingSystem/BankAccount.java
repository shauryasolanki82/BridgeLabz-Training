package BankingSystem;

public class BankAccount {
    int balance = 10000;
    
    public void withdraw(String customerName, int amount){
        System.out.println("[" + customerName + "] Attempting to withdraw: " + amount);
        if(balance >= amount){
              try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
             System.out.println("Transaction successful: " +customerName +", Amount: " + amount +", Balance: " + balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
}
