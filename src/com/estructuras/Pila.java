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
public class Pila extends Thread{
   
   private GraphViz gr;
   private NodoL<Personaje> origen;
   private NodoL<Personaje> fin;
   private Lista<Personaje> zombies;
   private int size;
   private int cantidad, repeticion;
   private final Random ra = new Random();
    
   public Pila(Lista<Personaje> zombies, int cantidad)
   {
       origen = fin = null;
       size=0;
       this.cantidad=cantidad;
       this.zombies=zombies;
       iniciarPila();
   }
   
   private void iniciarPila()
   {
       for (int i =0;i<5 ; i++)
       {
           getElemento();
       }
       repeticion =5;
   }
   
   private void getElemento()
   {
       int pos = ra.nextInt(zombies.size());
       Personaje aux = zombies.getElemento(pos).clone();
       push(aux);
   }
   
   public boolean vacia()
   {
       return origen ==null;
   }
   
   public void push(Personaje elemento)
   {
       size++;
       NodoL<Personaje> nuevo = new NodoL<>(elemento);
       if(origen!=null)
       {
           nuevo.setSiguiguiente(origen);
           origen = nuevo;
       }
       else
       {
           origen = fin =nuevo;
       }
   }
   
   public Personaje pop()
   {
       size--;
       Personaje aux;
       aux = origen.getElemento();
       
       origen = origen.getSiguiente();
       
       return aux;
   }
    
   public int getSize()
   {
       return size;
   }
   
   public void graficar()
   {
       gr = new GraphViz();
       gr.addln(gr.start_graph());
       gr.addln("rankdir = TB");
       NodoL<Personaje> aux1=origen;
       int i=0;
       
       if(aux1!=null)
       {
           
           gr.addln("top[label =\""+origen.getElemento().toString()+"\",color=blue];");
           aux1=aux1.getSiguiente();
           while(aux1!=null)
           {
               gr.addln("n"+i+"[ label=\""+aux1.getElemento().toString()+"\"];");
               i++;
               aux1=aux1.getSiguiente();
           }
           
           i=0;
           aux1=origen.getSiguiente();
           
           gr.add("top");
           
           while(aux1!=null)
           {
               gr.add("->n" +i);
               i++;
               aux1= aux1.getSiguiente();
           }
       }
       gr.addln(";");
       gr.addln(gr.end_graph());
       
       File ext= new File("Pila.gif");
       gr.writeGraphToFile(gr.getGraph(gr.getDotSource(), "gif"), ext);
   }

    @Override
    public void run() {
        for (;repeticion<cantidad;repeticion++)
        {
            esperar(5);
            getElemento();
            //quitar codigo antes de entregar
            System.out.println(repeticion +"Pila");
            graficar();
        }
    }
    
    public void graficar2()
    {
        GraphViz gv = new GraphViz();
        gv.addln();
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
