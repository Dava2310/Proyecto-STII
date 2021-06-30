package logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ODP {
    
    private conectate con;
    private Tasa_USD tasa_USD = new Tasa_USD();
    public ODP(){
        con = new conectate();
    }
    
    
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
    
    public double[][] generarODP_Materia_Prima(String semana){
        ArrayList<Integer> codigos = this.proveedoresMateriaPrima(semana);
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.valorUltimaTasa();
        double[][] cantidad_por_proveedores = new double[codigos.size()][2];
        try{
            for(int i = 0; i < codigos.size(); i++){
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
                System.out.println(codigos.get(i));
                pstm2.setInt(1, codigos.get(i));
                //System.out.println(codigos.get(i));
                pstm2.setString(2, semana);
                ResultSet res2 = pstm2.executeQuery();
                while(res2.next()){
                    float estEn_Planta = res2.getFloat("En_Planta");
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
    
    public double[][] ODP_Cuadrilla (String semana) {
        ArrayList<Integer> codigos = this.proveedoresCuadrilla(semana);
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.valorUltimaTasa();
        double[][] cantidad_por_proveedores = new double[codigos.size()][2];
        try{
            for(int i = 0; i < codigos.size(); i++){
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
                System.out.println(codigos.get(i));
                pstm2.setInt(1, codigos.get(i));
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
    
    public double[][] ODP_Flete (String semana) {
        ArrayList<Integer> codigos = this.proveedoresFlete(semana);
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.valorUltimaTasa();
        double[][] cantidad_por_proveedores = new double[codigos.size()][2];
        try{
            for(int i = 0; i < codigos.size(); i++){
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
                System.out.println(codigos.get(i));
                pstm2.setInt(1, codigos.get(i));
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
    
    public double[][] ODP_Peaje(String semana){
        ArrayList<Integer> codigos = this.proveedoresPeaje(semana);
        float cantidad = 0;
        double cantidad_BS = 0;
        double valorTasa_USD = tasa_USD.valorUltimaTasa();
        double[][] cantidad_por_proveedores = new double[codigos.size()][2];
        try{
            for(int i = 0; i < codigos.size(); i++){
                int peaje = 0;
                cantidad = 0;
                cantidad_BS = 0;
                int cantidad_boletos = 0;
                System.out.println(codigos.get(i));
                PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.ID_Transaccion, transacciones.Num_Boleto, transacciones.Semana, transacciones.Estado_Transaccion, transacciones.Codigo_Proveedor, transacciones.Peaje, boleto.Codigo_Boleto, proveedor.Codigo, proveedor.Razon_Social, proveedor.Identificacion, proveedor.Peaje as Peaje_Proveedor " +
                        " FROM proveedor, boleto, transacciones " +
                        " WHERE transacciones.Codigo_Proveedor = proveedor.Codigo AND " +
                        " transacciones.Semana = ? AND proveedor.Codigo = ? AND " +
                        " transacciones.Peaje = 'SI' AND " +
                        " transacciones.Estado_Transaccion = 'No Procesada' AND" +
                        " transacciones.Num_Boleto = boleto.Codigo_Boleto " +
                        " ORDER BY proveedor.Codigo ASC");
                pstm.setString(1, semana);
                pstm.setInt(2, codigos.get(i));
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
    
    public static void main(String args[]){
        
        ODP objeto = new ODP();
        double[][] matriz = objeto.ODP_Peaje("26-2021");
        for(int i = 0; i < 3; i++){
            System.out.println(matriz[i][0] + " cantidad DS");
            System.out.println(matriz[i][1] + " cantidad BS");
        }
        
    }
    
}
