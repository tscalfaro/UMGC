/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 2 - Shapes GUI
 * 
 * This is the Main class which extends Application to initiate the javaFX GUI. This class contains all the code 
 * to compose the GUI to include event handlers. Invalid input will update outPut TextField with error message.
 * All input is validated. 3D images rendered come in 3 sizes, small, medium, and large dependent on input.
 * There are 14 methods as follows:
 * public start(Stage) - Creates all objects in GUI, creates GUI, and sets objects in GUI.
 * private handleShapeSelection() - Event handler to make the TextFields visible/invisible depending on the shape 
 * 									selected from the ComboBox.
 * private handleSubmit() - Event handler to create the correct shape selected from the ComboBox upon button press.
 * private boolean checkTextFieldNumeric(TextField) - Checks the TextField that is passed as a parameter to ensure the
 * 									input is of valid numeric form, returns true if yes, false otherwise.
 * private createCircle() - Retrieves information from radius TextField creates Circle_ object. Clears HBox shapeBox.
 * 							Draws circle and adds circle to HBox shapeBox. Clears TextFields
 * private createRectangle() - Retrieve information from length and width TextFields, creates Rectangle_ object. Clears
 * 							   HBox shapeBox. Draws rectangle and adds to HBox shapeBox. Clears TextFields.
 * private createSquare() - Retrieves information from side TextField, creates Rectangle_ object. Clears HBox shapeBox.
 * 						    Draws square and adds to shapeBox. Clears TextFields.
 * private createTriangle() - Retrieves information from leg TextFields, creates Triangle object. Ensures information 
 * 							  from leg TextFields can form valid triangle. Clears HBox shapeBox. Draws triangle and adds to 
 * 							  shapeBox. Clears TextFields.
 * private createCube() - Retrieves information from side TextField, creates Cube object. Creates ImageView adds Cube image
 * 						  to ImageView, clears HBox shapeBox and adds ImageView to shapeBox. Clears TextFields.
 * private createCone() - Retrieves information from radius and height TextFields, creates Cone object. Creates ImageView adds
 * 						  Cone image to ImageView, clears HBox shapeBox and adds ImageView to shapeBox. Clears TextFields.
 * private createCylinder() - Retrieves information from radius and height TextFields, creates Cylinder object. Creates
 * 							  ImageView add Cylinder image to ImageView, clears HBox shapeBox and adds ImageView to shapeBox.
 * 							  Clears TextFields.
 * private createSphere() - Retrieves information from radius TextField, creates Sphere object. Creates ImageView adds Sphere
 * 							image to ImageView, clears HBox shapeBox and adds ImageView to shapeBox. Clears TextFields.
 * private createTorus() - Retrieves information from majorRadius and minorRadius TextFields, creates Torus object. Creates
 * 						   ImageView adds Torus image to ImageView, clears HBox shapeBox and adds ImageView to shapeBox.
 * 						   Clears TextFields.
 * public main(String[]) - Launches program.
 * */

package application;
	
import java.awt.Point;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Main extends Application {
	
	private ComboBox<String> shapeComboBox;
	private Button submitBtn;
	private Label selectShapeLabel;
	private TextField radiusField, lengthField, widthField, sideField, legField1, legField2, legField3;
	private TextField heightField, majorRadiusField, minorRadiusField, outPutField;
	private Point origin = new Point(350, 300);
	private HBox shapeBox = new HBox();

	
	@Override
	public void start(Stage primaryStage) {
		try {
			selectShapeLabel = new Label("Select a Shape:");
			selectShapeLabel.setStyle("-fx-pref-width: 100px;");
			shapeComboBox = new ComboBox<>();
			shapeComboBox.getItems().addAll("Circle", "Cone", "Cube", "Cylinder", "Rectangle", "Sphere",
					"Square", "Torus", "Triangle");
			shapeComboBox.setOnAction(event -> handleShapeSelection());
			
			radiusField = new TextField();
			radiusField.setPromptText("Radius");
			radiusField.setVisible(false);
			
			lengthField = new TextField();
			lengthField.setPromptText("Length");
			lengthField.setVisible(false);
			
			widthField = new TextField();
			widthField.setPromptText("Width");
			widthField.setVisible(false);
			
			sideField = new TextField();
			sideField.setPromptText("Side");
			sideField.setVisible(false);
			
			legField1 = new TextField();
			legField1.setPromptText("Leg 1");
			legField1.setVisible(false);
			
			legField2 = new TextField();
			legField2.setPromptText("Leg 3");
			legField2.setVisible(false);
			
			legField3 = new TextField();
			legField3.setPromptText("Leg 3");
			legField3.setVisible(false);
			
			heightField = new TextField();
			heightField.setPromptText("Height");
			heightField.setVisible(false);
			
			majorRadiusField = new TextField();
			majorRadiusField.setPromptText("Major Radius");
			majorRadiusField.setVisible(false);
			
			minorRadiusField = new TextField();
			minorRadiusField.setPromptText("Minor Radius");
			minorRadiusField.setVisible(false);
			
			outPutField = new TextField();
			outPutField.setPromptText("Output");
			outPutField.setStyle("-fx-pref-width: 400px;");
			
			submitBtn = new Button("Submit");
			submitBtn.setStyle("-fx-pref-width: 100px;");
			submitBtn.setOnAction(event -> handleSubmit());
			
			VBox vbox = new VBox();
			vbox.setPadding(new Insets(10));
			vbox.getChildren().addAll(selectShapeLabel, shapeComboBox);
			
			HBox topHbox = new HBox();
			topHbox.setPadding(new Insets(5));
			topHbox.setSpacing(5);
			topHbox.getChildren().addAll(selectShapeLabel, shapeComboBox);
			HBox midHbox = new HBox();
			midHbox.setPadding(new Insets(10));
			midHbox.setSpacing(5);
			midHbox.getChildren().addAll(radiusField, heightField, lengthField,
					widthField, sideField, legField1, legField2, legField3, 
					majorRadiusField, minorRadiusField);
			HBox bottomHbox = new HBox();
			bottomHbox.setPadding(new Insets(10));
			bottomHbox.setSpacing(10);
			bottomHbox.getChildren().addAll(submitBtn, outPutField);
			vbox.getChildren().addAll(topHbox, midHbox);
			
			shapeBox.setAlignment(Pos.CENTER);
			
			BorderPane root = new BorderPane();
			root.setTop(vbox);
			root.setCenter(shapeBox);
			root.setBottom(bottomHbox);
			Scene scene = new Scene(root,700,600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Draw a Shape");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void handleShapeSelection() {
		String selectedShape = shapeComboBox.getSelectionModel().getSelectedItem();
		if (selectedShape != null) {
			switch (selectedShape) {
				case "Circle":
					radiusField.setVisible(true);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(false);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(false);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Cone":
					radiusField.setVisible(true);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(false);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(true);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Cube":
					radiusField.setVisible(false);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(true);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(false);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Cylinder":
					radiusField.setVisible(true);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(false);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(true);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Rectangle":
					radiusField.setVisible(false);
					lengthField.setVisible(true);
					widthField.setVisible(true);
					sideField.setVisible(false);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(false);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Sphere":
					radiusField.setVisible(true);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(false);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(false);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Square":
					radiusField.setVisible(false);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(true);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(false);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				case "Torus":
					radiusField.setVisible(false);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(false);
					legField1.setVisible(false);
					legField2.setVisible(false);
					legField3.setVisible(false);
					heightField.setVisible(false);
					majorRadiusField.setVisible(true);
					minorRadiusField.setVisible(true);
					break;
				case "Triangle":
					radiusField.setVisible(false);
					lengthField.setVisible(false);
					widthField.setVisible(false);
					sideField.setVisible(false);
					legField1.setVisible(true);
					legField2.setVisible(true);
					legField3.setVisible(true);
					heightField.setVisible(false);
					majorRadiusField.setVisible(false);
					minorRadiusField.setVisible(false);
					break;
				default:
					break;
			}
		}
	}
	
	private void handleSubmit() {
		String selectedShape = shapeComboBox.getSelectionModel().getSelectedItem();
		if (selectedShape != null) {
			switch(selectedShape) {
				case "Circle":
					createCircle();
					break;
				case "Rectangle":
					createRectangle();
					break;
				case "Square":
					createSquare();
					break;
				case "Triangle":
					createTriangle();
					break;
				case "Cube":
					createCube();
					break;
				case "Cone":
					createCone();
					break;
				case "Cylinder":
					createCylinder();
					break;
				case "Sphere":
					createSphere();
					break;
				case "Torus":
					createTorus();
					break;
			}
		}
	}
	
	private boolean checkTextFieldNumeric(TextField tf) {
		if (tf.getText().matches("[0.]+")) {
			return false;
		}
		if(tf.getText().matches("\\d+") || tf.getText().matches("\\d+(\\.\\d+)?")) {
			return true;
		}
		return false;
	}
	
	private void createCircle() {
		if (checkTextFieldNumeric(radiusField)) {
			Circle_ c = new Circle_(Double.parseDouble(radiusField.getText()));
			c.setCenterX(origin.getX());
			c.setCenterY(origin.getY());
			c.setFill(Color.AZURE);
			c.setStroke(Color.BLACK);
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(c);
			outPutField.setText("Circle with radius: " + radiusField.getText());
			radiusField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for radius.");
		}
	}
	
	private void createRectangle() {
		if (checkTextFieldNumeric(widthField) && checkTextFieldNumeric(lengthField)) {
			Rectangle_ r = new Rectangle_(Double.parseDouble(widthField.getText()),
					Double.parseDouble(lengthField.getText()));
			r.setFill(Color.AZURE);
			r.setStroke(Color.BLACK);
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(r);
			outPutField.setText("Rectangle with width: " + widthField.getText() +
					" and length: " + lengthField.getText());
			widthField.clear();
			lengthField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for length and width");
		}
	}
	
	private void createSquare() {
		if (checkTextFieldNumeric(sideField)) {
			Rectangle_ r = new Rectangle_(Double.parseDouble(sideField.getText()),
					Double.parseDouble(sideField.getText()));
			r.setFill(Color.AZURE);
			r.setStroke(Color.BLACK);
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(r);
			outPutField.setText("Square with side length: " + sideField.getText());
			sideField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for side length");
		}
	}
	
	private void createTriangle() {
		if(checkTextFieldNumeric(legField1) && checkTextFieldNumeric(legField2) &&
				checkTextFieldNumeric(legField3)) {
			double leg1 = Double.parseDouble(legField1.getText());
			double leg2 = Double.parseDouble(legField2.getText());
			double leg3 = Double.parseDouble(legField3.getText());
			if (leg1 + leg2 <= leg3 || leg2 + leg3 <= leg1 || leg1 + leg3 <= leg2) {
				outPutField.setText("Invalid legs for Trianle, please try again.");
				return;
			}
			double angleA = Math.toDegrees(Math.acos((leg2 * leg2 + leg3 * leg3 - leg1 * leg1) / (2 * leg2 * leg3)));
	        double angleB = Math.toDegrees(Math.acos((leg1 * leg1 + leg3 * leg3 - leg2 * leg2) / (2 * leg1 * leg3)));
	        double angleC = 180 - angleA - angleB;
	        
			double[] points = {0, 0, leg3, 0,
					leg2 * Math.cos(Math.toRadians(angleC)), leg2 * Math.sin(Math.toRadians(angleC))};
			Triangle triangle = new Triangle(points);
			triangle.setFill(Color.AZURE);
			triangle.setStroke(Color.BLACK);
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(triangle);
			outPutField.setText("Triangle with leg: " + leg1 + " and leg: " + leg2 + " and leg: " + leg3);
			legField1.clear();
			legField2.clear();
			legField3.clear();
		} else {
			outPutField.setText("Please provide appropriate input for the legs");
		}
	}
	
	private void createCube() {
		if(checkTextFieldNumeric(sideField)) {
			double side = Double.parseDouble(sideField.getText());
			Cube cube = new Cube(side);
			ImageView imageView = new ImageView(cube.getImage());
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(imageView);
			if (side < 100) {
				imageView.setFitWidth(100);
				imageView.setFitHeight(100);
				outPutField.setText("A Small Cube with side length: " + side);
			} else if (side < 200) {
				imageView.setFitWidth(200);
				imageView.setFitHeight(200);
				outPutField.setText("A Medium Cube with side length: " + side);
			} else {
				imageView.setFitWidth(300);
				imageView.setFitHeight(300);
				outPutField.setText("A Large Cube with side length: " + side);
			}
			sideField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for side length");
		}
	}
	
	private void createCone() {
		if(checkTextFieldNumeric(radiusField) && checkTextFieldNumeric(heightField)) {
			double radius = Double.parseDouble(radiusField.getText());
			double height = Double.parseDouble(heightField.getText());
			Cone cone = new Cone(radius, height);
			ImageView imageView = new ImageView(cone.getImage());
			
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(imageView);
			if (radius < 100) {
				imageView.setFitWidth(100);
				imageView.setFitHeight(100);
				outPutField.setText("A Small Cone with radius: " + radius + " and height: " + height);
			} else if (radius < 200) {
				imageView.setFitWidth(200);
				imageView.setFitHeight(200);
				outPutField.setText("A Medium Cone with radius: " + radius + " and height: " + height);
			} else {
				imageView.setFitWidth(300);
				imageView.setFitHeight(300);
				outPutField.setText("A Large Cone with radius: " + radius + " and height: " + height);
			}
			radiusField.clear();
			heightField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for radius and height.");
		}
	}
	
	public void createCylinder() {
		if(checkTextFieldNumeric(radiusField) && checkTextFieldNumeric(heightField)) {
			double radius = Double.parseDouble(radiusField.getText());
			double height = Double.parseDouble(heightField.getText());
			Cylinder cylinder = new Cylinder(radius, height);
			ImageView imageView = new ImageView(cylinder.getImage());
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(imageView);
			if (radius < 100) {
				imageView.setFitWidth(100);
				imageView.setFitHeight(100);
				outPutField.setText("A Small Cylinder with radius: " + radius + " and height: " + height);
			} else if (radius < 200) {
				imageView.setFitWidth(200);
				imageView.setFitHeight(200);
				outPutField.setText("A Medium Cylinder with radius: " + radius + " and height: " + height);
			} else {
				imageView.setFitWidth(300);
				imageView.setFitHeight(300);
				outPutField.setText("A Large Cylinder with radius: " + radius + " and height: " + height);
			}
			radiusField.clear();
			heightField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for radius and height.");
		}
	}
	
	public void createSphere() {
		if(checkTextFieldNumeric(radiusField)) {
			double radius = Double.parseDouble(radiusField.getText());
			Sphere sphere = new Sphere(radius);
			ImageView imageView = new ImageView(sphere.getImage());
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(imageView);
			if (radius < 100) {
				imageView.setFitWidth(100);
				imageView.setFitHeight(100);
				outPutField.setText("A Small Sphere with radius: " + radius);
			} else if (radius < 200) {
				imageView.setFitWidth(200);
				imageView.setFitHeight(200);
				outPutField.setText("A Medium Sphere with radius: " + radius);
			} else {
				imageView.setFitWidth(300);
				imageView.setFitHeight(300);
				outPutField.setText("A Large Sphere with radius: " + radius);
			}
			radiusField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for radius");
		}
	}
	
	public void createTorus() {
		if (checkTextFieldNumeric(majorRadiusField) && checkTextFieldNumeric(minorRadiusField)) {
			double minRad = Double.parseDouble(minorRadiusField.getText());
			double majRad = Double.parseDouble(majorRadiusField.getText());
			
			if (minRad >= majRad) {
				outPutField.setText("The minor radius may not be equal or larger than the major radius.");
				return;
			}
			Torus torus = new Torus(majRad, minRad);
			ImageView imageView = new ImageView(torus.getImage());
			shapeBox.getChildren().clear();
			shapeBox.getChildren().add(imageView);
			if (majRad < 100) {
				imageView.setFitWidth(100);
				imageView.setFitHeight(100);
				outPutField.setText("A Small Torus with major radius: " + majRad + " and minor radius: " + minRad);
			} else if (majRad < 200) {
				imageView.setFitWidth(200);
				imageView.setFitHeight(200);
				outPutField.setText("A Medium Torus with major radius: " + majRad + " and minor radius: " + minRad);
			} else {
				imageView.setFitWidth(300);
				imageView.setFitHeight(300);
				outPutField.setText("A Large Torus with major radius: " + majRad + " and minor radius: " + minRad);
			}
			majorRadiusField.clear();
			minorRadiusField.clear();
		} else {
			outPutField.setText("Please provide appropriate input for major and minor radius");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
