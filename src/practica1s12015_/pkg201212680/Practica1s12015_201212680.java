/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1s12015_.pkg201212680;

import com.estructuras.*;
//import com.gui.Tablero;
import com.graphViz.GraphViz;
import java.io.File;
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
        Pila<String>  cola = new Pila<>();
        
        cola.push("Primero");
        cola.push("Segundo");
        cola.push("Tercero");
        cola.push("Cuarto");
        
        File ext= new File("pila.gif");
        GraphViz g = cola.grafiacar();
        g.writeGraphToFile(g.getGraph(g.getDotSource(), "gif"), ext);
       // cola.printD();*/
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
       
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tablero().setVisible(true);
            }
        });
        */
        //GraphViz a= new GraphViz();
    }
    
}
