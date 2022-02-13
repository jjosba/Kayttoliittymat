package fi.utu.tech.gui.javafx.assignment8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp8 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	var loader = new FXMLLoader(getClass().getResource("Example.fxml"));
    	
    	Scene scene = new Scene(loader.load());
    	
    	stage.setScene(scene);
        stage.show();
    }

}
