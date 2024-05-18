/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 4 - Time Interval Checker
 * 
 * This is the generic Interval class that extends Time that implements Comparable. This class contains two private class
 * variables, start & end of type Time. There is one constructor which takes two Time objs and sets them to start and end.
 * Two getters, one for each variable and three class methods. The within() method checks to see if a given time falls 
 * within this interval. The overlaps() method checks to see if the given Interval overlaps with this interval. Lastly,
 * the subinterval() method checks to see if a given Interval is a subinterval of this interval
 * */

package application;

public class Interval<TypeTime extends Time> {
	private TypeTime start;
	private TypeTime end;
	
	//Constructor
	public Interval(TypeTime start, TypeTime end) {
		this.start = start;
		this.end = end;
	}
	
	//Getters
	public TypeTime getStart() {
		return start;
	}
	
	public TypeTime getEnd() {
		return end;	
	}
	
	//Check if Time value falls within this interval
	public boolean within(TypeTime value) {
		//Change times to 24 hour clock
		int thisStart24 = Integer.parseInt(this.getStart().to24Hours());
	    int thisEnd24 = Integer.parseInt(this.getEnd().to24Hours());
	    int value24 = Integer.parseInt(value.to24Hours());

	    return value24 >= thisStart24 && value24 <= thisEnd24;
	}
	
	//Check if Interval is subinterval of this Interval
	public boolean subinterval(Interval<TypeTime> other) {
		//Convert times to 24 hour clock
		int thisStart24 = Integer.parseInt(this.getStart().to24Hours());
	    int thisEnd24 = Integer.parseInt(this.getEnd().to24Hours());
	    int otherStart24 = Integer.parseInt(other.getStart().to24Hours());
	    int otherEnd24 = Integer.parseInt(other.getEnd().to24Hours());

	    return otherStart24 >= thisStart24 && otherEnd24 <= thisEnd24;
	}
	
	//Check if Interval overlaps this interval
	public boolean overlaps(Interval<TypeTime> other) {
		//Convert times to 24 hour clock
		int thisStart24 = Integer.parseInt(this.start.to24Hours());
	    int thisEnd24 = Integer.parseInt(this.end.to24Hours());
	    int otherStart24 = Integer.parseInt(other.getStart().to24Hours());
	    int otherEnd24 = Integer.parseInt(other.getEnd().to24Hours());

	    return thisEnd24 >= otherStart24 && thisStart24 <= otherEnd24;
	}
}
