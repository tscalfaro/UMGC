/*
 * Created by: Antonio Scalfaro
 * CMSC 315 / 6380
 * 02/13/2024
 * Project 2 - Maximal Points
 * 
 * This is the Point class implements Comparable<Point>. It has two class variables, double
 * x and double y which will represent coordinates. It has 5 class methods:
 * Point(double, double) - Constructor
 * getX() - Getter for x value
 * getY() - Getter for y value
 * maximalPoint(Point) - Returns a boolean if the current Point is considered maximal compared
 * 						 to the Point passed.
 * */

package application;

public class Point implements Comparable<Point> {

	private double x = 0.0;
	private double y = 0.0;
	
	//Constructor for Point
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//Return x-coordinate
	public double getX() {
		return x;
	}
	
	//Return y-coordinate
	public double getY() {
		return y;
	}
	
	//Check if this Point is maximal compare to given Point p
	//i.e given point p x-coordinate is left of this Point and 
	//y-coordinate is below this Point
	public boolean maximalPoint(Point p) {
		return this.y > p.getY() && this.x < p.getX();
	}
	
	@Override
	public int compareTo(Point p) {
		return Double.compare(this.x, p.getX());
	}
}
