package test;

import Input.ReadFile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEXample extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(this.getClass().getResource("/test/fxml.fxml"));
		Scene scene = new Scene(root);
		try {
			scene.getStylesheets().add(this.getClass().getResource("ch.css").toExternalForm());
		} catch (Exception e) {
			System.err.println("don't connect stylesheets : " + e.toString());
		}
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		ReadFile.loadData();
		launch(args);
	}

}
