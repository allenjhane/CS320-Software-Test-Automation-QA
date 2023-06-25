import java.util.List;
import java.util.ArrayList; 

public class ContactService {

	private List<Contact> contactList = new ArrayList<>();
	
	// list of IDs that have been created so a loop to search each contact object is not needed for code
	// will just be used internally for verifying if given contactID already exists so no duplications are created
	private List<String> contactIDs = new ArrayList<>(); 
	
	/************************************************************************
	 * getter for contactList list
	 * setter not needed because object list has too much info, add method -
	 * is more convenient to add items to list, and required setters are in -
	 * place in class object
	 ************************************************************************/
	public List<Contact> getContactList(){
		return contactList;
	}
	
	
	/***********************************************************************
	 * method that generates a random alphanumeric string with given length
	 * this will be used to get a unique contactID for the program
	 * 
	 * @param length - the length of the string to be randomized
	 * @return 
	 ***********************************************************************/
    protected String generateID(int length){
    	
    	// array that will hold characters for unique id
        char[] alphanumericArray = 
        		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        
        // object used to create a string
        StringBuilder uniqueID = new StringBuilder();
        
        // used to get random character from alphanumericArray
        int randomChar;
 
        for(int i = 0; i < length; i++) {
            randomChar = (int)(Math.random()*alphanumericArray.length);
            uniqueID.append(alphanumericArray[randomChar]);
        }
        
        // return the unique id (Contact ID) to be used for contact creation
        return uniqueID.toString();
    }
    
    /**********************************************************************
     * method that will add a contact with a unique ID with no contact info
     **********************************************************************/
    public void addContact(String contactID) {
    	
    	// loop to check and generate unique IDs for each contact
    	while(true) {
    		
    		// if the contactID has already been created generate a new ID
    		if(contactIDs.contains(contactID)) {
    			contactID = generateID(10);
    		}
    		
    		// else if the ID is already unique create a new contact
    		else {
    			// add the IDs to the existing id list
    			contactIDs.add(contactID);
    			
    			// create a new contact and add it to the contact list
    			Contact contact = new Contact(contactID);
    			contactList.add(contact);
    			
    			break;
    		
    		 }
    	}

    }
    
    /********************************************************************
     * method that will add a contact with a unique ID with contact info
     ********************************************************************/
    public void addContact(String contactID, String firstName, String lastName, String number, String address) {
    	
    	// loop to check and generate unique IDs for each contact
    	while(true) {
    		
    		// if the contactID has already been created generate a new ID
    		if(contactIDs.contains(contactID)) {
    			contactID = generateID(10);
    		}
    		
    		// else if the ID is already unique create a new contact
    		else {
    			// add the IDs to the existing id list
    			contactIDs.add(contactID);
    			
    			// create a new contact and add it to the contact list
    			Contact contact = new Contact(contactID, firstName, lastName, number, address);
    			contactList.add(contact);
    			
    			break;
    		}
    		
    	}
    	
    }
    
    /***************************************************************************
     * method that will search a contact with the contactID given
     * note: no throw exception error needed in all other methods that use this
     * 		 method since that error will be accounted for when not found here
     * 
     * @param contactID - the ID that we will search for
     * @return returns that object that has that contactID
     ***************************************************************************/
    public Contact searchContactID(String contactID) {
    	
    	Contact foundContact = new Contact();
    	
    	// loop to look for the contact that has the same contactID
    	for(int i = 0; i < contactList.size(); ++i) {
    		if(contactID == contactList.get(i).getContactID()) {
    			foundContact = contactList.get(i);
    		}
    	}
    	
    	if(foundContact.getContactID() == "No Value") {
    		throw new IllegalArgumentException("Contact does not exist in the list.");
    	}
    	else {
    		return foundContact;
    	}
    	
    }
    
    /**********************************************************
     * method that will remove a contact based on the contactID
     * 
     * @param contactID - the contact that will be removed
     **********************************************************/
    public void removeContact(String contactID) {
    	Contact contact = searchContactID(contactID);
    	
    	contactIDs.remove(contactID);
    	contactList.remove(contact);
    	System.out.println("Contact successfully removed.");

    }
    
    /****************************************************************************
     * method that will update the first name of a contact based on the contactID
     * 
     * @param contactID - the contact that will be updated
     ****************************************************************************/
    public Contact updateFirstName(String contactID, String newFirstName) {
    	Contact contact = searchContactID(contactID);
    	
    	contactList.get(contactList.indexOf(contact)).setFirstName(newFirstName);
    	System.out.println("First name of contact successfully updated.");
    	
    	return contact;
    	
    }
    
    /****************************************************************************
     * method that will update the last name of a contact based on the contactID
     * 
     * @param contactID - the contact that will be updated
     ****************************************************************************/
    public void updateLastName(String contactID, String newLastName) {
    	Contact contact = searchContactID(contactID);
    	
    	contactList.get(contactList.indexOf(contact)).setLastName(newLastName);
    	System.out.println("Last name of contact successfully updated.");

    }
    
    /******************************************************************************
     * method that will update the phone number of a contact based on the contactID
     * 
     * @param contactID - the contact that will be updated
     ******************************************************************************/
    public void updateNumber(String contactID, String newNumber) {
    	Contact contact = searchContactID(contactID);
    	
    	contactList.get(contactList.indexOf(contact)).setPhoneNumber(newNumber);
    	System.out.println("Phone number of contact successfully updated.");

    }
    
    /*************************************************************************
     * method that will update the address of a contact based on the contactID
     * 
     * @param contactID - the contact that will be updated
     *************************************************************************/
    public void updateAddress(String contactID, String newAddress) {
    	Contact contact = searchContactID(contactID);
    	
    	contactList.get(contactList.indexOf(contact)).setAddress(newAddress);
    	System.out.println("Address of contact successfully updated.");

    }
    
}


