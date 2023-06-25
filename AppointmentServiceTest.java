import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
	// variables for tests
	private String appointmentID1 = "1A34c678p0";
	private String appointmentID2 = "1A34c679p0";
	private String wrongAppointmentID = "1A34c078p0";
	private Date date = new Date();
	private String description = "A description within the 50 character limit.";
	
	@Test
	void testAddAppointment() {
		Calendar calendar = Calendar.getInstance();   
		
		// get a date in 15 days which will be valid
		calendar.add(Calendar.DATE, 15);
		date = calendar.getTime();
		AppointmentService service = new AppointmentService();
		
		// test for adding an appointment with ID constructor
		service.addAppointment(appointmentID1);
		service.addAppointment(appointmentID1); //runs if statement since appointmentID already exists
		
		// test for adding an appointment with full constructor
		service.addAppointment(appointmentID2, date, description);
		service.addAppointment(appointmentID2, date, description); //runs if statement since appointmentID already exists
		
	}
	
	@Test
	void testSearchAppointment() {
	    AppointmentService service = new AppointmentService();
	    
	    // add appointment and get the size of the current list
	    service.addAppointment(appointmentID1);
	    int appointmentListSize = service.getAppointmentList().size();
	    
	    // search appointment that is guaranteed in the list
	    service.searchAppointmentID(service.getAppointmentList().get(appointmentListSize-1).getAppointmentID());
	    
	    // throw error if appointment is not in the list
	    assertThrows(IllegalArgumentException.class, () -> {
	    	service.searchAppointmentID(wrongAppointmentID);
	    });
	}
	
	@Test
	void testRemoveAppointment(){
	    AppointmentService service = new AppointmentService();
	    
	    // add appointment and get the size of the current list
	    service.addAppointment(appointmentID1);
	    int appointmentListSize = service.getAppointmentList().size();
	    
	    // test remove appointment in the list
	    service.removeAppointment(service.getAppointmentList().get(appointmentListSize-1).getAppointmentID());
	    
	}
}
