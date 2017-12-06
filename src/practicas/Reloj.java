/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import java.util.Scanner;

/**
 *
 * @author Antho
 */
public class Reloj {
    
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int hora = 0;
        int minuto = 0;
        int segundo = 0;
 
        System.out.println("Dame hora, minuto y segundo");
        hora = t.nextInt();
        while(!(hora >= 0 && hora <24)){
            System.out.println("La hora no cumplea el estandar de 24 horas");
            hora = t.nextInt();
        }
        minuto = t.nextInt();
        while(!(minuto >= 0 && minuto <60)){
            System.out.println("Los minutos no cumplen el estandar");
            minuto = t.nextInt();
        }
        segundo = t.nextInt();
        while(!(segundo >= 0 && segundo <60)){
            System.out.println("Los segundo no cumplen el estandar");
            segundo = t.nextInt();
        }
 
        System.out.printf("La hora es:%d:%d:%d\n",hora,minuto,segundo);
         
        System.out.println("La hora mas un segundo");
 
        System.out.println(sumarSegundo(hora,minuto,segundo));
 
    }
    
    public static String sumarSegundo(int hor, int min, int seg){
        seg++;
        if(seg > 59){
            min++;
            seg = 0;
            if(min > 59){
                hor++;
                min = 0;
                if(hor > 23){
                    hor = 0;
                }
            }
        }
        return hor + ":" + min + ":" + seg;
    }
    
}
