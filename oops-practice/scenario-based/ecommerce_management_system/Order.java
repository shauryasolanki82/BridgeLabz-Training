package scenario_based.ecommerce_management_system;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> productList;
    private double totalAmount;
    private String status;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.productList = customer.viewCart();
        this.status = "Pending";
        calculateTotal();
    }

    private void calculateTotal() {
        totalAmount = 0;
        for (Product p : productList) {
            totalAmount += p.getPrice();
        }
    }

    public void placeOrder(Payment paymentMethod) {
        try {
            paymentMethod.pay(totalAmount);
            this.status = "Placed";
            System.out.println("Order Placed Successfully! Order ID: " + orderId);
            for(Product p : productList) {
                p.setStockQuantity(1);
            }
            
        } catch (PaymentFailedException e) {
            this.status = "Payment Failed";
            System.out.println("Order Failed: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        if (status.equals("Placed")) {
            status = "Cancelled";
            System.out.println("Order " + orderId + " has been cancelled. Refund initiated.");
        } else {
            System.out.println("Cannot cancel order. Current status: " + status);
        }
    }

    public void trackOrder() {
        System.out.println("Order ID: " + orderId + " | Status: " + status);
    }
}
