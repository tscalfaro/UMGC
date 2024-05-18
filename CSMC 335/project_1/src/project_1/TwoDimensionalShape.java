/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the abstract TwoDimensionalShape class that extends the Shape class. It has a constructor
 * and declares an abstract method double getArea().
 * */

package project_1;

public abstract class TwoDimensionalShape extends Shape{
	
	public TwoDimensionalShape() {
		super(2);
	}
	
	public abstract double getArea();
}
