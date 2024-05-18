/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * Project 4 - Undirected Graph GUI
 * 
 * This is the GraphPane class which extends Pane. It creates the graph in the gui by drawing the vertices and edges.
 * It has one class variable Graph. It has 2 public methods:
 * GraphPane(Graph) - Constructor
 * drawGraph() - Clears current graph and draws new graph from Set<Vertex> vertices and List<List<Vertex>> edges
 * It has 2 private methods:
 * drawVertex(Vertex) - Creates a single vertex
 * drawEdge(Vertex, Vertex) - Creates a single edge between two vertices.
 * */

package application;

import java.util.List;
import java.util.Set;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GraphPane extends Pane{

	private Graph graph;
	
	public GraphPane(Graph graph) {
		this.graph = graph;
	}
	
	public void drawGraph() {
        // Clear existing drawings
        getChildren().clear();

        // Draw vertices
        Set<Vertex> vertices = graph.getVertices();
        for (Vertex vertex : vertices) {
            drawVertex(vertex);
        }

        // Draw edges
        List<List<Vertex>> edges = graph.getEdges();
        for (List<Vertex> edge : edges) {
            drawEdge(edge.get(0), edge.get(1));
        }
    }
	
	private void drawVertex(Vertex vertex) {
		Circle circle = new Circle(vertex.getX(), vertex.getY(), 5);
		circle.setFill(Color.BLACK);
		circle.setStroke(Color.BLACK);
		Text text = new Text(vertex.getX() - 10, vertex.getY() - 10, vertex.getName());
		getChildren().addAll(circle, text);
	}
	
	private void drawEdge(Vertex source, Vertex destination) {
		if (source == null || destination == null) {
	        System.err.println("Source or destination vertex is null.");
	        return;
	    }
	    
	    // Check if source and destination vertices exist in the graph
	    if (!graph.getVertices().contains(source) || !graph.getVertices().contains(destination)) {
	        System.err.println("Source or destination vertex does not exist in the graph.");
	        return;
	    }
		Line line = new Line(source.getX(), source.getY(), destination.getX(), destination.getY());
		getChildren().add(line);
	}
	
}
