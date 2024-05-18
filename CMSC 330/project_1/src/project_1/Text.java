/*
 * Created by: Antonio Scalfaro
 * CMSC 330
 * Project 1
 * 
 * This is the Text class which extends Image. It has a constructor that takes 3 parameters, Color, Point, and a String.
 * It implements the abstract method draw from the Image class and draws the text using the Graphics drawString() method.
 * */

package project_1;

import java.awt.*;

public class Text extends Image{

	Point upper_left;
	String text;
	Label label;
	
	public Text(Color text_color, Point upper_left, String text) {
		super(text_color);
		this.upper_left = upper_left;
		this.text = text;
	}
	
	public void draw(Graphics graphics) {
		colorDrawing(graphics);
		graphics.drawString(text, upper_left.x, upper_left.y);
	}
}
