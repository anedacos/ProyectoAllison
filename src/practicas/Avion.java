package practicas;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Avion {

    Thread hilo;
    ListView<Aviones> colaMostrada;
    Integer minutos = 0, segundo = 0, milesima = 0;
    Label cronometro = new Label("00:00:000");    
    String min = "", seg = "", mil = "";

    Queue<Aviones> cola;

    public Avion() {
        this.cola = cola;
    }

    public Avion(Queue<Aviones> cola) {
        this.cola = cola;
    }

    public Queue<Aviones> getCola() {
        return cola;
    }

    public void setCola(Queue<Aviones> cola) {
        this.cola = cola;
    }
    Button pausar = new Button("Pausar Simulación");
    Slider slider = new Slider();

    public StackPane Contenido(StackPane root) {
        Aviones t = null;
        ListView<Aviones> lista = new ListView();
        //lista.setBorder(Border.EMPTY);
        Aviones aviones = new Aviones();
        colaMostrada = aviones.llenandoTabla(lista, cola);
        colaMostrada.setPrefWidth(100);
        colaMostrada.setPrefHeight(70);

        slider.setMin(0);
        slider.setMax(10);
        slider.setValue(5);

        obteniendoDatosDeListView(colaMostrada);
        //modificandoTiempoConValorSlider(slider, t.getTiempoEspera());
        borrandoLineaDeListView(colaMostrada);

        Button pausar = new Button("Pausar Simulación");
        pausar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        VBox vb = new VBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        vb.getChildren().addAll(colaMostrada, slider, pausar, cronometro);
        root.getChildren().add(vb);
        return root;
    }

    public Scene Simulacion() {
        System.out.println("Aqui se deberia ejecutar el hilo");
        StackPane pane = new StackPane();
        //Group grupo = new Group();
        Contenido(pane);
        Scene escenaSimulacion = new Scene(pane, 600, 600);
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {                
                System.out.println("Hasta aqui llega la linea");
                try {
                    boolean c = true;
                    System.out.println("Holi1");
                    System.out.println("Tamanio de la cola: " + colaMostrada.getItems().size());
                    while (c = true) {
                        Thread.sleep(4);
                        milesima += 4;
                        if (milesima == 1000) {
                            milesima = 0;
                            segundo += 1;
                            System.out.println("Segundo" + segundo);
                            if (segundo == 60) {
                                segundo = 0;
                                minutos++;
                                System.out.println("Minuto" + minutos);
                            }
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    if (segundo % 5 == 0 && segundo >= 5) {
                                        System.out.println("Posi");

                                        obteniendoDatosDeListView(colaMostrada);
                                        borrandoLineaDeListView(colaMostrada);

                                    }
                                }
                            });

                        }
                        
                        if (minutos < 10) {
                            min = "0" + minutos;
                        } else {
                            min = minutos.toString();
                        }
                        if (segundo < 10) {
                            seg = "0" + segundo;
                        } else {
                            seg = segundo.toString();
                        }

                        if (milesima < 10) {
                            mil = "00" + milesima;
                        } else if (milesima < 100) {
                            mil = "0" + milesima;
                        } else {
                            mil = milesima.toString();
                        }

                        cronometro.setText(min + ":" + seg + ":" + mil);

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        hilo.start();
        return escenaSimulacion;
    }

    //public String<Aviones> sacandoLinea(ListView<Av>)
    public void obteniendoDatosDeListView(ListView<Aviones> lista) {
        Aviones primeraLineaDeListView = null;
        int tiempo = 0;
        if (lista.getItems().size() != 0) {
            primeraLineaDeListView = lista.getItems().get(0);
            System.out.println(primeraLineaDeListView);
            // tiempo = primeraLineaDeListView.getTiempoEspera();
            //System.out.println(tiempo);
        }
        //return primeraLineaDeListView;
    }

    public int modificandoTiempoConValorSlider(Slider slider, int i) {
        System.out.println(i);
        int temp = 0;
        temp = (int) slider.getValue();
        System.out.println(temp);
        i = temp;
        System.out.println(i);
        return i;
    }

    public void borrandoLineaDeListView(ListView<Aviones> lista) {
        if (lista.getItems().size() != 0) {
            int cero = 0;
            lista.getItems().remove(cero);
        }

        //return lista;
    }

}
