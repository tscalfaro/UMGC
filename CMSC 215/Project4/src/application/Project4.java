/*
 * Created by: Antonio Scalfaro
 * CMSC 215 / 6381
 * Project 4 - Time Interval Checker
 * 
 * This is the Project4 class which is a javaFX file that produces a 500 x 300 GUI. The GUI is a GridPane that contains
 * 3 columns and 7 rows. There are 6 TextFields, all but 1 are editable, and 2 buttons. The Compare Intervals button is 
 * set to Compare the two intervals entered once pressed and output text to the 1 uneditable textField. The Check Time 
 * button is set to check if the given time falls in one, both, or neither of the given intervals. Invalid time format 
 * in any textField will produce an alert to the GUI and will not compute the desired function. Additionally, there is 
 * an isValidTime() method that uses regex to create a pattern and then check if the given time matches the pattern.
 * */

package application;
	
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;


public class Project4 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Create pane and set properties
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
		    grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		    grid.setHgap(5.5); 
		    grid.setVgap(5.5);
		    
		    //Row 1
		    grid.add(new Label("Start Time"), 1, 0);
			grid.add(new Label("End Time"), 2, 0);
			
			//Row 2
			grid.add(new Label("Time Interval 1"), 0, 1);
			TextField intervalOneStartTf = new TextField();
			TextField intervalOneEndTf = new TextField();
			grid.add(intervalOneStartTf, 1, 1);
			grid.add(intervalOneEndTf, 2, 1);
			
			//Row 3
			grid.add(new Label("Time Interval 2"), 0, 2);
			TextField intervalTwoStartTf = new TextField();
			TextField intervalTwoEndTf = new TextField();
			grid.add(intervalTwoStartTf, 1, 2);
			grid.add(intervalTwoEndTf, 2, 2);
			
			//Row 4
			Button compareIntervals = new Button("\t\t\t\t\t  Compare Intervals \t\t\t\t\t");
			GridPane.setColumnSpan(compareIntervals, 3);//Could not get this to work, hence the goofy button name format above
			grid.add(compareIntervals, 0, 3);
			
			//Row 5
			grid.add(new Label("Time to Check"), 0, 4);
			TextField timeToCheckTf = new TextField();
			GridPane.setColumnSpan(timeToCheckTf, 2);
			grid.add(timeToCheckTf, 1, 4);
			
			//Row 6
			Button checkTime = new Button("\t\t\t\t\t Check Time\t\t\t\t\t\t\t");
			GridPane.setColumnSpan(checkTime, 3);
			grid.add(checkTime, 0, 5);
			
			//Row 7
			TextField outputTf = new TextField();
			outputTf.setEditable(false);
			GridPane.setColumnSpan(outputTf, 3);
			grid.add(outputTf, 0, 6);
			
			//Button events
			compareIntervals.setOnAction(event -> {
				//Retreive input from textFields
				String inputInt1Start = intervalOneStartTf.getText();
				String inputInt1End = intervalOneEndTf.getText();
				String inputInt2Start = intervalTwoStartTf.getText();
				String inputInt2End = intervalTwoEndTf.getText();
				
				//Validate input is in the correct format
				if(isValidTime(inputInt1Start) && isValidTime(inputInt1End) && 
						isValidTime(inputInt2Start) && isValidTime(inputInt2End)) {
					
					try {
						//Create Time objs
						Time int1Start = new Time(inputInt1Start);
						Time int1End = new Time(inputInt1End);
						Time int2Start = new Time(inputInt2Start);
						Time int2End = new Time(inputInt2End);
						
						//Create interval objs
						Interval<Time> int1 = new Interval<>(int1Start, int1End);
						Interval<Time> int2 = new Interval<>(int2Start, int2End);
						
						//Compare intervals
						//int2 is a subinterval of int1
						if(int1.subinterval(int2)) {
							System.out.println("HERE");
							outputTf.setText("Interval 2 is a subinterval of Interval 1");
						//int2 is overlapping int1
						} else if(int1.overlaps(int2)) {
							outputTf.setText("Interval 2 overlaps Interval 1");
						//int2 does not overlap/is a subinterval of int1
						} else {
							outputTf.setText("The intervals do not overlap");
						}
						//Display output
					} catch (InvalidTime e) {
						System.err.print(e);
					}
					
					
					
				} else {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
		    		alert.setContentText("Please fill all fields in the correct format. I.e '12:00 AM'");
		    		alert.showAndWait();
				}
			});
			
			checkTime.setOnAction(event -> {
				//Retrieve input from textFields
				String inputInt1Start = intervalOneStartTf.getText();
				String inputInt1End = intervalOneEndTf.getText();
				String inputInt2Start = intervalTwoStartTf.getText();
				String inputInt2End = intervalTwoEndTf.getText();
				String inputTimeToCheck = timeToCheckTf.getText();
				
				//Validate input
				if(isValidTime(inputTimeToCheck) && isValidTime(inputInt1Start) && isValidTime(inputInt1End) && 
						isValidTime(inputInt2Start) && isValidTime(inputInt2End)) {
					try {
						//Create Time objs
						Time int1Start = new Time(inputInt1Start);
						Time int1End = new Time(inputInt1End);
						Time int2Start = new Time(inputInt2Start);
						Time int2End = new Time(inputInt2End);
						Time timeToCheck = new Time(inputTimeToCheck);
						
						//Create interval objs
						Interval<Time> int1 = new Interval<>(int1Start, int1End);
						Interval<Time> int2 = new Interval<>(int2Start, int2End);
						
						//Compare time to check against intervals
						if(int1.within(timeToCheck) && int2.within(timeToCheck)) {
							String message = String.format("The time %s falls in both intervals", inputTimeToCheck);
							outputTf.setText(message);
						}else if(int1.within(timeToCheck) || int2.within(timeToCheck)) {
							String message = int1.within(timeToCheck) ? String.format("The time %s falls in interval 1", inputTimeToCheck):
								String.format("The time %s falls in interval 2", inputTimeToCheck);
							outputTf.setText(message);
						}else {
							String message = String.format("The time %s does not fall in either interval", inputTimeToCheck);
							outputTf.setText(message);
						}
						
						//Display output
					} catch (InvalidTime e) {
						System.err.print(e);
					}
				}else {
					Alert alert = new Alert(AlertType.ERROR);
		    		alert.setTitle("Error");
		    		alert.setHeaderText(null);
		    		alert.setContentText("Please fill all fields in the correct format. I.e '12:00 AM'");
		    		alert.showAndWait();
				}
			});
			
			Scene scene = new Scene(grid,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Time Interval Checker");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Use Regex to set the time format and return true if input matches format
	private boolean isValidTime(String input) {
		// Define a regular expression pattern for a valid time format (e.g., '12:00 AM/PM')
        String timePattern = "^(0?[1-9]|1[0-2]):[0-5][0-9] (AM|PM)$";
        
        // Create a Pattern object and a Matcher for the input string
        Pattern pattern = Pattern.compile(timePattern);
        Matcher matcher = pattern.matcher(input);

        // Check if the input matches the pattern
        return matcher.matches();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
