/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_2022;

import javax.swing.JFrame;

/**
 *
 * @author sofia
 */
public class Practicas_2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ventana marco = new ventana();
      marco.setVisible(true);
      marco.setTitle("Sistema administrativo de clientes y recursos");
      marco.setSize(590,490);
      marco.setLocationRelativeTo(null);
      marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
