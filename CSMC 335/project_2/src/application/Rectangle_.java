/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Rectangle_ class that extends the javaFX Rectangle class. It has a constructor that accepts
 * 2 doubles radius and height and calls the Rectangle constructor via super().
 * */

package application;

import javafx.scene.shape.Rectangle;

public class Rectangle_ extends Rectangle{

	public Rectangle_(double width, double length) {
		super(0, 0, width, length);
	}
}
