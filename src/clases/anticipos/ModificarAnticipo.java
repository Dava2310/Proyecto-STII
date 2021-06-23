/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.anticipos;

/**
 *
 * @author DANIEL
 */
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.anticipos;
import logica.proveedor;

public class ModificarAnticipo extends javax.swing.JFrame {

    anticipos a = new anticipos();
    proveedor p = new proveedor();
    boolean edicion = false;

    public ModificarAnticipo() {
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

        jButton1 = new javax.swing.JButton();
        MontoDStxt = new javax.swing.JTextField();
        FechaL = new javax.swing.JLabel();
        InfoProveedorL = new javax.swing.JLabel();
        Fechatxt = new javax.swing.JTextField();
        IconProveedor = new javax.swing.JLabel();
        AprobacionL = new javax.swing.JLabel();
        CodigoL = new javax.swing.JLabel();
        Aprobaciontxt = new javax.swing.JTextField();
        Codigotxt = new javax.swing.JTextField();
        ObservacionL = new javax.swing.JLabel();
        IDL = new javax.swing.JLabel();
        IDCB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Observaciontxt = new javax.swing.JTextArea();
        IDtxt = new javax.swing.JTextField();
        ModificarBT = new javax.swing.JButton();
        RazonSocialL = new javax.swing.JLabel();
        RazonSocialtxt = new javax.swing.JTextField();
        infoAnticipoL = new javax.swing.JLabel();
        IconAnticipo = new javax.swing.JLabel();
        NroAnticipoL = new javax.swing.JLabel();
        NroAnticipotxt = new javax.swing.JTextField();
        MotivoAnticipoL = new javax.swing.JLabel();
        MontoBSL = new javax.swing.JLabel();
        MontoBStxt = new javax.swing.JTextField();
        MontoDSL = new javax.swing.JLabel();
        CancelarBT = new javax.swing.JButton();
        BuscarBT = new javax.swing.JButton();
        MotivoAnticipoCB = new javax.swing.JComboBox<>();
        AprobacionL1 = new javax.swing.JLabel();
        DescontarCB = new javax.swing.JComboBox<>();
        EdicionBT = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MontoDStxt.setEditable(false);
        MontoDStxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        FechaL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaL.setText("Fecha");

        InfoProveedorL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InfoProveedorL.setText("Información del Proveedor");

        Fechatxt.setEditable(false);
        Fechatxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        IconProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagen1.png"))); // NOI18N

        AprobacionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AprobacionL.setText("Aprobado por");

        CodigoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CodigoL.setText("Código (*)");

        Aprobaciontxt.setEditable(false);
        Aprobaciontxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        Codigotxt.setEditable(false);
        Codigotxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        ObservacionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ObservacionL.setText("Observaciones");

        IDL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IDL.setText("Identificación (*)");

        IDCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "J", "P", "G" }));
        IDCB.setEnabled(false);
        IDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCBActionPerformed(evt);
            }
        });

        Observaciontxt.setColumns(20);
        Observaciontxt.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        Observaciontxt.setRows(5);
        jScrollPane1.setViewportView(Observaciontxt);

        IDtxt.setEditable(false);
        IDtxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        ModificarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ModificarBT.setText("Modificar");
        ModificarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarBTActionPerformed(evt);
            }
        });

        RazonSocialL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RazonSocialL.setText("Razón Social (*)");

        RazonSocialtxt.setEditable(false);

        infoAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        infoAnticipoL.setText("Información del Anticipo");

        IconAnticipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aa.png"))); // NOI18N

        NroAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NroAnticipoL.setText("Anticipo Nº");

        NroAnticipotxt.setBackground(new java.awt.Color(0, 0, 0));
        NroAnticipotxt.setForeground(new java.awt.Color(255, 255, 255));

        MotivoAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MotivoAnticipoL.setText("Motivo del Anticipo");

        MontoBSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoBSL.setText("Monto en BS");

        MontoBStxt.setEditable(false);
        MontoBStxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        MontoDSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoDSL.setText("Monto en DS");

        CancelarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CancelarBT.setText("CANCELAR");

        BuscarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BuscarBT.setText("Buscar");
        BuscarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBTActionPerformed(evt);
            }
        });

        MotivoAnticipoCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        MotivoAnticipoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materia Prima", "Adicional", "Peaje", "Otros" }));
        MotivoAnticipoCB.setEnabled(false);

        AprobacionL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AprobacionL1.setText("Descontar en ODP");

        DescontarCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        DescontarCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        DescontarCB.setEnabled(false);

        EdicionBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EdicionBT.setText("HABILITAR EDICION");
        EdicionBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EdicionBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InfoProveedorL)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IconProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CodigoL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(IDL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(RazonSocialL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RazonSocialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(infoAnticipoL)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IconAnticipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MotivoAnticipoL)
                                    .addComponent(MontoBSL)
                                    .addComponent(AprobacionL)
                                    .addComponent(AprobacionL1)
                                    .addComponent(NroAnticipoL))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(MotivoAnticipoCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(MontoBStxt))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(MontoDSL)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(MontoDStxt))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(FechaL)
                                                    .addGap(51, 51, 51)
                                                    .addComponent(Fechatxt))))
                                        .addComponent(Aprobaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ObservacionL))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EdicionBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BuscarBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModificarBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelarBT)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfoProveedorL)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IconProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodigoL)
                            .addComponent(Codigotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDL)
                            .addComponent(IDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RazonSocialL)
                            .addComponent(RazonSocialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoAnticipoL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconAnticipo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NroAnticipoL)
                            .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MotivoAnticipoL)
                            .addComponent(FechaL)
                            .addComponent(Fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MotivoAnticipoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MontoBSL)
                            .addComponent(MontoBStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MontoDSL)
                            .addComponent(MontoDStxt))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AprobacionL)
                            .addComponent(Aprobaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AprobacionL1)
                    .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(ObservacionL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BuscarBT)
                            .addComponent(ModificarBT)
                            .addComponent(CancelarBT)
                            .addComponent(EdicionBT))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDCBActionPerformed

    private void BuscarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBTActionPerformed
        Object[] dataAnticipo;
        Object[] dataProveedor;

        int num_anticipo = Integer.parseInt(NroAnticipotxt.getText());
        if (!NroAnticipotxt.getText().isEmpty()) {
            try{
                boolean encontrado = a.buscarAnticipo(num_anticipo);
                if (encontrado) {
                    dataAnticipo = a.conseguirDatos(num_anticipo);
                    //SE DEBE AGARRAR LOS DATOS DEL PROVEEDOR
                    if (p.buscarCodigo(Integer.parseInt(dataAnticipo[8].toString()))) {
                        dataProveedor = p.conseguirDatos(Integer.parseInt(dataAnticipo[8].toString()), "", "", 1);
                        escribirDatosProveedor(dataProveedor);
                    }
                    //UNA VEZ COLOCADOS TODOS LOS DATOS DEL PROVEEDOR, SE LLAMA A LA FUNCION DE ESCRIBIR LOS DATOS DEL ANTICIPO
                    escribirDatosAnticipo(dataAnticipo);    
                } else if (!encontrado){
                    JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN ANTICIPO CON ESTE CODIGO", "BUSQUEDA DE ANTICIPO", JOptionPane.ERROR);
                }    
            }catch(SQLException ex) {
                Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
    }//GEN-LAST:event_BuscarBTActionPerformed

    private void ModificarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarBTActionPerformed
        if (!(Codigotxt.getText().equals("")) && !(IDtxt.getText().equals("")) && !(RazonSocialtxt.getText().equals("")) && !(NroAnticipotxt.getText().isEmpty())) {
            String motivo_anticipo = MotivoAnticipoCB.getSelectedItem().toString();
            String fecha = Fechatxt.getText();
            float monto_bs = Float.parseFloat(MontoBStxt.getText());
            float monto_ds = Float.parseFloat(MontoDStxt.getText());
            String aprobacion = Aprobaciontxt.getText();
            String descontarODP = DescontarCB.getSelectedItem().toString();
            String observaciones = Observaciontxt.getText();
            String codigo_proveedor = Codigotxt.getText();
            String num_anticipo = NroAnticipotxt.getText();
            String semana = "";
            try {
                a.updateAnticipo(motivo_anticipo, fecha, semana, monto_bs, monto_ds, aprobacion, observaciones, descontarODP, codigo_proveedor, num_anticipo);
                JOptionPane.showMessageDialog(null, "LOS CAMBIOS HAN SIDO GUARDADOS EXITOSAMENTE", "ACTUALIZACION DE DATOS", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(ModificarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE REALIZAR PRIMERO UNA BUSQUEDA DEL PROVEEDOR", "ACTUALIZACION DE DATOS", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_ModificarBTActionPerformed

    private void EdicionBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EdicionBTActionPerformed
        //SE DEBE CONFIRMAR QUE HAY UN ANTICIPO BUSCADO EN LA PANTALLA
        if (!(Codigotxt.getText().equals("")) && !(IDtxt.getText().equals("")) && !(RazonSocialtxt.getText().equals("")) && !(NroAnticipotxt.getText().equals(""))) {
            if (edicion == false) {
                MotivoAnticipoCB.setEnabled(true);
                MontoBStxt.setEditable(true);
                MontoDStxt.setEditable(true);
                NroAnticipotxt.setEnabled(false);
            } else if (edicion == true) {
                MotivoAnticipoCB.setEnabled(false);
                MontoBStxt.setEditable(false);
                MontoDStxt.setEditable(false);
                NroAnticipotxt.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "DEBE HABER BUSCADO UN ANTICIPO PARA PODER MODIFICAR SUS DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_EdicionBTActionPerformed
    /*
     
     */
    public void escribirDatosAnticipo(Object[] dataAnticipo) {
        NroAnticipotxt.setText(dataAnticipo[0].toString());
        MotivoAnticipoCB.setSelectedIndex(a.motivoAnticipo(dataAnticipo[1].toString()));
        Fechatxt.setText(dataAnticipo[2].toString());
        MontoBStxt.setText(dataAnticipo[3].toString());
        MontoDStxt.setText(dataAnticipo[4].toString());
        Aprobaciontxt.setText(dataAnticipo[5].toString());
        Observaciontxt.setText(dataAnticipo[6].toString());
        DescontarCB.setSelectedIndex(a.descontarODP(dataAnticipo[7].toString()));
    }

    public void escribirDatosProveedor(Object[] dataProveedor) {
        Codigotxt.setText(dataProveedor[0].toString());
        RazonSocialtxt.setText(dataProveedor[2].toString());
        String identificacion_completa = dataProveedor[1].toString();
        char tipo_identificacion = identificacion_completa.charAt(0);
        int TipoID = p.indexIdentificacion(tipo_identificacion);
        IDCB.setSelectedIndex(TipoID);
        IDtxt.setText(identificacion_completa.substring(1, identificacion_completa.length()));
    }

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
            java.util.logging.Logger.getLogger(ModificarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarAnticipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AprobacionL;
    private javax.swing.JLabel AprobacionL1;
    private javax.swing.JTextField Aprobaciontxt;
    private javax.swing.JButton BuscarBT;
    private javax.swing.JButton CancelarBT;
    private javax.swing.JLabel CodigoL;
    private javax.swing.JTextField Codigotxt;
    private javax.swing.JComboBox<String> DescontarCB;
    private javax.swing.JButton EdicionBT;
    private javax.swing.JLabel FechaL;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JComboBox<String> IDCB;
    private javax.swing.JLabel IDL;
    private javax.swing.JTextField IDtxt;
    private javax.swing.JLabel IconAnticipo;
    private javax.swing.JLabel IconProveedor;
    private javax.swing.JLabel InfoProveedorL;
    private javax.swing.JButton ModificarBT;
    private javax.swing.JLabel MontoBSL;
    private javax.swing.JTextField MontoBStxt;
    private javax.swing.JLabel MontoDSL;
    private javax.swing.JTextField MontoDStxt;
    private javax.swing.JComboBox<String> MotivoAnticipoCB;
    private javax.swing.JLabel MotivoAnticipoL;
    private javax.swing.JLabel NroAnticipoL;
    private javax.swing.JTextField NroAnticipotxt;
    private javax.swing.JLabel ObservacionL;
    private javax.swing.JTextArea Observaciontxt;
    private javax.swing.JLabel RazonSocialL;
    private javax.swing.JTextField RazonSocialtxt;
    private javax.swing.JLabel infoAnticipoL;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
