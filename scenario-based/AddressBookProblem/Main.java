package AddressBookProblem;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Address Book Program in AddressBook Main class on Master Branch");
		 AddressBookContainer container = new AddressBookContainer();
	      AddressBook currentBook = null;
		 int choice = 0;
	        while (choice != 5) {
	        	 System.out.println("\nADDRESS BOOK MENU");
	             System.out.println("1. Create New Address Book");
	             System.out.println("2. Create New Contact");
	             System.out.println("3. Edit Contact by Name");
	             System.out.println("4. Delete Contact by Name");
	             System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            switch (choice) {
	            case 1:
                    currentBook = new AddressBook();
                    System.out.print("Enter Address Book Name: ");
                    String bookName = scanner.next();
                    container.addBook(bookName, currentBook);
                    System.out.println("📘 AddressBook '" + bookName + "' created & selected");
                    break;
 
	                case 2:
	                	 if (currentBook == null) {
	                         System.out.println("❌ Please create AddressBook first");
	                         break;
	                     }
	                    System.out.println("Create New Contact!");
	                    
	                    System.out.println("Enter First Name: ");
	                    String firstName = scanner.next();

	                    System.out.println("Enter Last Name: ");
	                    String lastName = scanner.next();

	                    System.out.println("Enter Address: ");
	                    String address = scanner.next();

	                    System.out.println("Enter City: ");
	                    String city = scanner.next();

	                    System.out.println("Enter State: ");
	                    String state = scanner.next();

	                    System.out.println("Enter Zip: ");
	                    String zip = scanner.next();

	                    System.out.println("Enter Phone Number: ");
	                    String phoneNumber = scanner.next();

	                    System.out.println("Enter Email: ");
	                    String email = scanner.next();

	                    Contact contact = new Contact(  firstName,lastName,address,city,state,zip,phoneNumber, email);
	                    currentBook.addContact(contact);
	                    break;
	                    
	                case 3:
	                    System.out.print("Enter First Name to Edit: ");
	                    String name = scanner.next();
	                    currentBook.editContactByName(name, scanner);
	                    break;
	                
	                case 4:
	                    System.out.print("Enter First Name to Delete: ");
	                    String deleteName = scanner.next();
	                    currentBook.deleteContactByName(deleteName);
	                    break;
	                    
	                case 5:
	                    System.out.println("Exiting Address Book. Goodbye!");
	                    break;

	                default:
	                    System.out.println("❌ Invalid choice. Please enter 1,2,3,4,5");
	            }
	        }
	        container.displayAllBook();
	}

}
