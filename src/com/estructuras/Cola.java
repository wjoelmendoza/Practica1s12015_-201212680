/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estructuras;

import com.graphViz.GraphViz;
import java.io.File;
import java.util.Random;

/**
 *
 * @author Walter Mendoza
 */
public class Cola  extends Thread {
    
    private NodoL<Personaje > origen;
    private NodoL<Personaje> fin;
    private int size;
    private int cantidad,repeticion;
    private final Random ra = new Random();
    private Lista<Personaje> catalogo;
    
    public Cola(Lista<Personaje> catalogo, int cantidad)
    {
        origen = fin = null;
        size =0;
        this.cantidad=cantidad;
        repeticion=0;
        this.catalogo=catalogo;
        iniciarCola();
    }
    
    private void iniciarCola()
    {
        for(int i =0; i<5;i++)
            getPersonaje();
        repeticion =5;
    }
    
    private void getPersonaje()
    {
        int num = ra.nextInt(catalogo.size());
        Personaje aux = catalogo.getElemento(num).clone();
        this.agregar(aux);
    }
    
    public boolean vacia()
    {
        return origen==null;
    }
    
    public void agregar(Personaje personaje)
    {
        size ++;
        NodoL<Personaje> nuevo = new NodoL<>(personaje);
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
    
   
    
    public Personaje getElemento(){
        Personaje aux = origen.getElemento();
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
        NodoL<Personaje> aux = origen;
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

    @Override
    public void run() {
        for(;repeticion<cantidad;repeticion++)
        {
            esperar(5);
            getPersonaje();
            System.out.println(repeticion +"Cola");
            //quitar instruccion antes de entregar
            graficar();
        }
    }
    
    private void esperar(int seg)
    {
        try{
            Thread.sleep(seg*1000);
        }catch(InterruptedException iE)
        {
            Thread.currentThread().interrupt();
            System.err.println(iE.toString());
        }
    }
}
