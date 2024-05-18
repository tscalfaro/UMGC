/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Cube class that extends the ThreeDimensionalShape abstract class. It has one private field,
 * double side, and has 4 public methods:
 * Cube(double) - Constructor
 * double getSide() - Getter for side
 * void setSide(double) - Setter for side
 * double getVolume() - Overriden abstract method that calculates the volume of the Cube rounded to 2 decimals
 * */

package project_1;

public class Cube extends ThreeDimensionalShape{

	private double side;
	
	public Cube(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	@Override
	public double getVolume() {
		return Math.ceil(Math.pow(side, 3) * 100) / 100;
	}
}
