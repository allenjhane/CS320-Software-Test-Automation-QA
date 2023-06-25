import java.util.ArrayList;
import java.util.List;

public class TaskService {

	private List<Task> taskList = new ArrayList<>();
	
	// list of IDs that have been created so a loop to search each task object is not needed for code
	// will just be used internally for verifying if given taskID already exists so no duplications are created
	private List<String> taskIDs = new ArrayList<>(); 
	
	/************************************************************************
	 * getter for taskList list
	 * setter not needed because object list has too much info, add method -
	 * is more convenient to add items to list, and required setters are in -
	 * place in class object
	 ************************************************************************/
	public List<Task> getTaskList(){
		return taskList;
	}
	
	
	/***********************************************************************
	 * method that generates a random alphanumeric string with given length
	 * this will be used to get a unique taskID for the program
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
        
        // return the unique id (task ID) to be used for task creation
        return uniqueID.toString();
    }
    
    /**********************************************************************
     * method that will add a task with a unique ID with no task info
     **********************************************************************/
    public void addTask(String taskID) {
    	
    	// loop to check and generate unique IDs for each task
    	while(true) {
    		
    		// if the taskID has already been created generate a new ID
    		if(taskIDs.contains(taskID)) {
    			taskID = generateID(10);
    		}
    		
    		// else if the ID is already unique create a new task
    		else {
    			// add the IDs to the existing id list
    			taskIDs.add(taskID);
    			
    			// create a new task and add it to the task list
    			Task task = new Task(taskID);
    			taskList.add(task);
    			
    			break;	
    		 }
    	}
    }
    
    /**********************************************************************
     * method that will add a task with a unique ID with no task info
     **********************************************************************/
    public void addTask(String taskID, String taskName, String description) {
    	
    	// loop to check and generate unique IDs for each task
    	while(true) {
    		
    		// if the taskID has already been created generate a new ID
    		if(taskIDs.contains(taskID)) {
    			taskID = generateID(10);
    		}
    		
    		// else if the ID is already unique create a new task
    		else {
    			// add the IDs to the existing id list
    			taskIDs.add(taskID);
    			
    			// create a new task and add it to the task list
    			Task task = new Task(taskID, taskName, description);
    			taskList.add(task);
    			
    			break;
    		 }
    	}
    }
    
    /***************************************************************************
     * method that will search for a task with the taskID given
     * note: no throw exception error needed in all other methods that use this
     * 		 method since that error will be accounted for when not found here
     * 
     * @param taskID - the ID that we will search for
     * @return returns that object that has that taskID if not an error
     ***************************************************************************/
    public Task searchTaskID(String taskID) {
    	
    	Task foundTask = new Task();
    	
    	// loop to look for the task that has the same taskID
    	for(int i = 0; i < taskList.size(); ++i) {
    		if(taskID == taskList.get(i).getTaskID()) {
    			foundTask = taskList.get(i);
    		}
    	}
    	
    	if(foundTask.getTaskID() == "No Value") {
    		throw new IllegalArgumentException("task does not exist in the list.");
    	}
    	else {
    		return foundTask;
    	}
    	
    }
    
    /**********************************************************
     * method that will remove a task based on the taskID
     * 
     * @param taskID - the task that will be removed
     **********************************************************/
    public void removeTask(String taskID) {
    	// will have an error if task was not found
    	Task task = searchTaskID(taskID);
    	
    	taskIDs.remove(taskID);
    	taskList.remove(task);
    	System.out.println("Task successfully removed.");

    }
    
    /****************************************************************************
     * method that will update the name of a task based on the taskID
     * 
     * @param taskID - the task that will be updated
     ****************************************************************************/
    public Task updateTaskName(String taskID, String newTaskName) {
    	Task task = searchTaskID(taskID);
    	
    	// change the name of the task if it was found
    	taskList.get(taskList.indexOf(task)).setTaskName(newTaskName);
    	System.out.println("Task name successfully updated.");
    	
    	return task;
    	
    }
    
    /****************************************************************************
     * method that will update the description of a task based on the taskID
     * 
     * @param description - the description of the task that will be updated
     ****************************************************************************/
    public Task updateDescription(String taskID, String newDescription) {
    	Task task = searchTaskID(taskID);
    	
    	// change the description of the task if it was found
    	taskList.get(taskList.indexOf(task)).setDescription(newDescription);
    	System.out.println("Description of task successfully updated.");
    	
    	return task;
    	
    }
}
