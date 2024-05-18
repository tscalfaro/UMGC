/*
 * Created by: Antonio Scalfaro
 * Due - 03/26/2024
 * CMSC 335
 * Project 1 - Shapes
 * This is the class that extends the TwoDimensionalShape abstract class. It has 3 private
 * fields, double leg1, leg2, and leg3, and has 8 public methods:
 * Triangle(double, double, double) - Constructor
 * double getLeg1() - Getter for leg1
 * double getLeg2() - Getter for leg2
 * double getLeg3() - Getter for leg3
 * void setLeg1(double) - Setter for leg1
 * void setLeg2(double) - Setter for leg2
 * void setLeg3(double) - Setter for leg3
 * double getArea() - Overriden abstract method that calculates the area of the Triangle, using Herron's
 * 					  formula, rounded to 2 decimals
 * */

package project_1;

public class Triangle extends TwoDimensionalShape{

	private double leg1;
	private double leg2;
	private double leg3;
	
	public Triangle(double leg1, double leg2, double leg3) {
		this.leg1 = leg1;
		this.leg2 = leg2;
		this.leg3 = leg3;
	}
	
	public double getLeg1() {
		return leg1;
	}
	
	public double getLeg2() {
		return leg2;
	}
	
	public double getLeg3() {
		return leg3;
	}
	
	public void setLeg1(double leg1) {
		this.leg1 = leg1;
	}
	
	public void setLeg2(double leg2) {
		this.leg2 = leg2;
	}
	
	public void setLeg3(double leg3) {
		this.leg3 = leg3;
	}
	
	@Override
	public double getArea() {
		double s = (leg1 + leg2 + leg3) / 2;
		return Math.ceil(Math.sqrt(s * (s - leg1) * (s - leg2) * (s - leg3)) * 100) / 100;
	}
}
