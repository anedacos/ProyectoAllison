package practicas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Interfaz extends Application {
      PriorityQueue<Avion> colaJunta= new PriorityQueue();
        PriorityQueue<Avion> prioridad1= new PriorityQueue();
        PriorityQueue<Avion> prioridad2= new PriorityQueue();
        PriorityQueue<Avion> prioridad3= new PriorityQueue();

        

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Aviones aviones = new Aviones();
        ArrayList<Label> ListaAviones = new ArrayList <Label>();
        
        Button cargarLista = new Button("Cargar Listado");
        Button simulador = new Button("Empezar Simulación");
        Button avisoProblema = new Button("Aviso Problema");
        Label text = new Label("Preparandose para el despegue");
        avisoProblema.setVisible(false);
        avisoProblema.setManaged(false);
        simulador.setVisible(false);
        simulador.setManaged(false);
        cargarLista.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    String texto = "";
                    try {
                        texto = file.getAbsolutePath();                        
                        aviones.instanciando(texto, colaJunta);
                        aviones.setCola(aviones.separandoCola(colaJunta, prioridad1, prioridad2, prioridad3));
                        
                        
                        simulador.setVisible(true);
                        simulador.setManaged(true);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        });
        //Scene escenaSimulacion;
        simulador.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pista pista = new Pista();
                pista.llenarPista(aviones);
                System.out.println("");                
                System.out.println("==============");
                
                System.out.println(aviones.cola.poll());               
               
                pista.SimulacionPista();                

            }
        });

        VBox vb = new VBox();
        vb.setSpacing(9);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().add(text);
        vb.getChildren().add(cargarLista);
        vb.getChildren().add(simulador);

        vb.getChildren().add(avisoProblema);

        StackPane pane = new StackPane();
        pane.getChildren().add(vb);
        Scene scene = new Scene(pane, 700, 600);

        primaryStage.setTitle("***Aeropuerto***");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   

}
