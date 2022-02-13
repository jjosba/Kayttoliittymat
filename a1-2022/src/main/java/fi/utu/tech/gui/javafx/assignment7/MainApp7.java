package fi.utu.tech.gui.javafx.assignment7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class MainApp7 extends Application {

	@Override
	public void start(Stage stage) throws FileNotFoundException { //miten try catch?
		
		BorderPane root = new BorderPane();
		
		Button b1 = new Button("Cheat");
		Button b2 = new Button("Regret");
		Label ot = new Label("Badabim badabum");
		Button b3 = new Button("About");
		
		HBox top = new HBox(12);
		top.getChildren().addAll(b1,b2,ot,b3);
		
		HBox.setHgrow(ot, Priority.ALWAYS);
		ot.setMaxWidth(Double.MAX_VALUE);
		ot.setAlignment(Pos.CENTER);
		
		root.setTop(top);
		
		GridPane ruudut = new GridPane();
		
		ArrayList<Button> buttons = new ArrayList<>();
		
		EventHandler<ActionEvent> hide = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Button) e.getSource()).setVisible(false);
			}
		};
		
		int luku = 1;
		for(int rivi=1;rivi<7;rivi++) {
			for(int solu=1;solu<5;solu++) {
				Button paiva = new Button();
				paiva.setText(String.valueOf(luku));
				paiva.setMaxWidth(Double.MAX_VALUE);
				paiva.setMaxHeight(Double.MAX_VALUE);
				paiva.setOnAction(hide);
				GridPane.setHgrow(paiva, Priority.ALWAYS);
				GridPane.setVgrow(paiva, Priority.ALWAYS);
				ruudut.add(paiva, solu, rivi);
				buttons.add(paiva);
				luku++;
			}	
		}
		
        EventHandler<ActionEvent> eventCheat = new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		for(Button button : buttons) {
        			button.setVisible(false);
        		}
        	}
        };

		b1.setOnAction(eventCheat);
		
		EventHandler<ActionEvent> eventRegret = new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		for(Button button : buttons) {
        			button.setVisible(true);
        		}
        	}
        };
        
        b2.setOnAction(eventRegret);
		
		root.setCenter(ruudut);
		
		FileInputStream input = new FileInputStream("src/main/resources/kuva.jpg");
		Image kuva = new Image(input);
		
		BackgroundImage bgi = new BackgroundImage(kuva,BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		
		Background bg = new Background(bgi);
		
		ruudut.setBackground(bg);
		
		Scene scene = new Scene(root, 600,800);
		
		stage.setScene(scene);
		stage.setTitle("Advent Calendar");
		stage.show();
	}
}
