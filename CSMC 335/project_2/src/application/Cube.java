/*
 * Created By: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Cube class, it has two fields: double side and Image image. It has getters for both fields and 
 * a setter for side. It has a constructor that accepts a double side.
 * */

package application;

import javafx.scene.image.*;

public class Cube {

	private double side;
	private Image image = new Image("/application/cube.png");
	
	public Cube(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	public Image getImage() {
		return image;
	}
}
