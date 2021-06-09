package clases.boletos;

import clases.transacciones.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.boleto;
import logica.proveedor;
import logica.transacciones;

public class IdentificacionBoleto extends javax.swing.JFrame {
    
    
    public boleto b = new boleto();
    public CreacionBoleto CB;
    
    public IdentificacionBoleto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NroBoletoL = new javax.swing.JLabel();
        NroBoletotxt = new javax.swing.JTextField();
        EnterBT = new javax.swing.JButton();
        Foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        NroBoletoL.setBackground(new java.awt.Color(0, 153, 153));
        NroBoletoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NroBoletoL.setText("<html>Ingrese Numero de Boleto<html>");
        NroBoletoL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        NroBoletoL.setOpaque(true);

        NroBoletotxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        EnterBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EnterBT.setText("Ingresar");
        EnterBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterBTActionPerformed(evt);
            }
        });

        Foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Foto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NroBoletoL, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(NroBoletotxt, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(EnterBT)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Foto)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(NroBoletoL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NroBoletotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EnterBT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EnterBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterBTActionPerformed
        /*
            LA PERSONA ESCRIBE EN EL JTEXTFIELD EL NUMERO DE BOLETO
            DEBO REVISAR ENTONCES QUE ESE NUMERO DE BOLETO NO SE ENCUENTRE EN EL SISTEMA
        */
        String num_boleto = NroBoletotxt.getText();
        if(!num_boleto.isEmpty()){
            
            //Procedimiento para quitarle los espacios
            String boletoBueno = "";
            for (int i = 0; i < num_boleto.length(); i++) {
                if (num_boleto.charAt(i) != ' ' && num_boleto.charAt(i) != '\n') {
                    boletoBueno = boletoBueno + num_boleto.charAt(i);
                }
            }   
            /*
                BUSCAR EN LA BASE DE DATOS SI ESTE BOLETO SE ENCUENTRA 
                SI SE ENCUENTRA, NO DEBE DEJARLE PASO
            */
            boolean encontrado;
            try {
                encontrado = b.buscarBoleto(boletoBueno);
                    if(!encontrado){
                    /*
                        COMO YA SABEMOS QUE EL BOLETO NO ESTA CREADO
                        PODEMOS DAR PASO A ENVIAR A LA SIGUIENTE PANTALLA
                    */
                    CB = new CreacionBoleto();
                    //LE PASAMOS ESTE BOLETO A LA SIGUIENTE PANTALLA
                    CB.Num_Boleto = boletoBueno;
                    CB.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "ESTE BOLETO YA ESTA CREADO EN EL SISTEMA", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(IdentificacionBoleto.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DEL BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EnterBTActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
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
            java.util.logging.Logger.getLogger(IdentificacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentificacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentificacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentificacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdentificacionBoleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnterBT;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel NroBoletoL;
    private javax.swing.JTextField NroBoletotxt;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
