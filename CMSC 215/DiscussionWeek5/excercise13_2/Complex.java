/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * 09/15/2023
 * Discussion Week 5 - excercise 13.2
 * 
 * This program is composed of a Complex class that implements addition, subtraction, multiplication,
 * and division of complex numbers. The class contains methods for all of those including absolute
 * value method and overriden toString, compareTo, and clone methods. It contains three constructors
 * Complex(), Complex(double), Complex(double, double)
 * */

package excercise13_2;

import java.math.*;

public class Complex implements Cloneable, Comparable<Complex> {
	private double real;
	private double imaginary;
	
	//Constructors
	public Complex(double a) {
		this(a, 0.0);
	}

	public Complex(double a, double b) {
		this.real = a;
		this.imaginary = b;
	}
	
	public Complex() {
		this(0.0, 0.0);
	}
	
	//Getters
	public double getRealPart() {
		return this.real;
	}
	
	public double getImaginaryPart() {
		return this.imaginary;
	} 
	
	//Operation Methods
	//Addition Formula: a + bi + c + di = (a + c) + (b + d)i
	public Complex add(Complex other) {
		return new Complex(this.real + other.real, this.imaginary + other.imaginary);
	}
	
	//Subtraction formula: a + bi - (c + di) = (a - c) + (b - d)i
	public Complex subtract(Complex other) {
		return new Complex(this.real - other.real, this.imaginary - other.imaginary);
	}
	
	//Multiplication formula: (a + bi) * (c + di) = (ac - bd) + (bc + ad)i
	public Complex multiply(Complex other) {
		double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
		double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
		return new Complex(newReal, newImaginary);
	}
	
	//Division formula: (a+bi)/(c+di) = (ac+bd)/(c^2 +d^2) + (bc-ad)i/(c^2 +d^2) 
	public Complex divide(Complex other) {
		double denom = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);
		double newReal = ((this.real * other.real) + (this.imaginary * other.imaginary)) / denom;
		double newImaginary = ((this.imaginary * other.real) - (this.real * other.imaginary)) / denom;
		return new Complex(newReal, newImaginary);
	}
	
	public double abs() {
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
	}
	
	@Override
	public String toString() {
		if (imaginary == 0) {
			return Double.toString(real);
		} else if (real == 0) {
			return imaginary + "i";
		} else if (imaginary < 0) {
			return real + " - " + (-imaginary) + "i"; 
		} else {
			return real + " + " + imaginary + "i";
		}
	}

	//Implement Comparable, compare by abs
	@Override
	public int compareTo(Complex other) {
		return Double.compare(this.abs(), other.abs());
	}
	
	//Implement clone
	@Override
	public Complex clone() {
		return new Complex(this.real, this.imaginary);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex first = new Complex(10, 432);
		Complex second = new Complex(20, 140);
		
		System.out.println("The first complex number is " + first);
		System.out.println("The second complex number is " + second);
		
		System.out.println("Addition of the two: " + first.add(second));
		System.out.println("Subtraction of the two: " + first.subtract(second));
		System.out.println("Multiplication of the two: " + first.multiply(second));
		System.out.println("Division of the two: " + first.divide(second));
		System.out.println("Compare the two: " + first.compareTo(second));
		System.out.println("First number: " + first + " and its clone " + first.clone());
		
		Complex third = new Complex();
		Complex fourth = new Complex(34);
		
		System.out.println("The third complex is: " + third);
		System.out.println("The fourth complex is: " + fourth);
		
		
	}

}
