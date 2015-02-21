/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estructuras;

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
            System.out.println("Agregando?");
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
}
