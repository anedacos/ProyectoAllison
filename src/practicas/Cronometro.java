package practicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class Cronometro extends Application {

    Label tiempo;
    //Thread hilo;
    boolean cronometroActivo = true;

    boolean bandera = true;

    @Override
    public void start(Stage primaryStage) {
        tiempo = new Label("00:00:000");
        //System.out.println("Hola");
        Pane root = new Pane();
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer minutos = 0, segundos = 0, milesimas = 0;
                    //min es minutos, seg es segundos y mil es milesimas de segundo
                    String min = "", seg = "", mil = "";
                    //Mientras cronometroActivo sea verdadero entonces seguira
                    //aumentando el tiempo

                    while (bandera) {
                        System.out.println("hola");
                        Thread.sleep(4);
                        milesimas += 4;
                        //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                        //y las milesimas de segundo de nuevo a 0
                        if (milesimas == 1000) {
                            milesimas = 0;
                            segundos += 1;
                            //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                            //y los segundos vuelven a 0
                            if (segundos == 60) {
                                segundos = 0;
                                minutos++;
                            }
                        }

                        //Esto solamente es estetica para que siempre este en formato
                        //00:00:000
                        if (minutos < 10) {
                            min = "0" + minutos;
                        } else {
                            min = minutos.toString();
                        }
                        if (segundos < 10) {
                            seg = "0" + segundos;
                        } else {
                            seg = segundos.toString();
                        }

                        if (milesimas < 10) {
                            mil = "00" + milesimas;
                        } else if (milesimas < 100) {
                            mil = "0" + milesimas;
                        } else {
                            mil = milesimas.toString();
                        }

                        //Colocamos en la etiqueta la informacion
                        
                        tiempo.setText(min + ":" + seg + ":" + mil);
                    }
                } catch (Exception e) {
                }
            }
        }
        );
        hilo.start();

        root.getChildren().add(tiempo);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cronometro");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
