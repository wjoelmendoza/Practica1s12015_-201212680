/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1s12015_.pkg201212680;

import com.estructuras.*;
//import com.gui.Tablero;
import com.graphViz.GraphViz;
import com.gui.Tablero;
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
        
        //plantas.graficar();
        /*
        planta.graficar("ListaPlantas");
        */
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
        
        //pruebaPC();
        //pruebaJG();
    }
    
    public static void pruebaJG()
    {
        ListaJ lj = new ListaJ();
        Jugador pt = new Jugador(100,"Walter","Plantas");
        pt.addDato("Joel");
        pt.addDato("Mendoza");
        pt.addDato("algomas");
        lj.addJugador(pt);
        
        Jugador zb = new Jugador(100,"Edgar","Zombie");
        zb.addDato("Canastuj");
        zb.addDato("Usac");
        zb.addDato("quimico");
        
        lj.addJugador(zb);
        
        lj.graficar();
    }
    
    public static void pruebaPC()
    {
       Personaje a = new Personaje("melocoton","Disparo","Planta","noImage",10,500);
        Personaje b = new Personaje("sandia","Disparo","Planta","noImage",10,500);
        Personaje c = new Personaje("col","Disparo","Planta","noImage",10,500);
        Personaje d = new Personaje("repollo","Disparo","Planta","noImage",10,500);
        Personaje e = new Personaje("maiz","Disparo","Planta","noImage",10,500);
        
        Lista<Personaje> planta = new Lista<>();
        
        planta.agregar(a);
        planta.agregar(b);
        planta.agregar(c);
        planta.agregar(d);
        planta.agregar(e);
        
        Cola plantas = new Cola(planta,15);
        plantas.graficar();
        Pila zombies = new Pila(planta,15);
        zombies.graficar();
        zombies.start();
       
        plantas.start(); 
    }
    
}
