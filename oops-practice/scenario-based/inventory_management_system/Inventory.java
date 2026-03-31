package scenario_based.inventory_management_system;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;
    private AlertService alertService;

    public Inventory(AlertService alertService) {
        this.products = new ArrayList<>();
        this.alertService = alertService;
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Added: " + p.getName());
    }

    public void reduceStock(int productId, int amount) throws OutOfStockException {
        Product target = null;
        for (Product p : products) {
            if (p.getId() == productId) {
                target = p;
                break;
            }
        }
        if (target == null) {
            System.out.println("Product not found.");
            return;
        }
        if (target.getQuantity() < amount) {
            throw new OutOfStockException("Not enough stock for " + target.getName() + 
                                          ". Requested: " + amount + ", Available: " + target.getQuantity());
        }
        int newQuantity = target.getQuantity() - amount;
        target.setQuantity(newQuantity);
        System.out.println("Sold " + amount + " units of " + target.getName());
        if (newQuantity <= target.getThreshold()) {
            alertService.sendAlert("Low stock warning for " + target.getName() + 
                                   ". Only " + newQuantity + " left!");
        }
    }
}