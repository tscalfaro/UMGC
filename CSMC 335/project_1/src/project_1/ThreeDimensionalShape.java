/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the abstract class ThreeDimensionalShape that extends the Shape class. It has a constructor
 * method and declares an abstract method, double getVolume().
 * */

package project_1;

public abstract class ThreeDimensionalShape extends Shape{

	public ThreeDimensionalShape() {
		super(3);
	}
	
	public abstract double getVolume();
}
