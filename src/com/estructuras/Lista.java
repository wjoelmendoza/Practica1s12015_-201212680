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
public class Lista <T>{
    
    private NodoLD<T> origen ;
    private NodoLD<T>fin;
    private int size;
    
    public Lista () 
    {
        origen = fin = null;
        size = 0;
    }
    
    public void agregar(T objeto)
    {
        size++;
        NodoLD<T> aux = new NodoLD<>(objeto);
        
        
        if(origen!=null)
        {
            
            fin.setSiguiente(aux);
            aux.setAnterior(fin);
            fin = aux;
        }
        else
        {
            origen = fin = aux;
        }
    }
    
    public boolean vacio()
    {
        return origen==null;
    }
    
    public void eliminar(NodoLD elemento)
    {
        NodoLD<T> aux = origen;
        NodoLD<T> aux2;
        
        
        while(aux!=null)
        {
            if (aux==elemento){
                aux2= aux.getAnterior();
                aux2.setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux2);
            }
            
          aux =  aux.getSiguiente();
        }
    }
    
    public int size()
    {
        return size;
    }
    
    public T getElemento(int posicion)
    {
        NodoLD<T> aux= origen;
        T aux2=null;
        for(int i =0;i<size;i++)
        {
            if(posicion ==i){
                aux2 = aux.getInfo();
            }
            
            aux = aux.getSiguiente();
        }
        
        
        return aux2;
    }
    
    /**
     * recorrere hacia delante
     */
    
    public void printD(){
        NodoLD<T> aux= origen;
        System.out.println("print?");
        while(aux!=null)
        {
            System.out.println(aux.getInfo());
            aux= aux.getSiguiente();
        }
    }
    
    public void printA()
    {
        NodoLD<T> aux= fin;
        while(aux!=null)
        {
            System.out.println(aux.getInfo());
            aux= aux.getAnterior();
        }
    }
    
    public void graficar(String nombre)
    {
        GraphViz gv = new GraphViz();
        gv.addln(gv.start_graph());
        gv.addln("rankdir = LR;");
        
        int i =0;
        NodoLD<T> aux=origen;
        
        if(aux!=null)
        {
            gv.addln("top[label= \"" + origen.getInfo().toString() + "\"];");
            aux =aux.getSiguiente();
            while(aux!=null)
            {
                gv.addln("n" + i +"[label=\""+aux.getInfo().toString()+"\"];");
                i++;
                aux=aux.getSiguiente();
            }
            
            i=0;
            aux = origen.getSiguiente();
            gv.add("top");
            
            while(aux!=null)
            {
                gv.add("->n"+i);
                i++;
                aux=aux.getSiguiente();
                
            }
            
            gv.add(";");
            i--;
            while(i>=0)
            {
                gv.add("n"+i +"->");
                i--;
            }
            gv.addln("top;");
        }
        gv.addln(gv.end_graph());
        
        File ext = new File(nombre+".gif");
        
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(),"gif"), ext);
    }
}
