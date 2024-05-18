/*
 * Created by: Antonio Scalfaro
 * CMSC 330
 * Project 1
 * 
 * This is the Parallelogram class that extends the SolidPolygon class. It has a constructor that accepts
 * four parameters: Color, Point upper_left, Point upper_right, and int x_offset. The two remaining points
 * for the parallelogram are calculated using the given points and the x_offset.
 * */

package project_1;

import java.awt.*;

public class Parallelogram extends SolidPolygon{

	public Parallelogram(Color color, Point upper_left, Point lower_right, int x_offset) {
		super(color, 4);
		int[] x_coordinates = {upper_left.x, upper_left.x + x_offset, lower_right.x, lower_right.x - x_offset };
		int[] y_coordinates = {upper_left.y, upper_left.y, lower_right.y, lower_right.y};
		createPolygon(x_coordinates, y_coordinates);
	}
}
