/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estructuras;
import com.graphViz.GraphViz;
import java.io.File;
/**
 *
 * @author Walter Mendoza
 */
public class ListaJ {
    private NodoL<Jugador> origen,fin;
    private int size;
    
    public ListaJ(){
        size =1;
        Jugador nj = new Jugador("Jugador");
        NodoL<Jugador> nuevo = new NodoL<>(nj);
        origen=fin=nuevo;
    }
    
    public void addJugador(Jugador nuevo)
    {
        size++;
        NodoL<Jugador> nuevoN = new NodoL<>(nuevo);
        fin.setSiguiguiente(nuevoN);
        fin = nuevoN;
    }
    
    public void eliminarDatos()
    {
        size=1;
        Jugador nj = new Jugador("Jugador");
        NodoL<Jugador> nuevo = new NodoL<>(nj);
        origen=fin=nuevo;
    }
    
    public int size()
    {
        return size;
    }
    
    public void graficar()
    {
        GraphViz gv = new GraphViz();
        gv.addln(gv.start_graph());
        gv.addln("rankdir=TB");
        
        int i =0;
        int k=0;
        int j=0;
        NodoL<Jugador> aux = origen;
        
        if(aux!=null){
            gv.addln("top[ label =\"" +  aux.getElemento().toString()+"\"];");
            aux = aux.getSiguiente();
            while(aux!=null)
            {
                gv.addln("n" + i + "[ label=\"" + aux.getElemento().toString()+"\" ];");
                if(i==0)
                {
                    k=aux.getElemento().size();
                    aux.getElemento().addGrafica("m", gv);
                }else
                {
                    j=aux.getElemento().size();
                    aux.getElemento().addGrafica("l", gv);
                }
                i++;
                aux = aux.getSiguiente();
            }
            i=0;
            aux = origen.getSiguiente();
            gv.add("top");
            while(aux!=null)
            {
                gv.add("->n" + i);
                i++;
                aux=aux.getSiguiente();
            }
            
            gv.addln(";");
            //gv.add("n0->m0;");
            
            gv.addln("n1->l0;");
            gv.addln("n0->m0;");
            //gv.addln("rank=same");
           
            i=1;
            
            gv.addln("subgraph mm {");
            //gv.addln("n0");
            //gv.addln("rotate = 90");
            gv.add("m0");
            while(i<k){
                gv.addln("->m" + i);
                i++;
            }
            gv.add("}");
            i=1;
            
            gv.addln("subgraph ll{");
            gv.addln("l0");
            while(i<j)
            {
                gv.addln("->l"+i);
                i++;
            }
            gv.addln("}");
            
            gv.addln(gv.end_graph());
        
            File ext = new File("jugadores.gif");
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource(),"gif"),ext);
        }
        
    }
    
    
    
}
