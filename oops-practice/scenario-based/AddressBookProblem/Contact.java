package AddressBookProblem;
public class Contact {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;
	
	public Contact(String firstName, String lastName, String address, String city, String state,
			    String zip, String phoneNumber, String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	public void displayDetails() {
		System.out.println("First Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Address: "+address);
		System.out.println("City: "+city);
		System.out.println("State: "+state);
		System.out.println("Zip Code: "+zip);
		System.out.println("Phone Number: "+phoneNumber);
		System.out.println("Email: "+email);
	}
	public String getName() {
		return firstName+" "+lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address+" "+city+" "+state+" "+zip;
	}
	
	public String getNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setFirstName(String newFirstName) {
		firstName=newFirstName;
	}
	
	public void setLastName(String newLastName) {
		lastName=newLastName;
	}
	
	public void setAddress(String newAddress) {
		address=newAddress;
	}
	
	public void setCity(String newCity) {
		city=newCity;
	}
	
	public void setState(String newState) {
		state=newState;
	}
	
	public void setZip(String newZip) {
		zip=newZip;
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		phoneNumber=newPhoneNumber;
	}
	
	public void setEmail(String newEmail) {
		email=newEmail;
	}
	
	@Override
	public String toString() {
	    return firstName + " " + lastName + ", " + address +
	            ", " + city +
	            ", " + state +
	            ", " + zip +
	            ", " + phoneNumber +
	            ", " + email;
	}
}