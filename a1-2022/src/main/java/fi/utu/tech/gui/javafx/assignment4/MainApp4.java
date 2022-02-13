package fi.utu.tech.gui.javafx.assignment4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MainApp4 extends Application{

	@Override
	public void start(Stage stage) {
		BorderPane rootPane = new BorderPane();
		
		Button b1 = new Button("Cheat");
		Button b2 = new Button("Regret");
		Label ot = new Label("Badabim badabum");
		Button b3 = new Button("About");
		
		HBox top = new HBox(12);
		top.getChildren().addAll(b1,b2,ot,b3);
		
		HBox.setHgrow(ot, Priority.ALWAYS);
		ot.setMaxWidth(Double.MAX_VALUE);
		ot.setAlignment(Pos.CENTER);
		
		rootPane.setTop(top);
		
		GridPane ruudut = new GridPane();
		
		int luku = 1;
		for(int rivi=1;rivi<7;rivi++) {
			for(int solu=1;solu<5;solu++) {
				Button paiva = new Button();
				paiva.setText(String.valueOf(luku));
				paiva.setMaxWidth(Double.MAX_VALUE);
				paiva.setMaxHeight(Double.MAX_VALUE);
				GridPane.setHgrow(paiva, Priority.ALWAYS);
				GridPane.setVgrow(paiva, Priority.ALWAYS);
				ruudut.add(paiva, solu, rivi);
				
				luku++;
			}	
		}
		
		rootPane.setCenter(ruudut);
		
		Scene scene = new Scene(rootPane,600,800);
		
		stage.setScene(scene);
		stage.setTitle("Advent Calendar");
		stage.show();
	}
}
