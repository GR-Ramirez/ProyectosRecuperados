package CodigoJuego;

import java.lang.StringBuilder;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Owner
 */

public abstract class Carta implements Serializable{
    




    public enum Color {ROJO("rojo"), AZUL("azul"), VERDE("verde"), AMARILLO("amarillo");
    String adjetivo;
    Color(String d){
        adjetivo= d;
    }
    }
    Color color;
    int valor;
    Juego perte;
    public ImageIcon img;


  public boolean aceptar(Carta evaluada){

       boolean sePuede= true;
       if (evaluada instanceof Comodin)
           return sePuede;
       if (evaluada instanceof Toma4){
           for (Carta enMano: perte.jugadores[perte.activo].exponer()){
               if (enMano.color.equals(perte.enJuego.color))
                   return false;
           }
       }
       else
           sePuede=false;

       return sePuede; 
   }

   public abstract void efecto();
  
 
   public Color getColor(){
       return color;
   }

}

