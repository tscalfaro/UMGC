/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 4 - Time Interval Checker
 * 
 * This is the JUnit test class Project4_UnitTest. It has 4 tests and tests 3 classes: Interval, Time, InvalidTime. 
 * The first test checks if all the methods of the Interval class operate as desired. The second test checks if the
 * Time class method to24Hours() operates as desired. The third test checks if the Time toString method operates 
 * correctly and also tests the InvalidTime class by attempting to create an invalid time. The fourth test checks if 
 * the Time compareTo method works as desired.
 * */

package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class Project4_UnitTest {

	@Test
	public void testInterval() throws InvalidTime {
		Interval t = new Interval(new Time("12:00 PM"), new Time("2:00 PM")); // control interval
		Time time = new Time("1:30 PM"); // time within control interval
		Interval t2 = new Interval(new Time("12:03 PM"), new Time("1:50 PM")); // fully within interval
		Interval t3 = new Interval(new Time("10:00 AM"), new Time("11:58 AM")); // fully outside interval
		Interval t4 = new Interval(new Time("12:30 PM"), new Time("12:50 PM")); // overlap interval
		
		boolean a = t.within(time);
		boolean b = t.subinterval(t4);
		boolean c = t.overlaps(t4);
		boolean d = t.overlaps(t3);
		
		assertEquals(true, a);
		assertEquals(true, b);
		assertEquals(true, c);
		assertEquals(false, d);
		
	}
	
	@Test
	public void testTimeTo24Hours() throws InvalidTime {
		Time t = new Time("2:00 PM");
		Time t2 = new Time("2:00 AM");
		
		String a = t.to24Hours();
		String b = t2.to24Hours();
		assertEquals("0200", b);
		assertEquals("1400", a);
	}
	@Test
	public void testTimeToString() throws InvalidTime {
		Time t = new Time("12:03 PM"); // String constructor
		Time t2 = new Time(3, 58, "AM"); // int, int, String constructor
		assertThrows(InvalidTime.class, () -> {
			new Time(0, 61, "AM"); //Invalid time
		});
		
		String a = t.toString();
		String b = t2.toString();
		
		assertEquals("12:03 PM", a);
		assertEquals("03:58 AM", b);	
	}
	
	@Test
	public void testTimeCompareTo() throws InvalidTime {
		Time t = new Time("12:03 PM");
		Time t2 = new Time("12:03 AM");
		Time t3 = new Time(12, 03, "PM");
		
		assertEquals(1, t.compareTo(t2)); // t later than t1
		assertEquals(-1, t2.compareTo(t)); // t1 earlier than t
		assertEquals(0, t.compareTo(t3)); // t equal to t3
	}
}
