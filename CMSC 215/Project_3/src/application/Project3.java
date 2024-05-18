/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 3 - Trip Cost Estimator
 * 
 * This is the Project3 class, it has 4 methods:
 * 				start() - contains all code for the gui for trip cost estimator. 9 rows are inserted into a GridPane.
 * 						  Event listener placed on the "Calculate" button to create a TripCost obj and using the class
 * 						  method totalTripCost() to display it.
 * 				createNumericTextField() - Creates and returns a TextField that accepts only numeric and decimal input.
 * 				isValidInput() - Checks that TextField input is in the valid form, i.e any number of numeric characters
 * 								 followed by only one decimal with any amount of numeric characters after the decimal.
 * 				main() - launches program  
 * */

package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Project3 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Create pane and set properties
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
		    grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		    grid.setHgap(5.5); 
		    grid.setVgap(5.5);
		    
		    //Create ComboBoxes
		    ComboBox<String> cbo = new ComboBox<>();
		    cbo.getItems().addAll("miles", "kilometers"); // 2 options for cbo
		    cbo.setValue("miles"); // default value miles
		    ComboBox<String> cbo2 = new ComboBox<>();
		    cbo2.getItems().addAll("dollars/gal", "dollars/liter"); // 2 options for cbo2
		    cbo2.setValue("dollars/gal"); // default value dollars/gal	
		    ComboBox<String> cbo3 = new ComboBox<>();
		    cbo3.getItems().addAll("miles/gal", "kilometers/liter"); // 2 options for cbo3
		    cbo3.setValue("miles/gal"); // default value miles/gal
		    
		    
		    //Place nodes in pane
		    //Row 1
		    grid.add(new Label("Distance: "), 0, 0);
		    TextField distTf = createNumericTextField(); //Create TextField and place in row
		    grid.add(distTf, 1, 0);
		    
		    grid.add(cbo, 2, 0);
		    
		    //Row 2
		    grid.add(new Label("Gasoline Cost: "), 0, 1);
		    TextField gasCostTf = createNumericTextField();
		    grid.add(gasCostTf, 1, 1);
		    
		    grid.add(cbo2, 2, 1);
		    
		    //Row 3
		    grid.add(new Label("Gas Mileage: "), 0, 2);
		    TextField gasMileageTf = createNumericTextField();
		    grid.add(gasMileageTf, 1, 2);
		    
		    grid.add(cbo3, 2, 2);
		    
		    //Row 4
		    grid.add(new Label("Number of Days: "), 0, 3);
		    TextField dayTf = createNumericTextField();
		    grid.add(dayTf, 1, 3);
		    
		    //Row 5
		    grid.add(new Label("Hotel Cost: "), 0, 4);
		    TextField hotelTf = createNumericTextField();
		    grid.add(hotelTf, 1, 4);
		    
		    //Row 6
		    grid.add(new Label("Food Cost: "), 0, 5);
		    TextField foodTf = createNumericTextField();
		    grid.add(foodTf, 1, 5);
		    
		    //Row 7
		    grid.add(new Label("Attractions: "), 0, 6);
		    TextField atcTf = createNumericTextField();
		    grid.add(atcTf, 1, 6);
		    
		    //Row 8
		    Button calcBtn = new Button("Calculate"); 
		    grid.add(calcBtn, 1, 7);
			
		    //Row 9
		    grid.add(new Label("Total Cost of Trip"), 0, 8);
		    TextField totalCostTf = new TextField();
		    totalCostTf.setEditable(false);
		    grid.add(totalCostTf, 1, 8);
		    
		    //Add Event listener for Button to calculate total
		    calcBtn.setOnAction(e -> {
		    	//Check if any field is empty and display alert, else continue event
		    	if(distTf.getText().isEmpty() || gasCostTf.getText().isEmpty() || gasMileageTf.getText().isEmpty() ||
		    			dayTf.getText().isEmpty() || hotelTf.getText().isEmpty() || foodTf.getText().isEmpty() ||
		    			atcTf.getText().isEmpty()) {
		    		Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
		    		alert.setContentText("Please fill all fields.");
		    		alert.showAndWait();
		    		
		    	}else {
		    		//Parse input data from TextFields
		    		double distance = Double.parseDouble(distTf.getText());
			    	double gasCost = Double.parseDouble(gasCostTf.getText());
			    	double gasMileage = Double.parseDouble(gasMileageTf.getText());
			    	int days = Integer.parseInt(dayTf.getText());
			    	double hotelCost = Double.parseDouble(hotelTf.getText());
			    	double foodCost = Double.parseDouble(foodTf.getText());
			    	double attractions = Double.parseDouble(atcTf.getText());
			    	
			    	//Create TripCost Obj with input
			    	TripCost tc = new TripCost(distance, gasCost, gasMileage, days, hotelCost, foodCost, attractions);
			    	
			    	//Display total cost
			    	totalCostTf.setText("$" + tc.totalTripCost());
		    	}
		    	
		    });
		    
		    //Set scene, show
			Scene scene = new Scene(grid,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Trip Cost Estimator");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Function to create TextField that only accepts numeric input
	private TextField createNumericTextField() {
        TextField numericTextField = new TextField();
        numericTextField.setPromptText("Enter numeric value");

        // Add a key event filter to restrict input to numeric characters and decimal point
        numericTextField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            if (!isValidInput(event.getCharacter(), numericTextField)) {
                event.consume();
            }
        });
        return numericTextField;
    }
	//Checks if input is a numeric value followed by a single period and any other amount of numeric values
	private boolean isValidInput(String input, TextField tf) {
        String text = tf.getText() + input;
        return text.matches("\\d*(\\.\\d*)?");
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
