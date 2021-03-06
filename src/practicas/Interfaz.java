package practicas;

import java.io.File;
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
      PriorityQueue<Aviones> colaJunta= new PriorityQueue();
        PriorityQueue<Aviones> prioridad1= new PriorityQueue();
        PriorityQueue<Aviones> prioridad2= new PriorityQueue();
        PriorityQueue<Aviones> prioridad3= new PriorityQueue();

        

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Avion a=new Avion();
       /*  PriorityQueue<Aviones> colaJunta= new PriorityQueue();
        PriorityQueue<Aviones> prioridad1= new PriorityQueue();
        PriorityQueue<Aviones> prioridad2= new PriorityQueue();
        PriorityQueue<Aviones> prioridad3= new PriorityQueue(); */
        Button cargarLista = new Button("Cargar Listado");
        Button simulador = new Button("Empezar Simulación");
        //Button pausar = new Button("Pausar Simulación");
        Button avisoProblema = new Button("Aviso Problema");
        Label text = new Label("Preparandose para el despegue");
        // texto.setAlignment(Pos.TOP_CENTER);
        //  simulador.setText("Empezar Simulación");
        avisoProblema.setVisible(false);
        avisoProblema.setManaged(false);
        simulador.setVisible(false);
        simulador.setManaged(false);
        // cargarLista.setText("Cargar Listado");
        cargarLista.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    String texto = "";
                    try {
                        texto = file.getAbsolutePath();
                        Aviones avion = new Aviones();
                        avion.instanciando(texto, colaJunta);
                        Queue<Aviones> lista = avion.separandoCola(colaJunta, prioridad1, prioridad2, prioridad3);
                        
                        a.setCola(lista);
                        //System.out.println(avion.separandoCola(colaJunta, prioridad1, prioridad2, prioridad3));
                        simulador.setVisible(true);
                        simulador.setManaged(true);
                        text.setText("Vamos a comenzar con la Simulación");
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
                /*Avion avion = new Avion();
                Thread hilo = new Thread(avion);
                hilo.start();*/
                Avion escena = new Avion(a.getCola());
                

                primaryStage.setScene(escena.Simulacion());

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
        Scene scene = new Scene(pane, 700, 700);

        primaryStage.setTitle("***Aeropuerto***");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
