package AddressBookProblem;
import java.util.*;

public class AddressBookContainer {
	 Map<String, AddressBook> books;

	    public AddressBookContainer() {
	        books = new HashMap<>();
	    }
	    public void addBook(String bookName, AddressBook addressBook) {
	        if (books.containsKey(bookName)) {
	            System.out.println("❌ AddressBook with this name already exists!");
	            return;
	        }
	        books.put(bookName, addressBook);
	        System.out.println("✅ AddressBook '" + bookName + "' added!");
	    }
	 public void displayAllBook() {
	        if (books.isEmpty()) {
	            System.out.println("No Book found.");
	            return;
	        }
	        for (Map.Entry<String, AddressBook> entry : books.entrySet()) {
	            System.out.println("\n📘 Address Book Name: " + entry.getKey());
	            entry.getValue().displayAllContacts();
	        }
	 }
	

}
