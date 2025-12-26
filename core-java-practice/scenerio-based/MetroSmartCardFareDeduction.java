import java.util.Scanner;

public class MetroSmartCardFareDeduction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int totalRides=0;
        System.out.print("Enter smart card balance: ");
        int balance= sc.nextInt();
        int initial=balance;
        System.out.println("Enter 0 to quit");
        while(balance>0){
            System.out.print("Enter your travelling distance (km) : ");
            int distance=sc.nextInt();
            if(distance==0) break;
            int fare = distance <= 2 ? 10 : distance <= 5 ? 20 : distance <= 12 ? 30 : 40;
            if(balance>=fare) {
                balance-=fare;
                totalRides++;
                System.out.println("Fare: "+fare+" Balance left: "+balance);
            }else{
                System.out.println("Insufficient balance");
                break;
            }
        }
        System.out.println("Total rides: "+totalRides);
        System.out.println("Money Spent: "+ (initial-balance));
        System.out.println("Balance left: "+balance);
        sc.close();
    }
}
