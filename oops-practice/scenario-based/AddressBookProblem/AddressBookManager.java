package AddressBookProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookManager {
	
	private Map<String,AddressBook> addressBookManager=new HashMap<>();
	
	public void addAddressBook(String addressBookName) {
		String key=addressBookName.toLowerCase();
		if(addressBookManager.containsKey(key)) {
			System.out.println("Address Book already exits");
			return;
		}
		addressBookManager.put(key, new AddressBook(addressBookName));
	}
	
	public AddressBook getAddressBook(String name) {
		return addressBookManager.get(name.toLowerCase());
	}
	
	public void renameAddressBookName(String newName, String oldName) {
		
		String oldKey=oldName.toLowerCase();
		String newKey=newName.toLowerCase();
		
		if(!addressBookManager.containsKey(oldKey)) {
			System.out.println("Address Book name not found!");
			return;
		}
		if(addressBookManager.containsKey(newKey)) {
			System.out.println("New name already exists!");
		}
		AddressBook book=addressBookManager.remove(oldKey);
		book.setName(newName);
		addressBookManager.put(newKey,book);
		
	}
	
	public void deleteAddressBook(String name) {
		String key=name.toLowerCase();
		if(addressBookManager.remove(key)==null) {
			System.out.println("Address Book not found");
		}else {
			System.out.println("Address Book deleted successfully.");
		}
	}
	
	public void displayAllAddressBookDetails() {
		for(AddressBook book: addressBookManager.values()) {
			System.out.println("++++++++++++++++++++");
			System.out.println("Details of AddressBook named "+book.getName()+" :");
			book.displayContactDetails();
			System.out.println("++++++++++++++++++++");
		}
	}
	
	public List<Contact> searchByCity(String city){
		List<Contact> result=new ArrayList<>();
		for(AddressBook book: addressBookManager.values()) {
			result.addAll(book.getContactsByCity(city));
		}
		return result;
	}
	
	public List<Contact> searchByState(String state){
		List<Contact> result=new ArrayList<>();
		for(AddressBook book:addressBookManager.values()) {
			result.addAll(book.getContactsByState(state));
		}
		return result;
	}
	
	public int countByCity(String city) {
		int total=0;
		for(AddressBook book: addressBookManager.values()) {
			total+=book.getCountByCity(city);
		}
		return total;
	}
	
	public int countByState(String state) {
		int total=0;
		for(AddressBook book : addressBookManager.values()) {
			total+=book.getCountByState(state);
		}
		return total;
	}
}