
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Aviones implements Comparable<Aviones>{

    String codigo, partida, destino;
    int distancia, tiempoEspera;

    public Aviones() {
        this.codigo = null;
        this.partida = null;
        this.destino = null;
        this.distancia = 500;
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

    @Override
    public int compareTo(Aviones a) {
        if (a.getDistancia() < this.getDistancia()) {
            if (a.getTiempoEspera() > this.getTiempoEspera()) {
                return -1;
            }
            if (a.getTiempoEspera() < this.getTiempoEspera()) {
                return 1;
            }
        }
        if (a.getDistancia() > this.getDistancia()) {
            if (a.getTiempoEspera() > this.getTiempoEspera()) {
                return 1;
            }
            if (a.getTiempoEspera() < this.getTiempoEspera()) {
                return -1;
            }

        }

        return 0;
    }

    public PriorityQueue instanciando(String fichero) throws FileNotFoundException {
        PriorityQueue<Aviones> colaPrioridad = new PriorityQueue();
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
            Iterator it = colaPrioridad.iterator();
            while (it.hasNext()) {
                Object sig = it.next();
                System.out.println(sig);
            }
            b.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return colaPrioridad;
    }}