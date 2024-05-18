/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 4 - Time Interval Checker
 * 
 * This is the InvalidTime class that extends Exception. There is one private class variable: message. There is 1 constructor
 * method which accepts a String and sets it to message. There is one getter method that return message.
 * */

package application;

public class InvalidTime extends Exception {
	private final String message;
	
	public InvalidTime(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
