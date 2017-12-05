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
public class Pista {
    ArrayList<Label> ListaAviones = new ArrayList <Label>(); 

    public Pista(ArrayList<Label> listaAviones) {
        this.ListaAviones=listaAviones;
    }
    
    public Pista(){
    
    }

    public ArrayList<Label> getListaAviones() {
        return ListaAviones;
    }

    public void setListaAviones(ArrayList<Label> ListaAviones) {
        this.ListaAviones = ListaAviones;
    }

    public Scene SimulacionPista() {
        StackPane root = new StackPane();     
        VBox colaAviones = new VBox();
        //Aviones aviones = new Aviones();
        Iterator LLP = ListaAviones.iterator();
        while(LLP.hasNext()){
            Label temp = (Label) LLP.next();
            colaAviones.getChildren().add(temp);
        }
        
        //llenarPista(ListaAviones, colaAviones);
        root.getChildren().add(colaAviones);
        Scene scene = new Scene(root, 400, 400);
        return scene;
        
    }
    
    
    
    public void llenarPista(Aviones aviones){        
        while(!aviones.cola.isEmpty()){
            System.out.println("Hasta aqui");
            Label temp = new Label(aviones.cola.poll().codigo);
            this.ListaAviones.add(temp);
        }        
        
        
    }
    
}
