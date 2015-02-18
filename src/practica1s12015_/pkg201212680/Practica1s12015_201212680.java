/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1s12015_.pkg201212680;

import com.estructuras.*;
import com.gui.Tablero;
/**
 *
 * @author Walter Mendoza
 */
public class Practica1s12015_201212680 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* Lista<String>  cola = new Lista<>();
        
        cola.agregar("Primero");
        cola.agregar("Segundo");
        cola.agregar("Tercero");
        cola.printA();
        cola.printD();*/
        /*
      //  for (int i = 0 ;i < cola.getSize();i++)
        while(!cola.vacia())
        {
            System.out.println(cola.pop());
        }
        
        System.out.println(cola.getSize());*/
       /*
        if (cola.vacia())
            System.out.println("Vacia");
        else
            System.out.println("con elementos");
        */
        MatrizOrtogonal mo = new MatrizOrtogonal(10,10);
        mo.print();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }
    
}
