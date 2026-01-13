package scenario_based.inventory_management_system;

public class Main {
    public static void main(String[] args) {
        AlertService emailService = new EmailAlertService();
        Inventory warehouse = new Inventory(emailService);
        Product p1 = new Product(101, "Wireless Mouse", 50, 10);
        Product p2 = new Product(102, "Mechanical Keyboard", 5, 2);
        warehouse.addProduct(p1);
        warehouse.addProduct(p2);
        System.out.println("Processing Orders");
        try {
            warehouse.reduceStock(101, 5);
            warehouse.reduceStock(102, 4); 
            System.out.println("Attempting Over-order");
            warehouse.reduceStock(101, 100);

        } catch (OutOfStockException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
