package scenario_based.ecommerce_management_system;

class Product {
	private int productId;
	private String productName;
	private double price;
	private int stockQuantity;
	
	Product(int productId, String productName, double price, int stockQuantity){
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public int getProductId(){
		return this.productId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return this.stockQuantity;
	}
	public void setStockQuantity(int quantity) {
		if(this.stockQuantity >= quantity) {
			this.stockQuantity -= quantity;
		}else {
			System.out.println("Out Of Stock");
		}
	}
}
