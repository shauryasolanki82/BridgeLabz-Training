import java.util.Scanner;
class CartItem {
    String itemName;
    double price;
    int quantity;
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }
    double getTotalCost() {
        return price * quantity;
    }
    void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}


public class SimulateAShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        CartItem item = new CartItem(name, price, qty);
        item.displayItem();
        System.out.print("Enter quantity to add: ");
        int addQty = sc.nextInt();
        item.addItem(addQty);

        System.out.print("Enter quantity to remove: ");
        int removeQty = sc.nextInt();
        item.removeItem(removeQty);
        System.out.println("Total cost: $" + item.getTotalCost());

        sc.close();
    }
}
