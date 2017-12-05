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
import javafx.scene.control.Label;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Avion implements Comparable<Avion> {

    String codigo, partida, destino;
    int distancia, tiempoEspera;
    //Label AvionCompleto;

    public Avion() {
        this.codigo = null;
        this.partida = null;
        this.destino = null;
        this.distancia = 0;
        this.tiempoEspera = 0;
    }

    public Avion(String codigo, String partida, String destino, int distancia, int tiempoEspera) {
        this.codigo = codigo;
        this.partida = partida;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempoEspera = tiempoEspera;
    }
    
    /*public void CrearAvion(ArrayList<Label> a){
        AvionCompleto=new Label(codigo+"\n"+partida+"\n");
        a.add(AvionCompleto);
        
    }*/

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

    @Override
    public int compareTo(Avion a) {
        if ((int) a.getTiempoEspera() > (int) this.getTiempoEspera()) {
            return 1;
        }
        if ((int) a.getTiempoEspera() < (int) this.getTiempoEspera()) {
            return -1;
        }
        return 0;
    }

    
}
