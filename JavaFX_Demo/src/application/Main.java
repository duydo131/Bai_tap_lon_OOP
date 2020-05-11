package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World");
		Button button = new Button();
		button.setText("JavaFX");
		button.setOnAction(event -> {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Choose your option");
			alert.setHeaderText("Alert Infomation");
			
			ButtonType button1 = new ButtonType("Yes", ButtonBar.ButtonData.YES); 
			ButtonType button2 = new ButtonType("No", ButtonBar.ButtonData.NO);
			ButtonType button3 = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
			
			alert.getButtonTypes().setAll(button1, button2, button3);
			
			Optional<ButtonType> result = alert.showAndWait();
			
			if(result.get() == button1 ) {
				System.out.println("Yes");
			}else if(result.get().getButtonData() == ButtonBar.ButtonData.NO) {
				System.out.println("No");
			}else {
				System.out.println("Cancel");
			}
			
			String message = result.get().getText();
			Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
			alert2.setTitle("Infomation");
			alert2.setHeaderText("khong");
			alert2.setContentText(message);
			
			alert2.show();
			
		});
		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);
		Scene scene = new Scene(layout, 300 , 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
