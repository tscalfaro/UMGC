package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.control.Button;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Pane pane = new Pane();
			//Create circle
			Circle circle = new Circle();
			circle.setCenterX(100);
			circle.setCenterY(100);
			circle.centerXProperty().bind(pane.widthProperty().divide(2));
			circle.centerYProperty().bind(pane.heightProperty().divide(2));
			circle.setRadius(50);
//			circle.setStroke(Color.BLACK);
//			circle.setFill(Color.WHITE);
			circle.setStyle("-fx-stroke: black");
			
			Button button = new Button("OK");
			Color color = new Color(.09, .8, .98, .5);
			
			circle.setFill(color);
			
			Label label = new Label("JavaFX");
			label.setFont(Font.font("Times New Roman", 
				      FontWeight.BOLD, FontPosture.ITALIC, 20));
			
			//Mouse event on text
			Text text = new Text(20, 20, "Fun Stuff");
			text.setOnMouseDragged(e -> {
				text.setX(e.getX());
				text.setY(e.getY());
			});
			
			text.setOnKeyPressed(e -> {
				switch(e.getCode()) {
				case DOWN: text.setY(text.getY() + 10); break;
				case UP: text.setY(text.getY() - 10); break;
				case LEFT: text.setX(text.getX() - 10); break;
				case RIGHT: text.setX(text.getX() + 10); break;
				default:
					if(e.getText().length() > 0)
						text.setText(e.getText());
				}
			});	
			
			//Button event
			Button btnEnlarge = new Button("Enlarge");
			Button btnShrink = new Button("Shrink");
			
			HBox hbox = new HBox();
			hbox.setSpacing(10);
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().add(btnEnlarge);
			hbox.getChildren().add(btnShrink);
			
//			root.setCenter(circle);
//			root.setBottom(hbox);
//			root.setAlignment(hbox, Pos.CENTER);
			pane.getChildren().addAll(hbox);
			
			
			
			//pane.getChildren().addAll(label, circle, button);
			//pane.getChildren().add(circle);
			//pane.getChildren().add(button);
			Scene scene = new Scene(pane,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("JAVAFX Playground");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			text.requestFocus();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
