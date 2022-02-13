package fi.utu.tech.gui.javafx.assignment1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainApp1 extends Application {
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Label("Placeholder for Calendar"),600,800);
		
		stage.setScene(scene);
		stage.setTitle("Advent Calendar");
		stage.show();
		
	}

}
