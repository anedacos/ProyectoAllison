/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

import javafx.util.Duration;

/**
 *
 * @author User
 */
public class Hilo extends Thread {
    @Override
    public void run() {
        try {
            Avion.interrupted();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
