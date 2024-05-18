/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Sphere class which extends ThreeDimensionalShapes abstract class. It has 1 private field,
 * double radius, and 4 public methods:
 * Sphere(double) - Constructor
 * double getRadius() - Getter for radius
 * void setRadius(double) - Setter for radius
 * double getVolume() - Overriden abstract method that calculates the volume of the Sphere rounded to 
 * 						2 decimals.
 * */

package project_1;

public class Sphere extends ThreeDimensionalShape{

	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getVolume() {
		return Math.ceil((4/3) * Math.pow(radius, 3) * Math.PI * 100) / 100;
	}
}
