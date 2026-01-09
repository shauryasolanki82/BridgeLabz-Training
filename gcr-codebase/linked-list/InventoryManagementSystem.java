class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private ItemNode head;

    // Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int id, String name, int qty, double price) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove by Item ID
    public void removeByItemId(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed: " + id);
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed: " + id);
        } else {
            System.out.println("Item not found.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for item ID: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Item ID
    public void searchByItemId(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Item Name
    public void searchByItemName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Sort by Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null) return;

        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                boolean condition = false;

                if (criteria.equalsIgnoreCase("name")) {
                    condition = ascending ?
                            i.itemName.compareToIgnoreCase(j.itemName) > 0 :
                            i.itemName.compareToIgnoreCase(j.itemName) < 0;
                } else if (criteria.equalsIgnoreCase("price")) {
                    condition = ascending ?
                            i.price > j.price :
                            i.price < j.price;
                }

                if (condition) {
                    swapData(i, j);
                }
            }
        }
        System.out.println("Inventory sorted by " + criteria);
    }

    // Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Helper methods
    private void swapData(ItemNode a, ItemNode b) {
        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    private void displayItem(ItemNode item) {
        System.out.println(
            "ID: " + item.itemId +
            ", Name: " + item.itemName +
            ", Qty: " + item.quantity +
            ", Price: ₹" + item.price
        );
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd(101, "Laptop", 5, 55000);
        inventory.addAtBeginning(102, "Mouse", 20, 500);
        inventory.addAtPosition(2, 103, "Keyboard", 10, 1500);

        inventory.displayInventory();

        inventory.searchByItemId(101);
        inventory.updateQuantity(102, 25);

        inventory.calculateTotalValue();

        inventory.sortInventory("price", true);
        inventory.displayInventory();

        inventory.removeByItemId(103);
        inventory.displayInventory();
    }
}
