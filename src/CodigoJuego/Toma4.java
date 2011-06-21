package CodigoJuego;


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
public class Toma4 extends Comodin{


    
    Toma4(Juego padre){
        super(padre, true);
        img= new ImageIcon("/Cartas/Toma4.png");
    }

    public void efecto(){
        super.efecto();
        perte.siguiente().tomarCartas(4);
        perte.siguiente().pasar(1);
        JOptionPane.showMessageDialog(null, perte.siguiente().nombre+ " toma cuatro cartas y pierde turno.");

    }


}
