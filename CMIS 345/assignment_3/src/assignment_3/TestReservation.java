package assignment_3;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestReservation {

	private static String datePattern = "MMM dd, yyyy";
	private static SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		testConstructorAndGetters();
		testSettersAndGetters();
		testReservationBillAmount();
		testReservationNumberOfDays();
	}
	
	
	public static void testConstructorAndGetters() {
		
		System.out.println();
		System.out.println("Testing Constructor and Getters");
		System.out.println("----------------------------------------");
		Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
		Reservation r2 = new Reservation(7, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
		Reservation r3 = new Reservation(9, "NormalRoom", "Jun 17, 2022", "Jun 20, 2022");
		Assert.assertNotEqualsUUID(r.getReservationID(), r2.getReservationID());
		Assert.assertEqualsDate(r.getReservationDate(), new Date());
		Assert.assertNotEqualsString(r.getReservationStartDate(), r3.getReservationStartDate());
		Assert.assertEqualsInt(r.getGuestID(), 1);
		Assert.assertNotEqualsInt(r.getGuestID(), r2.getGuestID());
		Assert.assertEqualsString(r.getRoomType(), r2.getRoomType());
		Assert.assertEqualsString(r.getReservationStartDate(), r2.getReservationStartDate());
		Assert.assertEqualsString(r.getReservationEndDate(), r2.getReservationEndDate());
	}
	
	public static void testReservationBillAmount() {
		
		System.out.println();
		System.out.println("Testing Calculate Reservation Bill Amount");
		System.out.println("----------------------------------------");
		Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
		Reservation r2 = new Reservation(7, "RoomWView", "Jun 16, 2022", "Jun 19, 2022");
		Reservation r3 = new Reservation(9, "NormalRoom", "Jun 16, 2022", "Jun 19, 2022");
		try {
			Assert.assertNotEqualsDouble(r.calculateReservationBillAmount(), r2.calculateReservationBillAmount());
			Assert.assertNotEqualsDouble(r2.calculateReservationBillAmount(), r3.calculateReservationBillAmount());
			Assert.assertEqualsDouble(r.calculateReservationBillAmount(), 600.00);
			Assert.assertEqualsDouble(r2.calculateReservationBillAmount(), 525.00);
			Assert.assertEqualsDouble(r3.calculateReservationBillAmount(), 375.00);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testSettersAndGetters() {
		System.out.println();
		System.out.println("Testing Setters and Getters");
		System.out.println("----------------------------------------");
		Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
		r.setCustomerID(2);
		Assert.assertEqualsInt(r.getGuestID(), 2);
		r.setRoom("RoomWView");
		Assert.assertEqualsString(r.getRoomType(), "RoomWView");
		r.setReservationStartDate("Jun 17, 2022");
		Assert.assertEqualsString(r.getReservationStartDate(), "Jun 17, 2022");
		r.setReservationEndDate("Jun 20, 2022");
		Assert.assertEqualsString(r.getReservationEndDate(), r.getReservationEndDate());
	}
	
	public static void testReservationNumberOfDays() {
		
		System.out.println();
		System.out.println("Testing Calculate Reservation Number of Days");
		System.out.println("----------------------------------------");
		Reservation r = new Reservation(1, "RoomWBath", "Jun 16, 2022", "Jun 19, 2022");
		Reservation r2 = new Reservation(7, "RoomWView", "Jun 16, 2022", "Jun 19, 2022");
		Reservation r3 = new Reservation(9, "NormalRoom", "Jun 16, 2022", "Jun 24, 2022");
		try {
			Assert.assertEqualsLong(r.calculateReservationNumberOfDays(), 3);
			Assert.assertEqualsLong(r2.calculateReservationNumberOfDays(), r.calculateReservationNumberOfDays());
			Assert.assertEqualsLong(r3.calculateReservationNumberOfDays(), 8);
			Assert.assertNotEqualsLong(r.calculateReservationNumberOfDays(), r3.calculateReservationNumberOfDays());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}