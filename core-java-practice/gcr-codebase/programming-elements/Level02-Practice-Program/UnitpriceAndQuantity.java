import java.util.Scanner;
public class UnitpriceAndQuantity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double unitPrice = scanner.nextDouble(); // Example unit price
        int quantity = scanner.nextInt();       // Example quantity

        double totalPrice = unitPrice * quantity;

        System.out.println("Total price for " + quantity + " items at unit price " + unitPrice + " is: " + totalPrice);
        scanner.close();
    }
}
