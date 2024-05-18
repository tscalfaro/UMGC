/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Circle class that extends the TwoDimensionalShape abstract class. It has 1 field,
 * double radius, and has 4 public methods:
 * Circle(double) - Constructor
 * double getRadius() - Getter for radius
 * void setRadius() - Setter for radius
 * double getArea() - Overriden abstract method that returns the area of the Circle, rounded 2 decimals
 * */

package project_1;

public class Circle extends TwoDimensionalShape{

	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.ceil(Math.PI * (radius * radius) * 100) / 100;
	}
}
