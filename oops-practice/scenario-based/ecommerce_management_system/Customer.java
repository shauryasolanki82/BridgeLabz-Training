package scenario_based.ecommerce_management_system;
import java.util.*;

public class Customer {
	private int customerId;
	private String customerName;
	private ArrayList<Product> shoppingCart;
	
	Customer(int customerId, String customerName){
		this.customerId = customerId;
		this.customerName = customerName;
		this.shoppingCart = new ArrayList<>();
	}
	
	public int getCustomerId() {
		return this.customerId;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void addToCart(Product p) {
		shoppingCart.add(p);
		System.out.println(p.getProductName()+" Added to cart.");
	}
	
	public ArrayList<Product> viewCart() {
		return shoppingCart;
	}
}
