package logica;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class ODP {
    
    private conectate con;
    private Tasa_USD tasa_USD = new Tasa_USD();
    private transacciones objetoTransacciones = new transacciones();
    private Proveedor_Beneficiario PB = new Proveedor_Beneficiario();
    private beneficiarios objetoBeneficiario = new beneficiarios();
    private anticipos objetoAnticipo = new anticipos();
    
    //CONSTRUCTOR
    public ODP(){
        con = new conectate();
    }
    
    public void generar_ODP_Completa(String semana){
        
        int registros = 0;
        
        ArrayList<Integer> codigos_Proveedores = new ArrayList<Integer>();
        /*
            PRIMERO, AGRUPAMOS CUANTAS TRANSACCIONES HAY POR CADA PROVEEDOR
            PERO AL FINAL, NO IMPORTA CUANTAS TENGA CADA UNO
            LO QUE IMPORTA ES QUE LA CANTIDAD DE REGISTROS SERA IGUAL A CUANTOS PROVEEDORES DISTINTOS 
            TUVIERON ACCIONES EN CIERTA SEMANA
        */
        try{
            int codigo;
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo_Proveedor FROM transacciones WHERE Semana = ? GROUP BY Codigo_Proveedor");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                registros++;
                codigo = res.getInt("Codigo_Proveedor");
                codigos_Proveedores.add(codigo);
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
            AHORA, IREMOS ITERANDO POR CADA PROVEEDOR
            EL CODIGO LO TENEMOS EN EL ARRAY LIST
            CALCULAREMOS ENTONCES LA MATERIA PRIMA, CUADRILLA, FLETE Y PEAJE DE ESTE PROVEEDOR
            Y LOS IREMOS METIENDO EN LAS CASILLAS CORRESPONDIENTES
        
            
        */
        for(int i = 0; i < registros; i++){
            double[][] materiaPrima = this.generarODP_Materia_Prima(semana, codigos_Proveedores.get(i));
            double[][] cuadrilla = this.ODP_Cuadrilla(semana, codigos_Proveedores.get(i));
            double[][] flete = this.ODP_Flete(semana, codigos_Proveedores.get(i));
            double[][] peaje = this.ODP_Peaje(semana, codigos_Proveedores.get(i));
            double tasaUSD = tasa_USD.tasaSemana(semana);
            float[] montosKg_Brutos_Netos = objetoTransacciones.cantidadKG_Brutos_Netos_PorProveedor_Semana(codigos_Proveedores.get(i), semana);
            Date fecha_Actual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dddd HH:mm:ss");
            String fecha_formateada = sdf.format(fecha_Actual);
            int cantidad_viajes = objetoTransacciones.cantidadViajes_PorProveedor_Semana(codigos_Proveedores.get(i), semana);
            double[] montos_anticipos = objetoAnticipo.anticipos_Proveedor_Semana(semana, codigos_Proveedores.get(i));
            double anticipo_BS = montos_anticipos[0];
            

            try{
                PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO ODP(Cod_DelProveedor, Fecha, Semana, Acumulado_MP_BS, Acumulado_MP_DS, Acumulado_Cuadrilla_BS, Acumulado_Cuadrilla_DS, Acumulado_Flete_BS, Acumulado_Flete_DS, Acumulado_Peaje_BS, Acumulado_Peaje_DS) "
                        + " values(?,?,?,?,?,?,?,?,?,?,?)");
                pstm.setInt(1, codigos_Proveedores.get(i));
                pstm.setString(2, fecha_formateada);
                pstm.setString(3, semana);
                pstm.setDouble(4, materiaPrima[0][1]);  //BS
                pstm.setDouble(5, materiaPrima[0][0]);  //DS
                pstm.setDouble(6, cuadrilla[0][1]);     //BS
                pstm.setDouble(7, cuadrilla[0][0]);     //DS
                pstm.setDouble(8, flete[0][1]);         //BS
                pstm.setDouble(9, flete[0][0]);         //DS
                pstm.setDouble(10, peaje[0][1]);        //BS
                pstm.setDouble(11, peaje[0][0]);        //DS
                pstm.execute();
                pstm.close();
            }catch(SQLException ex){
                Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        objetoTransacciones.cerrarTransacciones(semana);
    }
    
    public boolean verificarODP(String semana){
        boolean condicion = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Semana from ODP group by Semana");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                if(semana.equals(res.getString("Semana"))){
                    condicion = true;
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return condicion;
    }
    
    public Object[][] getDatos(String semana){
        int registros = 0;
        
        ArrayList<Integer> codigos_Proveedores = new ArrayList<Integer>();
        /*
            PRIMERO, AGRUPAMOS CUANTAS TRANSACCIONES HAY POR CADA PROVEEDOR
            PERO AL FINAL, NO IMPORTA CUANTAS TENGA CADA UNO
            LO QUE IMPORTA ES QUE LA CANTIDAD DE REGISTROS SERA IGUAL A CUANTOS PROVEEDORES DISTINTOS 
            TUVIERON ACCIONES EN CIERTA SEMANA
        */
        try{
            int codigo;
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo_Proveedor FROM transacciones WHERE Semana = ? GROUP BY Codigo_Proveedor");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                registros++;
                codigo = res.getInt("Codigo_Proveedor");
                codigos_Proveedores.add(codigo);
                System.out.println(codigo);
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] data = new Object[registros][12];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM ODP Where Semana = ? ORDER BY Cod_ODP DESC");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next() && i < registros){
                int estCod_ODP = res.getInt("Cod_ODP");
                int estCod_DelProveedor = res.getInt("Cod_DelProveedor");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                double estAcumulado_MP_BS = res.getDouble("Acumulado_MP_BS");
                double estAcumulado_MP_DS = res.getDouble("Acumulado_MP_DS");
                double estAcumulado_Cuadrilla_BS = res.getDouble("Acumulado_Cuadrilla_BS");
                double estAcumulado_Cuadrilla_DS = res.getDouble("Acumulado_Cuadrilla_DS");
                double estAcumulado_Flete_BS = res.getDouble("Acumulado_Flete_BS");
                double estAcumulado_Flete_DS = res.getDouble("Acumulado_Flete_DS");
                double estAcumulado_Peaje_BS = res.getDouble("Acumulado_Peaje_BS");
                double estAcumulado_Peaje_DS = res.getDouble("Acumulado_Peaje_DS");
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(10);
                data[i][0] = estCod_ODP;
                data[i][1] = estCod_DelProveedor;
                data[i][2] = estFecha;
                data[i][3] = estSemana;
                data[i][4] = df.format(estAcumulado_MP_BS);
                data[i][5] = df.format(estAcumulado_MP_DS);
                data[i][6] = df.format(estAcumulado_Cuadrilla_BS);
                data[i][7] = df.format(estAcumulado_Cuadrilla_DS);
                data[i][8] = df.format(estAcumulado_Flete_BS);
                data[i][9] = df.format(estAcumulado_Flete_DS);
                data[i][10] = df.format(estAcumulado_Peaje_BS);
                data[i][11] = df.format(estAcumulado_Peaje_DS);
                i++;
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /*
    private ArrayList<Integer> proveedoresMateriaPrima(String semana){
        ArrayList<Integer> proveedores = new ArrayList<Integer>();
        int cantidad_veces = 0;
        int codigo = 0;
        boolean existen = false;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Materia_Prima, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, boleto.Kg_Netos, boleto.Materia_S, Tasa_Precios.En_Planta, Tasa_Precios.Materia_Seca, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Materia_Prima "
                    + " FROM proveedor, boleto, transacciones, Tasa_Precios "
                    + " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND "
                    + " transacciones.Semana = ? AND "
                    + " proveedor.Materia_Prima = 'TABLA' "
                    + " AND Tasa_Precios.Materia_Seca = boleto.Materia_S AND "
                    + " transacciones.Materia_Prima = 'SI' AND "
                    + " transacciones.Estado_Transaccion = 'No Procesada' AND "
                    + " transacciones.Num_Boleto = boleto.Codigo_Boleto "
                    + " GROUP BY proveedor.Codigo ORDER BY proveedor.Codigo ASC");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Codigo");
                System.out.println(codigo);
                existen = true;
                cantidad_veces++;
                proveedores.add(codigo);
            }
            while(res.next() && existen){
                int codigo2 = res.getInt("Codigo");
                if(codigo2 != codigo){
                    codigo = codigo2;
                    cantidad_veces++;
                    proveedores.add(codigo2);
                    System.out.println("Nuevo codigo: " + codigo2);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }
    */
    
    public double[][] generarODP_Materia_Prima(String semana, int codigo){
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.tasaSemana(semana);
        double[][] cantidad_por_proveedores = new double[1][2];
        try{
            for(int i = 0; i < 1; i++){
                cantidad  = 0;
                cantidad_BS = 0;
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Materia_Prima, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, boleto.Kg_Netos, boleto.Materia_S, Tasa_Precios.En_Planta, Tasa_Precios.Materia_Seca, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Materia_Prima "
                        + " FROM proveedor, boleto, transacciones, Tasa_Precios "
                        + " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND "
                        + " proveedor.Codigo = ? AND transacciones.Semana = ? AND "
                        + " proveedor.Materia_Prima = 'TABLA' AND "
                        + " Tasa_Precios.Materia_Seca = boleto.Materia_S AND "
                        + " transacciones.Materia_Prima = 'SI' AND "
                        + " transacciones.Estado_Transaccion = 'No Procesada' AND "
                        + " transacciones.Num_Boleto = boleto.Codigo_Boleto "
                        + " ORDER BY proveedor.Codigo");
                pstm2.setInt(1, codigo);
                //System.out.println(codigos.get(i));
                pstm2.setString(2, semana);
                ResultSet res2 = pstm2.executeQuery();
                while(res2.next()){
                    float estEn_Planta = res2.getFloat("En_Planta");
                    //estEn_Planta /= 1000;
                    float estKg_Netos = res2.getFloat("Kg_Netos");
                    //System.out.println("En planta: " + estEn_Planta + " Kg_Netos: " + estKg_Netos);
                    cantidad += (estEn_Planta * estKg_Netos);
                    //System.out.println(cantidad);
                }
                cantidad_BS = cantidad * valorTasa_USD;
                cantidad_por_proveedores[i][0] = cantidad;
                cantidad_por_proveedores[i][1] = cantidad_BS;  
                //System.out.println(cantidad_por_proveedores[i][0]);
                //System.out.println(cantidad_por_proveedores[i][0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad_por_proveedores;
    }
    
    
    public ArrayList<String> semanasTransacciones(){
        ArrayList<String> semanas = new ArrayList<String>();
        int cantidad_semanas = 0;
        String semana = "";
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Semana FROM transacciones GROUP BY Semana");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                semanas.add(res.getString("Semana"));
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return semanas;
    }
    
    /*
    //CUADRILLA = KG_Netos * CUADRILLA_PROVEEDOR
    private ArrayList<Integer> proveedoresCuadrilla(String semana){
        ArrayList<Integer> proveedores = new ArrayList<Integer>();
        int cantidad_veces = 0;
        int codigo = 0;
        boolean existen = false;
        try {

                PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Cuadrilla, boleto.Codigo_Boleto, boleto.Kg_Netos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Cuadrilla "
                        + " FROM proveedor, boleto, transacciones "
                        + " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND "
                        + " transacciones.Semana = ? AND "
                        + " transacciones.Cuadrilla = 'SI' AND "
                        + " transacciones.Estado_Transaccion = 'No Procesada' AND "
                        + " transacciones.Num_Boleto = boleto.Codigo_Boleto "
                        + " GROUP BY proveedor.Codigo ORDER BY proveedor.Codigo ASC");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Codigo");
                System.out.println(codigo);
                existen = true;
                cantidad_veces++;
                proveedores.add(codigo);
            }
            while(res.next() && existen){
                int codigo2 = res.getInt("Codigo");
                if(codigo2 != codigo){
                    codigo = codigo2;
                    cantidad_veces++;
                    proveedores.add(codigo2);
                    System.out.println("Nuevo codigo: " + codigo2);
                }
            }
            
        } catch (SQLException e) {
                Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, e);
        }
        return proveedores;
    }
    */
    
    public double[][] ODP_Cuadrilla (String semana, int codigo) {
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.tasaSemana(semana);
        double[][] cantidad_por_proveedores = new double[1][2];
        try{
            for(int i = 0; i <1; i++){
                cantidad  = 0;
                cantidad_BS = 0;
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Cuadrilla, boleto.Codigo_Boleto, boleto.Kg_Netos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Cuadrilla as Cuadrilla_Proveedor "
                        + " FROM proveedor, boleto, transacciones "
                        + " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND "
                        + " proveedor.Codigo = ? AND transacciones.Semana = ? AND "
                        + " transacciones.Cuadrilla = 'SI' AND "
                        + " transacciones.Estado_Transaccion = 'No Procesada' AND "
                        + " transacciones.Num_Boleto = boleto.Codigo_Boleto "
                        + " ORDER BY proveedor.Codigo");
                pstm2.setInt(1, codigo);
                //System.out.println(codigos.get(i));
                pstm2.setString(2, semana);
                ResultSet res2 = pstm2.executeQuery();
                while(res2.next()){
                    float estKg_Netos = res2.getFloat("Kg_Netos");
                    float estCuadrilla_P = res2.getFloat("Cuadrilla_Proveedor");
                    //System.out.println("Kg Brutos: " + estKg_Brutos + " cuadrilla: " + estCuadrilla_P);
                    cantidad += (estKg_Netos * estCuadrilla_P);
                    //System.out.println(cantidad);
                }
                cantidad_BS = cantidad * valorTasa_USD;
                cantidad_por_proveedores[i][0] = cantidad;
                cantidad_por_proveedores[i][1] = cantidad_BS;  
                //System.out.println(cantidad_por_proveedores[i][0]);
                //System.out.println(cantidad_por_proveedores[i][0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad_por_proveedores;
    }
    
    /*
    private ArrayList<Integer> proveedoresFlete(String semana){
        ArrayList<Integer> proveedores = new ArrayList<Integer>();
        int cantidad_veces = 0;
        int codigo = 0;
        boolean existen = false;
        try {

                PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Flete, boleto.Codigo_Boleto, boleto.Kg_Brutos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Flete "
                        + " FROM proveedor, boleto, transacciones "
                        + " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND "
                        + " transacciones.Semana = ? AND "
                        + " transacciones.Flete = 'SI' AND "
                        + " transacciones.Estado_Transaccion = 'No Procesada' AND "
                        + " transacciones.Num_Boleto = boleto.Codigo_Boleto "
                        + " GROUP BY proveedor.Codigo ORDER BY proveedor.Codigo ASC");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Codigo");
                System.out.println(codigo);
                existen = true;
                cantidad_veces++;
                proveedores.add(codigo);
            }
            while(res.next() && existen){
                int codigo2 = res.getInt("Codigo");
                if(codigo2 != codigo){
                    codigo = codigo2;
                    cantidad_veces++;
                    proveedores.add(codigo2);
                    System.out.println("Nuevo codigo: " + codigo2);
                }
            }
            
        } catch (SQLException e) {
                Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, e);
        }
        return proveedores;
    }
    */
    
    public double[][] ODP_Flete (String semana, int codigo) {
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.tasaSemana(semana);
        double[][] cantidad_por_proveedores = new double[1][2];
        try{
            for(int i = 0; i < 1; i++){
                cantidad  = 0;
                cantidad_BS = 0;
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Flete, boleto.Codigo_Boleto, boleto.Kg_Brutos, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Flete as Flete_Proveedor "
                        + " FROM proveedor, boleto, transacciones "
                        + " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND "
                        + " proveedor.Codigo = ? AND transacciones.Semana = ? AND "
                        + " transacciones.Flete = 'SI' AND "
                        + " transacciones.Estado_Transaccion = 'No Procesada' AND "
                        + " transacciones.Num_Boleto = boleto.Codigo_Boleto "
                        + " ORDER BY proveedor.Codigo");
                pstm2.setInt(1, codigo);
                //System.out.println(codigos.get(i));
                pstm2.setString(2, semana);
                ResultSet res2 = pstm2.executeQuery();
                while(res2.next()){
                    float estKg_Brutos = res2.getFloat("Kg_Brutos");
                    float estFlete_P = res2.getFloat("Flete_Proveedor");
                    //System.out.println("Kg Brutos: " + estKg_Brutos + " cuadrilla: " + estCuadrilla_P);
                    cantidad += (estKg_Brutos * estFlete_P);
                    //System.out.println(cantidad);
                }
                cantidad_BS = cantidad * valorTasa_USD;
                cantidad_por_proveedores[i][0] = cantidad;
                cantidad_por_proveedores[i][1] = cantidad_BS;  
                //System.out.println(cantidad_por_proveedores[i][0]);
                //System.out.println(cantidad_por_proveedores[i][0]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad_por_proveedores;
    }
    
    /*
    private ArrayList<Integer> proveedoresPeaje(String semana){
        ArrayList<Integer> proveedores = new ArrayList<Integer>();
        int cantidad_veces = 0;
        int codigo = 0;
        boolean existen = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Peaje, boleto.Codigo_Boleto, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Peaje as Peaje_Proveedor " +
                        " FROM proveedor, boleto, transacciones " +
                        " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND " +
                        " transacciones.Semana = ? AND " +
                        " transacciones.Peaje = 'SI' AND " +
                        " transacciones.Estado_Transaccion = 'No Procesada' AND" +
                        " transacciones.Num_Boleto = boleto.Codigo_Boleto " +
                        " GROUP BY proveedor.Codigo ORDER BY proveedor.Codigo ASC");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Codigo");
                System.out.println(codigo);
                existen = true;
                cantidad_veces++;
                proveedores.add(codigo);
            }
            while(res.next() && existen){
                int codigo2 = res.getInt("Codigo");
                if(codigo2 != codigo){
                    codigo = codigo2;
                    cantidad_veces++;
                    proveedores.add(codigo2);
                    System.out.println("Nuevo codigo: " + codigo2);
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }
    */
    
    public double[][] ODP_Peaje(String semana, int codigo){
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.tasaSemana(semana);
        double[][] cantidad_por_proveedores = new double[1][2];
        try{
            for(int i = 0; i < 1; i++){
                int peaje = 0;
                cantidad = 0;
                cantidad_BS = 0;
                int cantidad_boletos = 0;
                PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Peaje, boleto.Codigo_Boleto, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Peaje as Peaje_Proveedor " +
                        " FROM proveedor, boleto, transacciones " +
                        " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND " +
                        " transacciones.Semana = ? AND proveedor.Codigo = ? AND " +
                        " transacciones.Peaje = 'SI' AND " +
                        " transacciones.Estado_Transaccion = 'No Procesada' AND" +
                        " transacciones.Num_Boleto = boleto.Codigo_Boleto " +
                        " ORDER BY proveedor.Codigo ASC");
                pstm.setString(1, semana);
                pstm.setInt(2, codigo);
                ResultSet res = pstm.executeQuery();
                while(res.next()){
                    peaje = res.getInt("Peaje_Proveedor");
                    cantidad_boletos++;
                }
                cantidad = cantidad_boletos * peaje;
                cantidad_BS = cantidad * valorTasa_USD;
                cantidad_por_proveedores[i][0] = cantidad;
                cantidad_por_proveedores[i][1] = cantidad_BS;  
                
            }
            
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad_por_proveedores;
    }
    
    /*
    public static void main(String args[]){
        
        ODP objeto = new ODP();
        Object[][] matriz = objeto.plantillaPago("26-2021");
        for(int i = 0; i < 4; i++){
            System.out.println("===============================================================================");
            System.out.println("PROVEEDOR Numero: " + (i+1));
            System.out.println("Semana: " + matriz[i][0]);
            System.out.println("Fecha: " + matriz[i][1]);
            System.out.println("Cedula: " + matriz[i][2]);
            System.out.println("Beneficiario: " + matriz[i][3]);
            System.out.println("Banco" + matriz[i][4]);
            System.out.println("Numero de Cuenta: " + matriz[i][5]);
            System.out.println("Tasa USD semana: " + matriz[i][6]);
            System.out.println("Kg_Netos: " + matriz[i][7]);
            System.out.println("Kg_Brutos: " + matriz[i][8]);
            System.out.println("Viajes: " + matriz[i][9]);
            System.out.println("Materia Prima BS: " +  matriz[i][10]);
            System.out.println("Materia Prima DS: "+ matriz[i][11]);
            System.out.println("Cuadrilla BS: " + matriz[i][12]);
            System.out.println("Cuadrilla DS: "+ matriz[i][13]);
            System.out.println("Flete BS: " + matriz[i][14]);
            System.out.println("Flete DS: " + matriz[i][15]);
            System.out.println("Peaje BS: " + matriz[i][16]);
            System.out.println("Peaje DS: " + matriz[i][17]);
            System.out.println("SubTotal BS: " + matriz[i][18]);
            System.out.println("SubTotal DS: "+ matriz[i][19]);
            System.out.println("Anticipos BS: " + matriz[i][20]);
            System.out.println("Anticipos DS: " + matriz[i][21]);
            System.out.println("Total a Pagar BS: " + matriz[i][22]);
            System.out.println("Total a Pagar DS: " + matriz[i][23]);
            System.out.println("===============================================================================");
        }
        
    }
    */
    
    public Object[][] plantillaPagoBS(String semana) throws SQLException{
        int registros = 0;
        
        ArrayList<Integer> codigos_Proveedores = new ArrayList<Integer>();
        /*
            PRIMERO, AGRUPAMOS CUANTAS TRANSACCIONES HAY POR CADA PROVEEDOR
            PERO AL FINAL, NO IMPORTA CUANTAS TENGA CADA UNO
            LO QUE IMPORTA ES QUE LA CANTIDAD DE REGISTROS SERA IGUAL A CUANTOS PROVEEDORES DISTINTOS 
            TUVIERON ACCIONES EN CIERTA SEMANA
        */
        try{
            int codigo;
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo_Proveedor FROM transacciones WHERE Semana = ? GROUP BY Codigo_Proveedor");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                registros++;
                codigo = res.getInt("Codigo_Proveedor");
                codigos_Proveedores.add(codigo);
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] data = new Object[registros][17];
        /*
            AHORA, IREMOS ITERANDO POR CADA PROVEEDOR
            EL CODIGO LO TENEMOS EN EL ARRAY LIST
            CALCULAREMOS ENTONCES LA MATERIA PRIMA, CUADRILLA, FLETE Y PEAJE DE ESTE PROVEEDOR
            Y LOS IREMOS METIENDO EN LAS CASILLAS CORRESPONDIENTES
        
            
        */
        for(int i = 0; i < registros; i++){
            double[][] materiaPrima = this.generarODP_Materia_Prima(semana, codigos_Proveedores.get(i));
            double[][] cuadrilla = this.ODP_Cuadrilla(semana, codigos_Proveedores.get(i));
            double[][] flete = this.ODP_Flete(semana, codigos_Proveedores.get(i));
            double[][] peaje = this.ODP_Peaje(semana, codigos_Proveedores.get(i));
            double tasaUSD = tasa_USD.tasaSemana(semana);
            float[] montosKg_Brutos_Netos = objetoTransacciones.cantidadKG_Brutos_Netos_PorProveedor_Semana(codigos_Proveedores.get(i), semana);
            Date fecha_Actual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha_formateada = sdf.format(fecha_Actual);
            int cantidad_viajes = objetoTransacciones.cantidadViajes_PorProveedor_Semana(codigos_Proveedores.get(i), semana);
            double[] montos_anticipos = objetoAnticipo.anticipos_Proveedor_Semana(semana, codigos_Proveedores.get(i));
            double anticipo_BS = montos_anticipos[0];
            
            data[i][0] = semana;                        //LA SEMANA CON LA QUE SE ESTA TRABAJANDO
            data[i][1] = fecha_formateada;              //FECHA EN DIA/MES/ANIO
            if(PB.encontrarProveedor(codigos_Proveedores.get(i))){
                //AQUI COLOCAMOS EN LAS CASILLAS DE BENEFICIARIO, LOS DATOS DE BENEFICIARIO QUE CORRESPONED A ESTE PROVEEDOR
                Object[] datosBeneficiario = objetoBeneficiario.informacionBeneficiario_ParaODP(codigos_Proveedores.get(i));
                data[i][2] = datosBeneficiario[0]; //ID_Beneficiario
                data[i][3] = datosBeneficiario[1]; //Name_Beneficiario
                data[i][4] = datosBeneficiario[2]; //Banco
                data[i][5] = datosBeneficiario[3]; //Numero de Cuenta
            } else {
                //AQUI COLOCAMOS EN LAS CASILLAS DE BENEFICIARIO, LOS DATOS EN BLANCO
                data[i][2] = " ";
                data[i][3] = " ";
                data[i][4] = " ";
                data[i][5] = " ";
            }
            data[i][6] = tasaUSD;                       //TASA DEL DOLAR EN LA SEMANA DE LA ODP
            data[i][7] = montosKg_Brutos_Netos[0];      //KG NETOS
            data[i][8] = montosKg_Brutos_Netos[1];      //KG BRUTOS
            data[i][9] = cantidad_viajes;
            //=======================================================================\\
            double materia_primaBS = materiaPrima[0][1];
            double cuadrilla_BS = cuadrilla[0][1];
            double flete_BS = flete[0][1];
            double peaje_BS = peaje[0][1];
            double subTotalBS = materia_primaBS + cuadrilla_BS + flete_BS + peaje_BS;
            //========================================================================\\
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(10);
            data[i][10] = df.format(materiaPrima[0][1]);            //EN BS
            data[i][11] = df.format(cuadrilla[0][1]);               //EN BS  
            data[i][12] = df.format(flete[0][1]);                   //EN BS
            data[i][13] = df.format(peaje[0][1]);                   //EN BS
            //====================================================================================================================\\
            data[i][14] = df.format(subTotalBS);
            //====================================================================================================================\\
            data[i][15] = df.format(anticipo_BS);
            //====================================================================================================================\\
            double total_BS = subTotalBS - anticipo_BS;
            data[i][16] = df.format(total_BS);
        }
        return data;
    }
    
    public Object[][] plantillaPagoDS(String semana) throws SQLException{
        int registros = 0;
        
        ArrayList<Integer> codigos_Proveedores = new ArrayList<Integer>();
        /*
            PRIMERO, AGRUPAMOS CUANTAS TRANSACCIONES HAY POR CADA PROVEEDOR
            PERO AL FINAL, NO IMPORTA CUANTAS TENGA CADA UNO
            LO QUE IMPORTA ES QUE LA CANTIDAD DE REGISTROS SERA IGUAL A CUANTOS PROVEEDORES DISTINTOS 
            TUVIERON ACCIONES EN CIERTA SEMANA
        */
        try{
            int codigo;
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo_Proveedor FROM transacciones WHERE Semana = ? GROUP BY Codigo_Proveedor");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                registros++;
                codigo = res.getInt("Codigo_Proveedor");
                codigos_Proveedores.add(codigo);
            }
        }catch(SQLException ex){
            Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] data = new Object[registros][17];
        /*
            AHORA, IREMOS ITERANDO POR CADA PROVEEDOR
            EL CODIGO LO TENEMOS EN EL ARRAY LIST
            CALCULAREMOS ENTONCES LA MATERIA PRIMA, CUADRILLA, FLETE Y PEAJE DE ESTE PROVEEDOR
            Y LOS IREMOS METIENDO EN LAS CASILLAS CORRESPONDIENTES
        
            
        */
        for(int i = 0; i < registros; i++){
            double[][] materiaPrima = this.generarODP_Materia_Prima(semana, codigos_Proveedores.get(i));
            double[][] cuadrilla = this.ODP_Cuadrilla(semana, codigos_Proveedores.get(i));
            double[][] flete = this.ODP_Flete(semana, codigos_Proveedores.get(i));
            double[][] peaje = this.ODP_Peaje(semana, codigos_Proveedores.get(i));
            double tasaUSD = tasa_USD.tasaSemana(semana);
            float[] montosKg_Brutos_Netos = objetoTransacciones.cantidadKG_Brutos_Netos_PorProveedor_Semana(codigos_Proveedores.get(i), semana);
            Date fecha_Actual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha_formateada = sdf.format(fecha_Actual);
            int cantidad_viajes = objetoTransacciones.cantidadViajes_PorProveedor_Semana(codigos_Proveedores.get(i), semana);
            double[] montos_anticipos = objetoAnticipo.anticipos_Proveedor_Semana(semana, codigos_Proveedores.get(i));
            double anticipo_DS = montos_anticipos[1];
            
            data[i][0] = semana;                        //LA SEMANA CON LA QUE SE ESTA TRABAJANDO
            data[i][1] = fecha_formateada;              //FECHA EN DIA/MES/ANIO
            if(PB.encontrarProveedor(codigos_Proveedores.get(i))){
                //AQUI COLOCAMOS EN LAS CASILLAS DE BENEFICIARIO, LOS DATOS DE BENEFICIARIO QUE CORRESPONED A ESTE PROVEEDOR
                Object[] datosBeneficiario = objetoBeneficiario.informacionBeneficiario_ParaODP(codigos_Proveedores.get(i));
                data[i][2] = datosBeneficiario[0]; //ID_Beneficiario
                data[i][3] = datosBeneficiario[1]; //Name_Beneficiario
                data[i][4] = datosBeneficiario[2]; //Banco
                data[i][5] = datosBeneficiario[3]; //Numero de Cuenta
            } else {
                //AQUI COLOCAMOS EN LAS CASILLAS DE BENEFICIARIO, LOS DATOS EN BLANCO
                data[i][2] = " ";
                data[i][3] = " ";
                data[i][4] = " ";
                data[i][5] = " ";
            }
            data[i][6] = tasaUSD;                       //TASA DEL DOLAR EN LA SEMANA DE LA ODP
            data[i][7] = montosKg_Brutos_Netos[0];      //KG NETOS
            data[i][8] = montosKg_Brutos_Netos[1];      //KG BRUTOS
            data[i][9] = cantidad_viajes;
            //=======================================================================\\
            //========================================================================\\
            double materiaPrimaDS = materiaPrima[0][0]; //System.out.println("Materia Prima DS C" + materiaPrimaDS);
            double cuadrillaDS = cuadrilla[0][0];       //System.out.println("Cuadrilla DS C" +cuadrillaDS);
            double fleteDS = flete[0][0];               //System.out.println("Flete DS C" +fleteDS);
            double peajeDS = peaje[0][0];               //System.out.println("Peaje DS C" +peajeDS);
            double subTotalDS = materiaPrimaDS + cuadrillaDS + fleteDS + peajeDS;
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(10);
            data[i][10] = df.format(materiaPrima[0][0]);            //EN DS
            data[i][11] = df.format(cuadrilla[0][0]);               //EN DS
            data[i][12] = df.format(flete[0][0]);                   //EN DS
            data[i][13] = df.format(peaje[0][0]);                   //EN DS  
            //====================================================================================================================\\
            data[i][14] = df.format(subTotalDS); 
            //====================================================================================================================\\
            data[i][15] = df.format(anticipo_DS);
            //====================================================================================================================\\
            double total_DS = subTotalDS - anticipo_DS;
            data[i][16] = df.format(total_DS);
        }
        return data;
    }
    
    public void CrearPDF_PlantillaPagoBS(File fichero, String semana) throws SQLException{
       Document documento = new Document();
       
        try{
           //SE LE COLOCA LA RUTA AL ARCHIVO
           PdfWriter.getInstance(documento, new FileOutputStream(fichero));
           Object[][] datos = this.plantillaPagoBS(semana);
           Paragraph parrafo = new Paragraph();
           parrafo.setAlignment(Paragraph.ALIGN_CENTER);
           parrafo.add("REPORTE DE LA PLANTILLA DE PAGO EN BS \n \n");
           parrafo.setFont(FontFactory.getFont("Arial", 30, Font.BOLD));
           
           //SE LE COLOCA EL TAMAÑO AL DOCUMENTO + ROTATE() QUE HACE COLOCARLO EN HORIZONTAL
           documento.setPageSize(PageSize.A1.rotate());
           //SE ABRE EL DOCUMENTO
           documento.open();
           documento.add(parrafo);
           //SE CREA UN OBJETO TABLA DONDE SE PUEDAN GUARDAR LOS DATOS + TAMAÑO
           PdfPTable tabla = new PdfPTable(17);
           //SE LE COLOCAN TITULO A CADA UNA DE LAS COLUMNAS
           tabla.addCell("Semana");
           tabla.addCell("Fecha");
           tabla.addCell("Cedula de Identidad");
           tabla.addCell("Beneficiario");
           tabla.addCell("Banco");
           tabla.addCell("Numero de Cuenta");
           tabla.addCell("Tasa USD Semana");
           tabla.addCell("KG_Netos");
           tabla.addCell("KG_Brutos");
           tabla.addCell("Viajes");
           tabla.addCell("Materia Prima BS");
           tabla.addCell("Cuadrilla BS");
           tabla.addCell("Flete BS");
           tabla.addCell("Peaje BS");
           tabla.addCell("SubTotal BS");
           tabla.addCell("Anticipos BS");
           tabla.addCell("Total a Pagar BS");
           int registros = 0;
           try{
            int codigo;
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo_Proveedor FROM transacciones WHERE Semana = ? GROUP BY Codigo_Proveedor");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                registros++;
            }
                System.out.println(registros);
            }catch(SQLException ex){
                Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
            }  
            for(int i = 0; i < registros; i++){
                tabla.addCell(datos[i][0].toString());
                tabla.addCell(datos[i][1].toString());
                tabla.addCell(datos[i][2].toString());
                tabla.addCell(datos[i][3].toString());
                tabla.addCell(datos[i][4].toString());
                tabla.addCell(datos[i][5].toString());
                tabla.addCell(datos[i][6].toString());
                tabla.addCell(datos[i][7].toString());
                tabla.addCell(datos[i][8].toString());
                tabla.addCell(datos[i][9].toString());
                tabla.addCell(datos[i][10].toString());
                tabla.addCell(datos[i][11].toString());
                tabla.addCell(datos[i][12].toString());
                tabla.addCell(datos[i][13].toString());
                tabla.addCell(datos[i][14].toString());
                tabla.addCell(datos[i][15].toString());
                tabla.addCell(datos[i][16].toString());            
            }
            documento.add(tabla);
            documento.close();
        }catch(Exception ex){
           Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void CrearPDF_PlantillaPagoDS(File fichero, String semana) throws SQLException{
       Document documento = new Document();
       
        try{
           //SE LE COLOCA LA RUTA AL ARCHIVO
           PdfWriter.getInstance(documento, new FileOutputStream(fichero));
           Object[][] datos = this.plantillaPagoDS(semana);
           Paragraph parrafo = new Paragraph();
           parrafo.setAlignment(Paragraph.ALIGN_CENTER);
           parrafo.add("REPORTE DE LA PLANTILLA DE PAGO EN DS \n \n");
           parrafo.setFont(FontFactory.getFont("Arial", 30, Font.BOLD));
           
           //SE LE COLOCA EL TAMAÑO AL DOCUMENTO + ROTATE() QUE HACE COLOCARLO EN HORIZONTAL
           documento.setPageSize(PageSize.A1.rotate());
           //SE ABRE EL DOCUMENTO
           documento.open();
           documento.add(parrafo);
           //SE CREA UN OBJETO TABLA DONDE SE PUEDAN GUARDAR LOS DATOS + TAMAÑO
           PdfPTable tabla = new PdfPTable(17);
           //SE LE COLOCAN TITULO A CADA UNA DE LAS COLUMNAS
           tabla.addCell("Semana");
           tabla.addCell("Fecha");
           tabla.addCell("Cedula de Identidad");
           tabla.addCell("Beneficiario");
           tabla.addCell("Banco");
           tabla.addCell("Numero de Cuenta");
           tabla.addCell("Tasa USD Semana");
           tabla.addCell("KG_Netos");
           tabla.addCell("KG_Brutos");
           tabla.addCell("Viajes");
           tabla.addCell("Materia Prima DS");
           tabla.addCell("Cuadrilla DS");
           tabla.addCell("Flete DS");
           tabla.addCell("Peaje DS");
           tabla.addCell("SubTotal DS");
           tabla.addCell("Anticipos DS");
           tabla.addCell("Total a Pagar DS");
           int registros = 0;
           try{
            int codigo;
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo_Proveedor FROM transacciones WHERE Semana = ? GROUP BY Codigo_Proveedor");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                registros++;
            }
            }catch(SQLException ex){
                Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
            }  
            for(int i = 0; i < registros; i++){
                tabla.addCell(datos[i][0].toString());
                tabla.addCell(datos[i][1].toString());
                tabla.addCell(datos[i][2].toString());
                tabla.addCell(datos[i][3].toString());
                tabla.addCell(datos[i][4].toString());
                tabla.addCell(datos[i][5].toString());
                tabla.addCell(datos[i][6].toString());
                tabla.addCell(datos[i][7].toString());
                tabla.addCell(datos[i][8].toString());
                tabla.addCell(datos[i][9].toString());
                tabla.addCell(datos[i][10].toString());
                tabla.addCell(datos[i][11].toString());
                tabla.addCell(datos[i][12].toString());
                tabla.addCell(datos[i][13].toString());
                tabla.addCell(datos[i][14].toString());
                tabla.addCell(datos[i][15].toString());
                tabla.addCell(datos[i][16].toString());            
            }
            documento.add(tabla);
            documento.close();
        }catch(Exception ex){
           Logger.getLogger(ODP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
