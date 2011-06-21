package CodigoJuego;


import CodigoJuego.Baraja;
import ManejadorPartidas.ManejadorPartidas;
import java.awt.Component;
import java.awt.Frame;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */

public class Juego implements Serializable{
    Jugador[] jugadores;
    Baraja Baraja;
    int activo;
    private byte direccion;
    public Carta enJuego;
    final int numJuego;


   public Juego(String[] jug, Component padre){//no verifica que sean diferentes nombres, esto tendremos que corregirlo luego
        this(jug,ManejadorPartidas.getNumPartida());
        
    }
   
   
   public void Retirar(String nombre){
       for(Jugador jugador: jugadores){
           if(jugador.nombre.equals(nombre)){
               jugador.activo= false;
               break;
           }
       }
   }

    public Jugador[] getJugadores() {
        return jugadores;
    }
    

    public void open() {
        for(Jugador jus: jugadores){
            if(jus.activo){
                jus.tomarCartas(7);
            }
        }
        activo= sigue();
    }
    

    public Juego(String[] nombres){
        this(nombres ,ManejadorPartidas.getNumPartida() );
        
    }
    
    public Juego(String[] nombres,  int num){
        ArrayList<Jugador> jugs= new ArrayList(0);
        for(String nun: nombres)
            jugs.add(new Jugador(nun,this));
        jugs.trimToSize();
        jugadores=  jugs.toArray(new Jugador[0]);
        Baraja= new Baraja(this);
        direccion = 1;
        enJuego= Baraja.obtenerCarta();
        numJuego= num;
    }


    

    public String[] getNombreJugadores(){

        String[] copia= new String[jugadores.length];
        for(int k=0; k<copia.length; k++)
            copia[k]= jugadores[k].nombre;
        return copia;
    }


    void cambioDir(){
        direccion *= -1;
        System.out.println("Ha cambiado la dirección del juego.");
    }

    int jugActivos() {
        int activos=0;
        for(Jugador j: jugadores)
            if(j.activo)
                activos++;
        return activos;
    }

    Jugador siguiente(){
        return jugadores[sigue()];
    }

   
    public int getNumPartida() {
        return this.numJuego;
    }

  

    public Jugador[] getActivos() {
        ArrayList<Jugador> copia= new ArrayList<Jugador>(0);
        for(Jugador lj: jugadores)
            if(lj.activo)
                copia.add(lj);
        copia.trimToSize();
        return copia.toArray(new Jugador[0]);
    }



    int sigue(){
        int seguis= activo ;
        while(true){
            seguis=+ direccion;
            if (seguis == jugadores.length)
            seguis = 0;
        if (seguis == -1)
            seguis = jugadores.length -1;
        if(jugadores[seguis].activo)
            return seguis;
        }

        
    }

    int calcularPuntaje(){
        int cPunt= 0;
        for(Jugador jugando: jugadores)
            cPunt+= jugando.puntuacion();
        cPunt-= jugadores[activo].puntuacion();
        return cPunt;
    }

//    public void flujoJuego(){//si crees que de otra manera se implementa mejor, cambialo
//        Scanner lee= new Scanner(System.in);
//        Baraja.crear();
//        for (Jugador cadauno: jugadores)
//            cadauno.tomarCartas(7);
//        enJuego= Baraja.obtenerCarta();
//        System.out.println("Se revela la primera carta: " + enJuego.toString());
//        enJuego.efecto();
//         while (true){
//             System.out.println("Turno de "+ jugadores[activo].nombre +"\nLa carta activa es "+ enJuego.toString()+ "\n\tMano");
//             for(Object mn: jugadores[activo].exponer()){
//                 System.out.println(mn.toString());
//             }if(jugadores[activo].puede()){
//                 System.out.println("Elije la carta que vayas a usar o pasa toma una (0):");
//                 manoJugado:
//                 while(true){
//                     short s= lee.nextShort();
//                     if(s==0){
//                         jugadores[activo].tomarUna();
//                         System.out.println(jugadores[activo].tomada.toString()+
//                                 " La piensas jugar? \n1.Sí \n2.No");
//                         for(;;){
//                             s= lee.nextShort();
//                             if(s==1){
//                                 if(enJuego.aceptar(jugadores[activo].tomada)){
//                                     enJuego= jugadores[activo].tomada;
//                                     System.out.println("La carta Descartar pasa ser " + enJuego.toString());
//                                     enJuego.efecto();
//                                     break manoJugado;
//                                 }
//                                 else{
//                                     System.out.println("No podes jugar esa carta.");
//                                     jugadores[activo].ponerEnMano();
//                                     break manoJugado;
//                                 }
//                             }else if(s==2){
//                                 System.out.println("Como quieras.");
//                                    jugadores[activo].ponerEnMano();
//                                     break manoJugado;
//                             } else
//                                 System.out.println("Ese no es un comando reconocido");
//                         }
//                     }else if(s>0&&s<=jugadores[activo].exponer().length){
//                         if(enJuego.aceptar(jugadores[activo].exponer()[s-1])){
//                                     enJuego= jugadores[activo].exponer()[s-1];
//                                     jugadores[activo].remover(s-1);
//                                     System.out.println("La carta Descartar pasa ser " + enJuego.toString());
//                                     enJuego.efecto();
//                                     break manoJugado;
//                          }  else
//                             System.out.println("No podes jugar esa carta ahora.");
//                     }else
//                         System.out.println("Comando no reconocido.");
//                 }
//             }else
//             System.out.println("Lo siento, pero debes turnos por pasar. No desesperes, te falta uno menos.");
//             if (jugadores[activo].exponer().length==1){
//                 System.out.println("Felicidades, " + jugadores[activo].nombre + " has ganado esta partida y te quedas con " + calcularPuntaje()+ " puntos!");
//                return;
//            }
//             activo = sigue();
//        }
//    }
    public Carta obtenerCarta(){
        return Baraja.obtenerCarta();
    }
    

    public void retirarOtros(String[] nombres){
        for(Jugador j: jugadores){
            boolean aRetirar= true;
            for(String k: nombres){
                if (k.equals(j.nombre)){
                        aRetirar= false;
                        break;
                }
                if(aRetirar)
                    j.activo= false;
            }
        }

    }

    public Jugador juega(){
        return jugadores[activo];

    }
}
