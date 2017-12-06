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
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Aviones implements Comparable<Aviones> {

    String codigo, partida, destino;
    int distancia, tiempoEspera;
    

    public Aviones() {
        this.codigo = null;
        this.partida = null;
        this.destino = null;
        this.distancia = 0;
        this.tiempoEspera = 0;
    }

    public Aviones(String codigo, String partida, String destino, int distancia, int tiempoEspera) {
        this.codigo = codigo;
        this.partida = partida;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempoEspera = tiempoEspera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public String toString() {
        return "Codigo=" + codigo + ", partida=" + partida + ", destino=" + destino + ", distancia=" + distancia + ", tiempoEspera=" + tiempoEspera + '}';
    }

    public Queue<Aviones> separandoCola(PriorityQueue<Aviones> colaJunta, PriorityQueue<Aviones> prioridad1, PriorityQueue<Aviones> prioridad2, PriorityQueue<Aviones> prioridad3) {
        ArrayList<Aviones> temp = new ArrayList<Aviones>();
        ArrayList<Aviones> temp1 = new ArrayList<Aviones>();
        ArrayList<Aviones> temp2 = new ArrayList<Aviones>();
        Queue<Aviones> colaNueva=new LinkedList<Aviones>();
        Iterator it = colaJunta.iterator();
        while (it.hasNext()) {
            Aviones line = (Aviones) it.next();
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
        for (Aviones n : temp) {
            prioridad1.offer(n);
        }
        for (Aviones n1 : temp1) {
            prioridad2.offer(n1);
        }
        for (Aviones n2 : temp2) {
            prioridad3.offer(n2);
        }
        System.out.println("Menores a 500");
        for (Aviones linea : temp) {
            System.out.println(linea);
        }
        System.out.println("\nEntre 500 y 1000");
        for (Aviones linea : temp1) {
            System.out.println(linea);
        }
        System.out.println("\nMayores a 1000");
        for (Aviones linea : temp2) {
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
        System.out.println(colaNueva);
        return colaNueva;
    }

    @Override
    public int compareTo(Aviones a) {
        if ((int) a.getTiempoEspera() > (int) this.getTiempoEspera()) {
            return 1;
        }
        if ((int) a.getTiempoEspera() < (int) this.getTiempoEspera()) {
            return -1;
        }
        return 0;
    }

    public PriorityQueue<Aviones> instanciando(String fichero, PriorityQueue<Aviones> colaPrioridad) throws FileNotFoundException {
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
                colaPrioridad.offer(new Aviones(dat, dat1, dat2, dat3, dat4));
            }
            b.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return colaPrioridad;
    }
    
    public ListView<Aviones> llenandoTabla(ListView<Aviones> lista, Queue<Aviones> cola){
        
        Iterator it= cola.iterator();
        while(it.hasNext()){
            Aviones linea= (Aviones) it.next();
            lista.getItems().add(linea);
            
        }
        
    return lista;
    }
}
