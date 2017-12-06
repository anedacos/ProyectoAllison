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
public class principalClase {
    public static void main(String[] args){
        ArrayList matriz = new ArrayList();
        Random rand = new Random();
        
        for (int i=0;i<=10;i++)
            //System.out.println(i);
            matriz.add(i);
            
        System.out.println(matriz);
        matriz.set(0, 2);
        System.out.println(matriz);
        for (Object k: matriz){
           // boolean j; 
        }
        System.out.println(matriz);
        matriz.set(1,2);
        System.out.println(matriz);
            
            
        }
        
    
    }
    

