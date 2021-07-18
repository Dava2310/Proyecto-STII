package clases.anticipos;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.anticipos;
import logica.proveedor;

public class ConsultarAnticipo extends javax.swing.JFrame {

    public anticipos a = new anticipos();
    public proveedor p = new proveedor();

    public ConsultarAnticipo() {
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

        MontoDStxt = new javax.swing.JTextField();
        FechaL = new javax.swing.JLabel();
        InfoProveedorL = new javax.swing.JLabel();
        Fechatxt = new javax.swing.JTextField();
        IconProveedor = new javax.swing.JLabel();
        AprobacionL = new javax.swing.JLabel();
        CodigoL = new javax.swing.JLabel();
        Aprobaciontxt = new javax.swing.JTextField();
        Codigotxt = new javax.swing.JTextField();
        ObservacionesL = new javax.swing.JLabel();
        IDL = new javax.swing.JLabel();
        IDCB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Observaciontxt = new javax.swing.JTextArea();
        IDtxt = new javax.swing.JTextField();
        BuscarBT = new javax.swing.JButton();
        RazonSocialL = new javax.swing.JLabel();
        RazonSocialtxt = new javax.swing.JTextField();
        InfoAnticipo = new javax.swing.JLabel();
        IconAnticipo = new javax.swing.JLabel();
        NroAnticipoL = new javax.swing.JLabel();
        NroAnticipotxt = new javax.swing.JTextField();
        MotivoAnticipoL = new javax.swing.JLabel();
        MontoBSL = new javax.swing.JLabel();
        MontoBStxt = new javax.swing.JTextField();
        MontoDSL = new javax.swing.JLabel();
        CancelarBT = new javax.swing.JButton();
        MotivoAnticipoCB = new javax.swing.JComboBox<>();
        AprobacionL1 = new javax.swing.JLabel();
        DescontarCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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
        Codigotxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        ObservacionesL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ObservacionesL.setText("Observaciones");

        IDL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IDL.setText("Identificación (*)");

        IDCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "J", "P", "G" }));
        IDCB.setEnabled(false);
        IDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCBActionPerformed(evt);
            }
        });

        Observaciontxt.setEditable(false);
        Observaciontxt.setColumns(20);
        Observaciontxt.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        Observaciontxt.setRows(5);
        jScrollPane1.setViewportView(Observaciontxt);

        IDtxt.setEditable(false);
        IDtxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        BuscarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BuscarBT.setText("BUSCAR");
        BuscarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBTActionPerformed(evt);
            }
        });

        RazonSocialL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RazonSocialL.setText("Razón Social (*)");

        RazonSocialtxt.setEditable(false);
        RazonSocialtxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        InfoAnticipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InfoAnticipo.setText("Información del Anticipo");

        IconAnticipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aa.png"))); // NOI18N

        NroAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NroAnticipoL.setText("Anticipo Nº");

        NroAnticipotxt.setEditable(false);

        MotivoAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MotivoAnticipoL.setText("Motivo del Anticipo");

        MontoBSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoBSL.setText("Monto en BS");

        MontoBStxt.setEditable(false);
        MontoBStxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        MontoDSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoDSL.setText("Monto en $");

        CancelarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CancelarBT.setText("CANCELAR");

        MotivoAnticipoCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        MotivoAnticipoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materia Prima", "Adicional", "Peaje", "Otros" }));
        MotivoAnticipoCB.setEnabled(false);
        MotivoAnticipoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotivoAnticipoCBActionPerformed(evt);
            }
        });

        AprobacionL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AprobacionL1.setText("Descontar en ODP");

        DescontarCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        DescontarCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        DescontarCB.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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
                            .addComponent(InfoAnticipo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IconAnticipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NroAnticipoL)
                                        .addGap(70, 70, 70)
                                        .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MotivoAnticipoL)
                                            .addComponent(MontoBSL)
                                            .addComponent(AprobacionL)
                                            .addComponent(AprobacionL1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(MontoBStxt, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                    .addComponent(MotivoAnticipoCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(MontoDSL)
                                                    .addComponent(FechaL))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Fechatxt)
                                                    .addComponent(MontoDStxt)))
                                            .addComponent(Aprobaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(ObservacionesL))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BuscarBT)
                        .addGap(18, 18, 18)
                        .addComponent(CancelarBT)))
                .addContainerGap())
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
                .addComponent(InfoAnticipo)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MontoBSL)
                                .addComponent(MontoBStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MontoDSL))
                            .addComponent(MontoDStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AprobacionL)
                            .addComponent(Aprobaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AprobacionL1)
                            .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ObservacionesL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarBT)
                    .addComponent(CancelarBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCBActionPerformed

    }//GEN-LAST:event_IDCBActionPerformed

    private void BuscarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBTActionPerformed
        Object[] dataAnticipo = new Object[10];
        Object[] dataProveedor = new Object[10];
        //LA BUSQUEDA POR AHORA SERA UNICAMENTE GRACIAS AL NUMERO O CODIGO DE ANTICIPO

        //CUANDO SE BUSQUE EL ANTICIPO, HAY QUE IMPRIMIR LOS DATOS DEL ANTICIPO
        //Y ADEMAS, HAY QUE HACER UNA BUSQUEDA DEL PROVEEDOR
        //SEGUN LA CLAVE FORANEA DEL ANTICIPO
        //Y SE COLOCAN LOS 3 DATOS PRINCIPALES DEL PROVEEDOR
        //REALIZANDO BUSQUEDA POR CODIGO
        int num_anticipo = Integer.parseInt(NroAnticipotxt.getText());
        if (!NroAnticipotxt.getText().isEmpty()) {
            boolean encontrado = false;
            try {
                encontrado = a.buscarAnticipo(num_anticipo);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (encontrado) {
                //SE DEBE AGARRAR LOS DATOS DEL PROVEEDOR
                try{
                    dataAnticipo = a.conseguirDatos(num_anticipo);
                    if (p.buscarCodigo(Integer.parseInt(dataAnticipo[8].toString()))) {
                        dataProveedor = p.conseguirDatos(Integer.parseInt(dataAnticipo[8].toString()), "", "", 1);
                        escribirDatosProveedor(dataProveedor);
                    }    
                    //UNA VEZ COLOCADOS TODOS LOS DATOS DEL PROVEEDOR, SE LLAMA A LA FUNCION DE ESCRIBIR LOS DATOS DEL ANTICIPO
                    escribirDatosAnticipo(dataAnticipo);
                }catch(SQLException ex){
                    Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } else if (!encontrado){
                JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN ANTICIPO CON ESTE CODIGO", "BUSQUEDA DE ANTICIPO", JOptionPane.ERROR);
            }
        }
    }//GEN-LAST:event_BuscarBTActionPerformed

    //FUNCION PARA ESCRIBIR TODOS LOS DATOS DEL ANTICIPO EN LA INTERFAZ
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
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //HACIENDO QUE EL CAMPO DE NUM_ANTICIPO SEA DISPONIBLE DE EDITAR
        NroAnticipotxt.setEditable(true);
        NroAnticipotxt.setBackground(Color.BLACK);
        NroAnticipotxt.setForeground(Color.WHITE);
    }//GEN-LAST:event_formWindowOpened

    private void MotivoAnticipoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotivoAnticipoCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MotivoAnticipoCBActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarAnticipo().setVisible(true);
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
    private javax.swing.JLabel FechaL;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JComboBox<String> IDCB;
    private javax.swing.JLabel IDL;
    private javax.swing.JTextField IDtxt;
    private javax.swing.JLabel IconAnticipo;
    private javax.swing.JLabel IconProveedor;
    private javax.swing.JLabel InfoAnticipo;
    private javax.swing.JLabel InfoProveedorL;
    private javax.swing.JLabel MontoBSL;
    private javax.swing.JTextField MontoBStxt;
    private javax.swing.JLabel MontoDSL;
    private javax.swing.JTextField MontoDStxt;
    private javax.swing.JComboBox<String> MotivoAnticipoCB;
    private javax.swing.JLabel MotivoAnticipoL;
    private javax.swing.JLabel NroAnticipoL;
    private javax.swing.JTextField NroAnticipotxt;
    private javax.swing.JLabel ObservacionesL;
    private javax.swing.JTextArea Observaciontxt;
    private javax.swing.JLabel RazonSocialL;
    private javax.swing.JTextField RazonSocialtxt;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
