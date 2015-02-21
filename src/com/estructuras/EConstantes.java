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
public enum EConstantes {
    PLANTAS(1),
    ZOMBIES(2);
    
    private final int value;
    
    EConstantes(int valor)
    {
        this.value = valor;
    }
    
    public int getValue(){
        return value;
    }
}
