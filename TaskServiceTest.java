import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
	// variables for tests
	private String taskID1 = "1A34c678p0";
	private String taskID2 = "1A34c679p0";
	private String wrongTaskID = "1A34c078p0";
	private String taskName = "Create Software!";
	private String description = "A description within the 50 character limit.";
	
	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		
		service.addTask(taskID1);
		service.addTask(taskID1); //runs if statement since taskID already exists
		
		service.addTask(taskID2, taskName, description);
		service.addTask(taskID2, taskName, description); //runs if statement since taskID already exists
		
	}
	
	@Test
	void testSearchTask() {
	    TaskService service = new TaskService();
	    
	    service.addTask(taskID1);
	    int taskListSize = service.getTaskList().size();
	    
	    service.searchTaskID(service.getTaskList().get(taskListSize-1).getTaskID());
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	    	service.searchTaskID(wrongTaskID);
	    });
	}
	
	@Test
	void testRemoveTask(){
	    TaskService service = new TaskService();
	    
	    service.addTask(taskID1);
	    int taskListSize = service.getTaskList().size();
	    
	    service.removeTask(service.getTaskList().get(taskListSize-1).getTaskID());
	    
	}
	
	// don't need to test name length since it is already tested in the setter method
	@Test
	void testUpdateTaskName() {
	    TaskService service = new TaskService();
	    
	    service.addTask(taskID1);
	    int taskListSize = service.getTaskList().size();
	    
	    service.updateTaskName(service.getTaskList().get(taskListSize-1).getTaskID(), taskName);
	    assertEquals(service.getTaskList().get(0).getTaskName(), taskName);
	    
	    
	}
	
	// don't need to test description length since it is already tested in the setter method
	@Test
	void testUpdateDescription() {
	    TaskService service = new TaskService();
	    
	    service.addTask(taskID1);
	    int taskListSize = service.getTaskList().size();
	    
	    service.updateDescription(service.getTaskList().get(taskListSize-1).getTaskID(), description);
	    
	}
}
