
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {
	
	// variables for tests
	private String contactID = "1A34c678p0";
	private String firstName = "Jhane";
	private String lastName = "Mao";
	private String phoneNumber = "1234567890";
	private String address = "12 Bow Rd. Hayward, TX 94544";
	
	private String longContactID = "1A34c678p0F";
	private String longFirstName = "Allen Jhane";
	private String longLastName = "Dela Cruz Mao";
	private String longPhoneNumber = "12345678910";
	private String shortPhoneNumber = "12345678";
	private String longAddress = "35 Linden St., Steinecken, CA 09034";

	@Test
	void testEmptyContactConstructor() {
		Contact contact = new Contact();
		
		assertNotNull(contact.getContactID());	
		assertNotNull(contact.getFirstName());
		assertNotNull(contact.getLastName());
		assertNotNull(contact.getPhoneNumber());
		assertNotNull(contact.getAddress());
	}
	
	@Test
	void testContactIDConstructor() {
		Contact contact = new Contact(contactID);
		
		assertEquals(contactID, contact.getContactID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(longContactID);
	    });
		
		assertNotNull(contact.getFirstName());
		assertNotNull(contact.getLastName());
		assertNotNull(contact.getPhoneNumber());
		assertNotNull(contact.getAddress());
	}

	@Test
	void testFullContactInfoConstructor() {

		Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		
		assertEquals(contactID, contact.getContactID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(null, firstName, lastName, phoneNumber, address);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(longContactID, firstName, lastName, phoneNumber, address);
	    });
		
		assertEquals(firstName, contact.getFirstName());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, null, lastName, phoneNumber, address);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, longFirstName, lastName, phoneNumber, address);
	    });
		
		assertEquals(lastName, contact.getLastName());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, firstName, null, phoneNumber, address);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, firstName, longLastName, phoneNumber, address);
	    });
		
		assertEquals(phoneNumber, contact.getPhoneNumber());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, firstName, lastName, null, address);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, firstName, lastName, longPhoneNumber, address);
	    });
		
		assertEquals(address, contact.getAddress());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, firstName, lastName, phoneNumber, null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Contact(contactID, firstName, lastName, phoneNumber, longAddress);
	    });
		
	}

	
	@Test
	void testSetFirstName() {
	    Contact contact = new Contact();
	    contact.setFirstName(firstName);
	    
	    assertEquals(firstName, contact.getFirstName());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	contact.setFirstName(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	contact.setFirstName(longFirstName);
	    });
	}
	
	@Test
	void testSetLastName() {
	    Contact contact = new Contact();
	    contact.setLastName(lastName);
	    
	    assertEquals(lastName, contact.getLastName());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	contact.setLastName(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	contact.setLastName(longLastName);
	    });
	}
	
	@Test
	void testSetPhone() {
	    Contact contact = new Contact();
	    contact.setPhoneNumber(phoneNumber);
	    
	    assertEquals(phoneNumber, contact.getPhoneNumber());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	contact.setPhoneNumber(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	contact.setPhoneNumber(longPhoneNumber);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	contact.setPhoneNumber(shortPhoneNumber);
	    });
	}
	
	@Test
	void testSetAddress() {
	    Contact contact = new Contact();
	    contact.setAddress(address);
	    
	    assertEquals(address, contact.getAddress());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	contact.setAddress(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	contact.setAddress(longAddress);
	    });
	}
}
