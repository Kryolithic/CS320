/*
 * Gary Clark
 * Contact Services JUnit Testing
 * CS320
 * Southern New Hampshire University
 */

package contact;

public class Contact { 
	//declaring field attributes
	private String contactID, firstName, lastName, phoneNumber, address;
	//holds length standard for respective variables
	private final int ID_LENGTH = 10;
	private final int NAME_LENGTH = 10;
	private final int PHONE_LENGTH = 10;
	private final int ADDRESS_LENGTH = 30;
	
	
	//constructor with test if statement checks
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		//verifies ID is proper format
		boolean inputCheck = validationCheck(contactID, ID_LENGTH);
		//if inputCheck is true then assigns value to ID
		if(inputCheck) {
			this.contactID = contactID;
		}
		//verifies remaining attributes and updates value of inputCheck
		inputCheck = inputCheck && validationCheck(firstName, NAME_LENGTH) && validationCheck(lastName, NAME_LENGTH) && validationCheck(phoneNumber, PHONE_LENGTH) && validationCheck(address, ADDRESS_LENGTH);
		inputCheck = inputCheck && phoneNumber.matches("\\d{10}"); //requires phone number to be valid 10 digit number
		//throws exception if any attributes fail verification
		if(!inputCheck) {
			throw new IllegalArgumentException("Invalid Input");
		}
		//assigning values using setters
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);	
	}
	
	//setters for modifiable attributes
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//getters for attributes
	public String getContactId() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	//verifies input against requirements
	private boolean validationCheck(String input, int length) {
		return (input != null && input.length() <= length);
	}

}
