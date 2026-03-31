package scenario_based.inventory_management_system;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int lowStockThreshold;

    public Product(int id, String name, int quantity, int lowStockThreshold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.lowStockThreshold = lowStockThreshold;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getThreshold() { return lowStockThreshold; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Stock: " + quantity;
    }
}
