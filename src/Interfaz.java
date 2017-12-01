import java.io.File;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class Interfaz extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button cargarLista = new Button("Cargar Listado");
        Button simulador = new Button("Empezar Simulación");
        Button pausar = new Button("Pausar Simulación");
        Button avisoProblema = new Button("Aviso Problema");
        Label text = new Label("Preparandose para el despegue");
        // texto.setAlignment(Pos.TOP_CENTER);
        //  simulador.setText("Empezar Simulación");
        avisoProblema.setVisible(false);
        avisoProblema.setManaged(false);
        simulador.setVisible(false);
        simulador.setManaged(false);
        pausar.setVisible(false);
        pausar.setManaged(false);
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
                        avion.instanciando(texto);
                        System.out.println(avion.instanciando(texto));
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
                pausar.setVisible(true);
                pausar.setManaged(true);
                Group grupo = new Group();
                Label l1 = new Label("1");
                l1.setLayoutX(240);
                l1.setLayoutY(180);
                Label l2 = new Label("2");
                l2.setLayoutX(240);
                l2.setLayoutY(230);
                Label l3 = new Label("3");
                l3.setLayoutX(240);
                l3.setLayoutY(280);
                Label l4 = new Label("4");
                l4.setLayoutX(240);
                l4.setLayoutY(330);
                Label l5 = new Label("5");
                l5.setLayoutX(240);
                l5.setLayoutY(380);
                Label l6 = new Label("6");
                l6.setLayoutX(240);
                l6.setLayoutY(430);
                Label l7 = new Label("7");
                l7.setLayoutX(240);
                l7.setLayoutY(480);
                Label l8 = new Label("8");
                l8.setLayoutX(240);
                l8.setLayoutY(540);
                
             
                grupo.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8,pausar);
                Scene escenaSimulacion = new Scene(grupo, 600, 600);
                primaryStage.setScene(escenaSimulacion);

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
