/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Antho
 */
public class Pista extends Application {
 
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();     
        VBox colaAviones = new VBox();
        Aviones aviones = new Aviones();
        
        
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Aeropuerto");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void llenarPista(ArrayList<Label> listaAviones){
        Iterator it = listaAviones.iterator();
        
        
    }
    
}
