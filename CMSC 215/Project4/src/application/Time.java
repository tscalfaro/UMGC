/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 4 - Time Interval Checker
 * 
 * This is the Time class which implements Comparable. It has 3 private class variables, hours, minutes and meridian.
 * It has 2 constructors, one that accepts 2 ints (hours and minutes) and a String (meridian), and the other which 
 * accepts a string. Both constructors throw InvalidTime exceptions if the data is in incorrect format. There are getters
 * for all 3 variables. There are 4 class methods. The first is to24Hours() which converts this time into 24 hour clock
 * format and returns it as a String. The second is compareTo which compares this time to a given time and returns an int
 * 1, 0, -1 depending on outcome. The third is the toString() method which returns the time as a String in the traditional
 * clock format (1:00 PM). The fourth is validateTime() which has a void return type and ensures that a given time is a 
 * valid time (I.e it rejects 12:61 PM). 
 * */

package application;

public class Time implements Comparable<Time>{
	private final int hours;
	private final int minutes;
	private final String meridian;
	
	//Constructors, throws InvalidTime Exceptions
	public Time(int hours, int minutes, String meridian) throws InvalidTime {
		try {
			validateTime(hours, minutes, meridian);
		} catch (InvalidTime e) {
			// TODO Auto-generated catch block
			throw e;
		}
		this.hours = hours;
		this.minutes = minutes;
		this.meridian = meridian;
	}
	
	public Time(String timeString) throws InvalidTime {
		String[] parts = timeString.split(" "); //Split hours and minutes away from meridian
		//If not size 2, invalid timeString entered
		if(parts.length != 2) {
			throw new InvalidTime("Invalid Time Format");
		}
		
		String[] timeParts = parts[0].split(":"); //Split hours from minutes
		//If not size 2, invalid time entered
		if(timeParts.length != 2) {
			throw new InvalidTime("Invalid Time Format");
		}
		
		//Try parsing ints from string, else NumericFormatException thrown
		try {
			this.hours = Integer.parseInt(timeParts[0]);
			this.minutes = Integer.parseInt(timeParts[1]);
		}catch(NumberFormatException e) {
			throw new InvalidTime("Invalid numeric value for hours or minutes");
		}
		//validate all parts of time and set meridian
		validateTime(hours, minutes, parts[1]);
		this.meridian = parts[1];
	}
	
	//Getters
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public String getMeridian() {
		return meridian;
	}
	
	//Convert time to 24 hour clock time and return as String
	public String to24Hours() {
		int hour24 = (meridian.equals("AM") && hours == 12) ? 0 : (meridian.equals("PM") && hours != 12) ? hours + 12 : hours;
	    String hourString = String.format("%02d", hour24);
	    String minuteString = String.format("%02d", minutes);
	    return hourString + minuteString;
	}
	//Compare this time to given time
	@Override
	public int compareTo(Time other) {
		if (this.meridian.equals("AM") && other.meridian.equals("PM")) {
            return -1;
        } else if (this.meridian.equals("PM") && other.meridian.equals("AM")) {
            return 1;
        } else {
            if (this.hours != other.hours) {
                return Integer.compare(this.hours, other.hours);
            } else {
                return Integer.compare(this.minutes, other.minutes);
            }
        }
	}
	
	//Return string in 12 hour clock format
	@Override
	public String toString() {
		return String.format("%02d:%02d %s", hours, minutes, meridian);
	}
	
	//Validate if given hours, minutes, and meridian are appropriate for 12 hour clock
	private void validateTime(int hours, int minutes, String meridian) throws InvalidTime {
		if(hours < 1 || hours > 12 || minutes < 0 || minutes > 59 || 
				(!meridian.equals("AM") && !meridian.equals("PM"))) {
			throw new InvalidTime("Invalid Time Input");
		}
	}
}
