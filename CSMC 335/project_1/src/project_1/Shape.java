/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the Shapes class, it has 1 protected field, numberOfDimensions, and 3 public methods:
 * Shape(int) - Constructor
 * int getNumberOfDimensions() - Getter for numberOfDimensions
 * void setNumberOfDimensions(int) - Setter for numberOfDimensions 
 * */

package project_1;

public class Shape {

	protected int numberOfDimensions;
	
	public Shape(int numberOfDimensions) {
		this.numberOfDimensions = numberOfDimensions;
	}
	
	public int getNumberOfDimensions() {
		return numberOfDimensions;
	}
	
	public void setNumberOfDimensions(int numberOfDimensions) {
		this.numberOfDimensions = numberOfDimensions;
	}
}
