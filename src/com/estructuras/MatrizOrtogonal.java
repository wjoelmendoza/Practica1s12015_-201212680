/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.estructuras;
import com.gui.Cuadrante;
import javax.swing.JFrame;

/**
 *
 * @author Walter Mendoza
 */
public class MatrizOrtogonal  {
    private int x,y;
    private JFrame frame;
    private NodoM<Cuadrante> origen;
    
    public MatrizOrtogonal(int x,int y, JFrame frame)
    {
        this.x=x;
        this.y=y;
        origen = null;
        this.frame = frame;
        inicializaMatriz();
    }
    
    
    private void inicializaMatriz()
    {
        NodoM<Cuadrante> aux1=null,fin=null,nuevo,aux2;
        String dato ="D";
        int k=0;
       
        for(int i=0;i<x;i++)
        {
            
            k++;
           
            Cuadrante cua = new Cuadrante(i,0,dato+k);
            frame.add(cua);
             nuevo = new NodoM<>(cua);
            if(fin!=null)
            {
                fin.setSiguiente(nuevo);
                nuevo.setAnterior(fin);
                fin = nuevo;
            }
            else
            {
                origen=fin=nuevo;
            }
           
        }
        
        int i=0;
        aux1=aux2=origen;
        for(int j=1;j<y;j++)
        {
            
            for(i=0;i<x;i++)
            {
                k++;
                Cuadrante cua = new Cuadrante(i,j,dato+k);
                frame.add(cua);
                nuevo = new NodoM<>(cua);
                if(i!=0)
                {
                    
                    fin.setSiguiente(nuevo);
                    nuevo.setAnterior(fin);
                    nuevo.setArriba(aux1);
                    aux1.setAbajo(nuevo);
                    fin = nuevo;
                    
                }else
                {
                    aux1.setAbajo(nuevo);
                    nuevo.setArriba(aux1);
                    fin =nuevo;
                }
                
                if(aux1.getSiguiente()!=null)
                    aux1= aux1.getSiguiente();
            }
            aux2=aux2.getAbajo();
            aux1=aux2;
        }
        
      
    }
    
    public NodoM getCoordenada(int x, int y)
    {
        NodoM aux = null;
        
       // System.out.println("x:" + x+",y:" + y);
        if(xValida(x)&&yValida(y))
        {
            aux = origen;
            int i=0,j=0;
            while(i!=x){
                aux=aux.getSiguiente();
                i++;
            }
            
            while(j!=y)
            {
                aux=aux.getAbajo();
                j++;
            }
        }
            
        return aux;
    }
    
    
    public boolean Vacia()
    {
        return origen==null;
    }
    
    private boolean xValida(int x)
    {
        return x>=0&&x<this.x+1;
    }
    
    private boolean yValida(int y)
    {
        return y>=0&&y<this.y+1;
    }
    
    public void print()
    {
        NodoM aux = origen;
        int k=0;
       for(int j=0;j<y;j++)
       {
           
           for (int i =0;i<x;i++ )
           {
               // System.out.print(aux.getValor()+"|");
                
                if(k%2==0){
                    if(aux.getSiguiente()!=null)
                        aux= aux.getSiguiente();
                }
                else
                    if(aux.getAnterior()!=null)
                    {
                            aux=aux.getAnterior();
                    }
           }
           
           System.out.println("");
           aux=aux.getAbajo();
           k++;
       }
        
    }
}
