/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class moviendoEnEjeX extends Application {

    @Override
    public void start(Stage stage) {
        VBox vb = new VBox();
          vb.setLayoutX(0);
        vb.setLayoutY(50);
        Line line = new Line();
      //  line.setScaleY(20);
       // line.setScaleX(20);
        line.setStartX(0);
       // line.setStartY(-300);
        line.setEndX(800);
       // line.setEndY(-300);
        line.setFill(Color.BLACK);
        //vb.setAlignment(Pos.CENTER);
        
        vb.getChildren().add(line);
        Circle circle= new Circle();
        circle.setRadius(30);
        
        
        Group root = new Group();
       
        
        root.getChildren().add(vb);
      // root.getChildren().add(line);
        
        Scene scene= new Scene(root,Color.GREY);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String args[]) {
        launch(args);
    }
}
