
import java.util.*;

interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}

abstract class FoodItem {
    
    private final String itemName; 
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.setPrice(price);
        this.quantity = (quantity > 0) ? quantity : 1;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + " | Unit Price: $" + price + " | Qty: " + quantity);
    }

    public String getItemName() { 
    	return itemName;
    }
    public int getQuantity() { 
    	return quantity;
    }
    
    public double getPrice() { 
    	return price;
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }
}

class VegItem extends FoodItem implements Discountable {

    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // Standard calculation: Price * Quantity
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90;
    }
    @Override
    public String getDiscountDetails() {
        return "Green Discount (10% Off)";
    }
}

class NonVegItem extends FoodItem implements Discountable {

   NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 5.00;
    }
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95;
    }
    @Override
    public String getDiscountDetails() {
        return "Feast Discount (5% Off)";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> orderList) {
        System.out.println("ORDER RECEIPT");
        double grandTotal = 0;
        for (FoodItem item : orderList) {
            item.getItemDetails();
            double baseTotal = item.calculateTotalPrice();
            System.out.println("   Subtotal: $" + String.format("%.2f", baseTotal));
            double finalItemPrice = baseTotal;
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                finalItemPrice = d.applyDiscount(baseTotal);
                System.out.println("   Applied: " + d.getDiscountDetails());
                System.out.println("   Discount Amount: -$" + String.format("%.2f", (baseTotal - finalItemPrice)));
            }
            System.out.println("   Final Cost: $" + String.format("%.2f", finalItemPrice));
            grandTotal += finalItemPrice;
        }
        System.out.println("TOTAL PAYABLE: $" + String.format("%.2f", grandTotal));
    }

    public static void main(String[] args) {
        List<FoodItem> myOrder = new ArrayList<>();
        myOrder.add(new VegItem("Paneer Wrap", 8.00, 2));
        myOrder.add(new NonVegItem("Chicken Bucket", 15.00, 1));
        processOrder(myOrder);
    }
}
