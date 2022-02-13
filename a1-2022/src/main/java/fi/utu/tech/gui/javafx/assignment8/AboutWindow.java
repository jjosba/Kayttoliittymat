package fi.utu.tech.gui.javafx.assignment8;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AboutWindow extends MainApp8 implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		Stage stage = new Stage();
				
		StackPane pane = new StackPane();
		pane.setAlignment(Pos.CENTER);
				
		int x = 300;
		int y = 300;
		int vari = 1;
		
		while(x >= 5) {
			Rectangle nelio = new Rectangle();
			nelio.setX(x+5);
			nelio.setY(y+5);
			nelio.setWidth(x);
			nelio.setHeight(y);
			if(vari%3 == 0) {
				nelio.setFill(Color.LIGHTCYAN);
			}else if(vari%3 == 1) {
				nelio.setFill(Color.ANTIQUEWHITE);
			}else {
				nelio.setFill(Color.LAVENDER);
			}
			pane.getChildren().add(nelio);
			x -=5;
			y -=5;
			vari +=1;
			}

//		miten toimii?		
//		int kerroin = 1;
//		int nimit = 1;
//		int v = 1;
//		
//		for(int i = 0;i < 10; i++){
//            Polygon heksa = new Polygon();
//            heksa.getPoints().addAll(new Double[]{
//                    200.0*kerroin, 50.0*kerroin,
//                    300.0*kerroin, 50.0*kerroin,
//                    350.0*kerroin, 150.0*kerroin,
//                    300.0*kerroin, 250.0*kerroin,
//                    200.0*kerroin, 250.0*kerroin,
//                    150.0*kerroin, 150.0*kerroin});
//            if (v%2 == 0) {
//                heksa.setFill(Color.LIGHTCYAN);
//            }else {
//                heksa.setFill(Color.LAVENDER);
//            }
//            pane.getChildren().add(heksa);
//            nimit += 2;
//            kerroin = 1/nimit;
//            v += 1;
//		}
            
		Scene scene = new Scene(pane,300,300);
		
		stage.setScene(scene);
		stage.setTitle("About-ikkuna");
		stage.show();
	}
}
