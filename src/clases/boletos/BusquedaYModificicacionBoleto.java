/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.boletos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import logica.boleto;

/**
 *
 * @author DANIEL
 */
public class BusquedaYModificicacionBoleto extends javax.swing.JFrame {

    /**
     * Creates new form CreacionBoleto
     */
    public String num_boleto_buscado = "";
    public String boletoBueno;
    public boleto boleto = new boleto();
    public boolean modificacion = false;
    public BusquedaYModificicacionBoleto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NumBoletotxt = new javax.swing.JTextField();
        NumBoletoLB = new javax.swing.JLabel();
        FechaLB = new javax.swing.JLabel();
        Fechatxt = new javax.swing.JTextField();
        SemanaLB = new javax.swing.JLabel();
        Semanatxt = new javax.swing.JTextField();
        KgBrutosLB = new javax.swing.JLabel();
        KgBrutostxt = new javax.swing.JTextField();
        KgNetosLB = new javax.swing.JLabel();
        KgNetostxt = new javax.swing.JTextField();
        MSlb = new javax.swing.JLabel();
        MStxt = new javax.swing.JTextField();
        ImpurezasLB = new javax.swing.JLabel();
        Impurezastxt = new javax.swing.JTextField();
        ObservacionesLB = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ObservacionestTXT = new javax.swing.JTextArea();
        CancelarBT = new javax.swing.JButton();
        BuscarBT = new javax.swing.JButton();
        ModificarBT = new javax.swing.JButton();
        CantidadTransaccionesLB = new javax.swing.JLabel();
        CantidadTransaccionesTXT = new javax.swing.JTextField();
        CambiarBT = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Informacion del Boleto");

        NumBoletotxt.setBackground(new java.awt.Color(0, 0, 0));
        NumBoletotxt.setForeground(new java.awt.Color(255, 255, 255));
        NumBoletotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumBoletotxtActionPerformed(evt);
            }
        });

        NumBoletoLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NumBoletoLB.setText("Num. Boleto");

        FechaLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaLB.setText("Fecha");

        Fechatxt.setEditable(false);
        Fechatxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FechatxtFocusLost(evt);
            }
        });

        SemanaLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SemanaLB.setText("Semana");

        Semanatxt.setEditable(false);

        KgBrutosLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KgBrutosLB.setText("Kg. Brutos");

        KgBrutostxt.setEditable(false);

        KgNetosLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KgNetosLB.setText("Kg. Netos");

        KgNetostxt.setEditable(false);

        MSlb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MSlb.setText("%MS");

        MStxt.setEditable(false);

        ImpurezasLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ImpurezasLB.setText("Impurezas");

        Impurezastxt.setEditable(false);

        ObservacionesLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ObservacionesLB.setText("Observaciones");

        ObservacionestTXT.setEditable(false);
        ObservacionestTXT.setColumns(20);
        ObservacionestTXT.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ObservacionestTXT.setRows(5);
        jScrollPane1.setViewportView(ObservacionestTXT);

        CancelarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CancelarBT.setText("CANCELAR");
        CancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBTActionPerformed(evt);
            }
        });

        BuscarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BuscarBT.setText("BUSCAR");
        BuscarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBTActionPerformed(evt);
            }
        });

        ModificarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ModificarBT.setText("GUARDAR CAMBIOS");
        ModificarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarBTActionPerformed(evt);
            }
        });

        CantidadTransaccionesLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CantidadTransaccionesLB.setText("Cantidad de Transacciones");

        CantidadTransaccionesTXT.setEditable(false);

        CambiarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CambiarBT.setText("HABILITAR CAMBIOS");
        CambiarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NumBoletoLB)
                                    .addComponent(FechaLB)
                                    .addComponent(KgBrutosLB))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NumBoletotxt)
                                            .addComponent(Fechatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addComponent(SemanaLB)
                                        .addGap(18, 18, 18)
                                        .addComponent(Semanatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(KgBrutostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(KgNetosLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(KgNetostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MSlb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ImpurezasLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Impurezastxt, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ObservacionesLB)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CantidadTransaccionesLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CantidadTransaccionesTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CambiarBT)
                        .addGap(18, 18, 18)
                        .addComponent(ModificarBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscarBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelarBT)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumBoletotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumBoletoLB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechaLB)
                            .addComponent(Fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SemanaLB)
                            .addComponent(Semanatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KgBrutosLB)
                            .addComponent(KgBrutostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KgNetosLB)
                            .addComponent(KgNetostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MSlb)
                            .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImpurezasLB)
                            .addComponent(Impurezastxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CantidadTransaccionesLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CantidadTransaccionesTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ObservacionesLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarBT)
                    .addComponent(BuscarBT)
                    .addComponent(ModificarBT)
                    .addComponent(CambiarBT))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NumBoletotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumBoletotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumBoletotxtActionPerformed

    private void BuscarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBTActionPerformed
        /*
            DEBO RECOLECTAR Y VERIFICAR EL NUM BOLETO
        */
        String num_boleto = NumBoletotxt.getText();
        if(!num_boleto.isEmpty()){
            boletoBueno = "";
            for (int i = 0; i < num_boleto.length(); i++) {
                if (num_boleto.charAt(i) != ' ' && num_boleto.charAt(i) != '\n') {
                    boletoBueno = boletoBueno + num_boleto.charAt(i);
                }
            }
            /*
                LLAMAR A LA FUNCION BUSQUEDA DE BOLETO
                CON LA VARIABLE "boletoBueno"
            */
            boolean encontrado = boleto.buscarBoleto(boletoBueno);
            //AHORA ME TOCA IDENTIFICAR SI LO ENCONTRAMOS O NO
            if(encontrado){
                /*
                    COMO SI SE ENCONTRO, ME TOCA IMPRIMIR TODOS LOS DATOS DEL BOLETO EN PANTALLA
                */
                Object[] data = boleto.conseguirDatos(boletoBueno);
                num_boleto_buscado = boletoBueno;
                imprimirDatos(data);
            } else {
                JOptionPane.showMessageDialog(null, "BOLETO NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DE BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BuscarBTActionPerformed
    
    /*
        FUNCION PARA ESCRIBIR LOS DATOS POR PANTALLA DEL BOLETO
        EXCEPTO POR EL NUMERO DE BOLETO
    */
    public void imprimirDatos(Object[] data){
        Fechatxt.setText(data[1].toString());
        Semanatxt.setText(data[2].toString());
        KgBrutostxt.setText(String.valueOf(data[3]));
        KgNetostxt.setText(String.valueOf(data[4]));
        MStxt.setText(String.valueOf(data[5]));
        Impurezastxt.setText(String.valueOf(data[6]));
        CantidadTransaccionesTXT.setText(String.valueOf(data[7]));
    }
    
    private void ModificarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarBTActionPerformed
        if(!NumBoletotxt.getText().isEmpty()){
            if(num_boleto_buscado.equals(NumBoletotxt.getText())){
                if(modificacion){
                    /*
                        AQUI YA DE SEGURO TENEMOS UNA MODIFICACION SEGURA
                        POR TANTO, RECOGEMOS LOS DATOS NUEVAMENTE DE CADA CAMPO
                    */
                    String num_boleto = boletoBueno;
                    String fecha = Fechatxt.getText();
                    String semana = Semanatxt.getText();
                    float KgBrutos = Float.parseFloat(KgBrutostxt.getText());
                    float KgNetos = Float.parseFloat(KgNetostxt.getText());
                    int MS = Integer.parseInt(MStxt.getText());
                    int Impurezas = Integer.parseInt(Impurezastxt.getText());
                    //DE AQUI YA TENEMOS TODOS LOS NECESARIOS PARA UN UPDATE DE BOLETO
                    boleto.updateBoleto(num_boleto, fecha, semana, KgBrutos, KgNetos, MS, Impurezas);
                    CambiarBT.setSelected(false);
                    modificacion = false;
                    deshabilitarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "HABILITE LA OPCION DE HACER CAMBIOS PARA PODER GUARDARLOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ESTE BOLETO NO COINCIDE CON EL QUE SE BUSCO POR ULTIMA VEZ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DE BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ModificarBTActionPerformed

    private void CancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarBTActionPerformed

    private void CambiarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarBTActionPerformed
        if(!modificacion){
            if(!NumBoletotxt.getText().isEmpty()){
                if(num_boleto_buscado.equals(NumBoletotxt.getText())){
                    /*
                        AQUI LO QUE DEBEMOS HACER ES DARLE PASO A PODER MODIFICAR TODOS LOS CAMPOS EXCEPTO EL CODIGO
                    */
                    NumBoletotxt.setEditable(false);
                    habilitarCampos();
                    modificacion = true;
                }
            } 
        } else if(modificacion){
            if(!NumBoletotxt.getText().isEmpty()){
                if(num_boleto_buscado.equals(NumBoletotxt.getText())){
                    /*
                        AQUI LO QUE DEBEMOS HACER ES DARLE PASO A PODER MODIFICAR TODOS LOS CAMPOS EXCEPTO EL CODIGO
                    */
                    NumBoletotxt.setEditable(true);
                    deshabilitarCampos();
                    modificacion = false;
                }
            } 
        }
    }//GEN-LAST:event_CambiarBTActionPerformed
    
    public void deshabilitarCampos(){
        Fechatxt.setEditable(false);
                    KgBrutostxt.setEditable(false);
                    KgNetostxt.setEditable(false);
                    MStxt.setEditable(false);
                    Impurezastxt.setEditable(false);
                    ObservacionestTXT.setEditable(false);
    }
    
    public void habilitarCampos(){
        Fechatxt.setEditable(true);
                    KgBrutostxt.setEditable(true);
                    KgNetostxt.setEditable(true);
                    MStxt.setEditable(true);
                    Impurezastxt.setEditable(true);
                    ObservacionestTXT.setEditable(true);
    }
    
    private void FechatxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FechatxtFocusLost
        if(modificacion){
                if(Fechatxt.getText().length() == 10){
                String date2 = Fechatxt.getText();
                Date anio = new Date();
                SimpleDateFormat formatoAnio = new SimpleDateFormat("YYYY");
                String anioActual = formatoAnio.format(anio);
                try {
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(date1);
                    Semanatxt.setText((calendar.get(Calendar.WEEK_OF_YEAR) - 1) + "-" + anioActual);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "INGRESE LA FECHA EN EL FORMATO CORRESPONDIENTE: DD/MM/YYYY", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "INGRESE LA FECHA EN EL FORMATO CORRESPONDIENTE: DD/MM/YYYY", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_FechatxtFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaYModificicacionBoleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarBT;
    private javax.swing.JToggleButton CambiarBT;
    private javax.swing.JButton CancelarBT;
    private javax.swing.JLabel CantidadTransaccionesLB;
    private javax.swing.JTextField CantidadTransaccionesTXT;
    private javax.swing.JLabel FechaLB;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JLabel ImpurezasLB;
    private javax.swing.JTextField Impurezastxt;
    private javax.swing.JLabel KgBrutosLB;
    private javax.swing.JTextField KgBrutostxt;
    private javax.swing.JLabel KgNetosLB;
    private javax.swing.JTextField KgNetostxt;
    private javax.swing.JLabel MSlb;
    private javax.swing.JTextField MStxt;
    private javax.swing.JButton ModificarBT;
    private javax.swing.JLabel NumBoletoLB;
    private javax.swing.JTextField NumBoletotxt;
    private javax.swing.JLabel ObservacionesLB;
    private javax.swing.JTextArea ObservacionestTXT;
    private javax.swing.JLabel SemanaLB;
    private javax.swing.JTextField Semanatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
