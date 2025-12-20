import java.util.Scanner;
public class TheCoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0;
        double gst = 0;
        String coffeeType;
        int quantity;
        double price = 0;

        while (true) {
            // Input coffee type
            System.out.println("Enter coffee type (latte/cappuccino/espresso) or 'exit' to finish:");
            coffeeType = scanner.nextLine();

            if (coffeeType.equals("exit")) {
                break;
            }

            System.out.println("Enter quantity:");
            // Input quantity
            quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 30.15;
                    break;
                case "latte":
                    price = 50.20;
                    break;
                case "cappuccino":
                    price = 45.35;
                    break;
                
                default:
                    System.out.println("Invalid coffee type.");
                    continue;
            }

            double bill = price * quantity;
            gst = bill * 0.10; // Assuming GST is 10%
            totalBill += bill + gst;

            System.out.println("Bill for this order: INR " + (bill + gst));
        }

        System.out.println("Total bill including GST: INR " + totalBill);
        scanner.close();
    }
}
