/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author usuario
 */
public class TransaccionesCrear extends javax.swing.JFrame {

    /**
     * Creates new form TransaccionesCrear
     */
    public TransaccionesCrear() {
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
        CodL = new javax.swing.JLabel();
        CODtxt = new javax.swing.JTextField();
        IDL = new javax.swing.JLabel();
        tipoIDProveedorCB = new javax.swing.JComboBox<>();
        IDtxt = new javax.swing.JTextField();
        RazonSocialL = new javax.swing.JLabel();
        RazonSocialtxt = new javax.swing.JTextField();
        InfoBoletoL = new javax.swing.JLabel();
        NroBoletoL = new javax.swing.JLabel();
        NroBoletotxt = new javax.swing.JTextField();
        SemanaL = new javax.swing.JLabel();
        Fechatxt = new javax.swing.JTextField();
        FechaL1 = new javax.swing.JLabel();
        Semanatxt = new javax.swing.JTextField();
        KGBrutosL = new javax.swing.JLabel();
        KGbrutostxt = new javax.swing.JTextField();
        KGNetosL = new javax.swing.JLabel();
        MSL = new javax.swing.JLabel();
        ImpurezasL = new javax.swing.JLabel();
        KGNetostxt = new javax.swing.JTextField();
        MStxt = new javax.swing.JTextField();
        KGbrutostxt3 = new javax.swing.JTextField();
        TipoTransaccion = new javax.swing.JLabel();
        MPCB = new javax.swing.JCheckBox();
        CuadrillaCB = new javax.swing.JCheckBox();
        FleteCB = new javax.swing.JCheckBox();
        PeajeCB = new javax.swing.JCheckBox();
        InfoAdicionalL = new javax.swing.JLabel();
        DTrabajadosl = new javax.swing.JLabel();
        DtrabajadosCB = new javax.swing.JComboBox<>();
        HaUbicacionL = new javax.swing.JLabel();
        HAubicacionCB = new javax.swing.JComboBox<>();
        USDdiaL = new javax.swing.JLabel();
        USDdiaCB = new javax.swing.JComboBox<>();
        USDHAL = new javax.swing.JLabel();
        USDHACB = new javax.swing.JComboBox<>();
        USDdiaL1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Informacion del Proveedor");

        CodL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CodL.setText("Codigo(*)");

        CODtxt.setEditable(false);
        CODtxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        IDL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IDL.setText("Identificacion(*)");

        tipoIDProveedorCB.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tipoIDProveedorCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "J", "P", "G" }));
        tipoIDProveedorCB.setEnabled(false);
        tipoIDProveedorCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoIDProveedorCBActionPerformed(evt);
            }
        });

        IDtxt.setEditable(false);
        IDtxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        RazonSocialL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RazonSocialL.setText("Razón Social (*)");

        RazonSocialtxt.setEditable(false);
        RazonSocialtxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        InfoBoletoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InfoBoletoL.setText("Informacion Boleto");

        NroBoletoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NroBoletoL.setText("Boleto Nº");

        NroBoletotxt.setEditable(false);
        NroBoletotxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        SemanaL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SemanaL.setText("Semana");

        Fechatxt.setEditable(false);
        Fechatxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        FechaL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaL1.setText("Fecha");

        Semanatxt.setEditable(false);
        Semanatxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        KGBrutosL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KGBrutosL.setText("Kg.Brutos");

        KGbrutostxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        KGNetosL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KGNetosL.setText("Kg.Netos");

        MSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MSL.setText("%MS");

        ImpurezasL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ImpurezasL.setText("Impurezas");

        KGNetostxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        MStxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        KGbrutostxt3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        TipoTransaccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TipoTransaccion.setText("TipoTransaccion");

        MPCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MPCB.setText("MP");

        CuadrillaCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CuadrillaCB.setText("Cuadrilla");

        FleteCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FleteCB.setText("Flete");

        PeajeCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PeajeCB.setText("Peaje");
        PeajeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeajeCBActionPerformed(evt);
            }
        });

        InfoAdicionalL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InfoAdicionalL.setText("Informacion Adicional");

        DTrabajadosl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DTrabajadosl.setText("Dias Trabajados");

        DtrabajadosCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "13", "14", "15", "16", "17", "18", "19", "20" }));

        HaUbicacionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        HaUbicacionL.setText("Ha. ubicacion");

        HAubicacionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "13", "14", "15", "16", "17", "18", "19", "20" }));

        USDdiaL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        USDdiaL.setText("USD DIA");

        USDdiaCB.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        USDdiaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

        USDHAL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        USDHAL.setText("USD HA");

        USDHACB.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        USDHACB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        USDHACB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USDHACBActionPerformed(evt);
            }
        });

        USDdiaL1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        USDdiaL1.setText("Observaciones");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagen1.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("CREAR");

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("CANCELAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(InfoBoletoL))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DTrabajadosl)
                                    .addComponent(USDdiaL))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(USDdiaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DtrabajadosCB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(HaUbicacionL)
                                        .addGap(18, 18, 18)
                                        .addComponent(HAubicacionCB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(USDHAL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(USDHACB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(CodL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(CODtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(IDL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tipoIDProveedorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(RazonSocialL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(RazonSocialtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))))
                                    .addComponent(InfoAdicionalL)
                                    .addComponent(USDdiaL1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NroBoletoL)
                                            .addComponent(FechaL1)
                                            .addComponent(KGBrutosL))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(KGbrutostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KGNetosL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(KGNetostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(MSL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ImpurezasL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(KGbrutostxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(NroBoletotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(SemanaL)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Semanatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TipoTransaccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MPCB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CuadrillaCB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PeajeCB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(FleteCB)))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodL)
                            .addComponent(CODtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDL)
                            .addComponent(tipoIDProveedorCB)
                            .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RazonSocialL)
                            .addComponent(RazonSocialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(InfoBoletoL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(NroBoletoL))
                            .addComponent(NroBoletotxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FechaL1)
                            .addComponent(Fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SemanaL)
                            .addComponent(Semanatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KGBrutosL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KGbrutostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KGNetosL)
                            .addComponent(KGNetostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MSL)
                            .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImpurezasL)
                            .addComponent(KGbrutostxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TipoTransaccion)
                            .addComponent(MPCB)
                            .addComponent(CuadrillaCB)
                            .addComponent(PeajeCB)
                            .addComponent(FleteCB)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InfoAdicionalL)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DTrabajadosl)
                    .addComponent(DtrabajadosCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HaUbicacionL)
                    .addComponent(HAubicacionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(USDdiaL)
                    .addComponent(USDdiaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USDHAL)
                    .addComponent(USDHACB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(USDdiaL1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void USDHACBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USDHACBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_USDHACBActionPerformed

    private void tipoIDProveedorCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoIDProveedorCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoIDProveedorCBActionPerformed

    private void PeajeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PeajeCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PeajeCBActionPerformed

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
            java.util.logging.Logger.getLogger(TransaccionesCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaccionesCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaccionesCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaccionesCrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaccionesCrear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CODtxt;
    private javax.swing.JLabel CodL;
    private javax.swing.JCheckBox CuadrillaCB;
    private javax.swing.JLabel DTrabajadosl;
    private javax.swing.JComboBox<String> DtrabajadosCB;
    private javax.swing.JLabel FechaL1;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JCheckBox FleteCB;
    private javax.swing.JComboBox<String> HAubicacionCB;
    private javax.swing.JLabel HaUbicacionL;
    private javax.swing.JLabel IDL;
    private javax.swing.JTextField IDtxt;
    private javax.swing.JLabel ImpurezasL;
    private javax.swing.JLabel InfoAdicionalL;
    private javax.swing.JLabel InfoBoletoL;
    private javax.swing.JLabel KGBrutosL;
    private javax.swing.JLabel KGNetosL;
    private javax.swing.JTextField KGNetostxt;
    private javax.swing.JTextField KGbrutostxt;
    private javax.swing.JTextField KGbrutostxt3;
    private javax.swing.JCheckBox MPCB;
    private javax.swing.JLabel MSL;
    private javax.swing.JTextField MStxt;
    private javax.swing.JLabel NroBoletoL;
    private javax.swing.JTextField NroBoletotxt;
    private javax.swing.JCheckBox PeajeCB;
    private javax.swing.JLabel RazonSocialL;
    private javax.swing.JTextField RazonSocialtxt;
    private javax.swing.JLabel SemanaL;
    private javax.swing.JTextField Semanatxt;
    private javax.swing.JLabel TipoTransaccion;
    private javax.swing.JComboBox<String> USDHACB;
    private javax.swing.JLabel USDHAL;
    private javax.swing.JComboBox<String> USDdiaCB;
    private javax.swing.JLabel USDdiaL;
    private javax.swing.JLabel USDdiaL1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> tipoIDProveedorCB;
    // End of variables declaration//GEN-END:variables
}
