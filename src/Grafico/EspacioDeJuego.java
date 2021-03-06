/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EspacioDeJuego.java
 *
 * Created on 06-12-2011, 04:05:37 PM
 */

package Grafico;


import CodigoJuego.Carta;
import CodigoJuego.Juego;
import ManejadorJugadores.JugManager;
import ManejadorJugadores.MostJugs;
import ManejadorPartidas.ManejadorPartidas;
import javax.swing.*;

/**
 *
 * @author Owner
 */
public class EspacioDeJuego extends javax.swing.JFrame {
int posPrimero=0;
int posUltimo=5;
public Juego jueg;

boolean juegoEnCurso= false;
static final String[] opci={"Sí","No"};

    /** Creates new form EspacioDeJuego */
    public EspacioDeJuego(){
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMainComponentsVisible(false);
        setComodinComponents(false);
        Temporal.setVisible(false);
    }

    public void prepararJuego() {
        this.setManejoJug(false);
        this.setMainComponentsVisible(true);
    }

    private void ciclo() {
        NombreJug.setText(jueg.juega().nombre);
        if(jueg.enJuego==null)
            System.err.println("WHYY");
        Descarte.setIcon(jueg.enJuego.img);
        manoUpdate();
    }
    
    private void manoUpdate(){
        Carta[] rep= jueg.juega().exponer();
        Carta1.setIcon(rep[posPrimero].img);
        Carta2.setIcon(rep[posPrimero+1].img);
        if(posPrimero+2<rep.length){
            Carta3.setVisible(true);
            Carta3.setIcon(rep[posPrimero+2].img);
        }else
            Carta3.setVisible(false);
        if(posPrimero+3<rep.length){
            Carta4.setVisible(true);
            Carta4.setIcon(rep[posPrimero+3].img);
        }else
            Carta4.setVisible(false);
        if(posPrimero+4<rep.length){
            Carta5.setVisible(true);
            Carta5.setIcon(rep[posPrimero+4].img);
        }else
            Carta6.setVisible(false);
        if(posPrimero+3<rep.length){
            Carta6.setVisible(true);
            Carta6.setIcon(rep[posUltimo].img);
        }else
            Carta6.setVisible(false);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Carta1 = new javax.swing.JLabel();
        Carta5 = new javax.swing.JLabel();
        Carta4 = new javax.swing.JLabel();
        Carta3 = new javax.swing.JLabel();
        Carta2 = new javax.swing.JLabel();
        Carta6 = new javax.swing.JLabel();
        Descarte = new javax.swing.JLabel();
        ColActiv = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();
        Adelante = new javax.swing.JButton();
        Baraja = new javax.swing.JLabel();
        LabelActivo = new javax.swing.JLabel();
        Temporal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        NombreJug = new javax.swing.JLabel();
        Barra = new javax.swing.JMenuBar();
        MenuUnico = new javax.swing.JMenu();
        Jugar = new javax.swing.JMenu();
        NuevaP = new javax.swing.JMenuItem();
        Salv = new javax.swing.JMenuItem();
        MenuCargar = new javax.swing.JMenuItem();
        Reiniciar = new javax.swing.JMenuItem();
        Terminar = new javax.swing.JMenuItem();
        ManJug = new javax.swing.JMenu();
        AddJug = new javax.swing.JMenuItem();
        DelJug = new javax.swing.JMenuItem();
        Listado = new javax.swing.JMenuItem();
        Toptoptop = new javax.swing.JMenu();
        ult10 = new javax.swing.JMenuItem();
        uegosTodos = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Carta1.setText("jLabel1");
        Carta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Carta5.setText("jLabel1");
        Carta5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Carta4.setText("jLabel1");
        Carta4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Carta3.setText("jLabel1");
        Carta3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Carta2.setText("jLabel1");
        Carta2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Carta6.setText("jLabel1");
        Carta6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Descarte.setText("jLabel1");
        Descarte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ColActiv.setToolTipText("Color activo de Comodines");
        ColActiv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Atras.setText("Atras");

        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        Adelante.setText("Adelante");
        Adelante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdelanteActionPerformed(evt);
            }
        });


        Baraja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cartas/Back.PNG"))); // NOI18N
        Baraja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LabelActivo.setText("Color Activo");

        Temporal.setText("jLabel1");
        Temporal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NombreJug.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NombreJug.setText("jLabel1");

        MenuUnico.setText("Jugar");

        Jugar.setText("Jugar");
        Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarActionPerformed(evt);
            }
        });

        NuevaP.setText("Nueva Partida");
        NuevaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaPActionPerformed(evt);
            }
        });
        Jugar.add(NuevaP);

        Salv.setText("Salvar Partida");
        Salv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvActionPerformed(evt);
            }
        });
        Jugar.add(Salv);

        MenuCargar.setText("Cargar Partida Anterior");
        Jugar.add(MenuCargar);

        Reiniciar.setText("Reiniciar Partida");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });
        Jugar.add(Reiniciar);

        Terminar.setText("Terminar Partida");
        Terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminarActionPerformed(evt);
            }
        });
        Jugar.add(Terminar);

        MenuUnico.add(Jugar);

        ManJug.setText("Manejo de Jugadores");
        ManJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManJugActionPerformed(evt);
            }
        });

        AddJug.setText("Añadir Jugador");
        AddJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddJugActionPerformed(evt);
            }
        });
        ManJug.add(AddJug);

        DelJug.setText("Eliminar Jugador");
        DelJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelJugActionPerformed(evt);
            }
        });
        ManJug.add(DelJug);

        Listado.setText("Listar Jugadores Activos");
        Listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadoActionPerformed(evt);
            }
        });
        ManJug.add(Listado);

        MenuUnico.add(ManJug);

        Toptoptop.setText("El TOP 10");

        ult10.setText("Diez Ultimos Juegos");

        ult10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ult10ActionPerformed(evt);
            }
        });

        Toptoptop.add(ult10);

        uegosTodos.setText("Todos los juegos anteriores");
        uegosTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uegosTodosActionPerformed(evt);
            }
        });
        Toptoptop.add(uegosTodos);

        MenuUnico.add(Toptoptop);

        MenuSalir.setText("Salir ");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        MenuUnico.add(MenuSalir);

        Barra.add(MenuUnico);

        setJMenuBar(Barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Atras)
                .addGap(18, 18, 18)
                .addComponent(Carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(Carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Adelante)
                .addContainerGap(40, Short.MAX_VALUE))

            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(Baraja, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Descarte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(Temporal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelActivo, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ColActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))

            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(NombreJug, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(188, 188, 188))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()

                .addGap(51, 51, 51)
                .addComponent(NombreJug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(54, 54, 54)
                .addComponent(LabelActivo)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ColActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Descarte, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Baraja, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Temporal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)))
                .addGap(45, 45, 45)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Carta6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(Adelante)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Atras)
                        .addGap(16, 16, 16)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        if(!juegoEnCurso)
            System.exit(0);
        else{
            Object[] options = {"Sí","No","Cancelar"};
            int op= -2;
            do{
                op= JOptionPane.showOptionDialog(this,
                "Tiene una partida en juego. Desea salvarla antes de partir?",
                "Salvar", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
            } while(op==JOptionPane.CLOSED_OPTION);
            if(op==JOptionPane.CANCEL_OPTION)
                return;
            if(op==JOptionPane.YES_OPTION){
                ManejadorPartidas kas= new ManejadorPartidas();
                kas.Salvar(jueg);
            }
            System.exit(0);
        }
}//GEN-LAST:event_MenuSalirActionPerformed

    private void ManJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManJugActionPerformed
       
    }//GEN-LAST:event_ManJugActionPerformed

    private void SalvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvActionPerformed
        int i= JOptionPane.CLOSED_OPTION;
        while(i== JOptionPane.CLOSED_OPTION){
            i= JOptionPane.showOptionDialog(rootPane, "Confirman los demás que se salve esta partida?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opci, opci[0]);
        }
        if(i==JOptionPane.YES_OPTION){
            ManejadorPartidas kas= new ManejadorPartidas();
                kas.Salvar(jueg);
        }
    }//GEN-LAST:event_SalvActionPerformed

    private void TerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminarActionPerformed
        JOptionPane.showMessageDialog(this,"Nota: al haber seleccionado está opción se perderá todo el progreso no salvado del juego anterior.\n Considerando que la opción de <html><i>Salvar </i><b>estaba muy claramente marcada en el menú, </b></html> no es responsabilidad nuestra ayudarle a recuperar su juego en caso de no haber salvado adecuadamente. \nAtentamente: La Gerencia","Aviso",JOptionPane.WARNING_MESSAGE);
        volverAInicial();

    }//GEN-LAST:event_TerminarActionPerformed

    private void uegosTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uegosTodosActionPerformed

        Partidas part= new Partidas(this,true,1);
        part.setVisible(true);

    }//GEN-LAST:event_uegosTodosActionPerformed

    private void JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JugarActionPerformed

    private void NuevaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaPActionPerformed

        MostJugs milong=   new MostJugs(this, true, 2);
        milong.setVisible(true);
        if(!milong.isVisible())
            milong=null;
        if(this.juegoEnCurso){
            this.setManejoJug(false);
            jueg.open();
            while(juegoEnCurso){
                ciclo();
            }
        }
    }//GEN-LAST:event_NuevaPActionPerformed

    private void AddJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddJugActionPerformed
         String nom= JOptionPane.showInputDialog(rootPane, "Cómo se llamará el jugador?" , "Anonimo");
        byte edad= 0;
        while(edad<=0){
            edad= Byte.parseByte(JOptionPane.showInputDialog(rootPane, "Qué edad tiene el jugador?" , ""));
        }
        char genero= 'c';
        while(!(genero=='F'||genero=='M')){
           genero= JOptionPane.showInputDialog(rootPane, "De qué género es el jugador?" , "???").charAt(0);
        }
        JugManager logger= new JugManager();
        logger.addJugador(nom, genero, edad);
        logger.cerrarStream();
    }//GEN-LAST:event_AddJugActionPerformed

    private void DelJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelJugActionPerformed
        JugManager jm= new JugManager();
        String[] nom= jm.getSoloNombres();
        String aBorrar= (String)JOptionPane.showInputDialog(this, "Cual jugador desea eliminar?", "Eliminar", JOptionPane.QUESTION_MESSAGE,null,nom,nom[0]);
        if(aBorrar==null){
            jm.cerrarStream();
            return;
        }
        int k= JOptionPane.CLOSED_OPTION;
        while(k==JOptionPane.CLOSED_OPTION)
           k= JOptionPane.showOptionDialog(this, "Esta seguro que que desea eliminar este jugador?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opci, opci[0]);
        if(k==JOptionPane.YES_OPTION){
            jm.desactivarJugador(aBorrar);
            JOptionPane.showMessageDialog(this, aBorrar +" ha sido eliminado.");
        }
        jm.cerrarStream();
    }//GEN-LAST:event_DelJugActionPerformed

    private void ListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadoActionPerformed
        MostJugs moju= new MostJugs(this,true,1);
        moju.setVisible(true);
    }//GEN-LAST:event_ListadoActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed

        String[] job= jueg.getNombreJugadores();
        int np= jueg.getNumPartida();
        jueg= new Juego(job,np);


        JugManager sunset= new JugManager();
        for(String regrets: job){
            if(sunset.buscarJugador(regrets)==-1)
                jueg.Retirar(regrets);
        }
        sunset.cerrarStream();
        this.setComodinComponents(false);
    }//GEN-LAST:event_ReiniciarActionPerformed


    private void ult10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ult10ActionPerformed
        Partidas part= new Partidas(this,true,2);
        part.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ult10ActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        if(posPrimero>=2){
            posPrimero--;
            posUltimo--;
            manoUpdate();
        }
    }//GEN-LAST:event_AtrasActionPerformed

    private void AdelanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdelanteActionPerformed
        if(posUltimo<jueg.juega().exponer().length){
            posUltimo++;
            posPrimero++;
            manoUpdate();
        }
    }//GEN-LAST:event_AdelanteActionPerformed


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EspacioDeJuego().setVisible(true);
            }
        });
    }
    void setMainComponentsVisible(boolean bool){
        Atras.setVisible(bool);
        Adelante.setVisible(bool);
        Baraja.setVisible(bool);
        Descarte.setVisible(bool);
        Carta1.setVisible(bool);
        Carta2.setVisible(bool);
        Carta3.setVisible(bool);
        Carta4.setVisible(bool);
        Carta5.setVisible(bool);
        Carta6.setVisible(bool);
        NombreJug.setVisible(bool);
        Salv.setEnabled(bool);
        Reiniciar.setEnabled(bool);
        Terminar.setEnabled(bool);
    }

    void setComodinComponents(boolean bool){
        ColActiv.setVisible(bool);
        LabelActivo.setVisible(bool);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddJug;
    private javax.swing.JButton Adelante;
    private javax.swing.JButton Atras;
    private javax.swing.JLabel Baraja;
    private javax.swing.JMenuBar Barra;
    private javax.swing.JLabel Carta1;
    private javax.swing.JLabel Carta2;
    private javax.swing.JLabel Carta3;
    private javax.swing.JLabel Carta4;
    private javax.swing.JLabel Carta5;
    private javax.swing.JLabel Carta6;
    private javax.swing.JLabel ColActiv;
    private javax.swing.JMenuItem DelJug;
    private javax.swing.JLabel Descarte;
    private javax.swing.JMenu Jugar;
    private javax.swing.JLabel LabelActivo;
    private javax.swing.JMenuItem Listado;
    private javax.swing.JMenu ManJug;
    private javax.swing.JMenuItem MenuCargar;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JMenu MenuUnico;
    private javax.swing.JLabel NombreJug;
    private javax.swing.JMenuItem NuevaP;
    private javax.swing.JMenuItem Reiniciar;
    private javax.swing.JMenuItem Salv;
    private javax.swing.JLabel Temporal;
    private javax.swing.JMenuItem Terminar;
    private javax.swing.JMenu Toptoptop;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem uegosTodos;
    private javax.swing.JMenuItem ult10;
    // End of variables declaration//GEN-END:variables


    public void setManejoJug(boolean b) {
        ManJug.setEnabled(b);
    }
    // End of variables declaration

    private void volverAInicial() {
        setComodinComponents(false);
        setMainComponentsVisible(false);
        juegoEnCurso= false;
        setManejoJug(true);
        jueg= null;
        posPrimero= 0;
        posUltimo= 5;
    }

}
