package clases;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.conectate;

public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    //CREACION DE TODOS LAS INTERFACES
    
    IdentificacionProveedor IP = new IdentificacionProveedor();
    ConsultarProveedor CP;
    TasaDePrecios TDP;
    TasaBsUSD TasaBSUSD;
    TasaBsUSDConsultarModificar TasaBSUSDCM;
    ModificarEliminarProveedor MEP;
    ModificarAnticipo MA;
    ConsultarAnticipo CA;
    TipoConsultaProveedor TCP;
    IdentificacionProveedorTransacciones IPT;
    TransaccionesConsultarModificar TCM;
    

    conectate con;
    
    public PantallaPrincipal() {
        initComponents();
        con = new conectate();
        setResizable(false);
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

        FONDO = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        M_Archivo = new javax.swing.JMenu();
        MI_Cerrar = new javax.swing.JMenuItem();
        MI_CerrarTodo = new javax.swing.JMenuItem();
        MI_Guardar = new javax.swing.JMenuItem();
        M_Proveedor = new javax.swing.JMenu();
        MI_Consultar = new javax.swing.JMenuItem();
        MI_Agregar = new javax.swing.JMenuItem();
        MI_Modificar = new javax.swing.JMenuItem();
        MI_Eliminar = new javax.swing.JMenuItem();
        M_Transaccion = new javax.swing.JMenu();
        CrearTransaccion = new javax.swing.JMenuItem();
        ConsultarModificarTransaccion = new javax.swing.JMenuItem();
        M_ODP = new javax.swing.JMenu();
        M_Anticipos = new javax.swing.JMenu();
        MI_CrearA = new javax.swing.JMenuItem();
        MI_ModificarA = new javax.swing.JMenuItem();
        MI_ConsultarA = new javax.swing.JMenuItem();
        M_Valores = new javax.swing.JMenu();
        M_Agregar = new javax.swing.JMenu();
        SMI_BSUSD = new javax.swing.JMenuItem();
        SMI_Precios = new javax.swing.JMenuItem();
        MI_ConsultarModificar = new javax.swing.JMenu();
        TasaBSUSDCONSUlTAR = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ICONO PROG PANT COMPL.png"))); // NOI18N

        M_Archivo.setText("Archivo");

        MI_Cerrar.setText("Cerrar");
        M_Archivo.add(MI_Cerrar);

        MI_CerrarTodo.setText("Cerrar Todo");
        M_Archivo.add(MI_CerrarTodo);

        MI_Guardar.setText("Guardar");
        MI_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_GuardarActionPerformed(evt);
            }
        });
        M_Archivo.add(MI_Guardar);

        MenuBar.add(M_Archivo);

        M_Proveedor.setText("Proveedor");

        MI_Consultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        MI_Consultar.setText("Consultar");
        MI_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ConsultarActionPerformed(evt);
            }
        });
        M_Proveedor.add(MI_Consultar);

        MI_Agregar.setText("Agregar");
        MI_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_AgregarActionPerformed(evt);
            }
        });
        M_Proveedor.add(MI_Agregar);

        MI_Modificar.setText("Modificar");
        MI_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ModificarActionPerformed(evt);
            }
        });
        M_Proveedor.add(MI_Modificar);

        MI_Eliminar.setText("Eliminar");
        MI_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_EliminarActionPerformed(evt);
            }
        });
        M_Proveedor.add(MI_Eliminar);

        MenuBar.add(M_Proveedor);

        M_Transaccion.setText("Transacción");

        CrearTransaccion.setText("Crear");
        CrearTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearTransaccionActionPerformed(evt);
            }
        });
        M_Transaccion.add(CrearTransaccion);

        ConsultarModificarTransaccion.setText("Consultar/Modificar");
        ConsultarModificarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarModificarTransaccionActionPerformed(evt);
            }
        });
        M_Transaccion.add(ConsultarModificarTransaccion);

        MenuBar.add(M_Transaccion);

        M_ODP.setText("ODP");
        MenuBar.add(M_ODP);

        M_Anticipos.setText("Anticipos");

        MI_CrearA.setText("Crear");
        MI_CrearA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_CrearAActionPerformed(evt);
            }
        });
        M_Anticipos.add(MI_CrearA);

        MI_ModificarA.setText("Modificar");
        MI_ModificarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ModificarAActionPerformed(evt);
            }
        });
        M_Anticipos.add(MI_ModificarA);

        MI_ConsultarA.setText("Consultar");
        MI_ConsultarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ConsultarAActionPerformed(evt);
            }
        });
        M_Anticipos.add(MI_ConsultarA);

        MenuBar.add(M_Anticipos);

        M_Valores.setText("Valores");

        M_Agregar.setText("Agregar");

        SMI_BSUSD.setText("Tasa Bs/Usd");
        SMI_BSUSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMI_BSUSDActionPerformed(evt);
            }
        });
        M_Agregar.add(SMI_BSUSD);

        SMI_Precios.setText("Tasa de precios");
        SMI_Precios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMI_PreciosActionPerformed(evt);
            }
        });
        M_Agregar.add(SMI_Precios);

        M_Valores.add(M_Agregar);

        MI_ConsultarModificar.setText("Consultar/Modificar");

        TasaBSUSDCONSUlTAR.setText("Tasa BS/USD");
        TasaBSUSDCONSUlTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasaBSUSDCONSUlTARActionPerformed(evt);
            }
        });
        MI_ConsultarModificar.add(TasaBSUSDCONSUlTAR);

        M_Valores.add(MI_ConsultarModificar);

        MenuBar.add(M_Valores);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FONDO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(FONDO, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MI_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_GuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_GuardarActionPerformed

    private void MI_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ConsultarActionPerformed
        TCP = new TipoConsultaProveedor();
        TCP.setVisible(true);
        TCP.modo = 1;
        
    }//GEN-LAST:event_MI_ConsultarActionPerformed

    private void MI_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_AgregarActionPerformed
        IP.setVisible(true);
        IP.modo = 1;
    }//GEN-LAST:event_MI_AgregarActionPerformed

    private void MI_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ModificarActionPerformed
        TCP = new TipoConsultaProveedor();
        TCP.setVisible(true);
        TCP.modo = 2;
    }//GEN-LAST:event_MI_ModificarActionPerformed

    private void MI_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_EliminarActionPerformed
        TCP = new TipoConsultaProveedor();
        TCP.setVisible(true);
        TCP.modo = 2;
        
    }//GEN-LAST:event_MI_EliminarActionPerformed

    private void MI_CrearAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_CrearAActionPerformed
        IP.setVisible(true);
        IP.modo = 2;
    }//GEN-LAST:event_MI_CrearAActionPerformed

    private void MI_ConsultarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ConsultarAActionPerformed
        CA = new ConsultarAnticipo();
        CA.setVisible(true);
    }//GEN-LAST:event_MI_ConsultarAActionPerformed

    private void MI_ModificarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ModificarAActionPerformed
        MA = new ModificarAnticipo();
        MA.setVisible(true);
    }//GEN-LAST:event_MI_ModificarAActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        con.desconectar();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.desconectar();
    }//GEN-LAST:event_formWindowClosing

    private void TasaBSUSDCONSUlTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TasaBSUSDCONSUlTARActionPerformed
        TasaBSUSDCM = new TasaBsUSDConsultarModificar();
        TasaBSUSDCM.setVisible(true);
    }//GEN-LAST:event_TasaBSUSDCONSUlTARActionPerformed

    private void CrearTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearTransaccionActionPerformed
        IPT = new IdentificacionProveedorTransacciones();
        IPT.setVisible(true);
    }//GEN-LAST:event_CrearTransaccionActionPerformed

    private void ConsultarModificarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarModificarTransaccionActionPerformed
        TCM = new TransaccionesConsultarModificar();
        TCM.setVisible(true);
    }//GEN-LAST:event_ConsultarModificarTransaccionActionPerformed

    private void SMI_BSUSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMI_BSUSDActionPerformed
        TasaBSUSD = new TasaBsUSD();
        TasaBSUSD.setVisible(true);
    }//GEN-LAST:event_SMI_BSUSDActionPerformed

    private void SMI_PreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMI_PreciosActionPerformed
        TDP = new TasaDePrecios();
        TDP.setVisible(true);
    }//GEN-LAST:event_SMI_PreciosActionPerformed
    
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
        int index = JOptionPane.showConfirmDialog(this, "ESTA SEGURO DE CERRAR LA APLICACION", "ADVERTENCIA", JOptionPane.YES_NO_OPTION);
        if(index==JOptionPane.YES_OPTION){
            System.exit(0);
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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConsultarModificarTransaccion;
    private javax.swing.JMenuItem CrearTransaccion;
    private javax.swing.JLabel FONDO;
    private javax.swing.JMenuItem MI_Agregar;
    private javax.swing.JMenuItem MI_Cerrar;
    private javax.swing.JMenuItem MI_CerrarTodo;
    private javax.swing.JMenuItem MI_Consultar;
    private javax.swing.JMenuItem MI_ConsultarA;
    private javax.swing.JMenu MI_ConsultarModificar;
    private javax.swing.JMenuItem MI_CrearA;
    private javax.swing.JMenuItem MI_Eliminar;
    private javax.swing.JMenuItem MI_Guardar;
    private javax.swing.JMenuItem MI_Modificar;
    private javax.swing.JMenuItem MI_ModificarA;
    private javax.swing.JMenu M_Agregar;
    private javax.swing.JMenu M_Anticipos;
    private javax.swing.JMenu M_Archivo;
    private javax.swing.JMenu M_ODP;
    private javax.swing.JMenu M_Proveedor;
    private javax.swing.JMenu M_Transaccion;
    private javax.swing.JMenu M_Valores;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem SMI_BSUSD;
    private javax.swing.JMenuItem SMI_Precios;
    private javax.swing.JMenuItem TasaBSUSDCONSUlTAR;
    // End of variables declaration//GEN-END:variables
}
