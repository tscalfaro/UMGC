/*
 * Created By: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Torus class, it has 3 class fields, double majorRadius, minorRadius and Image image.
 * It has getters for all fields and setters for the majorRadius and minorRadius. There is one 
 * constructor that accepts two doubles for majorRadius and minorRadius.
 * */

package application;

import javafx.scene.image.Image;

public class Torus {

	private double majorRadius;
	private double minorRadius;
	private Image image = new Image("/application/torus.png");
	
	public Torus(double majorRadius, double minorRadius) {
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}
	
	public double getMajorRadius() {
		return majorRadius;
	}
	
	public double getMinorRadius() {
		return minorRadius;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setMajorRadius(double majorRadius) {
		this.majorRadius = majorRadius;
	}
	
	public void setMinorRadius(double minorRadius) {
		this.minorRadius = minorRadius;
	}
}
