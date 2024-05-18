/*
 * Created by: Antonio Scalfaro
 * CMSC 315 / 6380
 * 02/13/2024
 * Project 2 - Maximal Points
 * 
 * This is the PointPane class that extends Pane. It has two class variables, ArrayList<Point>
 * pointSet and ArrayList<Point> maximalSet. There are 7 class methods:
 * PointPane(ArrayList<Point>) - Constructor
 * layoutChildren() - Overriden method that ensures the correct value for getHeight() is given for the
 * 					  initial data set by listening for layout changes.
 * createMaximalSet() - Determines if each Point in the pointSet is maximal and adds it to the
 * 						maximalSet. Returns sorted maximalSet.
 * drawPane() - Clears previous children, then adds each Point in the pointSet as Circles. Then
 * 				checks if there are Points in maximalSet, if there are it creates a PolyLine that
 * 				connects all maximal Points together. It connects the Polyline to edge of the GUI
 * 				Pane at the left most maximal point (left pane edge) and right most maximal point
 * 				(bottom pane edge).
 * handleMouseClick(MouseEvent) - Handles any MouseClick events from the GUI. Checks if it is a
 * 								  left click (Primary) or right click (Secondary) and either adds
 * 								  a point at that event location or removes the closest point to 
 * 								  that event location. Redraws the pane after any MouseClick.
 * removeClosestPoint(double, double) - Removes the closest found Point to the given coordinates.
 * findClosestPoint(double, double) - Finds the closest Point in the pointSet to the given 
 * 									  coordinates and returns that Point
 * */
package application;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Collections;

public class PointPane extends Pane {

	private ArrayList<Point> pointSet;
	private ArrayList<Point> maximalSet;
	
	public PointPane(ArrayList<Point> initialPointSet) {
		this.pointSet = new ArrayList<>(initialPointSet);
		this.maximalSet = createMaximalSet();
		
		//Draw Pane
		drawPane();
		
		//Mouse click Event Handler
		setOnMouseClicked(event -> handleMouseClick(event));
	}
	
	//Ensures initial maximal line correctly connects to bottom pane
	@Override
    protected void layoutChildren() {
        super.layoutChildren();
        drawPane(); //Redraw after layout changes
    }
	
	//Create and return ArrayList of maximal Points from current pointSet
	private ArrayList<Point> createMaximalSet(){
		ArrayList<Point> maximalSet = new ArrayList<>();
		for (Point curPoint : pointSet) {
			boolean isMaximal = true;
			
			for (Point otherPoint : pointSet) {
				if(!curPoint.equals(otherPoint) && curPoint.maximalPoint(otherPoint)) {
					isMaximal = false;
					break;
				}
			}
			
			if (isMaximal)
				maximalSet.add(curPoint);
		}
		
		Collections.sort(maximalSet);
		return maximalSet;
	}
	
	//Draw all points in current pointSet and draw line to maximal points
	private void drawPane() {
		//Clear points and lines
		getChildren().clear();
		
		//Draw new points
		for (Point p : pointSet) {
			Circle c = new Circle(p.getX(), p.getY(), 5, Color.CADETBLUE);
			getChildren().add(c);
		}
		
	    //Draw lines for maximal points
	    if (maximalSet.size() > 0) {
	        Polyline polyline = new Polyline();

	        //Connect the first maximal point to the left side of the pane
	        Point firstMaximal = maximalSet.get(0);
	        polyline.getPoints().addAll(0.0, firstMaximal.getY(), firstMaximal.getX(), firstMaximal.getY());

	        //Add coordinates of maximal points
	        for (Point point : maximalSet) {
	            polyline.getPoints().addAll(point.getX(), point.getY());
	        }

	        //Connect the last maximal point to the bottom of the pane
	        Point lastMaximal = maximalSet.get(maximalSet.size() - 1);
	        polyline.getPoints().addAll(lastMaximal.getX(), lastMaximal.getY(), lastMaximal.getX(), getHeight());

	        //Set stroke color and add polyline to children
	        polyline.setStroke(Color.RED);
	        getChildren().add(polyline);
	    }
	}
	
	//Handle mouse click
	//Primary click = Add point at coordinate
	//Secondary click = Remove closest point to that coordinate
	private void handleMouseClick(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if (x >= 0 && x <= getWidth() && y >= 0 && y <= getHeight()) {
			//Left click, add new point to pointSet
			if (e.getButton() == MouseButton.PRIMARY) {
				pointSet.add(new Point(x, y));
			} else if (e.getButton() == MouseButton.SECONDARY) {
				removeClosestPoint(x, y);
			}
			
			//Redefine Maximal set and draw new pane
			maximalSet = createMaximalSet();
			drawPane();
		}
	}
	
	//Remove the closest point to the given coordinates
	private void removeClosestPoint(double x, double y) {
		Point closestPoint = findClosestPoint(x, y);
		if (closestPoint != null)
			pointSet.remove(closestPoint);
	}
	
	//Find the closest point to the given coordinates
	private Point findClosestPoint(double x, double y) {
		Point closestPoint = null;
		double minDistance = Double.MAX_VALUE;
		
		for (Point p : pointSet) {
			double distance = Math.sqrt(Math.pow(x - p.getX(), 2) +
				Math.pow(y - p.getY(), 2));
			if (distance < minDistance) {
				minDistance = distance;
				closestPoint = p;
			}
		}
		return closestPoint;
	}
}
