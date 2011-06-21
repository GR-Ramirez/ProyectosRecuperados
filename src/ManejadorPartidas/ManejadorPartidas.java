/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManejadorPartidas;


import CodigoJuego.Juego;
import CodigoJuego.Jugador;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class ManejadorPartidas {
    static RandomAccessFile contador;
    File part= new File("Partidas");

    public static int getNumPartida(){
        try {
            contador= new RandomAccessFile("cont","rw");
            if (contador.length() == 0) {
                contador.writeInt(1);
                return 1;
            }
            else{
                contador.seek(0);
                int num= contador.readInt();
                contador.seek(0);
                contador.writeInt(num+1);
                return num+1;
            }
        } catch (IOException io) {
            System.err.println(io.getMessage());
            return -1;
        }
    }

    public ManejadorPartidas(){
        if(!part.exists())
            part.mkdir();
    }

    public void Salvar(Juego j){

        String fileName= "Partidas/partida_" + j.getNumPartida() +".uno";
        String fileNameO= "Partidas/partida_" + j.getNumPartida() +"O.uno";

        try{
            File f= new File(fileName);//evito cualquier posible conflicto
            if(f.exists())
                f.delete();
            f= new File(fileNameO);
            if(f.exists()){
                 f.delete();
                 f.createNewFile();
            }
            RandomAccessFile whatev= new RandomAccessFile(fileName,"rw");
            Jugador[] jugando= j.getJugadores();
            whatev.writeInt(jugando.length);
<<<<<<< HEAD
=======
            whatev.writeInt(j.getNumPartida());
>>>>>>> 961d0f3
            for(Jugador jug: jugando){
                whatev.writeUTF(jug.nombre);
                whatev.writeBoolean(jug.activo);
            }
            whatev.writeUTF(fileNameO);
            whatev.writeLong(new Date().getTime());
            whatev.close();
            ObjectOutputStream salvaObjeto= new ObjectOutputStream(new FileOutputStream(fileNameO));
            salvaObjeto.writeObject(j);
            salvaObjeto.close();
        }
        catch(IOException io){
            System.err.println(io.getMessage());
        }
    }
<<<<<<< HEAD
    public String[] participantes(String[] buscados){
=======
    public Integer[] participantes(String[] buscados){
>>>>>>> 961d0f3
        ArrayList<Integer> numeros= new ArrayList(0);
        File Partidas= new File("Partidas");
        for(File fil: Partidas.listFiles()){
            try {
                RandomAccessFile r = new RandomAccessFile(fil, "rw");
                r.seek(0);
                int canti= r.readInt();
<<<<<<< HEAD
                if(canti>=buscados.length){
                    boolean todosEncontrados=true;
                    interior:
                    for(String b: buscados){
                       
                        r.seek(4);
                        
=======
                int denom= r.readInt();
                if(canti>=buscados.length){
                    boolean todosEncontrados=true;
                    interior:
                    for(String b: buscados){                       
                        r.seek(8);                        
>>>>>>> 961d0f3
                        for(int w= 0; w<canti; w++){
                            if(r.readUTF().equals(b)&&r.readBoolean()){
                                continue interior;
                            }
<<<<<<< HEAD
                         
                        }
                        
                    }

=======
                            todosEncontrados= false;
                        }                        
                    }
                    if(todosEncontrados)
                        numeros.add(denom);
>>>>>>> 961d0f3
                }
                else{
                    continue;
                }
<<<<<<< HEAD
=======
               
>>>>>>> 961d0f3
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                return null;
            }
        }
<<<<<<< HEAD
=======
        numeros.trimToSize();
        return numeros.toArray(new Integer[0]);
>>>>>>> 961d0f3
    }


    public Juego getJuego(int num){
        try {
            String name = "Partidas/partida_" + num + ".uno";
            RandomAccessFile yeah = new RandomAccessFile(name, "rw");
            yeah.seek(0);
            int length = yeah.readInt();
            for (int i = 0; i < length; i++) {
                yeah.readUTF();
                yeah.readBoolean();
            }
            yeah.readLong();
            ObjectInputStream cargar = new ObjectInputStream(new FileInputStream(yeah.readUTF()));
            yeah.close();
            cargar.close();
            return (Juego)cargar.readObject();
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public void borrar(Juego j){
        String fileName= "Partidas/partida_" + j.getNumPartida() +".uno";
        String fileNameO= "Partidas/partida_" + j.getNumPartida() +"O.uno";
            File file= new File(fileName);
            if(file.exists())
                file.delete();
            file= new File(fileNameO);
                if(file.exists())
                file.delete();
   }


}
