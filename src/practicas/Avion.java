package practicas;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author User
 */
public class Avion extends Thread {
    //Hilo hilo = new Hilo();
    Button pausar = new Button("Pausar Simulación");
    Slider slider = new Slider();
    @Override
    public void run() {
        try {
            Avion.sl
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Group Contenido(Group grupo) {
        slider.setMin(0);
        slider.setMax(10);
        slider.setValue(0);
        //Button pausar = new Button("Pausar Simulación");
        pausar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(pausar.isPressed()==true){
                run();
            }}
        });

        VBox vb = new VBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        LinkedList<Label> arr = new LinkedList();
        Interfaz interfaz = new Interfaz();
        interfaz.prioridad1.toString();

        Iterator itp1 = interfaz.prioridad1.iterator();
        Iterator itp2 = interfaz.prioridad2.iterator();
        Iterator itp3 = interfaz.prioridad3.iterator();

        while (itp1.hasNext()) {
            Object infor1 = itp1.next();
            Label label = new Label((String) infor1);
            arr.add(label);
        }

        while (itp2.hasNext()) {
            Object infor2 = itp2.next();
            Label label = new Label((String) infor2);
            arr.add(label);
        }
        while (itp3.hasNext()) {
            Object infor3 = itp3.next();
            Label label = new Label((String) infor3);
            arr.add(label);
        }

        for (int i = 0; i < interfaz.prioridad1.size(); i++) {
            hb1.getChildren().add(arr.get(i));
            System.out.println("Holiita");
        }

        for (int i = interfaz.prioridad1.size(); i < interfaz.prioridad1.size() + interfaz.prioridad2.size(); i++) {
            hb2.getChildren().add(arr.get(i));
        }
        for (int i = interfaz.prioridad1.size() + interfaz.prioridad2.size(); i < interfaz.prioridad1.size() + interfaz.prioridad2.size() + interfaz.prioridad3.size(); i++) {
            hb3.getChildren().add(arr.get(i));
        }

        vb.getChildren().add(hb1);
        vb.getChildren().add(hb2);
        vb.getChildren().add(hb3);
        vb.getChildren().add(pausar);
        vb.getChildren().add(slider);
        grupo.getChildren().add(vb);

        return grupo;
    }

    public Scene Simulacion() {
        //Contenedora contenedor= new Contenedora();
        VBox vb = new VBox();
        VBox vbi = new VBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();

        LinkedList<Label> arr = new LinkedList();
        Group grupo = new Group();

        Contenido(grupo);
        /*    
        for (int i = 0; i < 7; i++) {
            Label label = new Label("1");
            arr.add(label);
        }
        
        for (int j=0; j < 3; j++) {
            Label label = new Label("2");
            arr.add(label);
        }
        
        for (int i = 0; i < 5; i++) {
            Label label = new Label("3");
            arr.add(label);
        }
        
        
        
        
        for(int h=0;h<7;h++){
            hb1.getChildren().add(arr.get(h));
        }
        
        for(int h=7;h<10;h++){
            hb2.getChildren().add(arr.get(h));
        }
        
        for(int h=10;h<15;h++){
            hb3.getChildren().add(arr.get(h));
        }
        
        vb.getChildren().add(hb1);
        vb.getChildren().add(hb2);
        vb.getChildren().add(hb3);
        grupo.getChildren().add(vb);
        /*for (int j = 0; j < 3; j++) {
            vb.getChildren().add(arr.get(j));
        }*/


 /* Label l1 = new Label();
        l1.set
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
         */
        //grupo.getChildren().addAll(l1, l2, l3, l4, l5, l6, l7, l8, pausar);
        Scene escenaSimulacion = new Scene(grupo, 600, 600);
        return escenaSimulacion;
    }
    
    public Queue<Aviones> cogiendoColaInterfaz(Queue<Aviones> cola){
        return cola;
    }
}
