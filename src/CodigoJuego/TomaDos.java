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
public class TomaDos extends Carta{
    

    TomaDos(Color color, Juego padre){
        perte= padre;
        this.color= color;
        valor= 20; 
        img= new ImageIcon("/Cartas/Toma2" +color.adjetivo);
    }



    public void efecto(){
        perte.siguiente().tomarCartas(2);
        perte.siguiente().pasar(1);
        JOptionPane.showMessageDialog(null, perte.siguiente().nombre+ " toma dos cartas y pierde un turno");
    }

    @Override
    public boolean aceptar(Carta eval){
        if(super.aceptar(eval))
            return true;
        if ((eval.color.equals(this.color))||(eval instanceof TomaDos))
            return true;
        return false;
    }

}
