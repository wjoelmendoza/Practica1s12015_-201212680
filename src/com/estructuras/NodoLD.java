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
public class NodoLD<T> {
    private NodoLD anterior;
    private NodoLD siguiente;
    private T info;
    
    public NodoLD(T info)
    {
        this.info= info;
        siguiente=anterior = null;
    }
    
    public void setSiguiente(NodoLD<T>  siguiente)
    {
        this.siguiente= siguiente;
    }
    
    public void setAnterior(NodoLD<T> anterior)
    {
        this.anterior= anterior;
    }
    
    public NodoLD<T> getAnterior()
    {
        return anterior;
    }
    
    
    public NodoLD<T> getSiguiente()
    {
        return siguiente;
    }
    
    public T getInfo()
    {
        return info;
    }
    
    
    
   
}
