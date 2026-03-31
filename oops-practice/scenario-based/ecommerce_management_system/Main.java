package scenario_based.ecommerce_management_system;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 999.99, 5);
        Product p2 = new Product(102, "Headphones", 49.99, 20);
        Customer user = new Customer(1, "Anuj");
        user.addToCart(p1);
        user.addToCart(p2);
        Order myOrder = new Order(5001, user);
        System.out.println("Payment 1 (UPI Success)");
        Payment upi = new UpiPay("alice@bank");
        myOrder.placeOrder(upi);
        myOrder.trackOrder();
        System.out.println("Tracking and Cancellation");
        myOrder.cancelOrder();
        myOrder.trackOrder();
        System.out.println("Payment 2 (Card Failure Scenario)");
        Customer user2 = new Customer(2, "Rajat");
        user2.addToCart(p2);
        Order myOrder2 = new Order(5002, user2);
        Payment card = new CreditCardPay("12345"); 
        myOrder2.placeOrder(card);
        myOrder2.trackOrder();
    }
}
