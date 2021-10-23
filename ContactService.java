package contact;


import java.util.HashMap;
import java.util.Map;
import contact.Contact;


public class ContactService {
	//declares static reference to class
	private static ContactService reference = new ContactService();
	private final Map<String, Contact> contactIndex; //hash map to store contacts
	//constructor class to initialize hash map
	ContactService() {
		this.contactIndex = new HashMap<String, Contact>();
	}
	//function to initialize reference to class
	public static ContactService getService() {
		return reference;
	}
	//method for adding new contact
	public void addContact(Contact newContact) {
		//validate contact ID isn't already in use
		if(!contactIndex.containsKey(newContact.getContactId())){
			contactIndex.put(newContact.getContactId(), newContact);
			return;
		}
		//throws exception if duplicate contact found
		throw new IllegalArgumentException("Contact Already Exists");
	}
	//method to delete contact
	public void deleteContact(String id) {
		if(contactIndex.get(id) != null) {
			contactIndex.remove(id);
			return;
		}
		//throws exception if contact not found within map
		throw new IllegalArgumentException("Contact Not Found");
	}
	//method to update contact
	public void updateContact(Contact updateContact) {
		if(contactIndex.get(updateContact.getContactId()) != null) {
			contactIndex.replace(updateContact.getContactId(), updateContact);
			}
		throw new IllegalArgumentException("Contact Not Found");
	}
	//getter for contact
	public Contact getContact(String id) {
		return contactIndex.get(id);
	}
}
	
	
	


