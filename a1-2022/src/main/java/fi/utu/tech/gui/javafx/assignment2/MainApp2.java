package fi.utu.tech.gui.javafx.assignment2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp2 extends Application{
	
	@Override
	public void start(Stage stage) {
		StackPane rootPane = new StackPane();
		
		FlowPane flow = new FlowPane();
		
		Button b1 = new Button("Cheat");
		Button b2 = new Button("Regret");
		Label ot = new Label("Badabim badabum");
		Button b3 = new Button("About");
		
		Label keski = new Label("Placeholder for Calendar");
		
		flow.getChildren().addAll(b1,b2,ot,b3);

		VBox vbox = new VBox(keski);
		
		vbox.setAlignment(Pos.CENTER);
		
		rootPane.getChildren().addAll(flow, vbox);
		
		Scene scene = new Scene(rootPane,600,800);
		
		stage.setScene(scene);
		stage.setTitle("Advent Calendar");
		stage.show();
	}
}
