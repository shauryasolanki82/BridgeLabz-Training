package AddressBookProblem;
import java.util.*;

public class AddressBook {
	//for add multiple contacts
	 private List<Contact> contactList;
	 public AddressBook() {
	        contactList = new ArrayList<>();
	    }
	 public void addContact(Contact contact) {
		 contactList.add(contact);
		 System.out.println("contact added!");
	 }
	// Display All Contacts
	 public void displayAllContacts() {
	        if (contactList.isEmpty()) {
	            System.out.println("No contacts found.");
	            return;
	        }
	        for (Contact contact : contactList) {
	            contact.displayContact();
	        }
	 }
	 public void editContactByName(String name, Scanner scanner) {

		    boolean contactFound = false;

		    for (Contact contact : contactList) {

		        if (contact.getFirstName().equalsIgnoreCase(name)) {
		            contactFound = true;

		            System.out.println("Contact Found. Enter new details:");

		            System.out.print("Enter New Address: ");
		            contact.setAddress(scanner.next());

		            System.out.print("Enter New City: ");
		            contact.setCity(scanner.next());

		            System.out.print("Enter New State: ");
		            contact.setState(scanner.next());

		            System.out.print("Enter New Zip: ");
		            contact.setZip(scanner.next());

		            System.out.print("Enter New Phone Number: ");
		            contact.setPhoneNumber(scanner.next());

		            System.out.print("Enter New Email: ");
		            contact.setEmail(scanner.next());

		            System.out.println("✅ Contact updated successfully!");
		            return;
		        }
		    }
		    if (!contactFound) {
		        System.out.println("❌ Contact not found with name: " + name);
		    }
		}
	 
	 public void deleteContactByName(String name) {

		    boolean contactFound = false;
		    for (int i = 0; i < contactList.size(); i++) {
		        Contact contact = contactList.get(i);

		        if (contact.getFirstName().equalsIgnoreCase(name)) {
		            contactList.remove(i); // delete by index
		            contactFound = true;
		            System.out.println("✅ Contact deleted successfully!");
		            return;
		        }
		    }

		    if (!contactFound) {
		        System.out.println("❌ Contact not found with name: " + name);
		    }
		}
}
