package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main1 extends Application{

	Stage window;
	Scene scene1, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		Label label = new Label("Main2");
		Button button = new Button("Go to course");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene2);
			}
		});
		VBox layout = new VBox();
		layout.getChildren().addAll(label, button);
		scene1 = new Scene(layout, 200, 300);
		
		Button button2 = new Button("Go Back");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				window.setScene(scene1);
				
			}
		});
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(button2);
		scene2 = new Scene(stackPane, 200, 300);
		
		window.setScene(scene1);
		
		window.show();
		
	}

}
