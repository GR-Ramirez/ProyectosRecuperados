package CodigoJuego;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Owner
 */
public class Jugador implements Serializable{
    final public String nombre;
    private long puntos= 0;
    public ArrayList<Carta> mano;
    private byte turnosAPasar= 0;
    public boolean activo;
    Carta tomada;
    Juego padre;
    boolean jugando;

    
    public Jugador(String nombre, Juego padre){
        this.nombre=nombre;
        this.padre=padre;
        this.mano= new ArrayList<Carta>(Collections.EMPTY_LIST);
        activo= true;
    }

    public boolean puede(){
        if(turnosAPasar== 0)
            return true;
        turnosAPasar--;
        return false;
    }
    private void tomarCartas(int cuantas, int van){
        if (cuantas==van)
            return;
        this.mano.add(padre.Baraja.obtenerCarta());
        tomarCartas(cuantas, ++van);
    }

    public void tomarCartas(int meta){
          tomarCartas(meta,0);
          mano.trimToSize();
    }

    public Carta[] exponer(){//por mientras
        mano.trimToSize();
        Carta falsa[]= mano.toArray(new Carta[0]);
        return falsa;
     }

    void pasar(int turnos){
        this.turnosAPasar += turnos;
    }

    public void tomarUna(){
        tomada= padre.Baraja.obtenerCarta();
    }

    public void ponerEnMano(){
         mano.add(tomada);
        mano.trimToSize();
    }

    public void remover(int numero){
        mano.remove(numero);
    }
    
    int puntuacion(){
        int punt= 0;
        for(Carta enMano: mano){
            punt+= enMano.valor;
        }
        return punt;
    }

    public long getPuntos(){
        return puntos;
    }
}
