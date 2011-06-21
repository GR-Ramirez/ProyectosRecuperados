/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejadorJugadores;


import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Owner
 */
public class JugManager {
    RandomAccessFile raf;

    public JugManager(){
        try{
            raf= new RandomAccessFile("Jugadores.uno","rw");
        }
        catch(IOException io){

        }
    }

    public void addJugador(String nom,char genero, byte edad){
        try{
            if(buscarJugador(nom)==-1){
                raf.seek(raf.length());
                raf.writeBoolean(true);
                raf.writeUTF(nom);
                raf.writeByte(edad);
                raf.writeChar(genero);
                raf.writeInt(0);//ganes
                raf.writeInt(0);//perdidas
                raf.writeInt(0);//record punto
                raf.writeInt(0);//puntostotal
            }
            else
                JOptionPane.showMessageDialog(null,
                "Los nombres de los jugadores deben ser únicos",
                    "Nombre ya tomado",
                JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException io){
            System.err.println(io.getMessage());
        }
    }

    public void desactivarJugador(String nom){
        try{
            long aBorrar= buscarJugador(nom);
            if(aBorrar!=-1){
                raf.seek(aBorrar);
                raf.writeBoolean(false);
            }
        }
        catch(IOException io){
            System.err.println(io.getMessage());
        }

    }

    public long  buscarJugador(String nombre){
        long pos= 0;
        try{
            raf.seek(0);
            while(raf.length()>raf.getFilePointer()){
                 pos= raf.getFilePointer();
                 boolean valido= raf.readBoolean();
                 if(nombre.equals(raf.readUTF())&&valido)
                     return pos;
                 raf.seek(raf.getFilePointer()+19);
            }
            return -1;
        }
        catch(IOException io){
            System.err.println();
            return -1;
        }
    }

    public JugInfo[] getJugadores(){
        ArrayList<JugInfo> info= new ArrayList(0);
        
        try{
            raf.seek(0);
            while(raf.getFilePointer()<raf.length()){
                if(raf.readBoolean())
                     info.add(getJI(raf.readUTF()));
                else{
                     raf.readUTF();
                raf.seek(raf.getFilePointer()+19);
                }
            }
            info.trimToSize();
            JugInfo[] estaraElErrorAqui= info.toArray(new JugInfo[0]);
            return estaraElErrorAqui;
        }
        catch(IOException io){
            System.err.println(io.getMessage());
            return null;
        }
    }

    public JugInfo getJI(String nombre){
        JugInfo j= new JugInfo();
        long aqui= buscarJugador(nombre);
        if(aqui!=-1){
            try{
                raf.seek(aqui);
                raf.readBoolean();
                j.nombre=raf.readUTF();
                j.edad= raf.readByte();
                j.genero= raf.readChar();
                j.ganes= raf.readInt();
                j.perdidas= raf.readInt();
                j.record= raf.readInt();
                j.puntosHistoria= raf.readInt();
                return j;
            }
            catch(IOException io){
                System.err.println(io.getMessage());
                return null;
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null,
                "No existe este jugador.",
                    "No existe",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void cerrarStream(){
        if(raf!=null)
            try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(JugManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getSoloNombres(JugInfo[] fuente){
        String[] copia= new String[fuente.length];
        for(int o=0; o<copia.length; o++)
            copia[o]= fuente[o].nombre;
        return copia;
    }

    public String[] getSoloNombres(){
        JugInfo[] fuente= getJugadores();
        String[] copia= new String[fuente.length];
        for(int o=0; o<copia.length; o++)
            copia[o]= fuente[o].nombre;
        return copia;
    }
}
