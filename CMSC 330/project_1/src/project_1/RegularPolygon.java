/*
 * Created by: Antonio Scalfaro
 * CMSC 330
 * Project 1
 * 
 * This is the RegularPolygon class that extends the SolidPolygon class. It has a constructor that accepts
 * four parameters: Color, int numSides, Point center, int radius. It calls SolidPolygon's constructor with
 * color and numSides and then calculates the rest of the points of a regular polygon using the sin/cos of the
 * angle of the vertices of the polygon. Using a for loop, each x and y coordinate are added to their respective
 * arrays. 
 * */

package project_1;

import java.awt.*;

public class RegularPolygon extends SolidPolygon{

	public RegularPolygon(Color color, int numSides, Point center, int radius) {
		super(color, numSides);
		int[] x_coordinates = new int[numSides];
		int[] y_coordinates = new int[numSides];
		double theta = 2 * Math.PI / numSides;
		
		for (int i = 0; i < numSides; i++) {
			x_coordinates[i] = (int) Math.round(center.x + radius * Math.cos(i * theta));
			y_coordinates[i] = (int) Math.round(center.y + radius * Math.sin(i * theta));
		}
		createPolygon(x_coordinates, y_coordinates);
	}
}
