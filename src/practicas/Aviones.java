package practicas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author User
 */
public class Aviones extends Thread {
    //Hilo hilo = new Hilo();
    Button pausar = new Button("Pausar Simulación");
    Slider slider = new Slider();
    Queue<Avion> cola;
    VBox panelAvion;
    ArrayList<Label> aviones = new ArrayList <Label>();
    
    

    public Aviones(Queue<Avion> cola) {
        this.cola = cola;
    }

    public Aviones() {
        
    }

    public Queue<Avion> getCola() {
        return cola;
    }

    public void setCola(Queue<Avion> cola) {
        this.cola = cola;
    }
        
    @Override
    public void run() {
        try {
            //Avion.
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
                //run();
            }}
        });

        VBox vb = new VBox();
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        LinkedList<Label> arr = new LinkedList();
        Iterator it = cola.iterator();        
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
        Scene escenaSimulacion = new Scene(grupo, 600, 600);
        return escenaSimulacion;
    }
    
    public Queue<Avion> separandoCola(PriorityQueue<Avion> colaJunta, PriorityQueue<Avion> prioridad1, PriorityQueue<Avion> prioridad2, PriorityQueue<Avion> prioridad3) {
        ArrayList<Avion> temp = new ArrayList<Avion>();
        ArrayList<Avion> temp1 = new ArrayList<Avion>();
        ArrayList<Avion> temp2 = new ArrayList<Avion>();
        Queue<Avion> colaNueva=new LinkedList<Avion>();
        Iterator it = colaJunta.iterator();
        while (it.hasNext()) {
            Avion line = (Avion) it.next();
            if (line.getDistancia() < 500) {
                temp.add(line);
                //prioridad1.offer(line);
            }
            if (line.getDistancia() >= 500 && line.getDistancia() <= 1000) {
                temp1.add(line);
                //prioridad2.offer(line);
            }
            if (line.getDistancia() > 1000) {
                temp2.add(line);
                //prioridad3.offer(line);
            }
        }
        Collections.sort(temp);
        Collections.sort(temp1);
        Collections.sort(temp2);
        for (Avion n : temp) {
            prioridad1.offer(n);
        }
        for (Avion n1 : temp1) {
            prioridad2.offer(n1);
        }
        for (Avion n2 : temp2) {
            prioridad3.offer(n2);
        }
        System.out.println("Menores a 500");
        for (Avion linea : temp) {
            System.out.println(linea);
        }
        System.out.println("\nEntre 500 y 1000");
        for (Avion linea : temp1) {
            System.out.println(linea);
        }
        System.out.println("\nMayores a 1000");
        for (Avion linea : temp2) {
            System.out.println(linea);
        }
      //  colaJunta.clear();
        while (!prioridad1.isEmpty()) {
            colaNueva.offer(prioridad1.poll());
        }

        while (!prioridad2.isEmpty()) {
            colaNueva.offer(prioridad2.poll());
        }
        while (!prioridad3.isEmpty()) {
            colaNueva.offer(prioridad3.poll());
        }
        
         while (it.hasNext()) {
            Avion line2 = (Avion) it.next();
            line2.AgregarAvion(aviones);
        }
        
        System.out.println("\n Posi \n");
        for (Avion cn : colaNueva) {
            System.out.println(cn);
        }
        
        return colaNueva;
    }

     public PriorityQueue<Avion> instanciando(String fichero, PriorityQueue<Avion> colaPrioridad) throws FileNotFoundException {
        String linea = "";
        try {
            final BufferedReader b = new BufferedReader(new FileReader(fichero));
            while ((linea = b.readLine()) != null) {
                String[] data = linea.split("\\|");
                String dat = data[0];
                String dat1 = data[1];
                String dat2 = data[2];
                int dat3 = Integer.parseInt(data[3]);
                int dat4 = Integer.parseInt(data[4]);
                colaPrioridad.offer(new Avion(dat, dat1, dat2, dat3, dat4));
            }
            b.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return colaPrioridad;
    }
    
}
