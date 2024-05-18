/*
 *Created by: Antonio Scalfaro
 *Due - 03/26/2024
 *CMSC 335
 *Project 1 - Shapes
 *This is the Cone class that extends the ThreeDimensionalShape abstract class. It has 2 private fields,
 *double radius, height, and it has 6 public methods:
 *Cone(double, double) - Constructor
 *double getRadius() - Getter for radius
 *double getHeight() - Getter for height
 *void setRadius(double) - Setter for radius
 *void setHeight(double) - Setter for height
 *double getVolume() - Overriden abstract method that calculates and returns the volume of the Cone 
 *					   rounded to 2 decimals.
 * */

package project_1;

public class Cone extends ThreeDimensionalShape{

	private double radius;
	private double height;
	
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getVolume() {
		return Math.ceil(Math.PI * (radius * radius) * (height/3) * 100) / 100;
	}
}
