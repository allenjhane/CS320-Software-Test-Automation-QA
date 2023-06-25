
public class Contact {

	// character lengths of each data entry for contact info
	private static final int ID_LENGTH = 10;
	private static final int FIRSTNAME_LENGTH = 10;
	private static final int LASTNAME_LENGTH = 10;
	private static final int PHONE_LENGTH = 10;
	private static final int ADDRESS_LENGTH = 30;
	
	// data variables for each contact
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// place holders for empty values
	private static final String NO_VALUE_STRING = "No Value";
	
	/***********************************************************************
	 * constructor method for placeholder creation with no values
	 ***********************************************************************/
	Contact() {
		this.contactID = NO_VALUE_STRING;
		this.firstName = NO_VALUE_STRING;
		this.lastName = NO_VALUE_STRING;
		this.phoneNumber = NO_VALUE_STRING;
		this.address = NO_VALUE_STRING;
	}
	
	/***********************************************************************
	 * constructor method if nothing was inputed when first creating contact
	 * except for their contactID that is uniquely generated
	 ***********************************************************************/
	Contact(String contactID) {
		if (contactID == null || contactID.length() > ID_LENGTH) {
			throw new IllegalArgumentException(String.format("Contact ID cannot be null and can only be %d characters max!", ID_LENGTH));
		}
		
		this.contactID = contactID;
		this.firstName = NO_VALUE_STRING;
		this.lastName = NO_VALUE_STRING;
		this.phoneNumber = NO_VALUE_STRING;
		this.address = NO_VALUE_STRING;	
	}
	
	/************************************************************************
	 * constructor method when all values are inputed when creating a contact
	 * done when a contact is created with all required info
	 * this is the only option for users when creating a contact object
	 * 
	 * @param contactID - the unique ID for the contact that was created
	 * @param firstName - first name of contact
	 * @param lastName - last name of contact
	 * @param phoneNumber - phone number of contact
	 * @param address - address of the contact
	 ***********************************************************************/
	Contact(String contactID, String firstName, String lastName, String phoneNumber, String address){
		
		
		// if statements to check if given params follow global variable constraints
		// will throw an error when not followed
		if (contactID == null || contactID.length() > ID_LENGTH) {
			throw new IllegalArgumentException(String.format("Contact ID cannot be null and can only be %d characters max!", ID_LENGTH));
		}
		
		if (firstName == null || firstName.length() > FIRSTNAME_LENGTH) {
			throw new IllegalArgumentException(String.format("First name cannot be null and can only be %d characters max!", FIRSTNAME_LENGTH));
		}
		
		if (lastName == null || lastName.length() > LASTNAME_LENGTH) {
			throw new IllegalArgumentException(String.format("Last name cannot be null and can only be %d characters max!", LASTNAME_LENGTH));
		}
		
		if (phoneNumber == null || phoneNumber.length() != PHONE_LENGTH) {
			throw new IllegalArgumentException(String.format("Phone number cannot be null and can only be exactly %d characters!", PHONE_LENGTH));
		}
		
		if (address == null || address.length() > ADDRESS_LENGTH) {
			throw new IllegalArgumentException(String.format("Address cannot be null and can only be %d characters max!", ADDRESS_LENGTH));
		}
		
		this.contactID = contactID;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.phoneNumber = phoneNumber;
	    this.address = address;
	    
	}
	
	/********************************************************
	 * getter for contact ID
	 * setter will only update field if it meets length requirements
	 ********************************************************/
	public String getContactID() {
		return this.contactID;
	}
	
	
	/****************************************************************
	 * getter and setter for contact first name
	 * setter will only update field if it meets length requirements
	 ****************************************************************/
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {	
		if (firstName == null || firstName.length() > FIRSTNAME_LENGTH) {
			throw new IllegalArgumentException(String.format("First name cannot be null and can only be %d characters max!", FIRSTNAME_LENGTH));
		}
		
		this.firstName = firstName;
	}
	
	/*****************************************************************
	 * getter and setter for contact last name
	 * setter will only update field if it meets length requirements
	 ****************************************************************/
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {		
		if (lastName == null || lastName.length() > LASTNAME_LENGTH) {
			throw new IllegalArgumentException(String.format("Last name cannot be null and can only be %d characters max!", LASTNAME_LENGTH));
		}
		
		this.lastName = lastName;
		
	}
	
	/*****************************************************************
	 * getter and setter for contact phone number
	 * setter will only update field if it meets length requirements
	 ****************************************************************/
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {		
		if (phoneNumber == null || phoneNumber.length() != PHONE_LENGTH) {
			throw new IllegalArgumentException(String.format("Phone number cannot be null and can only be exactly %d characters!", PHONE_LENGTH));
		}
		
		this.phoneNumber = phoneNumber;
		
	}
	
	/****************************************************************
	 * getter and setter for contact address
	 * setter will only update field if it meets length requirements
	 ****************************************************************/
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > ADDRESS_LENGTH) {
			throw new IllegalArgumentException(String.format("Address cannot be null and can only be %d characters max!", ADDRESS_LENGTH));
		}
		
		this.address = address;
	}
}
