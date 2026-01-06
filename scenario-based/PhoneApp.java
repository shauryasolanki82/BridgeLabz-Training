
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phoneNumber;
    }
}

class ContactOrganizer {
    private List<Contact> contactList;
    public ContactOrganizer() {
        this.contactList = new ArrayList<>();
    }
    public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Error: Phone number " + phoneNumber + " is invalid. Must be exactly 10 digits.");
        }

        for (Contact c : contactList) {
            if (c.phoneNumber.equals(phoneNumber)) {
                System.out.println("Failed to add '" + name + "': Phone number already exists for " + c.name);
                return;
            }
        }

        contactList.add(new Contact(name, phoneNumber));
        System.out.println("Success: Contact '" + name + "' added.");
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact c : contactList) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Search: No contact found with name '" + name + "'");
        }
    }

    public void deleteContact(String name) {
        Iterator<Contact> iterator = contactList.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Contact c = iterator.next();
            if (c.name.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Deleted: Contact '" + name + "' removed.");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Delete Failed: '" + name + "' not found.");
        }
    }

    public void displayAll() {
        System.out.println("\nContact List");
        if (contactList.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Contact c : contactList) {
                System.out.println(c);
            }
        }
    }
}

public class PhoneApp {
    public static void main(String[] args) {
        ContactOrganizer organizer = new ContactOrganizer();
        try {
            organizer.addContact("Alice", "9876543210");
            organizer.addContact("Bob", "1234567890");
        } catch (InvalidPhoneNumberException e) {
            System.err.println(e.getMessage());
        }
        try {
            organizer.addContact("Charlie", "1234567890"); 
        } catch (InvalidPhoneNumberException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println("\nAttempting to add Dave with invalid number...");
            organizer.addContact("Dave", "123");
        } catch (InvalidPhoneNumberException e) {
            System.err.println("CAUGHT EXCEPTION: " + e.getMessage());
        }
        organizer.displayAll();
        organizer.searchContact("Alice");
        organizer.deleteContact("Alice");
        organizer.displayAll();
    }
}