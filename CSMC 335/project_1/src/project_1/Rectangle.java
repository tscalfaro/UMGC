/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Rectangle class that extends the TwoDimensionalShape abstract class. It has 2 private
 * fields, double length and width, and has 6 public methods:
 * Rectangle(double, double) - Constructor
 * double getLength() - Getter for length
 * double getWidth() - Getter for width
 * void setLenght(double) - Setter for length
 * void setWidth(double) - Setter for width
 * double getArea() - Overriden abstract method that calculates the area of the Rectangle rounded to 2
 * 					  decimals.
 * */

package project_1;

public class Rectangle extends TwoDimensionalShape{

	private double length;
	private double width;
	
	public Rectangle(double len, double wid) {
		this.length = len;
		this.width = wid;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setLength(double len) {
		this.length = len;
	}
	
	public void setWidth(double wid) {
		this.width = wid;
	}
	
	@Override
	public double getArea() {
		return Math.ceil(length * width * 100) / 100;
	}
}
