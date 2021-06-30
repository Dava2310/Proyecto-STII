/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.anticipos;

import clases.proveedores.IdentificacionProveedor;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Tasa_USD;
import logica.anticipos;
import logica.proveedor;

/**
 *
 * @author DANIEL
 */
public class CrearAnticipo extends javax.swing.JFrame {

    private double monto = 0;
    private int cod_tasa = 0;
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
    private Tasa_USD tasas = new Tasa_USD();
    private Object[][] dataTasas;
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
        Moneda_CB = new javax.swing.JComboBox<>();
        Moneda_LB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Semana_txt = new javax.swing.JTextField();
        Tasa_CB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
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
        MontoBStxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MontoBStxtFocusLost(evt);
            }
        });

        MontoDS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MontoDS.setText("Monto en $");

        MontoDStxt.setEditable(false);
        MontoDStxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MontoDStxtFocusLost(evt);
            }
        });

        FechaL.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaL.setText("Fecha");

        Fechatxt.setEditable(false);
        Fechatxt.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

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

        DescuentoODPCB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DescuentoODPCB.setText("Descontar en ODP");

        DescontarCB.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        DescontarCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"SI", "NO" }));

        Moneda_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS", "$" }));
        Moneda_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Moneda_CBActionPerformed(evt);
            }
        });

        Moneda_LB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Moneda_LB.setText("Moneda a Ingresar");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Semana");

        Semana_txt.setEditable(false);

        Tasa_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIN TASA" }));
        Tasa_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tasa_CBActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Escoje la tasa en $");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CrearBT)
                        .addGap(18, 18, 18)
                        .addComponent(CancelarBT))
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
                                .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RazonSocialL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RazonSocialtxt))))
                    .addComponent(InfoProveedorL)
                    .addComponent(infoAnticipoL)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IconAnticipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Moneda_LB)
                                    .addGap(12, 12, 12)
                                    .addComponent(Moneda_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(MontoBSL)
                                    .addGap(18, 18, 18)
                                    .addComponent(MontoBStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MontoDS)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(MontoDStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(MotivoAnticipoL)
                                        .addComponent(AprobacionL)
                                        .addComponent(DescuentoODPCB))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(DescontarCB, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(Aprobaciontxt)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(MotivoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(FechaL)
                                                .addComponent(jLabel1))
                                            .addGap(14, 14, 14)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Semana_txt)
                                                .addComponent(Fechatxt))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NroAnticipo)
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tasa_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))))
                    .addComponent(ObservacionL))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InfoProveedorL)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(RazonSocialtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoAnticipoL)
                    .addComponent(Tasa_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IconAnticipo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NroAnticipo)
                            .addComponent(NroAnticipotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(Semana_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MotivoAnticipoL)
                                .addComponent(MotivoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FechaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MontoBStxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(MontoDStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MontoDS)
                                .addComponent(MontoBSL)
                                .addComponent(Moneda_LB)
                                .addComponent(Moneda_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearBT)
                    .addComponent(CancelarBT))
                .addContainerGap())
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
            Object[] data = p.conseguirDatos(0, identificacion_completa, "", 2);
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
            
            Date anio = new Date();
            SimpleDateFormat formatoAnio = new SimpleDateFormat("YYYY");
            String anioActual = formatoAnio.format(anio);
            
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(fecha);
            Semana_txt.setText((calendar.get(Calendar.WEEK_OF_YEAR) - 1) + "-" + anioActual);
            
            
            int codigo = a.codigoSiguiente();
            NroAnticipotxt.setText(String.valueOf(codigo));
        }catch(SQLException ex){
            Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ActualizarTasas();
        }
        
        
    }//GEN-LAST:event_formWindowOpened

    private void ActualizarTasas(){
        int registros = tasas.obtenerRegistros();
        try {
            dataTasas = tasas.getDatos();
            for(int i = 0; i <= registros - 1; i++){
                //26-2021 - 3.000.000
                String item = dataTasas[i][1].toString(); // LA SEMANA
                cod_tasa = Integer.parseInt(dataTasas[i][0].toString());
                item+= "   -   " + String.valueOf(Double.parseDouble(dataTasas[i][2].toString())); // EL MONTO
                Tasa_CB.addItem(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearAnticipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                && !(MontoBStxt.getText().isEmpty()) && !(MontoDStxt.getText().isEmpty()) && Tasa_CB.getSelectedIndex() != 0) {
            //RECOGIDA DE DATOS:
            String motivo_anticipo = MotivoCB.getSelectedItem().toString();
            String fecha = Fechatxt.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date data;
                    String dateFinal = "";
                    try {
                        data = sdf.parse(fecha);
                        dateFinal = output.format(data);
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearAnticipo.class.getName()).log(Level.SEVERE, null, ex);
                    }
            double monto_bs = Double.parseDouble(MontoBStxt.getText());
            double monto_ds = Double.parseDouble(MontoDStxt.getText());
            String aprobacion = Aprobaciontxt.getText();
            String descontarODP = DescontarCB.getSelectedItem().toString();
            String observaciones = Observaciontxt.getText();
            int codigo_proveedor = Integer.parseInt(Codigotxt.getText());
            String semana = Semana_txt.getText();
            int cod_tasa = this.cod_tasa;
            //LLAMADA DE LA FUNCION CREAR ANTICIPO:
            try{
                a.NuevoAnticipo(motivo_anticipo, dateFinal, semana, monto_bs, monto_ds, aprobacion, observaciones, descontarODP, codigo_proveedor, cod_tasa);
                creado = true;
                String[] botones_confirmacionHabilitar = {"ACEPTAR", "CANCELAR"};
                int index = JOptionPane.showOptionDialog(null, "¿DESEA CREAR UN NUEVO ANTICIPO?", "CONFIRMACION DE CAMBIO DE ESTADO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones_confirmacionHabilitar, botones_confirmacionHabilitar[0]);
                if(index == 0){
                    IP = new IdentificacionProveedor();
                    IP.modo = 2;
                    IP.setVisible(true);
                    this.dispose();
                } else {
                    this.dispose();
                }
            }catch(SQLException ex){
                Logger.getLogger(ConsultarAnticipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE POR FAVOR LOS DATOS NECESARIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_CrearBTActionPerformed

    private void Moneda_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Moneda_CBActionPerformed
        /*
            AQUI LO QUE TENGO QUE HACER ES DEPENDIENDO DE DONDE SE ENCUENTRE
            DEJO ESCRIBIR EN ESA MONEDA
            Y LA PASO POR CONVERSION A LA CONTRARIA
        */
        if(Moneda_CB.getSelectedItem().toString().equals("BS")){
            MontoBStxt.setEditable(true);
            MontoDStxt.setEditable(false);
            MontoBStxt.setText("");
            MontoDStxt.setText("");
        } else {
            MontoBStxt.setEditable(false);
            MontoDStxt.setEditable(true);
            MontoBStxt.setText("");
            MontoDStxt.setText("");
        }
    }//GEN-LAST:event_Moneda_CBActionPerformed

    private void MontoBStxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MontoBStxtFocusLost
        /*
            DESPUES DE QUE DEJAN DE ESCRIBIR EN EL MONTO TXT
            TENGO QUE DIVIDIRLO POR LA TASA
            E IMPRIMIRLO EN EL MONTODSTXT
        */
        if(MontoBStxt.isEditable() && !Tasa_CB.getSelectedItem().toString().equals("SIN TASA")){
            double Monto_BS = Double.parseDouble(MontoBStxt.getText());
            double monto_total = Monto_BS / monto;
            monto_total = (double) Math.round(monto_total * 100d) / 100;
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(10);
            MontoDStxt.setText(String.valueOf(df.format(monto_total)));
        } else if(Tasa_CB.getSelectedItem().toString().equals("SIN TASA")){
            JOptionPane.showMessageDialog(null, "PARA QUE LOS MONTOS SE ACTUALICEN, ESCOJA UNA TASA", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_MontoBStxtFocusLost

    private void Tasa_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tasa_CBActionPerformed
        if(!Tasa_CB.getSelectedItem().toString().equals("SIN TASA")){
            int index = Tasa_CB.getSelectedIndex() - 1;
            monto = Double.parseDouble(dataTasas[index][3].toString());
            monto = (double) Math.round(monto * 100d) / 100;
            cod_tasa = Integer.parseInt(dataTasas[index][0].toString());
        }
        
    }//GEN-LAST:event_Tasa_CBActionPerformed

    private void MontoDStxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MontoDStxtFocusLost
        /*
            DESPUES DE QUE DEJAN DE ESCRIBIR EN EL MONTO TXT
            TENGO QUE MULTIPLICARLO POR LA TASA
            E IMPRIMIRLO EN EL MONTOBSTXT
        */
        if(MontoDStxt.isEditable() && !Tasa_CB.getSelectedItem().toString().equals("SIN TASA")){
            double Monto_DS = Double.parseDouble(MontoDStxt.getText());
            double monto_total = Monto_DS * monto;
            monto_total = (double) Math.round(monto_total * 100d) / 100;
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(10);
            MontoBStxt.setText(String.valueOf(df.format(monto_total)));
        } else if(Tasa_CB.getSelectedItem().toString().equals("SIN TASA")){
            JOptionPane.showMessageDialog(null, "PARA QUE LOS MONTOS SE ACTUALICEN, ESCOJA UNA TASA", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_MontoDStxtFocusLost
    
    //SE CREA UNA FUNCION QUE PERMITA OBTENER LA FECHA ACTUAL DEL SISTEMA
    private static String fechaActual(){
        //SE CREA UN OBJETO TIPO DATE
        Date fecha = new Date();
        //SE HACE USO DE LA CLASE SIMPLEDATEFORMAT QUE PERMITE DARLE FORMATO QUE QUERAMOS A LA FECHA
        //ADEMAS PERMITE CONVERTIR DE DATE A STRING
        SimpleDateFormat formatoFecha=new SimpleDateFormat("MM/DD/YYYY");
        String nuevaFecha = formatoFecha.format(fecha);
        return nuevaFecha;
    
    }
    private void cerrar(){
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
    private void confirmarSalida(){
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
    private javax.swing.JComboBox<String> Moneda_CB;
    private javax.swing.JLabel Moneda_LB;
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
    private javax.swing.JTextField Semana_txt;
    private javax.swing.JComboBox<String> Tasa_CB;
    private javax.swing.JLabel infoAnticipoL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
