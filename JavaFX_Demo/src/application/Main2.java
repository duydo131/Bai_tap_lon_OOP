package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Main2 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Dialog");
		dialog.setHeaderText("Sign up");
		
		ButtonType loginButtonType = new ButtonType("login", ButtonBar.ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		
		TextField userName = new TextField();
		userName.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");
		
		grid.add(new Label("Username : "), 0, 0);
		grid.add(userName, 1, 0);
		grid.add(new Label("Password : "), 1, 0);
		grid.add(password, 1, 1);
		
		
	}

}
