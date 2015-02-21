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
public class NodoD<T> {
    private T cabecera;
    private NodoL<T> oPlanta;
    private NodoL<T> oZombie;
    private NodoL<T> finP;
    private NodoL<T> finZ;
    
    
    public NodoD(T cabecera)
    {
        this.cabecera = cabecera;
        oPlanta = finP=oZombie=finZ=null;
    }
    
    public void addPlanta(T datoJPlanta)
    {
        NodoL<T> aux = new NodoL<>(datoJPlanta);
        if(oPlanta!=null)
        {
            finP.setSiguiguiente(aux);
            finP=aux;
        }
        else
        {
            oPlanta= finP = aux;
        }
    }
    
    public void addZombie(T datoJZombie)
    {
        NodoL<T> aux = new NodoL<>(datoJZombie);
       if(oZombie!=null)
       {
           finZ.setSiguiguiente(aux);
           finZ=aux;
       }
       else
       {
           oZombie = finZ= aux;
       }
    }
    
    public NodoL<T> getPlanta()
    {
        return oPlanta;
    }
    
    public NodoL<T> getZombie()
    {
        return oZombie;
    }
    
    /**
     * metodos de prueba
     */
    
    public void printZ(){
        NodoL<T>  aux= oZombie;
        while(aux!=null)
        {
            System.out.println(aux.getElemento());
            aux=aux.getSiguiente();
        }
    }
    
    public void printP(){
        NodoL<T>  aux= oPlanta;
        while(aux!=null)
        {
            System.out.println(aux.getElemento());
            aux = aux.getSiguiente();
        }
    }
    
}
