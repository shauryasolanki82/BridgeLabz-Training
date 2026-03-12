package AddressBookProblem;

import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private AddressBookManager manager = new AddressBookManager();
    private AddressBook currentBook;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {

        int choice;

        do {
            showMainMenu();
            choice = Integer.parseInt(sc.nextLine());
            handleMainChoice(choice);
        } while (choice != 0);

        sc.close();
    }

    private void showMainMenu() {
        System.out.println("\n===== ADDRESS BOOK SYSTEM =====");
        System.out.println("1. Create Address Book");
        System.out.println("2. Select Address Book");
        System.out.println("3. Rename Address Book");
        System.out.println("4. Delete Address Book");
        System.out.println("5. Display All Address Books");
        System.out.println("6. Search Contact By City (Across Books)");
        System.out.println("7. Search Contact By State (Across Books)");
        System.out.println("8. Count By City (Across Books)");
        System.out.println("9. Count By State (Across Books)");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void handleMainChoice(int choice) {

        switch (choice) {

            case 1:
                createAddressBook();
                break;

            case 2:
                selectAddressBook();
                break;

            case 3:
                renameAddressBook();
                break;

            case 4:
                deleteAddressBook();
                break;

            case 5:
                manager.displayAllAddressBookDetails();
                break;

            case 6:
                searchByCity();
                break;

            case 7:
                searchByState();
                break;

            case 8:
                countByCity();
                break;

            case 9:
                countByState();
                break;

            case 0:
                System.out.println("Exiting Application...");
                break;

            default:
                System.out.println("Invalid Choice!");
        }
    }

    // ADDRESS BOOK LEVEL

    private void createAddressBook() {
        System.out.print("Enter Address Book Name: ");
        String name = sc.nextLine();
        manager.addAddressBook(name);
    }

    private void selectAddressBook() {
        System.out.print("Enter Address Book Name to Select: ");
        String name = sc.nextLine();
        currentBook = manager.getAddressBook(name);

        if (currentBook == null) {
            System.out.println("Address Book not found!");
            return;
        }

        addressBookMenu();
    }

    private void renameAddressBook() {
        System.out.print("Enter Old Name: ");
        String oldName = sc.nextLine();

        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();

        manager.renameAddressBookName(newName, oldName);
    }

    private void deleteAddressBook() {
        System.out.print("Enter Address Book Name to Delete: ");
        String name = sc.nextLine();
        manager.deleteAddressBook(name);
    }

    // CONTACT LEVEL MENU 

    private void addressBookMenu() {

        int choice;

        do {
            System.out.println("\n===== CONTACT MENU (" + currentBook.getName() + ") =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Sort By Name");
            System.out.println("6. Sort By City");
            System.out.println("7. Sort By State");
            System.out.println("8. Sort By Zip");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addContact();
                    break;

                case 2:
                    editContact();
                    break;

                case 3:
                    deleteContact();
                    break;

                case 4:
                    currentBook.displayContactDetails();
                    break;

                case 5:
                    currentBook.sortContactsByName();
                    break;

                case 6:
                    currentBook.sortContactsByCity();
                    break;

                case 7:
                    currentBook.sortContactsByState();
                    break;

                case 8:
                    currentBook.sortContactsByZip();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }

    // CONTACT OPERATIONS 

    private void addContact() {

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Zip: ");
        String zip = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        currentBook.addContact(
                new Contact(firstName, lastName, address, city, state, zip, phone, email));
    }

    private void editContact() {
        System.out.print("Enter Full Name of Contact to Edit: ");
        String name = sc.nextLine();

        System.out.println("Enter Updated Details:");

        System.out.print("First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        System.out.print("City: ");
        String city = sc.nextLine();

        System.out.print("State: ");
        String state = sc.nextLine();

        System.out.print("Zip: ");
        String zip = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Contact updated = new Contact(firstName, lastName, address,
                city, state, zip, phone, email);

        currentBook.editContact(name, updated);
    }

    private void deleteContact() {
        System.out.print("Enter Full Name of Contact to Delete: ");
        String name = sc.nextLine();
        currentBook.deleteContact(name);
    }

    // SEARCH & COUNT 

    private void searchByCity() {
        System.out.print("Enter City: ");
        String city = sc.nextLine();

        List<Contact> results = manager.searchByCity(city);
        results.forEach(System.out::println);
    }

    private void searchByState() {
        System.out.print("Enter State: ");
        String state = sc.nextLine();

        List<Contact> results = manager.searchByState(state);
        results.forEach(System.out::println);
    }

    private void countByCity() {
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.println("Total Contacts: " + manager.countByCity(city));
    }

    private void countByState() {
        System.out.print("Enter State: ");
        String state = sc.nextLine();
        System.out.println("Total Contacts: " + manager.countByState(state));
    }
}