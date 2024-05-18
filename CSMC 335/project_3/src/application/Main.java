/*
 * Created by: Antonio Scalfaro
 * CMSC 335
 * Project 3 - Traffic Light GUI
 * 
 * This is the Main class which extends javafx Application. This class contains 7 class methods:
 * public start(Stage) - Creates the GUI: creates Timer, Timer container, Buttons, Button container,
 * 						 and Lane container.
 * public static main(Stringp[]) - Launches program
 * private startBtnHandler() - Runs startTimer(), changes boolean started to true, itterates through List lanes and 
 * 							   resumes all lanes.
 * private stopBtnHandler() - Resets Timer to 0 seconds, clears the Lane container, ensures Pause button text
 * 							 is correct, interrupts all threads, and clears the List threads.
 * private pauseBtnHandler() - If pauseBtn text equals "Pause" pause timer, set text to "Continue", iterate
 * 							  List lanes and run the pause() method to pause every lane. If pauseBtn equals
 * 							  "Continue" run startTimer(), change text to "Pause", iterate List lanes and
 * 							  run resume() method to resume every lane.
 * private addLaneBtnHandler() - Instantiate threads ArrayList if currently null, creates new Lane and adds it 
 * 								to List lanes. Add Primary Mouse Button event to each lane that creates a car
 * 								with a random speed and set size and add car to lane. Add lane to laneContainer
 * 								If max lanes is reached (5) change button text to "Max Lanes Reached". Create new
 * 								Thread for new Lane, add it to List threads, and if started equals true start the
 * 								thread. If started is false, start threads and use Lane method pause() to pause thread.
 * private startTimer() - Creates new Timer with TimerTask to update the timerLabel every second.
 * 
 * */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private int seconds = 0;
	private HBox laneContainer;
	private VBox topBox;
	private Label timerLabel;
	private Button pauseBtn;
	private Button stopBtn;
	private Button startBtn;
	private Button addLaneBtn;
	private Timer timer;
	private List<Thread> threads;
	private List<Lane> lanes = new ArrayList<>();
	private boolean started = false;
	private Random random = new Random();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//Timer
			timerLabel = new Label("Seconds: 0");
			timerLabel.setStyle("-fx-pref-width: 100px;");
			
			//Timer Container
			topBox = new VBox();
			topBox.setPadding(new Insets(10));
			topBox.setSpacing(20);
			topBox.getChildren().add(timerLabel);
			
			//Buttons
			pauseBtn = new Button("Pause");
			pauseBtn.setOnAction(event -> pauseBtnHandler());
			stopBtn = new Button("Stop");
			stopBtn.setOnAction(event -> stopBtnHandler());
			startBtn = new Button("Start");
			startBtn.setOnAction(event -> startBtnHandler());
			addLaneBtn = new Button("Add Lane");
			addLaneBtn.setOnAction(event -> addLaneBtnHandler());
			
			//Button Container
			HBox btnBox = new HBox();
			btnBox.setPadding(new Insets(10));
			btnBox.setSpacing(25);
			btnBox.setAlignment(Pos.CENTER);
			btnBox.getChildren().addAll(startBtn, stopBtn, pauseBtn, addLaneBtn);
			
			//Lane Container
			laneContainer = new HBox();
			laneContainer.setPadding(new Insets(10));
			laneContainer.setAlignment(Pos.CENTER);
			laneContainer.setSpacing(15);
			
			BorderPane root = new BorderPane();
			root.setTop(topBox);
			root.setCenter(laneContainer);
			root.setBottom(btnBox);
			Scene scene = new Scene(root,1200,750);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Traffic Light Simulator");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void startBtnHandler() {
		startTimer();
		started = true;
		if (threads != null) {
			lanes.forEach(Lane::resume);
		}
	}
	
	private void stopBtnHandler() {
		if (timer != null) {
			timer.cancel();
			seconds = 0;
		}
		laneContainer.getChildren().clear();
		if (pauseBtn.getText().equals("Continue")) {
			pauseBtn.setText("Pause");
		}
		if (!addLaneBtn.getText().equals("Add Lane")) {
			addLaneBtn.setText("Add Lane");
		}
		if (threads != null) {
			for (Thread thread : threads) {
				thread.interrupt();
			}
			threads.clear();
		}
		started = false;
	}
	
	private void pauseBtnHandler() {
		if (pauseBtn.getText().equals("Pause")) {
			timer.cancel();
			pauseBtn.setText("Continue");
			started = false;
			if (threads != null) {
				lanes.forEach(Lane::pause);
			}
			
		} else {
			startTimer();
			started = true;
			if (threads != null) {
				lanes.forEach(Lane::resume);
			}
			pauseBtn.setText("Pause");
		}
		
	}
	
	private void addLaneBtnHandler() {
		if (threads == null) {
			threads = new ArrayList<>();
		}
		
		Lane lane = new Lane();
		lanes.add(lane);
		lane.setOnMousePressed(e -> {
			if (e.isPrimaryButtonDown()) {
				int randomSpeed = random.nextInt(65 - 30 + 1) + 30;
				Car car = new Car(30, 60, randomSpeed);
				lane.addCar(car);
			}
		});
		
		if (laneContainer.getChildren().size() > 4) {
			addLaneBtn.setText("Maximum Lanes Reached");
			return;
		}
		laneContainer.getChildren().add(lane);
		Thread t = new Thread(lane);
		threads.add(t);
		if (started == true) {
			t.start();
		} else {
			t.start();
			lane.pause();
		}
	}
	
	
	private void startTimer() {
		if (timer != null) {
			timer.cancel();
		}
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                Platform.runLater(() -> {
                    timerLabel.setText("Seconds: " + seconds);
                });
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
