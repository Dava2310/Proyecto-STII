/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.anticipos;

import clases.proveedores.IdentificacionProveedor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.anticipos;
import logica.proveedor;

/**
 *
 * @author DANIEL
 */
public class CrearAnticipo extends javax.swing.JFrame {

    public String identificacion;
    public int tipo_identificacion;
    public String codigo_proveedor;
    public String razon_social;
    public String identificacion_completa;
    public proveedor p = new proveedor();
    public anticipos a = new anticipos();
    public String num_anticipo = "";
    public boolean creado = false;
    public IdentificacionProveedor IP;
    public CrearAnticipo() {
        initComponents();
        cerrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InfoProveedorL = new javax.swing.JLabel();
        IconoProveedor = new javax.swing.JLabel();
        CodigoL = new javax.swing.JLabel();
        Codigotxt = new javax.swing.JTextField();
        IDL = new javax.swing.JLabel();
        IDCB = new javax.swing.JComboBox<>();
        IDtxt = new javax.swing.JTextField();
        RazonSocialL = new javax.swing.JLabel();
        RazonSocialtxt = new javax.swing.JTextField();
        infoAnticipoL = new javax.swing.JLabel();
        IconAnticipo = new javax.swing.JLabel();
        NroAnticipo = new javax.swing.JLabel();
        NroAnticipotxt = new javax.swing.JTextField();
        MotivoAnticipoL = new javax.swing.JLabel();
        MontoBSL = new javax.swing.JLabel();
        MontoBStxt = new javax.swing.JTextField();
        MontoDS = new javax.swing.JLabel();
        MontoDStxt = new javax.swing.JTextField();
        FechaL = new javax.swing.JLabel();
        Fechatxt = new javax.swing.JTextField();
        AprobacionL = new javax.swing.JLabel();
        Aprobaciontxt = new javax.swing.JTextField();
        ObservacionL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Observaciontxt = new javax.swing.JTextArea();
        CrearBT = new javax.swing.JButton();
        CancelarBT = new javax.swing.JButton();
        MotivoCB = new javax.swing.JComboBox<>();
        DescuentoODPCB = new javax.swing.JLabel();
        DescontarCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        InfoProveedorL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InfoProveedorL.setText("Información del Proveedor");

        IconoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagen1.png"))); // NOI18N

        CodigoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CodigoL.setText("Código (*)");

        Codigotxt.setEditable(false);
        Codigotxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        IDL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IDL.setText("Identificación (*)");

        IDCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "J", "P", "G" }));
        IDCB.setEnabled(false);
        IDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCBActionPerformed(evt);
            }
        });

        IDtxt.setEditable(false);
        IDtxt.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        RazonSocialL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RazonSocialL.setText("Razón Social (*)");

        RazonSocialtxt.setEditable(false);

        infoAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        infoAnticipoL.setText("Información del Anticipo");

        IconAnticipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aa.png"))); // NOI18N

        NroAnticipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NroAnticipo.setText("Anticipo Nº");

        NroAnticipotxt.setEditable(false);

        MotivoAnticipoL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MotivoAnticipoL.setText("Motivo del Anticipo");

        MontoBSL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoBSL.setText("Monto en BS");

        MontoBStxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        MontoDS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoDS.setText("Monto en $");

        FechaL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaL.setText("Fecha");

        Fechatxt.setEditable(false);
        Fechatxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        Fechatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechatxtActionPerformed(evt);
            }
        });

        AprobacionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AprobacionL.setText("Aprobado por");

        ObservacionL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ObservacionL.setText("Observaciones");

        Observaciontxt.setColumns(20);
        Observaciontxt.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        Observaciontxt.setRows(5);
        jScrollPane1.setViewportView(Observaciontxt);

        CrearBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CrearBT.setText("Crear");
        CrearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearBTActionPerformed(evt);
            }
        });

        CancelarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CancelarBT.setText("CANCELAR");
        CancelarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBTActionPerformed(evt);
            }
        });

        MotivoCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        MotivoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materia Prima", "Adicional", "Peaje", "Otros" }));
        MotivoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotivoCBActionPerformed(evt);
            }
        });

        DescuentoODPCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DescuentoODPCB.setText("Descontar en ODP");

        DescontarCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        DescontarCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"SI", "NO" }));

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
                                .addComponent(IconoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NroAnticipo)
                                        .addGap(70, 70, 70)
                                        .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MotivoAnticipoL)
                                            .addComponent(MontoBSL)
                                            .addComponent(AprobacionL)
                                            .addComponent(DescuentoODPCB))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(MontoBStxt, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                    .addComponent(MotivoCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(MontoDS)
                                                    .addComponent(FechaL))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Fechatxt)
                                                    .addComponent(MontoDStxt)))
                                            .addComponent(Aprobaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(ObservacionL))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CrearBT)
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
                        .addComponent(IconoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(NroAnticipo)
                            .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MotivoAnticipoL)
                                .addComponent(FechaL)
                                .addComponent(MotivoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MontoBSL)
                                    .addComponent(MontoDS))
                                .addComponent(MontoDStxt, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addComponent(MontoBStxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AprobacionL)
                            .addComponent(Aprobaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DescuentoODPCB)
                            .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ObservacionL)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearBT)
                    .addComponent(CancelarBT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDCBActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //DEBEMOS COLOCAR LAS SIGUIENTES COSAS AL ABRIR LA VENTANA:
        //LA IDENTIFICACION
        //TIPO IDENTIFICACION
        //CODIGO - RAZON SOCIAL (LO PODEMOS CONSEGUIR LLAMADO A LA FUNCION DE CONSEGUIR DATOS Y EXTRAYENDO UNICAMENTE ESOS DOS VALORES)
        //=============================================================================================================================
        IDtxt.setText(identificacion);
        IDCB.setSelectedIndex(tipo_identificacion);
        try{
            Object[] data = p.conseguirDatos("", identificacion_completa, "", 2);
            this.codigo_proveedor = data[0].toString();
            Codigotxt.setText(codigo_proveedor);
            String razon_social = data[2].toString();
            RazonSocialtxt.setText(razon_social);
            //SE CREA UN OBJETO TIPO DATE
            Date fecha = new Date();
            //SE HACE USO DE LA CLASE SIMPLEDATEFORMAT QUE PERMITE DARLE FORMATO QUE QUERAMOS A LA FECHA
            //ADEMAS PERMITE CONVERTIR DE DATE A STRING
            SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
            String nuevaFecha = formatoFecha.format(fecha);
            Fechatxt.setText(nuevaFecha);
        }catch(SQLException ex){
            Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_formWindowOpened

    String[] botones = {"ACEPTAR","CANCELAR"};
    private void CancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTActionPerformed
        if(creado){
            int index = JOptionPane.showOptionDialog(null, "¿DESEA CREAR OTRO ANTICIPO?","CONFIRMACION", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            if(index == 0){
                IP = new IdentificacionProveedor();
                IP.modo = 2;
                IP.setVisible(true);
                this.dispose();
            } else{
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_CancelarBTActionPerformed

    //CUANDO SE ABRIO LA VENTANA, YA SABEMOS QUE LA IDENTIFICACION DEL PROVEEDOR ESTA EN PANTALLA
    //SIMPLEMENTE, RECOGEMOS TODOS LOS DATOS DE LA INTERFAZ Y CREAMOS EL ANTICIPO
    //DESPUES DE ESO, DESHABILITAMOS EL BOTON DE CREAR
    //COLOCAMOS EL CODIGO DEL ANTICIPO CREADO EN EL TEXTFIELD CORRESPONDIENTE
    //MANDAMOS UN MENSAJE POR PANTALLA AVISANDO PARA QUE LO ANOTE
    //Y PODEMOS CAMBIAR EL TEXTO DEL BOTON DE CANCELAR POR CERRAR
    private void CrearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearBTActionPerformed
        //HAY QUE HACER UNA VALIDACION DE QUE SE INGRESEN LOS DATOS NECESARIOS
        //MOTIVO DEL ANTICIPO, FECHA, MONTOBS, MONTODS
        if (!(MotivoCB.getSelectedItem().toString().isEmpty()) && !(Fechatxt.getText().isEmpty())
                && !(MontoBStxt.getText().isEmpty()) && !(MontoDStxt.getText().isEmpty())) {
            //RECOGIDA DE DATOS:
            String motivo_anticipo = MotivoCB.getSelectedItem().toString();
            String fecha = Fechatxt.getText();
            String monto_bs = MontoBStxt.getText();
            String monto_ds = MontoDStxt.getText();
            String aprobacion = Aprobaciontxt.getText();
            String descontarODP = DescontarCB.getSelectedItem().toString();
            String observaciones = Observaciontxt.getText();
            String codigo_proveedor = Codigotxt.getText();
            //LLAMADA DE LA FUNCION CREAR ANTICIPO:
            try{
                a.NuevoAnticipo(motivo_anticipo, fecha, monto_bs, monto_ds, aprobacion, observaciones, descontarODP, codigo_proveedor, "SI");
                creado = true;
                //DEBEMOS MANDAR UN MENSAJE DE CONFIRMACION-------------

                //DESHABILITAR EL BOTON DE CREACION:
                CrearBT.setEnabled(false);
                //DESHABILITAR CADA CAMPO DE LA INTERFAZ
                MontoBStxt.setEnabled(false);
                MontoDStxt.setEnabled(false);
                Aprobaciontxt.setEnabled(false);
                Observaciontxt.setEnabled(false);
                MotivoCB.setEnabled(false);

                //COLOCAMOS EL CODIGO DEL ANTICIPO CREADO EN EL TXT
                String num_anticipo = a.codigo_RecienCreado();
                //YA PODEMOS PASAR EL ESTADO DE RECIEN CREADO DE SI A NO EN EL ANTICIPO
                NroAnticipotxt.setText(num_anticipo);
                a.updateEstado(num_anticipo);
            
                //AQUI HAY QUE DEJAR UN MENSAJE DICIENDO QUE REVISE EL NRO DEL ANTICIPO QUE ESTA, COLOCADO EN EL TEXTFIELD
                JOptionPane.showMessageDialog(null, "LA CREACION DE SU ANTICIPO HA SIDO EXITOSA", "CONFIRMACION", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "VERIFIQUE EL NUMERO DEL ANTICIPO GENERADO POR EL SISTEMA ANTES DE CERRAR", "AVISO", JOptionPane.PLAIN_MESSAGE);
                //CAMBIANDO EL TEXTO DEL BOTON DE CANCELAR POR CERRAR
                CancelarBT.setText("CERRAR");
            }catch(SQLException ex){
                Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE POR FAVOR LOS DATOS NECESARIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_CrearBTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void FechatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechatxtActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_FechatxtActionPerformed

    private void MotivoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotivoCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MotivoCBActionPerformed
    
    //SE CREA UNA FUNCION QUE PERMITA OBTENER LA FECHA ACTUAL DEL SISTEMA
    public static String fechaActual(){
        //SE CREA UN OBJETO TIPO DATE
        Date fecha = new Date();
        //SE HACE USO DE LA CLASE SIMPLEDATEFORMAT QUE PERMITE DARLE FORMATO QUE QUERAMOS A LA FECHA
        //ADEMAS PERMITE CONVERTIR DE DATE A STRING
        SimpleDateFormat formatoFecha=new SimpleDateFormat("MM/DD/YYYY");
        String nuevaFecha = formatoFecha.format(fecha);
        return nuevaFecha;
    
    }
    public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e){
                   confirmarSalida();
                }
            });
            this.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //CONFIRMAR SALIDA
    public void confirmarSalida(){
        int index = JOptionPane.showConfirmDialog(this, "ESTA SEGURO DE CERRAR LA VENTANA?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
        if(index==JOptionPane.YES_OPTION){
            this.dispose();
        }
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
            java.util.logging.Logger.getLogger(CrearAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearAnticipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearAnticipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AprobacionL;
    private javax.swing.JTextField Aprobaciontxt;
    private javax.swing.JButton CancelarBT;
    private javax.swing.JLabel CodigoL;
    private javax.swing.JTextField Codigotxt;
    private javax.swing.JButton CrearBT;
    private javax.swing.JComboBox<String> DescontarCB;
    private javax.swing.JLabel DescuentoODPCB;
    private javax.swing.JLabel FechaL;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JComboBox<String> IDCB;
    private javax.swing.JLabel IDL;
    private javax.swing.JTextField IDtxt;
    private javax.swing.JLabel IconAnticipo;
    private javax.swing.JLabel IconoProveedor;
    private javax.swing.JLabel InfoProveedorL;
    private javax.swing.JLabel MontoBSL;
    private javax.swing.JTextField MontoBStxt;
    private javax.swing.JLabel MontoDS;
    private javax.swing.JTextField MontoDStxt;
    private javax.swing.JLabel MotivoAnticipoL;
    private javax.swing.JComboBox<String> MotivoCB;
    private javax.swing.JLabel NroAnticipo;
    private javax.swing.JTextField NroAnticipotxt;
    private javax.swing.JLabel ObservacionL;
    private javax.swing.JTextArea Observaciontxt;
    private javax.swing.JLabel RazonSocialL;
    private javax.swing.JTextField RazonSocialtxt;
    private javax.swing.JLabel infoAnticipoL;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
