package clases;

import javax.swing.JOptionPane;
import logica.proveedor;
import logica.transacciones;

public class IdentificacionProveedorTransacciones extends javax.swing.JFrame {

    TransaccionesCrear TC;
    proveedor p = new proveedor();
    transacciones t = new transacciones();

    public IdentificacionProveedorTransacciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NroBoletoL = new javax.swing.JLabel();
        NroBoletotxt = new javax.swing.JTextField();
        IDProveedorL = new javax.swing.JLabel();
        IDProveedortxt = new javax.swing.JTextField();
        tipoIDProveedorCB = new javax.swing.JComboBox<>();
        EnterBT = new javax.swing.JButton();
        Foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NroBoletoL.setBackground(new java.awt.Color(0, 153, 153));
        NroBoletoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NroBoletoL.setText("<html>Ingrese Numero de Boleto<html>");
        NroBoletoL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        NroBoletoL.setOpaque(true);

        NroBoletotxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        IDProveedorL.setBackground(new java.awt.Color(0, 153, 153));
        IDProveedorL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IDProveedorL.setText("<html>Ingrese Identificacion del proveedor<html>");
        IDProveedorL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        IDProveedorL.setOpaque(true);

        IDProveedortxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        IDProveedortxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDProveedortxtActionPerformed(evt);
            }
        });

        tipoIDProveedorCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "J", "P", "G" }));
        tipoIDProveedorCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoIDProveedorCBActionPerformed(evt);
            }
        });

        EnterBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EnterBT.setText("Ingresar");
        EnterBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterBTActionPerformed(evt);
            }
        });

        Foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagen1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Foto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NroBoletoL, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(NroBoletotxt, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(IDProveedorL, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(tipoIDProveedorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDProveedortxt)))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(EnterBT)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Foto))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(NroBoletoL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NroBoletotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IDProveedorL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDProveedortxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoIDProveedorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EnterBT)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tipoIDProveedorCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoIDProveedorCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoIDProveedorCBActionPerformed

    private void IDProveedortxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDProveedortxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDProveedortxtActionPerformed

    private void EnterBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterBTActionPerformed
        if (NroBoletotxt.getText().isEmpty() || IDProveedortxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DEL BOLETO Y LA IDENTIFICACION DEL PROVEEDOR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            //DESPUES DE HABER COMPROBADO QUE NINGUNO DE LOS CAMPOS ESTAN VACIOS, PROCEDEMOS A HACER DISTINTAS VALIDACIONES
            //1- Validar que el num de transaccion no se encuentra en el sistema
            //2- Validad que el proveedor si se encuentra en el sistema

            boolean transaccionEncontrada = t.buscarTransaccion(NroBoletotxt.getText());
            //Recolectar los datos en una identificacion completa
            int tipoIdentificacion = tipoIDProveedorCB.getSelectedIndex();
            String t_identificacion = tipoIDProveedorCB.getSelectedItem().toString();
            String identificacion_completa = t_identificacion + IDProveedortxt.getText();
            boolean proveedorActivoEncontrado = p.buscarProveedorActivo(identificacion_completa);

            /*
                AHORA QUE YA SABEMOS SI TENEMOS UN PROVEEDOR ACTIVO EN EL SISTEMA, 
                Y QUE SI EXISTE O NO UNA TRANSACCION EN EL SISTEMA,
                PROCEDEMOS A VERIFICAR
             */
            if (transaccionEncontrada == false && proveedorActivoEncontrado == true) {
                TC = new TransaccionesCrear();
                TC.setVisible(true);
                this.dispose();
            } else if (transaccionEncontrada) {
                JOptionPane.showMessageDialog(null, "Esta transaccion o boleto ya existe en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (proveedorActivoEncontrado == false){
                JOptionPane.showMessageDialog(null, "El proveedor asignado no esta activo en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_EnterBTActionPerformed

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
            java.util.logging.Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdentificacionProveedorTransacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnterBT;
    private javax.swing.JLabel Foto;
    private javax.swing.JLabel IDProveedorL;
    private javax.swing.JTextField IDProveedortxt;
    private javax.swing.JLabel NroBoletoL;
    private javax.swing.JTextField NroBoletotxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> tipoIDProveedorCB;
    // End of variables declaration//GEN-END:variables
}
