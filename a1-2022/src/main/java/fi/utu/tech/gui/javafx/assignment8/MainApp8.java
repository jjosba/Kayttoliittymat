package fi.utu.tech.gui.javafx.assignment8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp8 extends Application {

	@Override
	public void start(Stage stage) throws FileNotFoundException { //miten try catch?
		
		BorderPane root = new BorderPane();
		
		//yläosan painikkeet
		Button b1 = new Button("Cheat");
		Button b2 = new Button("Regret");
		Label ot = new Label("Badabim badabum");
		Button b3 = new Button("About");
		
		//lisätään HBoxiin
		HBox top = new HBox(12); //12 px väli
		top.getChildren().addAll(b1,b2,ot,b3);
		HBox.setHgrow(ot, Priority.ALWAYS); //ohjeteksti täyttää ylimääräisen tilan + keskitetty
		ot.setMaxWidth(Double.MAX_VALUE);
		ot.setAlignment(Pos.CENTER);
		root.setTop(top); //rootin top-osaan

		//About-ikkuna
		EventHandler<ActionEvent> about = new AboutWindow();
		b3.setOnAction(about);
		
		//button piiloon
		EventHandler<ActionEvent> hide = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				((Button) e.getSource()).setVisible(false);
			}
		};
		
		//päivämääräruudukko
		GridPane ruudut = new GridPane();
		int luku = 1; //luukun teksti
		for(int rivi=1;rivi<7;rivi++) {
			for(int solu=1;solu<5;solu++) {
				Button paiva = new Button();
				paiva.setText(String.valueOf(luku));
				paiva.setMaxWidth(Double.MAX_VALUE); //buttonien ja gridin tila
				paiva.setMaxHeight(Double.MAX_VALUE);
				paiva.setOnAction(hide);
				GridPane.setHgrow(paiva, Priority.ALWAYS);
				GridPane.setVgrow(paiva, Priority.ALWAYS);
				ruudut.add(paiva, solu, rivi); //lisätään button gridiin
				luku++;
			}	
		}
		
		//piilotetaan luukut
		EventHandler<ActionEvent> eventCheat = e -> ruudut.setVisible(false);
		b1.setOnAction(eventCheat);
		
		//näytetään luukut
        EventHandler<ActionEvent> eventRegret = e -> ruudut.setVisible(true);
        b2.setOnAction(eventRegret);
		
        //taustakuva
        StackPane keski = new StackPane();
        keski.getChildren().add(ruudut);
        		
		FileInputStream input = new FileInputStream("src/main/resources/kuva.jpg");
		Image kuva = new Image(input);
		
		BackgroundImage bgi = new BackgroundImage(kuva,BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		
		Background bg = new Background(bgi);
		
		keski.setBackground(bg);
		
		root.setCenter(keski);
		
		//scene
		Scene scene = new Scene(root, 600,800);
		
		stage.setScene(scene);
		stage.setTitle("Advent Calendar");
		stage.show();
	}
}
