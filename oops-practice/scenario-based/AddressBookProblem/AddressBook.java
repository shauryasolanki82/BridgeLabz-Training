package AddressBookProblem;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
	private String addressBookName;
	private Map<String,Contact> addressBook=new HashMap<>();
	private Map<String,List<Contact>> cityMap=new HashMap<>();
	private Map<String,List<Contact>> stateMap=new HashMap<>();
	
	public AddressBook(String addressBookName) {
		this.addressBookName=addressBookName;
	}
	
	public String getName() {
        return addressBookName;
    }
	
	public void setName(String newAddressBookName) {
		addressBookName=newAddressBookName;
	}
	
	public void addContact(Contact contact) {
		String key=contact.getName().toLowerCase();
		if(addressBook.containsKey(key)) {
			System.out.println("Contact already exits!");
			return;
		}
		addressBook.put(key,contact);
		addToDictionary(contact);
		System.out.println("Contact added successfully.");
	}
	
	private void addToDictionary(Contact contact) {
		cityMap.computeIfAbsent(contact.getCity(),k-> new ArrayList<>()).add(contact);
		stateMap.computeIfAbsent(contact.getState(),k->new ArrayList<>()).add(contact);
	}
	
	public void editContact(String fullName, Contact updatedContact) {
		String key=fullName.toLowerCase();
		if(!addressBook.containsKey(key)) {
			System.out.println("Contact not found!");
			return;
		}
		addressBook.remove(key);
		addressBook.put(updatedContact.getName().toLowerCase(), updatedContact);
		System.out.println("Contact updated successfully.");
		
	}
	public void deleteContact(String fullName) {
		String key=fullName.toLowerCase();
		if(addressBook.remove(key)==null) {
			System.out.println("Contact not found!");
		}else {
			System.out.println("Contact deleted successfully.");
		}
	}
	
	public void displayContactDetails() {
		for(Contact contact: addressBook.values()) {
			System.out.println("====================");
			System.out.println("Details of Contact named "+contact.getName()+" :");
			contact.displayDetails();
			System.out.println("====================");
		}
	}
	
	public Collection<Contact> getAllcontacts(){
		return addressBook.values();
	}
	
	public List<Contact> getContactsByCity(String city){
		return cityMap.getOrDefault(city, new ArrayList<>());
	}
	
	public List<Contact> getContactsByState(String state){
		return stateMap.getOrDefault(state, new ArrayList<>());
	}
	
	public int getCountByCity(String city) {
		return cityMap.getOrDefault(city,new ArrayList<>()).size();
	}
	
	public int getCountByState(String state) {
		return stateMap.getOrDefault(state, new ArrayList<>()).size();
	}
	
	public void sortContactsByName() {
		List<Contact> sortedList=new ArrayList<>(addressBook.values());
		sortedList.sort((c1,c2) -> {
			int firstNameCompare=c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
			if(firstNameCompare!=0) return firstNameCompare;
			return c1.getLastName().compareToIgnoreCase(c2.getLastName());
		});
		for(Contact contact:sortedList) {
			System.out.println(contact);
		}
	}
	
	public void sortContactsByCity() {
		List<Contact> sortedList=new ArrayList<>(addressBook.values());
		//sortedList.sort((c1,c2)->c1.getCity().compareToIgnoreCase(c2.getCity()));
		sortedList.sort(Comparator.comparing(Contact::getCity,String.CASE_INSENSITIVE_ORDER));
		for(Contact contact:sortedList) {
			System.out.println(contact);
		}
	}
	
	public void sortContactsByState() {
		List<Contact> sortedList=new ArrayList<>(addressBook.values());
		sortedList.sort(Comparator.comparing(Contact::getState,String.CASE_INSENSITIVE_ORDER));
		for(Contact contact:sortedList) {
			System.out.println(contact);
		}
	}
	
	public void sortContactsByZip() {
		List<Contact> sortedList=new ArrayList<>(addressBook.values());
		sortedList.sort(Comparator.comparing(Contact::getZip,String.CASE_INSENSITIVE_ORDER));
		for(Contact contact:sortedList) {
			System.out.println(contact);
		}
	}
}