package fi.utu.tech.gui.javafx.assignment3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp3 extends Application {
	
	private Line line;

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
	        rootPane.getChildren().addAll(source, dest);

            source.setOnMouseClicked(new EventHandler<MouseEvent>() {
            	
            	@Override
            	public void handle(MouseEvent e) {
            		Rectangle punainen = (Rectangle) e.getSource();
                	line = new Line();
                	rootPane.getChildren().add(line);
                	line.setMouseTransparent(true);
                	line.setStartX(punainen.getLayoutX()+50);
    	        	line.setStartY(punainen.getLayoutY()+50);
    	        }
            });
            
        	rootPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
        		
        		@Override
        		public void handle(MouseEvent event) {
        			if (line != null) {  	
        				line.setEndX(event.getX());
        				line.setEndY(event.getY());
        			}
        		}
	        });            
        	
            dest.setOnMouseClicked(new EventHandler<MouseEvent>() {
            	
            	@Override
        		public void handle(MouseEvent e) {
	            	Rectangle sininen = (Rectangle) e.getSource();
	            	if (line != null) {
		            	line.setEndX(sininen.getLayoutX()+50);
		            	line.setEndY(sininen.getLayoutY()+50);
		            	line = null;
	            	}
            	}
            });
            
            rootPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            	
            	@Override
            	public void handle(MouseEvent event) {
            		if (event.getButton() == MouseButton.SECONDARY) {
            			rootPane.getChildren().remove((rootPane.getChildren()).size()-1);
            		}
            	}
            });
	    }
        
        // Create scene and attach root pane
        Scene scene = new Scene(rootPane);
        // Set scene to the main stage
        stage.setScene(scene);
        // Set the stage visible once every component has been attached
        stage.show();
    }

}
