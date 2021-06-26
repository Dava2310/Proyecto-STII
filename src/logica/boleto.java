package logica;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class boleto {
    conectate con;
    
    public boleto(){
        //CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    //ESTA FUNCION NOS PERMITE CREAR UN NUEVO BOLETO EN LA BASE DE DATOS
    public void NuevoBoleto(String codigo, String nombre, String fecha, String semana, float Kg_Brutos, float Kg_Netos, int Materia_S, int Impurezas, int Cantidad_Transacciones, String Observaciones)
    throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "boleto(Codigo_Boleto, Nombre, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Cantidad_Transacciones, Observaciones) " +
                      " values(?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, codigo);
            pstm.setString(2, nombre);
            pstm.setString(3, fecha);
            pstm.setString(4, semana);
            pstm.setFloat(5, Kg_Brutos);
            pstm.setFloat(6, Kg_Netos);
            pstm.setInt(7, Materia_S);
            pstm.setInt(8, Impurezas);
            pstm.setString(9, String.valueOf(Cantidad_Transacciones));
            pstm.setString(10, Observaciones);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA BOTENER DATOS DE TODOS LOS BOLETOS
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla.
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM boleto");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new Object[registros][10];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
                    "Codigo_Boleto, Nombre, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Cantidad_Transacciones, Observaciones " +
                    " FROM boleto " +
                    " ORDER BY Codigo_Boleto");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estCodigo = res.getString("Codigo_Boleto");
                String estNombre = res.getString("Nombre");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                float estKg_Brutos = res.getFloat("Kg_Brutos");
                float estKg_Netos = res.getFloat("Kg_Netos");
                int estMateria_S = res.getInt("Materia_S");
                int estImpurezas = res.getInt("Impurezas");
                int estCantidad_Transaccioens = res.getInt("Cantidad_Transacciones");
                String estObservaciones = res.getString("Observaciones");
                //Ingresando todos los datos
                data[i][0] = estCodigo;
                data[i][1] = estNombre;
                data[i][2] = estFecha;
                data[i][3] = estSemana;
                data[i][4] = estKg_Brutos;
                data[i][5] = estKg_Netos;
                data[i][6] = estMateria_S;
                data[i][7] = estImpurezas;
                data[i][8] = estCantidad_Transaccioens;
                data[i][9] = estObservaciones;
                i++;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    /*
        UNA FUNCION DE BUSQUEDA QUE ME RETORNE SI ESTE BOLETO ESTA EN EL SISTEMA
    */
    public boolean buscarBoleto(String codigo) throws SQLException{
        boolean encontrado = false;
        
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * from boleto where Codigo_Boleto = ?");
            pstm.setString(1, codigo);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            }
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado;
    }
    
    /*
        UNA FUNCION QUE ME DIGA CUANTAS TRANSACCIONES EXISTEN POR ESTE BOLETO
    */
    public int cantidadTransacciones_Boleto(String codigo) throws SQLException{
        int cantidad_Transacciones = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cantidad_Transacciones from boleto where Codigo_Boleto = ?");
            pstm.setString(1, codigo);
            ResultSet res = pstm.executeQuery();
            res.next();
            cantidad_Transacciones = res.getInt("Cantidad_Transacciones");
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cantidad_Transacciones;
    }
    
    
    /*
        UNA FUNCION QUE ME HAGA EL UPDATE DE LAS CANTIDADES DE TRANSACCIONES
    */
    
    public void updateCantidad_Transacciones(String codigo, int cantidad_transacciones) throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE boleto " + 
                    " set Cantidad_Transacciones = ? " +
                    " where Codigo_Boleto = ?");
            pstm.setInt(1, cantidad_transacciones);
            pstm.setString(2, codigo);
            pstm.execute();
            pstm.close();
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        FUNCION QUE NOS PERMITE HACER UN UPDATE COMPLETO DEL BOLETO
    */
    public void updateBoleto(String codigo, String fecha, String nombre, String semana,
            float KgBrutos, float KgNetos, int MS, int Impurezas, String Observaciones) throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE boleto " +
                    " set Fecha = ? , " +
                    " Nombre = ? , " +
                    " Semana = ? , " +
                    " Kg_Brutos = ? , " + 
                    " Kg_Netos = ? , " +
                    " Materia_S = ? , " +
                    " Impurezas = ? , " + 
                    " Observaciones = ? " + 
                    " where Codigo_Boleto = ?");
            pstm.setString(1, fecha);
            pstm.setString(2, nombre);
            pstm.setString(3, semana);
            pstm.setFloat(4, KgBrutos);
            pstm.setFloat(5, KgNetos);
            pstm.setInt(6, MS);
            pstm.setInt(7, Impurezas);
            pstm.setString(8, Observaciones);
            pstm.setString(9, codigo);
            pstm.execute();
            pstm.close();
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
        FUNCION PARA OBTENER LOS DATOS DE UN SOLO BOLETO
    */
    public Object[] conseguirDatos(String codigo) throws SQLException{
        Object[] data = new Object[10];
        Object[] data2 = new Object[10];
        PreparedStatement pstm;
        ResultSet res;
        try{
            pstm = con.getConnection().prepareStatement("SELECT " +
                    " Codigo_Boleto, Nombre, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Cantidad_Transacciones, Observaciones " + 
                    " FROM boleto " +
                    " WHERE Codigo_Boleto = ?");
            pstm.setString(1, codigo);
            res = pstm.executeQuery();
            res.next();
            data2 = informacion(res, data);
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data2;
    }
    
    private Object[] informacion(ResultSet res, Object[] data) throws SQLException{
        try{
            String estCodigo = res.getString("Codigo_Boleto");
            String estNombre = res.getString("Nombre");
            String estFecha = res.getString("Fecha");
            String estSemana = res.getString("Semana");
            float estKg_Brutos = res.getFloat("Kg_Brutos");
            float estKg_Netos = res.getFloat("Kg_Netos");
            int estMateria_S = res.getInt("Materia_S");
            int estImpurezas = res.getInt("Impurezas");
            int estCantidad_Transaccioens = res.getInt("Cantidad_Transacciones");
            String estObservaciones = res.getString("Observaciones");
            //Ingresando todos los datos en el vector[] data
            data[0] = estCodigo;
            data[1] = estNombre;
            data[2] = estFecha;
            data[3] = estSemana;
            data[4] = estKg_Brutos;
            data[5] = estKg_Netos;
            data[6] = estMateria_S;
            data[7] = estImpurezas;
            data[8] = estCantidad_Transaccioens; 
            data[9] = estObservaciones;
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
