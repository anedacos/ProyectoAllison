/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class llenandoMatrizNumeroAleatorio {

    public static void llenando(String[] args) {
       // ArrayList cadena = new ArrayList();
        ArrayList matriz = new ArrayList();
        Random num = new Random();
        for (int i = 0; i <= 9; i++) {
            int j = num.nextInt(4);
            matriz.add(j);
        }
        System.out.println(matriz);
        System.out.println(matriz.contains(3));
        System.out.println(matriz.indexOf(0));
       // cadena[0]="e";
        
        //System.out.println(cadena.s);

    }
}
