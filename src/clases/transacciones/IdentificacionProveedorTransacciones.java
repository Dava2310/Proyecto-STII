package clases.transacciones;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import logica.ConversionesVerificaciones;
import logica.boleto;
import logica.proveedor;
import logica.transacciones;

public class IdentificacionProveedorTransacciones extends javax.swing.JFrame {

    public TransaccionesCrear TC;
    public proveedor p = new proveedor();
    public transacciones t = new transacciones();
    public ConversionesVerificaciones objetoVerificador = new ConversionesVerificaciones();
    public boleto b = new boleto();
    public int modo = 0;
    public String num_Boleto = "";
    private Border borde_rojo = BorderFactory.createLineBorder(Color.RED, 1);
    private Border borde_default;
    public IdentificacionProveedorTransacciones() {
        initComponents();
        borde_default = NroBoletotxt.getBorder();
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

        IDProveedorL.setBackground(new java.awt.Color(0, 153, 153));
        IDProveedorL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IDProveedorL.setText("<html>Ingrese Identificacion del proveedor<html>");
        IDProveedorL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        IDProveedorL.setOpaque(true);

        IDProveedortxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        IDProveedortxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDProveedortxtKeyTyped(evt);
            }
        });

        tipoIDProveedorCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "J", "P", "G" }));

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

    private void EnterBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterBTActionPerformed
        procedimiento();
    }//GEN-LAST:event_EnterBTActionPerformed
    
    private boolean verificacionCompleta(){
        //PRIMERO OBTENEMOS LOS DATOS DE LA IDENTIFICACION MAS EL BOLETO
        String identificacion = IDProveedortxt.getText();
        String boleto = NroBoletotxt.getText();
        //Y LE QUITAMOS LOS ESPACIOS PARA QUE NO HAYA ERRORES EN LAS VERIFICACIONES
        identificacion = objetoVerificador.quitarEspacios(identificacion);
        boleto = objetoVerificador.quitarEspacios(boleto);
        //DESPUES CREAMOS UNA CONDICION QUE MANTIENE SI EL PASO A LA SIGUIENTE PANTALLA SE PODRA DAR O NO
        boolean condicion = true;
        /*
            AQUI HAY QUE VERIFICAR LOS CAMPOS DE BOLETO E IDENTIFICACION
        */
        //Primero comprobamos si la identificacion está vacía
        if(IDProveedortxt.getText().isEmpty()){
            IDProveedortxt.setBorder(borde_rojo);
            condicion = false;
            JOptionPane.showMessageDialog(null, "INGRESE LA IDENTIFICACION DEL PROVEEDOR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if(!IDProveedortxt.getText().isEmpty()){
            //En caso de no estar vacía, verificamos si tiene el rango que queremos
            if(identificacion.length() < 7){
                condicion = false;
                IDProveedortxt.setBorder(borde_rojo);
                JOptionPane.showMessageDialog(null, "LA IDENTIFICACION DEL PROVEEDOR DEBE ESTAR ENTRE 7 Y 8 DIGITOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if(!(identificacion.length() < 7)){
                //En caso de si estar entre 7 y 8 digitos, hay que ver si todos son digitos numericos.
                if(!p.comprobacionIdentificacion(identificacion)){
                    condicion = false;
                    IDProveedortxt.setBorder(borde_rojo);
                    JOptionPane.showMessageDialog(null, "TODOS LOS DIGITOS DEBEN SER NUMERICOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if(p.comprobacionIdentificacion(identificacion)){
                    //En caso de ser una identificacion valida, hay que ver si es un proveedor activo.
                    String tipoIdentificacion = tipoIDProveedorCB.getSelectedItem().toString();
                    String identificacionCompleta = tipoIdentificacion + identificacion;
                    try {
                        if(!p.buscarProveedorActivo(identificacionCompleta)){
                            condicion = false;
                            IDProveedortxt.setBorder(borde_rojo);
                            JOptionPane.showMessageDialog(null, "LA IDENTIFICACION DEBE CORRESPONDER A UN PROVEEDOR REGISTRADO Y ACTIVO EN EL SISTEMA", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else if(p.buscarProveedorActivo(identificacionCompleta)){
                            IDProveedortxt.setBorder(borde_default);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        //Ahora las comprobaciones para el numero de boleto.
        if(NroBoletotxt.getText().isEmpty()){
            NroBoletotxt.setBorder(borde_rojo);
            condicion = false;
            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if(!NroBoletotxt.getText().isEmpty()){
            try {
                //Para el boleto, lo unico que necesitamos es ademas de que no este vacio y haberle quitado los espacios
                //Es comprobar que el numero de boleto sea uno existente
                if(!b.buscarBoleto(boleto)){
                    NroBoletotxt.setBorder(borde_rojo);
                    JOptionPane.showMessageDialog(null, "EL BOLETO INGRESADO NO SE ENCUENTRA EN EL SISTEMA", "ERROR", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                } else if(b.buscarBoleto(boleto)){
                    /*
                        AQUI VERIFICAMOS Y GUARDAMOS CUANTAS TRANSACCIONES TIENE ESTE BOLETO
                        PARA HACER ESO, DEBERIAMOS ENTONCES BUSCAR SI PRIMERO SE ENCUENTRA REGISTRADO EL BOLETO
                        SI SE ENCUENTRA, ENTONCES DEFINIREMOS UN BOOLEAN QUE SERA TRUE SI AUN TIENE CUPO
                        DE LO CONTRARIO SERA FALSE
                    */
                    int cantidad_transacciones_boleto = b.cantidadTransacciones_Boleto(boleto);
                    if(cantidad_transacciones_boleto == 4){
                        condicion = false;
                        NroBoletotxt.setBorder(borde_rojo);
                        JOptionPane.showMessageDialog(null, "EL BOLETO INGRESADO TIENE LAS 4 TRANSACCIONES CUBIERTAS", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else if(cantidad_transacciones_boleto != 4){
                        NroBoletotxt.setBorder(borde_default);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        return condicion;
    }
            
    
    public void procedimiento(){
        if (verificacionCompleta()) {
            //DESPUES DE HABER COMPROBADO QUE NINGUNO DE LOS CAMPOS ESTAN VACIOS, PROCEDEMOS A HACER DISTINTAS VALIDACIONES
            //1- Validar que el num de boleto exista en el sistema.
            //2- Validad que el proveedor si se encuentra en el sistema
            String cadena = NroBoletotxt.getText();
            //PROCESO PARA QUITAR LOS ESPACIOS EN BLANCO
            String boletoBueno = objetoVerificador.quitarEspacios(cadena);
            try {
                //Recolectar los datos en una identificacion completa
                int tipoIdentificacion = tipoIDProveedorCB.getSelectedIndex();
                String t_identificacion = tipoIDProveedorCB.getSelectedItem().toString();
                String identificacion_numeros = objetoVerificador.quitarEspacios(IDProveedortxt.getText());
                String identificacion_completa = t_identificacion + identificacion_numeros;

                TC = new TransaccionesCrear();
                //EMPEZAMOS POR DECIRLE A LA SIGUIENTE PANTALLA QUE ESTE BOLETO YA ESTA CREADO
                TC.boletoCreado = true;

                Object[] datosProveedor = new Object[3];
                datosProveedor = p.conseguirDatosPrincipales(0, identificacion_completa, "", 2);
                /*
                    AHORA TENGO QUE LLAMAR A LAS VARIABLES PUBLICAS DE LA PANTALLA DE TRANSACCION
                    PARA DARLE LOS VALORES DE LOS DATOS PRINCIPALES DEL PROVEEDOR ENCONTRADO
                    int indexComboProveedor = 0;
                    String identificacionTXT;
                    String codigoTXT;
                    String razonSocialTXT;
                 */

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
                    LO SIGUIENTE QUE DEBEMOS DARLE A LA PANTALLA SIGUIENTE SON LOS DATOS FIJOS:
                    - Fecha         (String fecha)
                    - Semana        (String semana)
                    - Kg_Brutos     (int Kg_Brutos)
                    - Kg_Netos      (int Kg_Netos)
                    - Materia_Seca  (float MS)
                    - Impurezas     (float Impurezas)

                    PARA ESO ENTONCES RECOGEMOS LOS DATOS DEL BOLETO, Y VAMOS METIENDO CADA DATO DEL VECTOR EN ESAS VARIABLES
                */
                Object[] informacionBoleto = new Object[10];
                informacionBoleto = b.conseguirDatos(boletoBueno);
                TC.fecha = informacionBoleto[2].toString();
                TC.semana = informacionBoleto[3].toString();
                TC.Kg_Brutos = Float.parseFloat(informacionBoleto[4].toString());
                TC.Kg_Netos = Float.parseFloat(informacionBoleto[5].toString());
                TC.MS = Integer.parseInt(informacionBoleto[6].toString());
                TC.Impurezas = Integer.parseInt(informacionBoleto[7].toString());

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
                if (Cuadrilla) {
                    //Asignamos la variable booleana que corresponde a verdadera.
                    TC.Cuadrilla = true;
                }

                if (Materia_Prima) {
                    //Asignamos la variable booleana que corresponde a verdadera.
                    TC.Materia_Prima = true;
                }

                if (Flete) {
                    //Asignamos la variable booleana que corresponde a verdadera.
                    TC.Flete = true;
                }

                if (Peaje) {
                    //Asignamos la variable booleana que corresponde a verdadera.
                    TC.Peaje = true;
                }
                TC.numeroBoleto = boletoBueno;
                TC.setVisible(true);
                this.dispose();
                
            } catch (SQLException ex) {
                Logger.getLogger(IdentificacionProveedorTransacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(modo == 1){
            NroBoletotxt.setEditable(false);
            NroBoletotxt.setText(num_Boleto);
        }
    }//GEN-LAST:event_formWindowOpened

    private void IDProveedortxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDProveedortxtKeyTyped
        //AQUI LA IDEA ES QUE NO SE PUEDAN INGRESAR MAS DE 8 DIGITOS
        if(IDProveedortxt.getText().length() >= 8){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_IDProveedortxtKeyTyped

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
