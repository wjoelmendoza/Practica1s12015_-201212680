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
public class Jugador {
    private NodoL<String> origen,fin;
    private int cantidad;
    private String tipo;
    private int size=0;
    
    
    public Jugador(int cantidad, String dato, String tipo){
        
        borrarDatos();
        addDato(dato);
        this.tipo=tipo;
    }
    
    public Jugador(String tipo)
    {
        this.tipo= tipo;
        origen=fin=null;
    }
    
    public Jugador()
    {
        borrarDatos();
    }
    
    public void borrarDatos(){
        origen=fin = null;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad)
    {
        this.cantidad=cantidad;
    }
    
    public void addDato(String dato)
    {
        size++;
        NodoL<String> aux=origen;
        NodoL<String> nuevo= new NodoL<>(dato);
        if (aux!=null){
            fin.setSiguiguiente(nuevo);
            fin = nuevo;
        }else{
            origen = fin = nuevo;
        }
    }
    
    public int size()
    {
        return size;
    }
    
    public String getTipo()
    {
        return tipo;
    }
    
    public void addGrafica(String nodo,GraphViz gv)
    {
        NodoL<String> aux = origen;
        int i =0;
        while(aux!=null)
        {
            gv.addln(nodo+i+"[ label =\""+ aux.getElemento()+"\",orientation=90];");
            i++;
            aux=aux.getSiguiente();
           
        }
    }
    
    @Override
    public String toString()
    {
        return tipo;
    }
    
}
