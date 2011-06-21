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
public class Reversa extends Carta{

    Reversa(Color col, Juego padre){
 
        valor= 20;
        color= col;
        perte= padre;
        img= new ImageIcon("/Cartas/Reversa" +color.adjetivo+".png");
    }

    @Override
    public boolean aceptar(Carta eval){

        if (super.aceptar(eval))
            return true;
        if ((eval instanceof Reversa)||(eval.color.equals(this.color)))
            return true;
        return false;

    }

    public void efecto(){
        if(perte.jugActivos()>2){
            perte.cambioDir();
            JOptionPane.showMessageDialog(null, "Hubo una reversa en la direccion","Reversa",JOptionPane.INFORMATION_MESSAGE);
         }
        else{
            perte.siguiente().pasar(1);
            JOptionPane.showMessageDialog(null, perte.siguiente().nombre+ " pierde su turno","Pasa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

