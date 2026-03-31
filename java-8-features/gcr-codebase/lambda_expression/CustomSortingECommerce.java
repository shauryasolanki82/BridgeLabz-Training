package lambda_expression;
import java.util.*;

public class CustomSortingECommerce {
	static class Product {
		String name;
		double price;
		double rating;
		double discount;

		Product(String n, double p, double r, double d) {
			name = n;
			price = p;
			rating = r;
			discount = d;
		}

		public String toString() {
			return name + " " + price + " " + rating + " " + discount;
		}
	}

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product("Laptop", 70000, 4.5, 10),
				new Product("Phone", 30000, 4.7, 15), new Product("Tablet", 25000, 4.2, 20));
		products.sort((a, b) -> Double.compare(a.price, b.price));
		products.forEach(System.out::println);
		products.sort((a, b) -> Double.compare(b.rating, a.rating));
		products.forEach(System.out::println);
		products.sort((a, b) -> Double.compare(b.discount, a.discount));
		products.forEach(System.out::println);
	}
}