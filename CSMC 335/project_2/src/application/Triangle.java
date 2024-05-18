/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Triangle class that extends the javaFX Polygon class. It has a constructor that
 * accepts a double[] points and calls the Polygon constructor via super();
 * */

package application;

import javafx.scene.shape.Polygon;

public class Triangle extends Polygon{

	public Triangle(double[] points) {
		super(points);
	}
}
