import java.util.Scanner;

class BankAccount{
    String accountHolder;
    int accountNumber;
    int balance;
    public BankAccount(String accountHolder, int accountNumber, int balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void DepositMoney(int money){
        balance+=money;
        System.out.println("Available Balance: "+balance);
    }
    public void Withdrawl(int money){
        if(balance>=money){
            balance-=money;
            System.out.println("Withrawl successfull and available balance is: "+balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    public void DisplayBalance(){
        System.out.println("Your Available balance is: "+balance);
    }

}
public class ATMSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Holder Name: ");
        String accountHolder = sc.nextLine();
        System.out.println("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        System.out.println("Enter balance");
        int balance = sc.nextInt();
        BankAccount bankAccount = new BankAccount(accountHolder, accountNumber, balance);
        boolean flag = true;
        while(flag){
        System.out.println("press 1 for Deposit. Press 2 for withdrawl. Press 3 for check balance");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Enter Deposit Money:");
                int money = sc.nextInt();
                bankAccount.DepositMoney(money);
                break;
            case 2:
                System.out.println("Enter Money for withdrawl:");
                int money1 = sc.nextInt();
                bankAccount.Withdrawl(money1);
                break;
            case 3:
                bankAccount.DisplayBalance();
                break;
            default:
                System.out.println("Wrong input");
                flag = false;
                break;
        }
    }
    sc.close();
}
}
