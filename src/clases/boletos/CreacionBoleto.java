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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.boleto;

/**
 *
 * @author DANIEL
 */
public class CreacionBoleto extends javax.swing.JFrame {

    /**
     * Creates new form CreacionBoleto
     */
    public String Num_Boleto;
    public String[] botones_confirmacionCrear = {"SI", "NO"};
    public boleto boleto = new boleto();
    public IdentificacionBoleto IB = new IdentificacionBoleto();
    public CreacionBoleto() {
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
        MsLB = new javax.swing.JLabel();
        MStxt = new javax.swing.JTextField();
        ImpurezasLB = new javax.swing.JLabel();
        Impurezastxt = new javax.swing.JTextField();
        ObservacionesLB = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ObservacionestTXT = new javax.swing.JTextArea();
        CancelarBT = new javax.swing.JButton();
        CrearBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Informacion del Boleto");

        NumBoletotxt.setEditable(false);
        NumBoletotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumBoletotxtActionPerformed(evt);
            }
        });

        NumBoletoLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NumBoletoLB.setText("Num. Boleto");

        FechaLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaLB.setText("Fecha");

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

        KgNetosLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KgNetosLB.setText("Kg. Netos");

        MsLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MsLB.setText("%MS");

        ImpurezasLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ImpurezasLB.setText("Impurezas");

        ObservacionesLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ObservacionesLB.setText("Observaciones");

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

        CrearBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CrearBT.setText("CREAR");
        CrearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearBTActionPerformed(evt);
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
                                        .addComponent(MsLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ImpurezasLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Impurezastxt, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ObservacionesLB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CrearBT)
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
                            .addComponent(MsLB)
                            .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImpurezasLB)
                            .addComponent(Impurezastxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ObservacionesLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarBT)
                    .addComponent(CrearBT))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NumBoletotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumBoletotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumBoletotxtActionPerformed

    private void CancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTActionPerformed
        String[] botones_confirmacionCancelar = {"NO, NO DESEO CANCELAR", "SI, SI DESEO CANCELAR"};
        int index = JOptionPane.showOptionDialog(null, "DESEA CANCELAR LA CREACION DE TRANSACCION?", "CONFIRMACION DE CANCELACION", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones_confirmacionCancelar, botones_confirmacionCancelar[0]);
        /*
            ESTE AVISO ARROJA DOS VALORES ENTEROS
            0- NO DESEA CANCELAR
            1- SI DESEA CANCELAR
         */
        if (index == 1) {
            this.dispose();
        }
        
    }//GEN-LAST:event_CancelarBTActionPerformed

    private void CrearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearBTActionPerformed
        /*
            TENEMOS QUE IDENTIFICAR PRIMERO QUE TODOS LOS DATOS HAYAN SIDO COMPLETADOS (excepto las observaciones)
            GUARDAMOS EN VARIAS VARIABLES LOS DATOS
        */
        String num_boleto = NumBoletotxt.getText();
        String Fecha = Fechatxt.getText();
        String Semana = Semanatxt.getText();
        float Kg_Brutos = Float.parseFloat(KgBrutostxt.getText());
        float Kg_Netos = Float.parseFloat(KgNetostxt.getText());
        int MS = Integer.parseInt(MStxt.getText());
        int impurezas = Integer.parseInt(Impurezastxt.getText());
        
        
        if(!num_boleto.isEmpty() && !Fecha.isEmpty() && !Semana.isEmpty() && !KgBrutostxt.getText().isEmpty() 
                && !KgNetostxt.getText().isEmpty() && !MStxt.getText().isEmpty() && !Impurezastxt.getText().isEmpty()){
            
            /*
                ESTO SIGNIFICA QUE TODOS Y ABSOLUTAMENTE TODOS ESTAN LLENOS
                COMO YA TENEMOS LOS DATOS AQUI, SOLAMENTE PROCEDEMOS A LLAMAR A LA FUNCION CON LAS VARIABLES
            */
            boleto.NuevoBoleto(num_boleto, Fecha, Semana, Kg_Brutos, Kg_Netos, MS, impurezas, 0);
            // EL ULTIMO DATO DEL BOLETO ES 0, QUE SIGNIFICA LA CANTIDAD DE TRANSACCIONES
            // COMO ESTE BOLETO, ESTA CREANDOSE A PENAS, NO TIENE NIGUNA TRANSACCION
            int index = JOptionPane.showOptionDialog(null, "CREACION EXITOSA \n \n ¿DESEA CREAR UN NUEVO PROVEEDOR?", "CONFIRMACION DE CREAR", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones_confirmacionCrear, botones_confirmacionCrear[0]);
            if(index == 0){
                IB.setVisible(true);
                this.dispose();
            } else {
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE TODOS LOS CAMPOS (las observaciones NO)", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CrearBTActionPerformed

    private void FechatxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FechatxtFocusLost
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
    }//GEN-LAST:event_FechatxtFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        NumBoletotxt.setText(Num_Boleto);
    }//GEN-LAST:event_formWindowOpened

    
    
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
            java.util.logging.Logger.getLogger(CreacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreacionBoleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarBT;
    private javax.swing.JButton CrearBT;
    private javax.swing.JLabel FechaLB;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JLabel ImpurezasLB;
    private javax.swing.JTextField Impurezastxt;
    private javax.swing.JLabel KgBrutosLB;
    private javax.swing.JTextField KgBrutostxt;
    private javax.swing.JLabel KgNetosLB;
    private javax.swing.JTextField KgNetostxt;
    private javax.swing.JTextField MStxt;
    private javax.swing.JLabel MsLB;
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
