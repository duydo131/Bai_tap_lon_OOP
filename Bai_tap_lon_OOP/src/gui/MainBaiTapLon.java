package gui;

import java.io.IOException;

import Input.ReadFile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainBaiTapLon extends Application{

	@Override
	public void start(Stage primaryStage) {
		Parent root = null;
		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getResource("/gui/Gui.fxml"));
			primaryStage.setTitle("Bản Tin Chứng Khoán");
			scene = new Scene(root);
			scene.getStylesheets().add(this.getClass().getResource("chart.css").toExternalForm());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		ReadFile.loadData();
		launch(args);
	}

}
