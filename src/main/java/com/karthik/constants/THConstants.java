package com.karthik.constants;

public class THConstants {
	public static final String URLIP="http://192.168.2.68:8080/HSignzAppServices/";
	public static final String URLPAYU="http://192.168.1.102:8080/POZApp/schedulecontrol/getpaymentstatusfrompayu";
	
	public static final String STATUSKEY="statusCode";
	public static final int STATUS200=200;
	
	public static final int STATUS201=201;
	
	public static final int STATUS405=405;
	public static final int STATUS500=500; //Internal Server Error
	public static final int STATUS404 = 404;
	public static final int ERROR_UNAUTHORIZED = 401;
	public static final int STATUS524 =524;// A Timeout Occurred;

	public static final String SESSION_GEN_FAILED="Session Id Generation Failed";
	public static final String MSG="statusMessage";
	public static final String DESCRIPTION_MSG="Doctor Name: Dr. %1$ss, Poc Name: %2$s, Booking Id: %3$s"
			+ ", Date: %4$s, Time: %5$s, Contact: %6$s, Room Number: %7$s";
	
	public static final String TIME_EXPIRED="Time Expired";
	public static final String UPDATECALENDER="account/updateslotincalendar";
	public static final String SUCCESS="Successful";
	public static final String FAILS="Fails";
	public static final String INSERTION_FAILED="Insertion Failed";
	public static final String INSERTION_SUCCESS="Inserted Successfully";
	public static final String UPDATE_SUCCESS="Successfully updated";
	public static final String UPDATE_FAILED="Updation Failed";
	public static final String EMP_DETAILS_UPDATED="Employee Deatils Updated";
	public static final String ID_EXISTS="EmployeeId already Exists";
	public static final String TIME_GOT_OVER="Time got over";
	public static final Object SLOT_HAS_BEEN_EXPIRED = "Slot has been expired.";
	public static final String NOTIFICATION_MSG="You have an appointment with doctor";
	public static final String APPOINTMENT_DR="Appointment Dr. ";
	public static final String IN_CLINIC="";
	
	public static final long SLOTTIME=1800000;
	public static final long SEVENDAYPERIOD=604800000;
	public static final long ONEDAYINMILLI=86400000;
	public static final int ONEDAYPERIODINSECONDS=86400;
	public static final long FIVEMINUTESPERIODINMILLI=300000;
	public static final int EIGHTDAYPERIOD = 691200000;
	public static final long DURATION = 900000;

	public static final Object STATUS401 = "auhentication Error" ;
	
	public static final String NOTIFICATION_MESSAGE_FOR_MEDIA_CHAT = "%1$s is Available For %2$s Chat";
	private  THConstants() {
		super();
		// TODO Auto-generated constructor stub
	}


}
