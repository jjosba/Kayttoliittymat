package fi.utu.tech.gui.javafx.assignment1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp1 extends Application {

    @Override
    public void start(Stage stage) {
        // Set title for the Main window
        stage.setTitle("Connect points");
        stage.setWidth(600);
        stage.setHeight(800);

        // Create Layout components for the main interface
        Pane rootPane = new Pane();
        
        // Create squares
        for (int i = 0; i < 5; i++) {
            var source = new Rectangle(100, 100, Color.RED);
            var dest = new Rectangle(100, 100, Color.BLUE);
            source.relocate(0, i * 150);
            dest.relocate(500, i * 150);
            
            source.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            	Rectangle nelio = (Rectangle) e.getSource();
            	Line line = new Line();
	        	line.setStartX(nelio.getLayoutX()+50);
	        	line.setStartY(nelio.getLayoutY()+50);
	        	
	        	rootPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
	                
	        		@Override
	                public void handle(MouseEvent event) {
	                	line.setEndX(event.getX());
	                	line.setEndY(event.getY());
	                }
	            });
	        	rootPane.getChildren().add(line);
	        });
	        rootPane.getChildren().addAll(source, dest);
	    }       
            
        // Create scene and attach root pane
        Scene scene = new Scene(rootPane);
        // Set scene to the main stage
        stage.setScene(scene);
        // Set the stage visible once every component has been attached
        stage.show();
    }

}
