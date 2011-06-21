/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CodigoJuego;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Owner
 */
    class Baraja implements Serializable{
        LinkedList<Carta> baraja;
        Juego padre;
    
    Baraja(Juego padre){
        this.padre= padre;
    }

    public void crear(){
       int i=0;
       for( Carta.Color col: Carta.Color.values()){
            for(int num: Numerica.legales)
                baraja.add(new Numerica(num,col,padre));
            for(i=0; i<2; i++){
                baraja.add(new Reversa(col,padre));
                baraja.add(new TomaDos(col,padre));
                baraja.add(new Salta(col,padre));
            }
       }
       for(i=0; i<4; i++){
           baraja.add(new Comodin(padre));
           baraja.add(new Toma4(padre));
       }
       Random aleatorio= new Random(Math.round(Math.random()*23));// trata de crear la semilla más aleatoria posible
       Collections.shuffle(baraja,aleatorio);
    }

    public void rebarajar(){
         baraja= new LinkedList();
         crear();
         for(Jugador adores: padre.jugadores){
                for(Carta aQuitar: adores.exponer())
                    baraja.remove(aQuitar);
            }
         baraja.remove(padre.enJuego);
    }

    Carta obtenerCarta(){
       if (barajaVacia())
           rebarajar();
       return baraja.pollFirst();
    }

    private boolean barajaVacia(){
        return baraja.isEmpty();
    }
 }