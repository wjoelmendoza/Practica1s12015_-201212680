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
public class Jugador {
    private NodoD<String> jugadores;
    
    public Jugador(){
        this.borrarDatos();
    }
    
    public void borrarDatos(){
        jugadores = new NodoD<>("Jugadores");
    }
    
    public void addDatoP(String dato)
    {
       jugadores.addPlanta(dato);
    }
    
    public void addDatoZ(String dato)
    {
        jugadores.addZombie(dato);
    }
    
    public void printDatos(){
        System.out.println("Planta");
        jugadores.printP();
        System.out.println("Zombie");
        jugadores.printZ();
    }
    
}
