/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Square class which extends the TwoDimensionalShape abstract class. It has 1 private field,
 * double sideLength, and 4 public methods:
 * Square(double) - Constructor
 * double getSideLength() - Getter for sideLength
 * void setSideLength(double) - Setter for sideLength
 * double getArea() - Overriden abstract method that calculates the area of the Square rounded to 2 decimals.
 * */

package project_1;

public class Square extends TwoDimensionalShape{

	private double sideLength;
	
	public Square(double sideLength) {
		this.sideLength = sideLength;
	}
	
	public double getSideLength() {
		return sideLength;
	}
	
	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
	
	@Override
	public double getArea() {
		return Math.ceil(sideLength * sideLength * 100) / 100;
	}
}
