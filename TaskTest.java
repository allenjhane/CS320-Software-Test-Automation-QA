import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskTest {

	
	// variables for tests
	private String taskID = "1A34c678p0";
	private String taskName = "Create Software!";
	private String description = "A description within the 50 character limit.";
		
	private String longTaskID = "1A34c678p0F";
	private String longTaskName = "Validate the software errors!";
	private String longDescription = "A description not withing the 50 character limit for test validation.";
	
	@Test
	void testEmptyTaskConstructor() {
		Task task = new Task();
		
		assertNotNull(task.getTaskID());	
		assertNotNull(task.getTaskName());
		assertNotNull(task.getDescription());
	}
	
	@Test
	void testTaskIDConstructor() {
		Task task = new Task(taskID);
		
		// test taskID
		assertEquals(taskID, task.getTaskID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(longTaskID);
	    });
		
		assertNotNull(task.getTaskName());
		assertNotNull(task.getDescription());
	}
	
	@Test
	void testFullTaskIDConstructor() {
		Task task = new Task(taskID, taskName, description);
		
		// test taskID
		assertEquals(taskID, task.getTaskID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(null, taskName, description);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(longTaskID, taskName, description);
	    });
		
	    // test taskName
		assertEquals(taskID, task.getTaskID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(taskID, null, description);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(taskID, longTaskName, description);
	    });
	    
	    // test task description
		assertEquals(taskID, task.getTaskID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(taskID, taskName, null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Task(taskID, taskName, longDescription);
	    });

	}
	
	// test for the taskName setter
	@Test
	void testSetTaskName() {
	    Task task = new Task();
	    task.setTaskName(taskName);
	    
	    assertEquals(taskName, task.getTaskName());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	task.setTaskName(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	task.setTaskName(longTaskName);
	    });
	}
	
	// test for the task description setter
	@Test
	void testSetDescription() {
	    Task task = new Task();
	    task.setDescription(description);
	    
	    assertEquals(description, task.getDescription());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	task.setDescription(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	task.setDescription(longDescription);
	    });
	}
}
