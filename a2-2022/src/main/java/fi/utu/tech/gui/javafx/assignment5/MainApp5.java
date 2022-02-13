package fi.utu.tech.gui.javafx.assignment5;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp5 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BossKey Example");

        // Scene and layout for the main view
        VBox root = new VBox();
        Scene mainScene = new Scene(root, 500, 300);

        // Scene for the BOSS view
        Scene bossScene = new Scene(new Label("Nothing suspicious here"), 500, 300);

        List<TextField> fields = new ArrayList<TextField>();
        for (int i = 0; i < 10; i++) {
            fields.add(new TextField());
        }
      
        mainScene.addEventFilter(KeyEvent.KEY_TYPED, key -> {
	        if (key.getCharacter().equals("b")) {
        		stage.setScene(bossScene);
        		key.consume();
        	}
        });
        
        bossScene.addEventFilter(KeyEvent.KEY_TYPED, key -> {
	        if (key.getCharacter().equals("b")) {
        		stage.setScene(mainScene);
        		key.consume();
        	}
        });
        
        // Create components for main view
        root.getChildren().addAll(fields);
        root.getChildren().add(new Button("Hello!"));

        stage.setScene(mainScene);
        stage.show();

    }

}
