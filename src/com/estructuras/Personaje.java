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
public class Personaje implements Cloneable {
    private int numero;
    private String nombre;
    private String atk;
    private String tipoPer;
    private String img;
    private int ptsAtq;
    private int ptsDef;
    
    public Personaje(String nombre,String atk, String tipoPer,String img,int ptsAtq,int ptsDef)
    {
        this.numero=numero;
        this.nombre=nombre;
        this.atk=atk;
        this.tipoPer=tipoPer;
        this.img=img;
        this.ptsAtq=ptsAtq;
        this.ptsDef=ptsDef;
    }
    
    public int getNumero()  {       return numero;   }
    
    public String getNombre(){  return nombre;}
    
    public String getTipoAtaque(){return atk;}
    
    public String getTipoPersonaje(){return tipoPer;}
    
    public String getImagen(){return img;}
    
    public int getAtaque(){return ptsAtq;}
    
    public void recibirAtaque(int ptsAtq){
        ptsDef-= ptsAtq;
    }
    
    public int getDefensa(){return ptsDef;}
    
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
    @Override
    public String toString()
    {
        return nombre;
    }
    
    @Override
    public Personaje clone()
    {
        Personaje clon = new Personaje(this.nombre,this.atk,this.tipoPer,this.img,this.ptsAtq,this.ptsDef);
        clon.setNumero(this.numero);
        return clon;
    }
}
