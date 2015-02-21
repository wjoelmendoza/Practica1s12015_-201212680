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
}
