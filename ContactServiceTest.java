package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	//creating instance of contact service for testing
	private static ContactService contactService;
	@BeforeAll
	static void initialize() {
		contactService = ContactService.getService();
	}

	@Test
	void testContactService() {
		//adds contact to hash map
		Contact contact = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		contactService.addContact(contact);
		//verifies contact was initialized
		assertTrue(contactService.getContact(contact.getContactId()) != null);
		
		Contact getContact = contactService.getContact(contact.getContactId());
		//checks that each attribute was correctly added
		assertTrue(getContact.getContactId().contentEquals(contact.getContactId()));
		assertTrue(getContact.getFirstName().contentEquals(contact.getFirstName()));
		assertTrue(getContact.getLastName().contentEquals(contact.getLastName()));
		assertTrue(getContact.getPhoneNumber().contentEquals(contact.getPhoneNumber()));
		assertTrue(getContact.getAddress().contentEquals(contact.getAddress()));
		
		
	}
	
	@Test
	void testContactServiceAddMultiple() {
		//test instance with multiple contact entries
		Contact testContact1 = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		Contact testContact2 = new Contact("2", "Bob", "Ross", "1234567890", "Muncy, IN");
		Contact testContact3 = new Contact("3", "Bill", "Marshall", "0987654321", "25 Cedar Road, Seneca, NY");
		
		contactService.addContact(testContact1);
		contactService.addContact(testContact2);
		contactService.addContact(testContact3);
		
		
		//checks that entries for each test contact are not null
		assertTrue(contactService.getContact(testContact1.getContactId()) != null);
		assertTrue(contactService.getContact(testContact2.getContactId()) != null);
		assertTrue(contactService.getContact(testContact3.getContactId()) != null);
	}
	
	@Test
	void testContactServiceUpdate() {
		//test instance of contact service with one contact entry
		Contact testContact1 = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		contactService.addContact(testContact1);
		Contact testContact2 = new Contact("2", "Bob", "Ross", "1234567890", "Muncy, IN");
		//updates contact with test contact 2
		contactService.updateContact(testContact2);
		Contact getContact = contactService.getContact(testContact2.getContactId());
		//validates contact updated properly
		assertTrue(getContact.getContactId().contentEquals(testContact2.getContactId()));
	}
	
	@Test
	void testContactServiceRemove() {
		//test instance of contact service with one contact entry
		Contact testContact1 = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		contactService.addContact(testContact1);
		Contact testContact2 = new Contact("2", "Bob", "Ross", "1234567890", "Muncy, IN");
		contactService.addContact(testContact2);
		contactService.deleteContact(testContact1.getContactId());
		//validates that contact is now null
		assertTrue(contactService.getContact(testContact1.getContactId()) == null);
	}
	
	void testContactServiceGetContact() {
		//adding 3 test contacts to service
		Contact testContact1 = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		Contact testContact2 = new Contact("2", "Bob", "Ross", "1234567890", "Muncy, IN");
		Contact testContact3 = new Contact("3", "Bill", "Marshall", "0987654321", "25 Cedar Road, Seneca, NY");
		
		contactService.addContact(testContact1);
		contactService.addContact(testContact2);
		contactService.addContact(testContact3);
		//validates get contact function returns correct contact
		Contact getContact = contactService.getContact(testContact1.getContactId());
		assertTrue(getContact.getContactId().contentEquals(testContact1.getContactId()));
	}
	
	@Test
	void testContactServiceDuplicate() {
		//validates service will not add duplicate contact
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact testContact1 = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
					contactService.addContact(testContact1);
					Contact testContact2 = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
					contactService.addContact(testContact2);
		});
	}
	
	@Test
	void testContactServiceNotFound() {
		//validates service responds to unknown contact
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("Hello");
		});
	}

}
