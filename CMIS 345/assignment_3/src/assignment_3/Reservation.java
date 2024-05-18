package assignment_3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Reservation {

	int guestID;
	String roomType;
	String reservationStartDate;
	String reservationEndDate;
	
	public Reservation(int guestID, String roomType, String reservationStartDate,
			String reservationEndDate) {
		setCustomerID(guestID);
		setRoom(roomType);
		setReservationStartDate(reservationStartDate);
		setReservationEndDate(reservationEndDate);
	}
	
	//getters
	public UUID getReservationID() {
		Random random = new Random();
		long randomLong = random.nextLong();
		long randomLong2 = random.nextLong();
		UUID uuid = null;
		try {
			uuid = new UUID(randomLong, randomLong2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uuid;
	}
	
	public Date getReservationDate() {
		Date date = new Date();
		return date;
	}
	
	public int getGuestID() {
		return guestID;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public String getReservationStartDate() {
		return reservationStartDate;
	}
	
	public String getReservationEndDate() {
		return reservationEndDate;
	}
	
	//setters
	public void setCustomerID(int newValue) {
		this.guestID = newValue;
	}
	
	public void setRoom(String newValue) {
		this.roomType = newValue;
	}
	
	public void setReservationStartDate(String newValue) {
		this.reservationStartDate = newValue;
	}
	
	public void setReservationEndDate(String newValue) {
		this.reservationEndDate = newValue;
	}
	
	public long calculateReservationNumberOfDays() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date resStartDate = dateFormat.parse(reservationStartDate);
		Date resEndDate = dateFormat.parse(reservationEndDate);
		
		long startTime = resStartDate.getTime();
		long endTime = resEndDate.getTime();
		
		long millisPerDay = 1000 * 60 * 60 * 24;
		long difference = endTime - startTime;
		
		long numberOfDays = difference / millisPerDay;
		return numberOfDays;
	}
	
	public double calculateReservationBillAmount() throws Exception {
		double total;
		double rate;
		long days;
		
		if (roomType == "RoomWBath") {
			rate = 200;
		} else if (roomType == "RoomWView") {
			rate = 175;
		} else {
			rate = 125;
		}
		
		days = calculateReservationNumberOfDays();
		total = days * rate;
		return total;
	}
}
