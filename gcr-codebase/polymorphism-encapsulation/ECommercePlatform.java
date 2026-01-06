
import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price;

    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    abstract double calculateDiscount();

    public String getProductId() { 
    	return productId; 
    }
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    public double getPrice() { 
    	return price; 
    }
    public void setPrice(double price) { 
        if(price > 0) this.price = price; 
    }

    public void displayInfo() {
        System.out.println("ID: " + productId + " | Name: " + name + " | Base Price: $" + price);
    }
}

class Electronics extends Product implements Taxable {
    
    Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "18% Electronics Tax";
    }
}

class Clothing extends Product implements Taxable {
    
	Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "5% Textile Tax";
    }
}

class Groceries extends Product {
    
    Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return (getPrice() > 50) ? getPrice() * 0.05 : 0.0;
    }
}

public class ECommercePlatform {

    public static void printFinalBill(List<Product> cart) {
        double grandTotal = 0;
        for (Product p : cart) {
            p.displayInfo();
            double discount = p.calculateDiscount();
            double tax = 0;
            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println("   Tax: $" + String.format("%.2f", tax) + " (" + t.getTaxDetails() + ")");
            } else {
                System.out.println("   Tax: $0.00 (Non-Taxable)");
            }
            double finalPrice = p.getPrice() + tax - discount;
            grandTotal += finalPrice;
            System.out.println("   Discount: -$" + String.format("%.2f", discount));
            System.out.println("   Final Price: $" + String.format("%.2f", finalPrice));
        }
        System.out.println("GRAND TOTAL: $" + String.format("%.2f", grandTotal));
    }

    public static void main(String[] args) {
        Product laptop = new Electronics("E101", "Gaming Laptop", 1200.00);
        Product shirt = new Clothing("C202", "Denim Jacket", 80.00);
        Product apple = new Groceries("G303", "Bag of Apples", 10.00);
        Product bulkRice = new Groceries("G304", "Premium Rice (20kg)", 60.00);
        List<Product> shoppingCart = new ArrayList<>();
        shoppingCart.add(laptop);
        shoppingCart.add(shirt);
        shoppingCart.add(apple);
        shoppingCart.add(bulkRice);
        printFinalBill(shoppingCart);
    }
}
