package clases;

import javax.swing.JOptionPane;
import logica.boleto;
import logica.proveedor;
import logica.transacciones;

public class IdentificacionProveedorTransacciones extends javax.swing.JFrame {

    TransaccionesCrear TC;
    proveedor p = new proveedor();
    transacciones t = new transacciones();
    boleto b = new boleto();
    public int modo = 0;
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
            //1- Validar que el num de boleto tenga >= 1 transaccion y < 4 transacciones.
            //2- Validad que el proveedor si se encuentra en el sistema
            String cadena = NroBoletotxt.getText();
            String boletoBueno = "";
            for(int i = 0; i < cadena.length(); i++){
                if(cadena.charAt(i)!=' ' && cadena.charAt(i)!='\n'){
                    boletoBueno = boletoBueno + cadena.charAt(i);
                }
            }
            boolean boletoEncontrado = b.buscarBoleto(boletoBueno);
            //Recolectar los datos en una identificacion completa
            int tipoIdentificacion = tipoIDProveedorCB.getSelectedIndex();
            String t_identificacion = tipoIDProveedorCB.getSelectedItem().toString();
            String identificacion_completa = t_identificacion + IDProveedortxt.getText();
            boolean proveedorActivoEncontrado = p.buscarProveedorActivo(identificacion_completa);
            
            /*
                AQUI VERIFICAMOS Y GUARDAMOS CUANTAS TRANSACCIONES TIENE ESTE BOLETO
                PARA HACER ESO, DEBERIAMOS ENTONCES BUSCAR SI PRIMERO SE ENCUENTRA REGISTRADO EL BOLETO
                SI SE ENCUENTRA, ENTONCES DEFINIREMOS UN BOOLEAN QUE SERA TRUE SI AUN TIENE CUPO
                DE LO CONTRARIO SERA FALSE
            */
            int cantidad_transacciones = 0;
            boolean cupoBoleto = true;
            if(boletoEncontrado){
                cantidad_transacciones = b.cantidadTransacciones_Boleto(boletoBueno);
                if(cantidad_transacciones == 4){
                    cupoBoleto = false;
                }
            }
            /*
                AHORA QUE YA SABEMOS SI TENEMOS UN PROVEEDOR ACTIVO EN EL SISTEMA, 
                Y QUE EL BOLETO ASIGNADO TIENE CUPO
                O EN SU DEFECTO NO ESTA NI SIQUIERA ASIGNADO
                PROCEDEMOS A VERIFICAR LAS CONDICIONES VERDADERAS PARA PROCEDER
             */
            if (proveedorActivoEncontrado == true && cupoBoleto == true) {
                /*
                    AQUI PUEDEN PASAR DOS CASOS
                    1- Un boleto no creado
                    2- Un boleto ya creado pero con menos de 4 transacciones.
                
                    Para los boletos no creados, es tan facil como hacer un procedimiento standard.
                    
                    Para los boletos ya creados, es distinto, debemos ingresar ciertos datos necesarios que no se pueden modificar
                    Mandar una condicion boleeana que sepa que debe hacer con los datos del boleto.
                
                */
                //Primer escenario: Un boleto no creado
                if(!boletoEncontrado){
                    Object[] datosProveedor = new Object[3];
                    datosProveedor = p.conseguirDatosPrincipales("", identificacion_completa, "", 2);
                    /*
                        AHORA TENGO QUE LLAMAR A LAS VARIABLES PUBLICAS DE LA PANTALLA DE TRANSACCION
                        PARA DARLE LOS VALORES DE LOS DATOS PRINCIPALES DEL PROVEEDOR ENCONTRADO
                        int indexComboProveedor = 0;
                        String identificacionTXT;
                        String codigoTXT;
                        String razonSocialTXT;
                    */

                    TC = new TransaccionesCrear();

                    /*
                        ASIGNACION DE DATOS
                    */

                    TC.codigoTXT = datosProveedor[0].toString();
                    TC.razonSocialTXT = datosProveedor[2].toString();
                    /*
                        CON RESPECTO A LA IDENTIFICACION, ESO YA LO TENEMOS
                        GRACIAS A QUE LA BUSQUEDA FUE CON ESTE DATO
                    */
                    TC.indexComboProveedor = tipoIdentificacion;
                    TC.identificacionTXT = IDProveedortxt.getText();

                    /*
                        DE AQUI YA SE HAN ASIGNADO CORRECTAMENTE LOS DATOS DEL PROVEEDOR A LA PANTALLA SIGUIENTE
                        SOLO FALTA SACAR EL NUMERO DE BOLETO DE ESTA PANTALLA Y MANDARLO A LA SIGUIENTE
                    */
                    TC.numeroBoleto = boletoBueno;
                    TC.setVisible(true);
                    this.dispose();
                } else if(boletoEncontrado){ //Segundo escenario: boleto ya creado.
                    TC = new TransaccionesCrear();
                    //EMPEZAMOS POR DECIRLE A LA SIGUIENTE PANTALLA QUE ESTE BOLETO YA ESTA CREADO
                    TC.boletoCreado = true;
                    /*
                        LO SIGUIENTE QUE DEBEMOS DARLE A LA PANTALLA SIGUIENTE SON LOS DATOS FIJOS:
                        - Fecha         (String fecha)
                        - Semana        (String semana)
                        - Kg_Brutos     (int Kg_Brutos)
                        - Kg_Netos      (int Kg_Netos)
                        - Materia_Seca  (float MS)
                        - Impurezas     (float Impurezas)
                    
                        PARA ESO ENTONCES RECOGEMOS LOS DATOS DEL BOLETO, Y VAMOS METIENDO CADA DATO DEL VECTOR EN ESAS VARIABLES
                    */
                    Object[] informacionBoleto = new Object[8];
                    informacionBoleto = b.conseguirDatos(boletoBueno);
                    TC.fecha = informacionBoleto[1].toString();
                    TC.semana = informacionBoleto[2].toString();
                    TC.Kg_Brutos = (int) informacionBoleto[3];
                    TC.Kg_Netos = (int) informacionBoleto[4];
                    TC.MS = (float) informacionBoleto[5];
                    TC.Impurezas = (float) informacionBoleto[6];
                    
                    //VARIABLES BOOLEANAS DE CADA TIPO DE TRANSACCION PARA LA SIGUIENTE SECCION
                    boolean Cuadrilla = false;
                    boolean Materia_Prima = false;
                    boolean Flete = false;
                    boolean Peaje = false;
                    /*
                        DESPUES DE HABERNOS ENCARGADO DE ESTOS DATOS
                        DEBEMOS ENTONCES BLOQUEAR LOS CAMPOS QUE YA SE HAYAN SELECCIONADO DE ESTE BOLETO
                        PARA ESO, PODEMOS IR HACIENDO QUERY POR QUERY DE CADA CAMPO
                        CADA UNO QUE SALGA SI, PUES MANDAMOS A BLOQUEAR ESE CAMPO
                        CADA UNO QUE SALGA QUE NO, NO LE HACEMOS NADA
                    
                        PARA DECIRLE A LA SIGUIENTE PANTALLA QUE ESO ES ASI
                        PUES HAY VARIABLES BOLEANAS PARA CADA CAMPO
                        QUE AL MOMENTO DE QUE LA PANTALLA SE ABRA EN ESE MODO, PUES SABRA CUAL BLOQUEAR
                        - Materia_Prima (boolean Materia_Prima)
                        - Cuadrilla     (boolean Cuadrilla)
                        - Flete         (boolean Flete)
                        - Peaje         (boolean Peaje)
                    */
                    //LLAMEMOS ENTONCES A LAS QUERYS
                    Cuadrilla = t.transaccionCuadrilla(boletoBueno);
                    Materia_Prima = t.transaccionMateria_Prima(boletoBueno);
                    Flete = t.transaccionFlete(boletoBueno);
                    Peaje = t.transaccionPeaje(boletoBueno);
                    //REALIZAMOS LAS VERIFICACIONES POR CADA TRANSACCION PARA BLOQUEAR LO QUE TOCA
                    if(Cuadrilla){
                        //Asignamos la variable booleana que corresponde a verdadera.
                        TC.Cuadrilla = true;
                    }
                    
                    if(Materia_Prima){
                        //Asignamos la variable booleana que corresponde a verdadera.
                        TC.Materia_Prima = true;
                    }
                    
                    if(Flete){
                        //Asignamos la variable booleana que corresponde a verdadera.
                        TC.Flete = true;
                    }
                    
                    if(Peaje){
                        //Asignamos la variable booleana que corresponde a verdadera.
                        TC.Peaje = true;
                    }
                    TC.numeroBoleto = boletoBueno;
                    TC.setVisible(true);
                    this.dispose();
                }
            } else if (cantidad_transacciones == 4) {
                JOptionPane.showMessageDialog(null, "Este boleto ya tienes las 4 transacciones asignadas", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (p.buscarIdentificacion(identificacion_completa) && proveedorActivoEncontrado == false){
                JOptionPane.showMessageDialog(null, "El proveedor asignado no esta activo en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if(!p.buscarIdentificacion(identificacion_completa)){
                JOptionPane.showMessageDialog(null, "El proveedor asignado no se encuentra en el sistema", "ERROR", JOptionPane.ERROR_MESSAGE);
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
