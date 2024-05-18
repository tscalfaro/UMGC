/*
 * Created by: Antonio Scalfaro
 * CMSC 315 / 6380
 * 02/13/2024
 * Project 2 - Maximal Points
 * 
 * This is the Main class that extends Application. This class creates the GUI for the program and
 * reads the initial set of Points in from the points.txt file. It has three class variables
 * BufferedReader reader, ArrayList<Point> initialPointSet, and String fileName. The fileName is
 * hardcoded per the project instructions. There are two class methods:
 * start(Stage) - Reads the points.txt file line by line and creates Points to add to the 
 * 				  initialPointSet. Creates the initialPane using the PointPane class, passing
 * 				  in the initialPointSet. Sets the scene for the GUI with the initialPane
 * main(String[]) - Launches program.
 * */
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
	private BufferedReader reader;
	private ArrayList<Point> initialPointSet;
	private String fileName = "src/points.txt";
	
	@Override
	public void start(Stage primaryStage) {

		try {
			
			reader = new BufferedReader(new FileReader(fileName));
			initialPointSet = new ArrayList<>();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] coordinates = line.split(" ");
				double x = Double.parseDouble(coordinates[0]);
				double y = Double.parseDouble(coordinates[1]);
				
				Point p = new Point(x, y);
				initialPointSet.add(p);
			}

			PointPane initialPane = new PointPane(initialPointSet);
			BorderPane root = new BorderPane();
			root.setCenter(initialPane);
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Maximal Points Connected by Line");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			System.out.println("Error reading file " + e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
