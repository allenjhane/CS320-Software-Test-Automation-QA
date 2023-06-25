
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	// variables for tests
	private String contactID1 = "1A34c678p0";
	private String contactID2 = "1A34c679p0";
	private String wrongContactID = "1A34c078p0";
	private String firstName = "Jhane";
	private String lastName = "Mao";
	private String phoneNumber = "1234567890";
	private String address = "12 Bow Rd. Hayward, TX 94544";
	
	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		
		service.addContact(contactID1);
		service.addContact(contactID1); //runs if statement since contactID already exists
		
		service.addContact(contactID2, firstName, lastName, phoneNumber, address);
		service.addContact(contactID2, firstName, lastName, phoneNumber, address); //runs if statement since contactID already exists
		
	}
	
	@Test
	void testSearchContact() {
	    ContactService service = new ContactService();
	    
	    service.addContact(contactID1);
	    int contactListSize = service.getContactList().size();
	    
	    service.searchContactID(service.getContactList().get(contactListSize-1).getContactID());
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	    	service.searchContactID(wrongContactID);
	    });
	}
	
	@Test
	void testRemoveContact(){
	    ContactService service = new ContactService();
	    
	    service.addContact(contactID1);
	    int contactListSize = service.getContactList().size();
	    
	    service.removeContact(service.getContactList().get(contactListSize-1).getContactID());
	    
	}
	
	@Test
	void testUpdateFirstName() {
	    ContactService service = new ContactService();
	    
	    service.addContact(contactID1);
	    int contactListSize = service.getContactList().size();
	    
	    service.updateFirstName(service.getContactList().get(contactListSize-1).getContactID(), firstName);
	    assertEquals(service.getContactList().get(0).getFirstName(), firstName);
	    
	    
	}
	
	@Test
	void testUpdateLastName() {
	    ContactService service = new ContactService();
	    
	    service.addContact(contactID1);
	    int contactListSize = service.getContactList().size();
	    
	    service.updateLastName(service.getContactList().get(contactListSize-1).getContactID(), lastName);
	    
	}
	
	@Test
	void testUpdateNumber() {
	    ContactService service = new ContactService();
	    
	    service.addContact(contactID1);
	    int contactListSize = service.getContactList().size();
	    
	    service.updateNumber(service.getContactList().get(contactListSize-1).getContactID(), phoneNumber);
	    
	}
	
	@Test
	void testUpdateAddress() {
	    ContactService service = new ContactService();
	    
	    service.addContact(contactID1);
	    int contactListSize = service.getContactList().size();
	    
	    service.updateAddress(service.getContactList().get(contactListSize-1).getContactID(), address);
	    
	}
	
	
}
