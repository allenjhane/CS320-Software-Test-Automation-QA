import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AppointmentService {
private List<Appointment> appointmentList = new ArrayList<>();
	
	// list of IDs that have been created so a loop to search each Appointment object is not needed for code
	// will just be used internally for verifying if given AppointmentID already exists so no duplications are created
	private List<String> appointmentIDs = new ArrayList<>(); 
	
	/************************************************************************
	 * getter for AppointmentList list
	 * setter not needed because object list has too much info, add method -
	 * is more convenient to add items to list, and required setters are in -
	 * place in class object
	 ************************************************************************/
	public List<Appointment> getAppointmentList(){
		return appointmentList;
	}
	
	
	/***********************************************************************
	 * method that generates a random alphanumeric string with given length
	 * this will be used to get a unique AppointmentID for the program
	 * 
	 * @param length - the length of the string to be randomized
	 * @return the generated unique ID for the object
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
        
        // return the unique id (Appointment ID) to be used for Appointment creation
        return uniqueID.toString();
    }
    
    /**********************************************************************
     * method that will add an Appointment with a unique ID with no Appointment info
     * 
     * @param appointmentID - ID of the Appointment
     **********************************************************************/
    public void addAppointment(String appointmentID) {
    	
    	// loop to check and generate unique IDs for each Appointment
    	while(true) {
    		
    		// if the appointmentID has already been created generate a new ID
    		if(appointmentIDs.contains(appointmentID)) {
    			appointmentID = generateID(10);
    		}
    		
    		// else if the ID is already unique create a new Appointment
    		else {
    			// add the IDs to the existing id list
    			appointmentIDs.add(appointmentID);
    			
    			// create a new Appointment and add it to the Appointment list
    			Appointment appointment = new Appointment(appointmentID);
    			appointmentList.add(appointment);
    			
    			break;	
    		 }
    	}
    }
    
    /*************************************************************************************
     * method that will add a Appointment with a unique ID, a given date, and description
     * 
     * @param appointmentID - ID of the Appointment
     * @param date - the date the appointment will be on
     * @param description - description and any notes about the appointment
     *************************************************************************************/
    public void addAppointment(String appointmentID, Date date, String description) {
    	
    	// loop to check and generate unique IDs for each Appointment
    	while(true) {
    		
    		// if the AppointmentID has already been created generate a new ID
    		if(appointmentIDs.contains(appointmentID)) {
    			appointmentID = generateID(10);
    		}
    		
    		// else if the ID is already unique create a new Appointment
    		else {
    			// add the IDs to the existing id list
    			appointmentIDs.add(appointmentID);
    			
    			// create a new Appointment and add it to the Appointment list
    			Appointment appointment = new Appointment(appointmentID, date, description);
    			appointmentList.add(appointment);
    			
    			break;
    		 }
    	}
    }
    
    /***************************************************************************
     * method that will search for a Appointment with the AppointmentID given
     * note: no throw exception error needed in all other methods that use this
     * 		 method since that error will be accounted for when not found here
     * 
     * @param AppointmentID - the ID that we will search for
     * @return returns that object that has that AppointmentID if not an error
     ***************************************************************************/
    public Appointment searchAppointmentID(String appointmentID) {
    	
    	Appointment foundAppointment = new Appointment();
    	
    	// loop to look for the Appointment that has the same AppointmentID
    	for(int i = 0; i < appointmentList.size(); ++i) {
    		if(appointmentID == appointmentList.get(i).getAppointmentID()) {
    			foundAppointment = appointmentList.get(i);
    		}
    	}
    	
    	// if an empty appointment was never made then throw an error to the user
    	// otherwise return the appointment that was found
    	if(foundAppointment.getAppointmentID() == "No Value") {
    		throw new IllegalArgumentException("Appointment does not exist in the list.");
    	}
    	else {
    		return foundAppointment;
    	}
    	
    }
    
    /**********************************************************
     * method that will remove a Appointment based on the AppointmentID
     * 
     * @param AppointmentID - the Appointment that will be removed
     **********************************************************/
    public void removeAppointment(String appointmentID) {
    	// will have an error if Appointment was not found
    	Appointment appointment = searchAppointmentID(appointmentID);
    	
    	appointmentIDs.remove(appointmentID);
    	appointmentList.remove(appointment);
    	System.out.println("Appointment successfully removed.");

    }
}
