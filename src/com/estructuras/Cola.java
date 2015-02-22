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
public class Cola <T> {
    
    private NodoL< T > origen;
    private NodoL<T> fin;
    private int size;
    
    public Cola()
    {
        origen = fin = null;
        size =0;
    }
    
    public boolean vacia()
    {
        return origen==null;
    }
    
    public void agregar(T t)
    {
        size ++;
        NodoL<T> nuevo = new NodoL<>(t);
        if(origen!=null)
        {
            fin.setSiguiguiente(nuevo);
            fin = nuevo;
        }
        else
        {
            origen=fin=nuevo;
        }
    }
    
   
    
    public T getElemento(){
        T aux = origen.getElemento();
        size --;
        
        origen = origen.getSiguiente();
        
        return aux;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void graficar()
    {
        GraphViz gv =new GraphViz();
        gv.addln(gv.start_graph());
        gv.addln("rankdir=LR;");
        int i =0;
        NodoL<T> aux = origen;
        if(aux!=null)
        {
            gv.addln("top [ label =\""+aux.getElemento().toString()+"\"];");
            aux = aux.getSiguiente();
            
            while(aux!=null)
            {
                gv.addln("n" + i +"[ label= \" " +  aux.getElemento().toString()+"\" ];");
                i++;
                aux=aux.getSiguiente();
            }
            
            i=0;
            aux = origen.getSiguiente();
            gv.add("top");
            
            while(aux!=null)
            {
                gv.add(" -> n"+i);
                i++;
                aux = aux.getSiguiente();
            }
            
            gv.addln(";");
            gv.addln(gv.end_graph());
            
            File ext = new File("cola.gif");
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), "gif"), ext);
        }
    }
}
