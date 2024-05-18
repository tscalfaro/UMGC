/*
 * Created by: Antonio Scalfaro
 * CMSC 330
 * Project 1
 * 
 * This is the IsoscelesTriangle class that extends the SolidPolygon class. It contains a constructor that
 * accepts four parameters, Color, Point, int height, int width. The constructor calculates the x and y 
 * coordinates of the additional verticees by using the provided height and width.
 * */

package project_1;

import java.awt.*;

public class IsoscelesTriangle extends SolidPolygon{

	public IsoscelesTriangle(Color color, Point top_vertex, int height, int width) {
		super(color, 3);
		int[] x_points = {top_vertex.x, top_vertex.x + (int) Math.ceil(.5 * width), top_vertex.x - (int) Math.ceil(.5 * width)};
	    int[] y_points = {top_vertex.y, top_vertex.y + (int) Math.ceil(.5 * height), top_vertex.y + (int) Math.ceil(.5 * height)};
	    createPolygon(x_points, y_points);
	}
}
