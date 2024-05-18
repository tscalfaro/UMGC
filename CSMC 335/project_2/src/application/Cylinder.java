/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Cylinder class that has 3 fields: doubles radius and height, and Image image. It has getters
 * for all fields and setters for radius and height. It has a constructor that accepts two doubles radius and height.
 * 
 * */

package application;

import javafx.scene.image.Image;

public class Cylinder {

	private double radius;
	private double height;
	private Image image = new Image("/application/cylinder.png");
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getHeight() {
		return height;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
}
