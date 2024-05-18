/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 3 - Traffic Light GUI
 * 05/05/2024
 * 
 * This is the Lane class that extends the javafx Pane class and implements the Runnable interface.
 * There are 10 class methods for the Lane class:
 * public Lane() - Constructor for Lane
 * public initializeGUI() - Creates the GUI for the lane, creates a label that displays each car's speed and position
 * 							in the lane.
 * Synchronized changeLightColor() - Uses Platform.runLater() to change the GUI appearance of the light in the lane.
 * Synchronized addCar(Car) - Adds car to beginning of the lane, up to 4 cars.
 * public run() - While the thread is not interrupted, continue to change the light and move the cars. Green light is
 * 				  4 seconds long, Yellow is 3 seconds, and Red is 7 seconds.
 * synchronized moveCars() - If cars List is not empty, iterate cars List and track the car ahead's position and speed
 * 							 and move cars the calculated distance unless the car would "crash" into the car ahead. If 
 * 							 "crash" occurs, current car maintains half a car length distance and mimics car ahead's 
 * 							 speed. List of cars to remove is kept (if car has eclipsed intersection line), removes all
 * 							 cars on the list using Platform.runLater().
 * synchronized List<Car> getCars() - Returns List cars.
 * synchronized updateLabel() - Utilizes Platform.runLater() to update car speed and position label in the GUI.
 * synchronized pause() - Changes boolean stop to true.
 * synchronized resume() - Changes boolean stop to false.
 * */

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Lane extends Pane implements Runnable{
	private Rectangle lane;
	private Circle light;
	private Line intersectionLine;
	private HBox labelBox = new HBox();
	private Label label = new Label("");
	private Color lightColor = Color.GREEN;
	private double width = 250;
	private double height = 600;
	private List<Car> cars;
	private TrafficLight trafficLight;
	private boolean stop = false;
	
	
	public Lane() {
		this.trafficLight = new TrafficLight();
		this.cars = new ArrayList<>();
		initializeGUI();
	}
	
	
	public void initializeGUI() {
		label.setTextFill(Color.WHITE);
		label.setWrapText(true);
		labelBox.getChildren().add(label);
		labelBox.setPrefWidth(width);
		setPrefSize(width, height);
		lane = new Rectangle(width, height, Color.BLACK);
		lane.setStroke(Color.YELLOW);
		lane.setFill(Color.BLACK);
		light = new Circle(width / 2, height / 8, height / 14, lightColor);
		light.setStroke(Color.BLACK);
		double intersectionLineY = height / 4;
		intersectionLine = new Line(0, intersectionLineY, width, intersectionLineY);
		intersectionLine.setStroke(Color.WHITE);
		getChildren().addAll(lane, light, intersectionLine, labelBox);
	}
	
	
	synchronized void changeLightColor(){
		Platform.runLater(() -> {
			if (trafficLight.getTrafficLightState() == TrafficLightState.RED) {
				lightColor = Color.GREEN;
				light.setFill(lightColor);
				trafficLight.setTrafficLightState(TrafficLightState.GREEN);
			} else if (trafficLight.getTrafficLightState() == TrafficLightState.GREEN) {
				lightColor = Color.YELLOW;
				light.setFill(lightColor);
				trafficLight.setTrafficLightState(TrafficLightState.YELLOW);
			} else {
				lightColor = Color.RED;
				light.setFill(lightColor);
				trafficLight.setTrafficLightState(TrafficLightState.RED);
			}
		});
	}
	
	
	synchronized void addCar(Car car) {
		if (cars.size() > 3) {
			return;
		}
		car.setXPos((int) (width / 2 - car.getWidth() / 2));
		car.setYPos((int) (height - car.getHeight() - 5));
		car.setLayoutX(car.getXPos());
		car.setLayoutY(car.getYPos());
		cars.add(car);
		getChildren().add(car);
	}
	

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
            try {
            	if (stop) {
            		Thread.sleep(100);
            		continue;
            	}
                switch(trafficLight.getTrafficLightState()) {
                case GREEN:
                	moveCars();
                	updateLabel();
                	Thread.sleep(4000);
                	break;
                case YELLOW:
                	moveCars();
                	updateLabel();
                    Thread.sleep(3000);
                	break;
                case RED:
                	Thread.sleep(7000);
                	break;
                }
                if (!stop) {
                	changeLightColor();
                }
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                stop = true;
            }
            
        }
	}
	
	
	synchronized void moveCars() {
		if (!cars.isEmpty()) {
			double timeInSeconds = 4.0;
			if (lightColor == Color.YELLOW) {
				timeInSeconds = 3.0;
			}
			List<Car> carsToRemove = new ArrayList<>();
			int carAheadSpeed = 0;
			int carAheadPosition = (int) (height/4);
			int carLength = 60;
	        for (Car car : cars) {
	            int newY = (int) (car.getYPos() - car.getMoveDistance(timeInSeconds));
	            if (newY < (height / 4)) {
	            	carsToRemove.add(car);
	            } else {
	            	if(newY < carAheadPosition) {
	            		newY = carAheadPosition + carLength / 2;
	            		car.setSpeed(carAheadSpeed);
	            	}
	            	car.setYPos(newY);
		            car.setLayoutY(car.getYPos());
		            carAheadSpeed = car.getSpeed();
		            carAheadPosition = car.getYPos() + carLength;
	            }
	        }
	        Platform.runLater(() -> {
	            for (Car carToRemove : carsToRemove) {
	                getChildren().remove(carToRemove);
	                cars.remove(carToRemove);
	            }
	        });
	    }
    }
	

    synchronized List<Car> getCars() {
        return cars;
    }
    
    synchronized void updateLabel() {
    	Platform.runLater(() -> {
    		String l = "";
    		if (cars.isEmpty()) {
    			labelBox.getChildren().remove(label);
            	label.setText(l);
            	labelBox.getChildren().add(label);
        	} else {
        		int count = 1;
            	for (Car car : cars) {
            		l += "Car " + count + " Speed: " + car.getSpeed() + "km/hr Pos: " + car.getYPos() + " ";
            		count++;
            	}
        		labelBox.getChildren().remove(label);
            	label.setText(l);
            	labelBox.getChildren().add(label);
        	}
        });
    	
    }
    
    synchronized void pause() {
    	stop = true;
    }
    
    synchronized void resume() {
    	stop = false;
    }
}
