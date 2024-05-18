/*
 * Created by: Antonio Scalfaro
 * CMSC 330
 * Project 1
 * 
 * This is the SolidPolygon class that extends Polygon_. It calls the Polygon_ constructor using super and then implements
 * the abstract method drawPolygon(), drawing and filling the polygon using Graphics methods.
 * */

package project_1;

import java.awt.*;

public class SolidPolygon extends Polygon_{
	
	public SolidPolygon(Color color, int vertexCount) {
		super(color, vertexCount);
	}
	
	@Override
	public void drawPolygon(Graphics graphics, Polygon polygon) {
		graphics.drawPolygon(polygon);
		graphics.fillPolygon(polygon);
	}
}
