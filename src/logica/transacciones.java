package logica;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class transacciones {
    conectate con;
    
    public transacciones(){
        //CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    public void NuevaTransaccion(String Num_Transaccion, String Fecha, String Semana, String Kg_Brutos, String Kg_Netos, String Materia_S,
            String Impurezas, String Materia_Prima, String Cuadrilla, String Flete, String Peaje, String Dias_Trabajados, String Ha_Ubicacion, 
            String USD_DIA, String USD_HA, String Observaciones, String Codigo_Proveedor){
        
        //INICIO DE LA FUNCION Y QUERY
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " transacciones(Num_Transaccion, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Materia_Prima, Cuadrilla, Flete, Peaje, Dias_Trabajados, Ha_Ubicacion, USD_DIA, USD_HA, Observaciones, Codigo_Proveedor)" + 
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, Num_Transaccion);
            pstm.setString(2, Fecha);
            pstm.setString(3, Semana);
            pstm.setString(4, Kg_Brutos);
            pstm.setString(5, Kg_Netos);
            pstm.setString(6, Materia_S);
            pstm.setString(7, Impurezas);
            pstm.setString(8, Materia_Prima);
            pstm.setString(9, Cuadrilla);
            pstm.setString(10, Flete);
            pstm.setString(11, Peaje);
            pstm.setString(12, Dias_Trabajados);
            pstm.setString(13, Ha_Ubicacion);
            pstm.setString(14, USD_DIA);
            pstm.setString(15, USD_HA);
            pstm.setString(16, Observaciones);
            pstm.setString(17, Codigo_Proveedor);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA OBTENER DATOS DE TODAS LAS TRANSACCIONES
    public Object[][] getDatos(){
        int registros = 0;
        //OBTENEMOS LA CANTIDAD DE REGISTROS EXISTENTES EN LA TABLA DE TRANSACCIONES
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM transacciones");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new String[registros][17];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Num_Transaccion, Fecha, Semana, Kg_Brutos, Kg_Netos, Materia_S, Impurezas, Materia_Prima, Cuadrilla, Flete, Peaje, Dias_Trabajados, Ha_Ubicacion, USD_DIA, USD_HA, Observaciones, Codigo_Proveedor " + 
                    " FROM transacciones " + 
                    " ORDER BY Num_Transaccion");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estNum_Transaccion = res.getString("Num_Transaccion");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                String estKg_Brutos = res.getString("Kg_Brutos");
                String estKg_Netos = res.getString("Kg_Netos");
                String estMateria_S = res.getString("Materia_S");
                String estImpurezas = res.getString("Impurezas");
                String estMateria_Prima = res.getString("Materia_Prima");
                String estCuadrilla = res.getString("Cuadrilla");
                String estFlete = res.getString("Flete");
                String estPeaje = res.getString("Peaje");
                String estDias_Trabajados = res.getString("Dias_Trabajados");
                String estHa_Ubicacion = res.getString("Ha_Ubicacion");
                String estUSD_DIA = res.getString("USD_DIA");
                String estUSD_HA = res.getString("USD_HA");
                String estObservaciones = res.getString("Observaciones");
                String estCodigo_Proveedor = res.getString("Codigo_Proveedor");
                //Ingresando todos los datos en el object[][] data.
                data[i][0] = estNum_Transaccion;
                data[i][1] = estFecha;
                data[i][2] = estSemana;
                data[i][3] = estKg_Brutos;
                data[i][4] = estKg_Netos;
                data[i][5] = estMateria_S;
                data[i][6] = estImpurezas;
                data[i][7] = estMateria_Prima;
                data[i][8] = estCuadrilla;
                data[i][9] = estFlete;
                data[i][10] = estPeaje;
                data[i][11] = estDias_Trabajados;
                data[i][12] = estHa_Ubicacion;
                data[i][13] = estUSD_DIA;
                data[i][14] = estUSD_HA;
                data[i][15] = estObservaciones;
                data[i][16] = estCodigo_Proveedor;
                i++;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
}
