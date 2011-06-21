package CodigoJuego;


import javax.swing.Icon;

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
public class Comodin extends Carta{

    static Icon icon= new ImageIcon("Colores.jpeg");

    Comodin(Juego padre){
        perte= padre;
        valor= 50;
        img= new ImageIcon("/Cartas/Comodin.png");
    }

    Comodin(Juego padre, boolean g){
        perte= padre;
      }
    
    @Override
    public boolean aceptar(Carta eva){
        if (super.aceptar(eva))
            return true;
        if (eva.color.equals(this.color))
            return true;
        return false;
    }

    public void efecto(){

       while(color==null){
       this.color= (Color)JOptionPane.showInputDialog(
                    null,
                    "Qué color tendrá esta carta?",
                    "Seleccionar Color",
                    JOptionPane.QUESTION_MESSAGE,
                    icon,
                    Color.values(),
                    Color.AMARILLO);
       
       }
    }


}
