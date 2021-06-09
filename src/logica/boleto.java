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
    public void NuevoBoleto(String codigo, String fecha, String semana, float Kg_Brutos, float Kg_Netos, int Materia_S, int Impurezas, int Cantidad_Transacciones){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into "
                    + "boleto(Codigo, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Cantidad_Transacciones) " +
                      " values(?,?,?,?,?,?,?,?)");
            pstm.setString(1, codigo);
            pstm.setString(2, fecha);
            pstm.setString(3, semana);
            pstm.setString(4, String.valueOf(Kg_Brutos));
            pstm.setString(5, String.valueOf(Kg_Netos));
            pstm.setString(6, String.valueOf(Materia_S));
            pstm.setString(7, String.valueOf(Impurezas));
            pstm.setString(8, String.valueOf(Cantidad_Transacciones));
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA BOTENER DATOS DE TODOS LOS BOLETOS
    public Object[][] getDatos(){
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla.
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) ast total FROM boleto");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new String[registros][8];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
                    "Codigo, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Cantidad_Transacciones " +
                    " FROM boleto " +
                    " ORDER BY Codigo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estCodigo = res.getString("Codigo");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                int estKg_Brutos = res.getInt("Kg_Brutos");
                int estKg_Netos = res.getInt("Kg_Netos");
                float estMateria_S = res.getFloat("Materia_S");
                float estImpurezas = res.getFloat("Impurezas");
                int estCantidad_Transaccioens = res.getInt("Cantidad_Transacciones");
                //Ingresando todos los datos
                data[i][0] = estCodigo;
                data[i][1] = estFecha;
                data[i][2] = estSemana;
                data[i][3] = String.valueOf(estKg_Brutos);
                data[i][4] = String.valueOf(estKg_Netos);
                data[i][5] = String.valueOf(estMateria_S);
                data[i][6] = String.valueOf(estImpurezas);
                data[i][7] = String.valueOf(estCantidad_Transaccioens);
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
    public boolean buscarBoleto(String codigo){
        boolean encontrado = false;
        
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * from boleto where Codigo = ?");
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
    public int cantidadTransacciones_Boleto(String codigo){
        int cantidad_Transacciones = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cantidad_Transacciones from boleto where Codigo = ?");
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
    
    public void updateCantidad_Transacciones(String codigo, int cantidad_transacciones){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE boleto " + 
                    " set Cantidad_Transacciones = ? " +
                    " where Codigo = ?");
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
    public void updateBoleto(String codigo, String fecha, String semana,
            float KgBrutos, float KgNetos, int MS, int Impurezas){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE boleto " +
                    " set Fecha = ? , " +
                    " Semana = ? , " +
                    " Kg_Brutos = ? , " + 
                    " Kg_Netos = ? , " +
                    " Materia_S = ? , " +
                    " Impurezas = ? " + 
                    " where Codigo = ?");
            pstm.setString(1, fecha);
            pstm.setString(2, semana);
            pstm.setFloat(3, KgBrutos);
            pstm.setFloat(4, KgNetos);
            pstm.setInt(5, MS);
            pstm.setInt(6, Impurezas);
            pstm.setString(7, codigo);
            pstm.execute();
            pstm.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "NO SE PUDO REALIZAR EL UPDATE DE BOLETO", "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
        FUNCION PARA OBTENER LOS DATOS DE UN SOLO BOLETO
    */
    public Object[] conseguirDatos(String codigo){
        Object[] data = new Object[8];
        Object[] data2 = new Object[8];
        PreparedStatement pstm;
        ResultSet res;
        try{
            pstm = con.getConnection().prepareStatement("SELECT " +
                    " Codigo, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Cantidad_Transacciones " + 
                    " FROM boleto " +
                    " WHERE Codigo = ?");
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
    
    private Object[] informacion(ResultSet res, Object[] data){
        try{
            String estCodigo = res.getString("Codigo");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                float estKg_Brutos = res.getFloat("Kg_Brutos");
                float estKg_Netos = res.getFloat("Kg_Netos");
                int estMateria_S = res.getInt("Materia_S");
                int estImpurezas = res.getInt("Impurezas");
                int estCantidad_Transaccioens = res.getInt("Cantidad_Transacciones");
                //Ingresando todos los datos en el vector[] data
                data[0] = estCodigo;
                data[1] = estFecha;
                data[2] = estSemana;
                data[3] = estKg_Brutos;
                data[4] = estKg_Netos;
                data[5] = estMateria_S;
                data[6] = estImpurezas;
                data[7] = estCantidad_Transaccioens; 
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
