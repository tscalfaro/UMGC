/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * Project 4 - Undirected Graph GUI
 * 
 * This is the Main class which extends Application. It has 3 class variables, Graph, GraphPane, and String[].
 * It has 3 class methods:
 * start(Stage) - Initializes graph and graphPane, and creates the initial GUI with associated text fields and 
 * 				  buttons. It sets the onAction for all buttons and graphPane (responds only to Primary mouse click).
 * String newVertexName() - Method that returns the String name of a new vertex, goes alphabetically starting at A.
 * 							When it reaches Z, the naming transitions to lower case starting at a.
 * main(String[]) - Launches application
 * */

package application;
	
import java.util.Set;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Graph graph;
	private GraphPane graphPane;
	private String[] vertexNames = new String[0];
	
	@Override
	public void start(Stage primaryStage) {
		graph = new Graph();
		graphPane = new GraphPane(graph);
		
		TextField vertex1Field = new TextField();
		TextField vertex2Field = new TextField();
		TextField outputField = new TextField();
		Text vertex1 = new Text("Vertex 1");
		Text vertex2 = new Text("Vertex 2");
		Button addEdgeButton = new Button("Add Edge");
		Button isConnectedButton = new Button("Is Connected");
		Button hasCycleButton = new Button("Has Cycle");
		Button depthFirstSearchButton = new Button("Depth First Search");
		Button breadthFirstSearchButton = new Button("Breadth First Search");
		
		vertex1Field.setStyle("-fx-pref-width: 35px;");
		vertex2Field.setStyle("-fx-pref-width: 35px;");
		
		addEdgeButton.setOnAction(e -> {
			String vertex1Name = vertex1Field.getText();
		    String vertex2Name = vertex2Field.getText();

		    if (!graph.containsVertex(vertex1Name) || !graph.containsVertex(vertex2Name)) {
		        outputField.setText("Error: One or more vertices does not exist");
		        return; // Exit the method if any vertex does not exist
		    }

		    Vertex firstVertex = graph.getVertexByName(vertex1Name);
		    Vertex secondVertex = graph.getVertexByName(vertex2Name);
		    vertex1Field.clear();
		    vertex2Field.clear();
		    graph.addEdge(firstVertex, secondVertex);
		    graphPane.drawGraph();
		});
		
		isConnectedButton.setOnAction(e -> {
			if(graph.getVertexByName("A") == null || graph.getVertexByName("B") == null) {
				outputField.setText("Please add more vertices");
				return;
			}
			if(graph.isConnected()) {
				outputField.setText("This graph is Connected");
			} else {
				outputField.setText("This graph is not Connected");
			}
		});
		
		hasCycleButton.setOnAction(e -> {
			if(graph.getVertexByName("A") == null || graph.getVertexByName("B") == null
					|| graph.getVertexByName("C") == null) {
				outputField.setText("Please add more vertices");
				return;
			}
			if(graph.hasCycles()) {
				outputField.setText("This graph has Cycles");
			} else {
				outputField.setText("This graph does not have Cycles");
			}
		});
		
		depthFirstSearchButton.setOnAction(e -> {
			if(graph.getVertexByName("A") == null) {
				outputField.setText("Graph is empty, please add a vertex.");
				return;
			}
			Set<Vertex> vertices = graph.depthFirstSearch(graph.getVertexByName("A"));
			String dfsVertices = "";
			for(Vertex vertex : vertices) {
				if (dfsVertices.isEmpty()) {
					dfsVertices = vertex.getName();
				} else {
					dfsVertices = dfsVertices + ", " + vertex.getName();
				}
			}
			outputField.setText(dfsVertices);
		});
		
		breadthFirstSearchButton.setOnAction(e -> {
			if(graph.getVertexByName("A") == null) {
				outputField.setText("Graph is empty, please add a vertex.");
				return;
			}
			Set<Vertex> vertices = graph.breadthFirstSearch(graph.getVertexByName("A"));
			String bfsVertices = "";
			for(Vertex vertex : vertices) {
				if(bfsVertices.isEmpty()) {
					bfsVertices = vertex.getName();
				} else {
					bfsVertices = bfsVertices + ", " + vertex.getName();
				}
			}
			outputField.setText(bfsVertices);
		});
		
		graphPane.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				graph.addVertex(new Vertex (e.getX(), e.getY(), newVertexName()));
				graphPane.drawGraph();
			}
		});
		
		BorderPane root = new BorderPane();
		HBox buttonsBox = new HBox(isConnectedButton, hasCycleButton,
				depthFirstSearchButton, breadthFirstSearchButton);
		VBox bottomBox = new VBox(buttonsBox, outputField);
		bottomBox.setAlignment(Pos.CENTER);
		HBox addEdgeBox = new HBox(addEdgeButton, vertex1, vertex1Field, vertex2, vertex2Field);
		addEdgeBox.setAlignment(Pos.CENTER);
		root.setCenter(graphPane);
		root.setTop(addEdgeBox);
		root.setBottom(bottomBox);
		root.setPadding(new Insets(10));
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Project 4 - Undirected Graph GUI");
		primaryStage.show();
	}
	
	private String newVertexName() {
		String vertexName = "";
		String lastVertexName = "";
	    if (vertexNames.length == 0) {
	        vertexName = "A";
	    } else if (vertexNames[vertexNames.length - 1].equals("Z")){
	    	vertexName = "a";
	    } else {
	    	lastVertexName = vertexNames[vertexNames.length - 1];
	        char nextChar = (char) (lastVertexName.charAt(0) + 1);
	        vertexName = vertexName + nextChar;    
	    }
	    String[] newVertexNames = new String[vertexNames.length + 1];
	    System.arraycopy(vertexNames, 0, newVertexNames, 0, vertexNames.length);
	    newVertexNames[vertexNames.length] = vertexName;
	    vertexNames = newVertexNames;
	    return vertexName;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}