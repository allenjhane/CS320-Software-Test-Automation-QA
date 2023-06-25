import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {
	// variables for tests
	private String appointmentID = "1A34c678p0";	
	private Date futureDate = new Date();
	private String description = "A description within the 50 character limit.";
		
	private String longAppointmentID = "1A34c678p0F";
	private Date pastDate = new Date();
	private String longDescription = "A description not withing the 50 character limit for test validation.";
	
	@Test
	void testEmptyAppointmentConstructor() {
		Appointment Appointment = new Appointment();
		
		// test if any components are null
		assertNotNull(Appointment.getAppointmentID());	
		assertNotNull(Appointment.getDate());
		assertNotNull(Appointment.getDescription());
	}
	
	@Test
	void testAppointmentIDConstructor() {
		Appointment Appointment = new Appointment(appointmentID);
		
		// test appointmentID
		assertEquals(appointmentID, Appointment.getAppointmentID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(longAppointmentID);
	    });
		
		assertNotNull(Appointment.getDate());
		assertNotNull(Appointment.getDescription());
	}
	
	@Test
	void testFullappointmentIDConstructor() {
		
		// create a calendar class that will establish dates
		Calendar calendar = Calendar.getInstance();   
		
		// get an old date that will be invalid
		calendar.add(Calendar.DATE, -15);
		pastDate = calendar.getTime();
		
		// get a future date that will be valid
		calendar.add(Calendar.MONTH, 2);
		futureDate = calendar.getTime();
		
		// create an instance of appointment that will work based on dates from above
		Appointment appointment = new Appointment(appointmentID, futureDate, description);

		// test appointmentID
		assertEquals(appointmentID, appointment.getAppointmentID());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(null, futureDate, description);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(longAppointmentID, futureDate, description);
	    });
		
	    // test Date
	    assertEquals(futureDate, appointment.getDate());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(appointmentID, null, description);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	new Appointment(appointmentID, pastDate, longDescription);
	    });
	    
	    // test Appointment description
		assertEquals(description, appointment.getDescription());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(appointmentID, futureDate, null);
	    });
	    assertThrows(IllegalArgumentException.class, () -> {
	    	new Appointment(appointmentID, futureDate, longDescription);
	    });

	}
	
	// test for the Date setter
	@Test
	void testSetDate() {
		Calendar calendar = Calendar.getInstance();   
		
		// get an old date that will be invalid
		calendar.add(Calendar.DATE, -15);
		pastDate = calendar.getTime();
		
		// get a future date that will be valid for the month
		calendar.add(Calendar.MONTH, 2);
		futureDate = calendar.getTime();
		
		// create an instance of appointment that will work based on dates from above
	    Appointment appointment = new Appointment();
	    appointment.setDate(futureDate);
	    
	    assertEquals(futureDate, appointment.getDate());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	appointment.setDate(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	appointment.setDate(pastDate);
	    });
	}
	
	// test for the Appointment description setter
	@Test
	void testSetDescription() {
	    Appointment Appointment = new Appointment();
	    Appointment.setDescription(description);
	    
	    assertEquals(description, Appointment.getDescription());
	    assertThrows(IllegalArgumentException.class, () -> {
	    	Appointment.setDescription(null);
	    });
	    assertThrows(IllegalArgumentException.class,() -> {
	    	Appointment.setDescription(longDescription);
	    });
	}
}
