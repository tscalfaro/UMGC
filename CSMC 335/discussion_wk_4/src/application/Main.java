package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.*;



public class Main extends Application {
	
	private Label textLabel;
	@Override
	public void start(Stage primaryStage) {
		try {
			textLabel = new Label("Drag me or Right Click me!");
			textLabel.setTextFill(Color.BLACK);
			textLabel.setOnMousePressed(e -> {
				if (e.getButton() == MouseButton.SECONDARY) {
					if (textLabel.getTextFill() == Color.BLACK) {
						textLabel.setTextFill(Color.BLUE);
					} else {
						textLabel.setTextFill(Color.BLACK);
					}
				}
			});
			textLabel.setOnMouseDragged(e -> {
				if (e.getButton() == MouseButton.PRIMARY) {
					textLabel.setLayoutX(e.getSceneX());
					textLabel.setLayoutY(e.getSceneY());
				}
			});
			Pane pane = new Pane();
			pane.getChildren().add(textLabel);
			BorderPane root = new BorderPane();
			root.getChildren().add(pane);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
