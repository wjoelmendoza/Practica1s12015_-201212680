/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estructuras;
import com.graphViz.GraphViz;

/**
 *
 * @author Walter Mendoza
 */
public class Pila <T>{
   
   private GraphViz gr;
   private NodoL<T> origen;
   private NodoL<T> fin;
   private int size;
    
   public Pila()
   {
       origen = fin = null;
       size=0;
   }
   
   public boolean vacia()
   {
       return origen ==null;
   }
   
   public void push(T elemento)
   {
       size++;
       NodoL<T> nuevo = new NodoL<>(elemento);
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
   
   public T pop()
   {
       size--;
       T aux;
       aux = origen.getElemento();
       
       origen = origen.getSiguiente();
       
       return aux;
   }
    
   public int getSize()
   {
       return size;
   }
   
   public GraphViz grafiacar()
   {
       gr = new GraphViz();
       gr.addln(gr.start_graph());
       gr.addln("rankdir = LR");
       NodoL<T> aux1=origen;
       int i=0;
       
       if(aux1!=null)
       {
           
           gr.addln("top[label =\""+origen.getElemento().toString()+"\"];");
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
               gr.add(" -> n" +i);
               i++;
               aux1= aux1.getSiguiente();
           }
       }
       gr.addln(";");
       gr.addln(gr.end_graph());
       
       return gr;
   }
}
