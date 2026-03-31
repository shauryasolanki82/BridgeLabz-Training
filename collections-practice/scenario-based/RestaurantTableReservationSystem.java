package scenario_based;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TableAlreadyReservedException extends Exception {
    TableAlreadyReservedException(String message) {
        super(message);
    }
}

class Table {
    int id;
    int capacity;

    Table(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Table " + id + " (Seats: " + capacity + ")";
    }
}

class Reservation {
    String customerName;
    int tableId;
    String timeSlot;

    Reservation(String customerName, int tableId, String timeSlot) {
        this.customerName = customerName;
        this.tableId = tableId;
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "ResID: [T" + tableId + "-" + timeSlot + "] Name: " + customerName;
    }
}

class Restaurant {
    private Map<Integer, Table> tables;
    private List<Reservation> reservations;

    Restaurant() {
        tables = new HashMap<>();
        reservations = new ArrayList<>();
        initializeTables();
    }

    private void initializeTables() {
        tables.put(1, new Table(1, 2));
        tables.put(2, new Table(2, 4));
        tables.put(3, new Table(3, 4));
        tables.put(4, new Table(4, 6));
        tables.put(5, new Table(5, 8));
    }

    public void reserveTable(String customerName, int tableId, String timeSlot) throws TableAlreadyReservedException {
        if (!tables.containsKey(tableId)) {
            System.out.println("Error: Table " + tableId + " does not exist.");
            return;
        }

        for (Reservation r : reservations) {
            if (r.tableId == tableId && r.timeSlot.equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException("Table " + tableId + " is already booked for " + timeSlot);
            }
        }

        reservations.add(new Reservation(customerName, tableId, timeSlot));
        System.out.println("Success: Table " + tableId + " reserved for " + customerName + " at " + timeSlot);
    }

    public void cancelReservation(String customerName, int tableId, String timeSlot) {
        Reservation toCancel = null;
        for (Reservation r : reservations) {
            if (r.tableId == tableId && r.timeSlot.equalsIgnoreCase(timeSlot) && r.customerName.equalsIgnoreCase(customerName)) {
                toCancel = r;
                break;
            }
        }

        if (toCancel != null) {
            reservations.remove(toCancel);
            System.out.println("Success: Reservation cancelled for " + customerName);
        } else {
            System.out.println("Error: Reservation not found.");
        }
    }

    public void showAvailableTables(String timeSlot) {
        System.out.println("Available Tables for " + timeSlot);
        
        for (Table t : tables.values()) {
            boolean isBooked = false;
            for (Reservation r : reservations) {
                if (r.tableId == t.id && r.timeSlot.equalsIgnoreCase(timeSlot)) {
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) {
                System.out.println(t);
            }
        }
    }

    public void showAllReservations() {
        System.out.println("Current Reservations");
        if (reservations.isEmpty()) {
            System.out.println("[No active reservations]");
        } else {
            for (Reservation r : reservations) {
                System.out.println(r);
            }
        }
    }
}

public class RestaurantTableReservationSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner input = new Scanner(System.in);
        int choice, tableId;
        String name, timeSlot;

        System.out.println("RESTAURANT TABLE RESERVATION SYSTEM");

        while (true) {
            System.out.println("1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Show All Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    name = input.nextLine();
                    System.out.print("Enter Table ID: ");
                    if (input.hasNextInt()) {
                        tableId = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter Time Slot (e.g., 7PM): ");
                        timeSlot = input.nextLine();
                        
                        try {
                            restaurant.reserveTable(name, tableId, timeSlot);
                        } catch (TableAlreadyReservedException e) {
                            System.out.println("EXCEPTION: " + e.getMessage());
                        }
                    } else {
                        input.nextLine();
                        System.out.println("Invalid Table ID.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    name = input.nextLine();
                    System.out.print("Enter Table ID: ");
                    tableId = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Time Slot: ");
                    timeSlot = input.nextLine();
                    restaurant.cancelReservation(name, tableId, timeSlot);
                    break;
                case 3:
                    System.out.print("Enter Time Slot to check: ");
                    timeSlot = input.nextLine();
                    restaurant.showAvailableTables(timeSlot);
                    break;
                case 4:
                    restaurant.showAllReservations();
                    break;
                case 5:
                    System.out.println("Exiting System.");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}