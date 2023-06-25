import java.util.Date;

public class Appointment {
	// data input requirements of each data entry for appointment info
	private static final int ID_LENGTH = 10;
	private static final int DESCRIPTION_LENGTH = 50;
	private static final Date TODAY = new Date();
	
	// data variables for each appointment
	private String appointmentID;
	private Date date;
	private String description;
	
	// place holder for empty values
	private static final String NO_VALUE_STRING = "No Value";
	
	/***********************************************************************
	 * constructor method for placeholder creation with no values
	 ***********************************************************************/
	Appointment(){	
		this.appointmentID = NO_VALUE_STRING;
		this.date = TODAY;
		this.description = NO_VALUE_STRING;
	}
	
	/***************************************************************************
	 * constructor method if nothing was inputed when first creating task
	 * except for their appointmentID that is uniquely generated
	 * 
	 * @param appointmentID - the unique ID for the appointment that was created
	 ***************************************************************************/
	Appointment(String appointmentID){
		
		if (appointmentID == null || appointmentID.length() > ID_LENGTH) {
			throw new IllegalArgumentException(String.format("Appointment ID cannot be null and can only be %d characters max!", ID_LENGTH));
		}
		
		this.appointmentID = appointmentID;
		this.date = TODAY;
		this.description = NO_VALUE_STRING;	
	}
	
	/*****************************************************************************
	 * constructor method when all values are inputed when creating an appointment 
	 * done when a task is created with all required info
	 * this is the only option for users when creating a task object
	 * 
	 * @param appointmentID - the unique ID for the appointment that was created
	 * @param date - date of appointment
	 * @param description - description of appointment
	 *****************************************************************************/
	Appointment(String appointmentID, Date date, String description){
		
		if (appointmentID == null || appointmentID.length() > ID_LENGTH) {
			throw new IllegalArgumentException(String.format("Appointment ID cannot be null and can only be %d characters max!", ID_LENGTH));
		}
		
		if (date == null || date.before(TODAY)) {
			throw new IllegalArgumentException("Date cannot be null and can not be before today!");
		}
		
		if (description == null || description.length() > DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException(String.format("Appointment description cannot be null and can only be %d characters max!", DESCRIPTION_LENGTH));
		}
		
		this.appointmentID = appointmentID;
		this.date = date;
		this.description = description;	
	}
	
	/********************************************************
	 * getter for appointment ID
	 * setter not needed since appointmentID cannot be updated
	 ********************************************************/
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	
	/**********************************************************
	 * getter and setter for appointment date
	 * setter will only update field if it is not before today
	 **********************************************************/
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		
		if (date == null || date.before(TODAY)) {
			throw new IllegalArgumentException("Date cannot be null and can not be before today!");
		}
		
		this.date = date;
	}
	
	/****************************************************************
	 * getter and setter for appointment description
	 * setter will only update field if it meets length requirements
	 ****************************************************************/
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {	
		if (description == null || description.length() > DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException(String.format("First name cannot be null and can only be %d characters max!", DESCRIPTION_LENGTH));
		}
		
		this.description = description;
	}
	
}
