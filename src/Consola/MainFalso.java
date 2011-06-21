/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Consola;
import CodigoJuego.*;
import java.io.File;
/**
 *
 * @author Owner
 */
public class MainFalso {
    public static void main(String args[]) throws Exception{
<<<<<<< HEAD
       /* Baraja.crear();
        Carta e= new Comodin();
        Jugador prueba= new Jugador("Joel");
        prueba.tomarCartas(3);
        System.out.println(prueba.mano.size());
        System.out.println(prueba.mano.get(0));
        Carta x[]= prueba.exponer();
        System.out.println(x.length);
        if(x[0] instanceof Carta)
            System.out.println("Si es carta.");
        else
            System.out.println("No reconoce.");*/
        Comodin i= new Comodin(null);
        i.efecto();
        System.out.println(i.getColor());
        File File= new File("estamos.txt");
        File.createNewFile();
=======
        String yu[]= {"kai", "yosh"};
        Juego goda= new Juego(yu,6);
        goda.open();
        System.out.println(""+goda.juega().toString());
       
>>>>>>> 961d0f3
    }


}
