package SceneBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEvent extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			Parent root = FXMLLoader.load(this.getClass().getResource("/SceneBuilder/Event.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
