
public class Task {
	
	// character lengths of each data entry for task info
	private static final int ID_LENGTH = 10;
	private static final int NAME_LENGTH = 20;
	private static final int DESCRIPTION_LENGTH = 50;
	
	// data variables for each task
	private String taskID;
	private String taskName;
	private String description;
	
	// place holder for empty values
	private static final String NO_VALUE_STRING = "No Value";
	
	/***********************************************************************
	 * constructor method for placeholder creation with no values
	 ***********************************************************************/
	Task(){
		this.taskID = NO_VALUE_STRING;
		this.taskName = NO_VALUE_STRING;
		this.description = NO_VALUE_STRING;
		
	}
	
	/***********************************************************************
	 * constructor method if nothing was inputed when first creating task
	 * except for their taskID that is uniquely generated
	 * 
	 * @param taskID - the unique ID for the task that was created
	 ***********************************************************************/
	Task(String taskID){
		if (taskID == null || taskID.length() > ID_LENGTH) {
			throw new IllegalArgumentException(String.format("Task ID cannot be null and can only be %d characters max!", ID_LENGTH));
		}
		
		this.taskID = taskID;
		this.taskName = NO_VALUE_STRING;
		this.description = NO_VALUE_STRING;
		
	}
	
	/************************************************************************
	 * constructor method when all values are inputed when creating a task
	 * done when a task is created with all required info
	 * this is the only option for users when creating a task object
	 * 
	 * @param taskID - the unique ID for the task that was created
	 * @param taskName - name of task
	 * @param description - description of task
	 ***********************************************************************/
	Task(String taskID, String taskName, String description){
		if (taskID == null || taskID.length() > ID_LENGTH) {
			throw new IllegalArgumentException(String.format("Task ID cannot be null and can only be %d characters max!", ID_LENGTH));
		}
		
		if (taskName == null || taskName.length() > NAME_LENGTH) {
			throw new IllegalArgumentException(String.format("Task name cannot be null and can only be %d characters max!", NAME_LENGTH));
		}
		
		if (description == null || description.length() > DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException(String.format("Task description cannot be null and can only be %d characters max!", DESCRIPTION_LENGTH));
		}
		
		this.taskID = taskID;
		this.taskName = taskName;
		this.description = description;
	}
	
	/********************************************************
	 * getter for task ID
	 * setter not needed since taskID cannot be updated
	 ********************************************************/
	public String getTaskID() {
		return this.taskID;
	}
	
	/****************************************************************
	 * getter and setter for task name
	 * setter will only update field if it meets length requirements
	 ****************************************************************/
	public String getTaskName() {
		return this.taskName;
	}
	public void setTaskName(String taskName) {	
		if (taskName == null || taskName.length() > NAME_LENGTH) {
			throw new IllegalArgumentException(String.format("Task name cannot be null and can only be %d characters max!", NAME_LENGTH));
		}
		
		this.taskName = taskName;
	}
	
	/****************************************************************
	 * getter and setter for task description
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
