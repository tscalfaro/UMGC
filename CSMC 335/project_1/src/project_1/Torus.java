/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Torus class which extends the ThreeDimensionalShape abstract class. It has 2 private fields,
 * double majorRadius and minorRadius, and has 6 public methods:
 * Torus(double, double) - Constructor
 * double getMajorRadius() - Getter for major radius
 * double getMinorRadius() - Getter for minor radius
 * void setMajorRadius(double) - Setter for major radius
 * void setMinorRadius(double) - Setter for minor radius
 * double getVolume() - Overriden abstract method that calculates the volume of the Torus rounded to 
 * 						2 decimals.
 * */

package project_1;

public class Torus extends ThreeDimensionalShape{

	private double majorRadius;
	private double minorRadius;
	
	public Torus(double majorRadius, double minorRadius) {
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}
	
	public double getMajorRadius() {
		return majorRadius;
	}
	
	public double getMinorRadius() {
		return minorRadius;
	}
	
	public void setMajorRadius(double majorRadius) {
		this.majorRadius = majorRadius;
	}
	
	public void setMinorRadius(double minorRadius) {
		this.minorRadius = minorRadius;
	}
	
	@Override
	public double getVolume() {
		return Math.ceil((2 * Math.PI * majorRadius) * 
				(Math.PI * (minorRadius * minorRadius)) * 100) / 100;
	}
}
