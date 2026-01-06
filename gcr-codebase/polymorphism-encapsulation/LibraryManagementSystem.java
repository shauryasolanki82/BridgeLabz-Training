package encapsulation_polymorphism;
import java.util.*;

interface Reservable {
    void reserveItem(String borrowerId);
    boolean checkAvailability();
}

abstract class LibraryItem {
    
    private String itemId;
    private String title;
    private String author;
    private boolean isCheckedOut;
    private String currentBorrowerId; 

    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.currentBorrowerId = null;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + " | Title: " + title + " | Author: " + author);
    }
    
    protected void setCheckedOut(boolean status, String borrowerId) {
        this.isCheckedOut = status;
        this.currentBorrowerId = borrowerId;
    }
    
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    
    public String getBorrowerStatus() {
        if (currentBorrowerId == null) return "Available";
        return "Checked out by User ending in ***" + currentBorrowerId.substring(Math.max(0, currentBorrowerId.length() - 3));
    }
}

class Book extends LibraryItem implements Reservable {
    Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    @Override
    public int getLoanDuration() {
        return 21; 
    }
    @Override
    public void reserveItem(String borrowerId) {
        if (checkAvailability()) {
            setCheckedOut(true, borrowerId);
            System.out.println("Book reserved successfully. Due in " + getLoanDuration() + " days.");
        } else {
            System.out.println("Reservation Failed: Book is currently unavailable.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return !isCheckedOut();
    }
}

class Magazine extends LibraryItem implements Reservable {
	
    Magazine(String itemId, String title, String publisher) {
        super(itemId, title, publisher);
    }
    @Override
    public int getLoanDuration() {
        return 7; 
    }
    @Override
    public void reserveItem(String borrowerId) {
        if (checkAvailability()) {
            setCheckedOut(true, borrowerId);
            System.out.println("Magazine reserved. Due in " + getLoanDuration() + " days.");
        } else {
            System.out.println("Unavailable.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return !isCheckedOut();
    }
}

class DVD extends LibraryItem implements Reservable {

    DVD(String itemId, String title, String director) {
        super(itemId, title, director);
    }

    @Override
    public int getLoanDuration() {
        return 3; 
    }
    @Override
    public void reserveItem(String borrowerId) {
         if (checkAvailability()) {
            setCheckedOut(true, borrowerId);
            System.out.println("DVD reserved. Due in " + getLoanDuration() + " days.");
        } else {
            System.out.println("Unavailable.");
        }
    }
    @Override
    public boolean checkAvailability() {
        return !isCheckedOut();
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {
        List<LibraryItem> catalog = new ArrayList<>();
        catalog.add(new Book("B-101", "The Great Gatsby", "F. Scott Fitzgerald"));
        catalog.add(new Magazine("M-202", "National Geographic", "NatGeo Society"));
        catalog.add(new DVD("D-303", "Inception", "Christopher Nolan"));
        System.out.println("=== LIBRARY CATALOG SCAN ===");
        for (LibraryItem item : catalog) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable resItem = (Reservable) item;
                if (resItem.checkAvailability()) {
                    resItem.reserveItem("User-987654321"); 
                }
            }
            System.out.println("Status: " + item.getBorrowerStatus());
        }
    }
}
