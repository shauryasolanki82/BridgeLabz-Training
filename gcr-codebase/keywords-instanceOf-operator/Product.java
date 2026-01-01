public class Product {
	
	private static float discount = 10.0f;
	private String productName;
	private float price;
	private int quantity;
	private final String productID;
	
	Product(String productName, float price, int quantity, String productID){
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.productID = productID;
	}
	
	public void displayProductDetails() {
		if(this instanceof Product) {
			System.out.println("Product ID: "+productID);
			System.out.println("Product Name: "+productName);
			System.out.printf("Price: $%.1f%n",price);
			System.out.println("Quantity: "+quantity);
			System.out.printf("Discount: %.1f%n",discount);
			System.out.printf("Price After Discount: %.1f%n",calculateDiscount(price));
		}else {
			System.err.println("Product details not found");
		}
	}
	
	private float calculateDiscount(float price) {
		return price-(price*(discount/100));
	}
	
	public static void updateDiscount(float newDiscount) {
		discount = newDiscount;
	}

	public static void main(String[] args) {
		Product p1 = new Product("Laptop", 	1200.0f, 5, "P001");
		Product p2 = new Product("Smartphone", 800.0f, 10, "P002");
		p1.displayProductDetails();
		p2.displayProductDetails();
		Product.updateDiscount(15.0f);
		p1.displayProductDetails();
		p2.displayProductDetails();
	}

}
