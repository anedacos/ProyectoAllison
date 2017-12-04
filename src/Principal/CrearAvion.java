/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javafx.scene.image.ImageView;
/**
 *
 * @author Antho
 */
public class CrearAvion {
    private static final String avion = "Imagenes/avioncito.png";
    private static ImageView img;
    
     public CrearAvion(int tipoAvion){
        setAvion(tipoAvion);
    }
     
     public static ImageView setAvion(int tipoAvion){
        if (tipoAvion==0){
            img = new ImageView(avion);
        }
        return img;
    }
    
}
