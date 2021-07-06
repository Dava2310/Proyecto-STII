/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.boletos;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.boleto;

/**
 *
 * @author DANIEL
 */
public class BusquedaYModificicacionBoleto extends javax.swing.JFrame {

    /**
     * Creates new form CreacionBoleto
     */
    public String num_boleto_buscado = "";
    public String boletoBueno;
    public boleto boleto = new boleto();
    private Object[][] datos;
    private int fila = -1;
    public BusquedaYModificicacionBoleto() {
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
        MSlb = new javax.swing.JLabel();
        MStxt = new javax.swing.JTextField();
        ImpurezasLB = new javax.swing.JLabel();
        Impurezastxt = new javax.swing.JTextField();
        ObservacionesLB = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ObservacionestTXT = new javax.swing.JTextArea();
        CancelarBT = new javax.swing.JButton();
        GuardarBT = new javax.swing.JButton();
        CantidadTransaccionesLB = new javax.swing.JLabel();
        CantidadTransaccionesTXT = new javax.swing.JTextField();
        CambiosBT = new javax.swing.JToggleButton();
        SeleccionarBT = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        Nombretxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boleto.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Informacion del Boleto");

        NumBoletotxt.setEditable(false);
        NumBoletotxt.setBackground(new java.awt.Color(240, 240, 240));
        NumBoletotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumBoletotxtActionPerformed(evt);
            }
        });

        NumBoletoLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NumBoletoLB.setText("Num. Boleto");

        FechaLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FechaLB.setText("Fecha");

        Fechatxt.setEditable(false);
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

        KgBrutostxt.setEditable(false);

        KgNetosLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        KgNetosLB.setText("Kg. Netos");

        KgNetostxt.setEditable(false);

        MSlb.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MSlb.setText("%MS");

        MStxt.setEditable(false);

        ImpurezasLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ImpurezasLB.setText("Impurezas");

        Impurezastxt.setEditable(false);

        ObservacionesLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ObservacionesLB.setText("Observaciones");

        ObservacionestTXT.setEditable(false);
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

        GuardarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GuardarBT.setText("GUARDAR");
        GuardarBT.setEnabled(false);
        GuardarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarBTActionPerformed(evt);
            }
        });

        CantidadTransaccionesLB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CantidadTransaccionesLB.setText("Cantidad de Transacciones");

        CantidadTransaccionesTXT.setEditable(false);

        CambiosBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CambiosBT.setText("HABILITAR CAMBIOS");
        CambiosBT.setEnabled(false);
        CambiosBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiosBTActionPerformed(evt);
            }
        });

        SeleccionarBT.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SeleccionarBT.setText("SELECCIONAR");
        SeleccionarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarBTActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre ");

        Nombretxt.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(SemanaLB))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Semanatxt)
                                            .addComponent(Nombretxt)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(KgBrutostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(KgNetosLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(KgNetostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MSlb)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ImpurezasLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Impurezastxt, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ObservacionesLB)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CantidadTransaccionesLB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CantidadTransaccionesTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GuardarBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CambiosBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeleccionarBT)
                        .addGap(18, 18, 18)
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
                            .addComponent(NumBoletoLB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(Nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(MSlb)
                            .addComponent(MStxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImpurezasLB)
                            .addComponent(Impurezastxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CantidadTransaccionesLB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CantidadTransaccionesTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(ObservacionesLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelarBT)
                    .addComponent(GuardarBT)
                    .addComponent(CambiosBT)
                    .addComponent(SeleccionarBT))
                .addContainerGap())
        );

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Num Boleto", "Nombre", "Fecha", "Semana", "Kg. Brutos", "Kg. Netos", "Materia S", "Impuresas", "Cantidad transacciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NumBoletotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumBoletotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumBoletotxtActionPerformed
    
    /*
        FUNCION PARA ESCRIBIR LOS DATOS POR PANTALLA DEL BOLETO
        EXCEPTO POR EL NUMERO DE BOLETO
    */

    
    private void GuardarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarBTActionPerformed
        if(!NumBoletotxt.getText().isEmpty()){
            if(CambiosBT.isSelected()){
                /*
                    AQUI YA DE SEGURO TENEMOS UNA MODIFICACION SEGURA
                    POR TANTO, RECOGEMOS LOS DATOS NUEVAMENTE DE CADA CAMPO
                */
                String num_boleto = NumBoletotxt.getText();
                String nombre = Nombretxt.getText();
                String fecha = Fechatxt.getText();
                String semana = Semanatxt.getText();
                float KgBrutos = Float.parseFloat(KgBrutostxt.getText());
                float KgNetos = Float.parseFloat(KgNetostxt.getText());
                int MS = Integer.parseInt(MStxt.getText());
                int Impurezas = Integer.parseInt(Impurezastxt.getText());
                String Observaciones = ObservacionestTXT.getText();
                try {
                    //DE AQUI YA TENEMOS TODOS LOS NECESARIOS PARA UN UPDATE DE BOLETO
                    boleto.updateBoleto(num_boleto, fecha, nombre, semana, KgBrutos, KgNetos, MS, Impurezas, Observaciones);
                    JOptionPane.showMessageDialog(null, "SE PUDO REALIZAR LA MODIFICACION DEL BOLETO CON EXITO", "EXITO", JOptionPane.PLAIN_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "NO SE PUDO REALIZAR LA MODIFICACION DEL BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                CambiosBT.setSelected(false);
                reestablecerPagina();
            } else {
                JOptionPane.showMessageDialog(null, "HABILITE LA OPCION DE HACER CAMBIOS PARA PODER GUARDARLOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "INGRESE EL NUMERO DE BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        reestablecerPagina();
    }//GEN-LAST:event_GuardarBTActionPerformed

    private void CancelarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBTActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarBTActionPerformed

    private void CambiosBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiosBTActionPerformed
        if(!CambiosBT.isSelected()){
            /*
                AQUI LO QUE DEBEMOS HACER ES DARLE PASO A PODER MODIFICAR TODOS LOS CAMPOS EXCEPTO EL CODIGO
            */
            GuardarBT.setEnabled(false);
            deshabilitarCampos();
            
        } else if(CambiosBT.isSelected()){ 
            /*
                AQUI LO QUE DEBEMOS HACER ES DARLE PASO A PODER MODIFICAR TODOS LOS CAMPOS EXCEPTO EL CODIGO
            */
            habilitarCampos();
            GuardarBT.setEnabled(true);
        }
    }//GEN-LAST:event_CambiosBTActionPerformed
    
    private void reestablecerPagina(){
        updateTabla();
        Fechatxt.setEditable(false);
        KgBrutostxt.setEditable(false);
        KgNetostxt.setEditable(false);
        MStxt.setEditable(false);
        Impurezastxt.setEditable(false);
        ObservacionestTXT.setEditable(false);
        GuardarBT.setEnabled(false);
        CambiosBT.setEnabled(false);
        CambiosBT.setSelected(false);
        SeleccionarBT.setSelected(false);
    }
    
    public void deshabilitarCampos(){
        KgBrutostxt.setEditable(false);
        KgNetostxt.setEditable(false);
        MStxt.setEditable(false);
        Impurezastxt.setEditable(false);
        ObservacionestTXT.setEditable(false);
        Nombretxt.setEditable(false);
    }
    
    public void habilitarCampos(){
        KgBrutostxt.setEditable(true);
        KgNetostxt.setEditable(true);
        MStxt.setEditable(true);
        Impurezastxt.setEditable(true);
        ObservacionestTXT.setEditable(true);
        Nombretxt.setEditable(true);
    }
    
    private void FechatxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FechatxtFocusLost
        if(CambiosBT.isSelected() && Fechatxt.isEditable()){
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
        }
    }//GEN-LAST:event_FechatxtFocusLost

    private void SeleccionarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarBTActionPerformed
        if(!NumBoletotxt.getText().isEmpty()){
            if(SeleccionarBT.isSelected()){
                Tabla.setVisible(false);
                CambiosBT.setEnabled(true);
            } else {
                Tabla.setVisible(true);
                CambiosBT.setEnabled(false);
                GuardarBT.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN ELEMENTO DE LA TABLA", "ERROR", JOptionPane.ERROR_MESSAGE);    
            SeleccionarBT.setSelected(false);
        }
    }//GEN-LAST:event_SeleccionarBTActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        MostrarTodo();
    }//GEN-LAST:event_formWindowOpened

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        fila = Tabla.rowAtPoint(evt.getPoint());
        if(fila > -1 && !SeleccionarBT.isSelected()){
            NumBoletotxt.setText(String.valueOf(Tabla.getValueAt(fila, 0)));
            Nombretxt.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
            Fechatxt.setText(String.valueOf(Tabla.getValueAt(fila, 2)));
            Semanatxt.setText(String.valueOf(Tabla.getValueAt(fila, 3)));
            KgBrutostxt.setText(String.valueOf(Tabla.getValueAt(fila, 4)));
            KgNetostxt.setText(String.valueOf(Tabla.getValueAt(fila, 5)));
            MStxt.setText(String.valueOf(Tabla.getValueAt(fila, 6)));
            Impurezastxt.setText(String.valueOf(Tabla.getValueAt(fila, 7)));
            CantidadTransaccionesTXT.setText(String.valueOf(Tabla.getValueAt(fila, 8)));
            ObservacionestTXT.setText(String.valueOf(Tabla.getValueAt(fila, 9)));
        }
               
    }//GEN-LAST:event_TablaMouseClicked

    private void MostrarTodo(){
        Object[][] dataTabla;
        String[] columname = {"Num Boleto", "Nombre", "Fecha", "Semana", "KgBrutos", "KgNetos", "Materia S", "Impuresas", "Cantidad Transacciones","Observaciones"};
        try {
            dataTabla = boleto.getDatos();
            DefaultTableModel datos = new DefaultTableModel(dataTabla, columname);
            Tabla.setModel(datos);
        } catch (SQLException e) {
            Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void updateTabla(){
        String[] columName = {"Num Boleto, Nombre, Fecha, Semana, Kg. Brutos, Kg. Netos, Materia S, Impuresas, Cantidad Transacciones","Observaciones"};
        try {
            datos = boleto.getDatos();
            DefaultTableModel dato = new DefaultTableModel(datos,columName);
            Tabla.setModel(dato);
        } catch (SQLException e) {
            Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(Level.SEVERE, null, e);

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
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaYModificicacionBoleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaYModificicacionBoleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CambiosBT;
    private javax.swing.JButton CancelarBT;
    private javax.swing.JLabel CantidadTransaccionesLB;
    private javax.swing.JTextField CantidadTransaccionesTXT;
    private javax.swing.JLabel FechaLB;
    private javax.swing.JTextField Fechatxt;
    private javax.swing.JButton GuardarBT;
    private javax.swing.JLabel ImpurezasLB;
    private javax.swing.JTextField Impurezastxt;
    private javax.swing.JLabel KgBrutosLB;
    private javax.swing.JTextField KgBrutostxt;
    private javax.swing.JLabel KgNetosLB;
    private javax.swing.JTextField KgNetostxt;
    private javax.swing.JLabel MSlb;
    private javax.swing.JTextField MStxt;
    private javax.swing.JTextField Nombretxt;
    private javax.swing.JLabel NumBoletoLB;
    private javax.swing.JTextField NumBoletotxt;
    private javax.swing.JLabel ObservacionesLB;
    private javax.swing.JTextArea ObservacionestTXT;
    private javax.swing.JToggleButton SeleccionarBT;
    private javax.swing.JLabel SemanaLB;
    private javax.swing.JTextField Semanatxt;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
