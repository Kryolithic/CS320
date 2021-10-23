package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContactClass() {
		//initializing test contact
		Contact testContact = new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		//checks that contact data was initialized correctly
		assertTrue(testContact.getContactId().equals("1"));
		assertTrue(testContact.getFirstName().equals("sponge"));
		assertTrue(testContact.getLastName().equals("bob"));
		assertTrue(testContact.getPhoneNumber().equals("3332221111"));
		assertTrue(testContact.getAddress().equals("2 Pineapple way, Ocean City, MD"));
	}
	
	@Test
	void testContactIDTooLong() {
		//testing behavior if ID entry is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1123123441241245121245", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		//testing behavior if address entry is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "sponge", "bob", "3332221111", "2 Pineapple way, Ocean City, This address is going to be far too long I hope the system doesn't crash");
		});
	}
	
	@Test
	void testContactNameTooLong() {
		//testing behavior if name entry is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "spongebob squarepants", "bob", "3332221111", "2 Pineapple way, Ocean City, MD");
		});
	}
	
	@Test
	void testContactNumberTooLong() {
		//testing behavior if phone entry is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "sponge", "bob", "33322211111231244141", "2 Pineapple way, Ocean City, MD");
		});
	}
	
	@Test
	void testContactNumberTooShort() {
		//testing behavior if phone entry is too short
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "sponge", "bob", "123", "2 Pineapple way, Ocean City, MD");
		});
	}
	
}
