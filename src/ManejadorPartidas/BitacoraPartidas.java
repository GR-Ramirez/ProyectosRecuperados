/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejadorPartidas;
import java.io.*;
import CodigoJuego.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Owner
 */
public class BitacoraPartidas {
    RandomAccessFile loggeador;

    public BitacoraPartidas(){
        try {
            loggeador = new RandomAccessFile("PartidasCompletadas", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BitacoraPartidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void anotarVictoria(Juego j, boolean buenGane, Jugador gano){
        try {
            loggeador.seek(loggeador.length());
            loggeador.writeInt(j.getJugadores().length);
            loggeador.writeLong(new Date().getTime());
            loggeador.writeBoolean(buenGane);
            loggeador.writeUTF(gano.nombre);
            if(buenGane){
                for(Jugador k: j.getJugadores()){
                    loggeador.writeUTF(k.nombre);
                    loggeador.writeBoolean(k.activo);
                }
                loggeador.writeLong(gano.getPuntos());
            }else{
               for(Jugador k: j.getJugadores()){
                    loggeador.writeUTF(k.nombre);                    
                }loggeador.writeLong(gano.getPuntos());
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public String[] getReportes(){
        LinkedList<String> descripciones = new LinkedList();
        try {
            loggeador.seek(0);            
            while (loggeador.getFilePointer() < loggeador.length()) {
                int numJug = loggeador.readInt();
                long cuando= loggeador.readLong();
                boolean gano= loggeador.readBoolean();
                String ganador= loggeador.readUTF();
                String resulto= "El juego fue ganado por " +ganador+ "habiendole ganado";
                if(gano){
                    resulto+= " a ";
                    for(int y= 0; y<numJug; y++){
                        resulto+= loggeador.readUTF();
                        if(!(loggeador.readBoolean()))
                            resulto+=" (quien se retiró antes que terminara la partida)";
                        if(y<numJug-2)
                            resulto+=", ";
                        else if(y==numJug-2)
                            resulto+=" y ";
                    }
                    resulto+=" con "+ loggeador.readLong()+" puntos.- "+ new Date(cuando).toString();
                    descripciones.addFirst(resulto);
                }else{
                    resulto+= " a ";
                    for(int y= 0; y<numJug; y++){
                        resulto+= loggeador.readUTF();
                        if(y<numJug-2)
                            resulto+=", ";
                        else if(y==numJug-2)
                            resulto+=" y ";
                    }
                    resulto+=" habiendo ganado "+ loggeador.readLong()+" puntos ruante la partida.- "+ new Date(cuando).toString();
                    descripciones.addFirst(resulto);
                }
            }            
                
        } catch (IOException ex) {
            Logger.getLogger(BitacoraPartidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return descripciones.toArray(new String[0]);
    }

    public String[] Top(int num){
        String[] filtrar= getReportes();
        if(filtrar.length==0){
            String[] jane= {"No se ha guardado ninguna partida por el momento."};
            return jane;
        }
        if(num>=filtrar.length)
            num= filtrar.length-1;

        String[] filtrado= new String[num];
        for(int z=0; z<num; z++)
            filtrado[z]=filtrar[z];
        return filtrado;
    }

    public void cerrarStream() {
        try {
            loggeador.close();
        } catch (IOException ex) {
            Logger.getLogger(BitacoraPartidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
