/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * Project 4 - Undirected Graph GUI
 * 
 * This is the Vertex class which creates the vertices for the graph and GUI. It has 3 class variable, double x & y,
 * String name. It has 6 public methods:
 * Vertex(double, double, String) - Constructor
 * double getX() - Getter for x
 * double getY() - Getter for y
 * String getName() - Getter for name
 * boolean equals(Object) - Returns true if one vertex is equal to another
 * int hashCode() - Returns a hash for each vertex
 * */

package application;

import java.util.Objects;

public class Vertex {

	private final double x;
	private final double y;
	private final String name;
	
	public Vertex(double x, double y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vertex vertex = (Vertex) o;
		return Double.compare(vertex.x, x) == 0 &&
				Double.compare(vertex.y, y) == 0 &&
				Objects.equals(name, vertex.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, x, y);
	}
}
