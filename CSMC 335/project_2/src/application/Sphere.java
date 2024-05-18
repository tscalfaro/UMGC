/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Sphere class that has 2 fields: double radius and Image image. There are getters for both
 * fields and a setter for radius. The constructor accepts a double radius.
 * */

package application;

import javafx.scene.image.Image;

public class Sphere {

	private double radius;
	private Image image = new Image("/application/sphere.png");
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
