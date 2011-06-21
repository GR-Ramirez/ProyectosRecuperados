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
public class Salta extends Carta{
    Salta(Color col, Juego padre){
        color= col;
        img= new ImageIcon("/Cartas/Salta" +color.adjetivo+".png");
        valor= 20;
        perte= padre;
    }
           
    
    @Override
    public boolean aceptar(Carta eva){
        if (super.aceptar(eva))
            return true;
        if (color.equals(eva.color)||eva.getClass().equals(this.getClass()))
                return true;
        return false;
    }



    
    public void efecto(){
        perte.siguiente().pasar(1);
        JOptionPane.showMessageDialog(null, perte.siguiente().nombre+ "pierde un turno");

    }
}

