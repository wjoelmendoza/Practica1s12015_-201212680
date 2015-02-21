/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estructuras;

/**
 *
 * @author Walter Mendoza
 * @param <T>
 */
public class NodoL <T>{
    protected T elemento;
    protected NodoL<T> siguiente;
    
    public NodoL(T elemento)
    {
        this.elemento = elemento;
        siguiente = null;
    }
    
    public void setSiguiguiente(NodoL<T> siguiente){
        this.siguiente = siguiente;
    }
    
    public NodoL<T> getSiguiente(){
        return siguiente;
    }
    
    public T getElemento()
    {
        return elemento;
    }
    
}
