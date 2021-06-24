package logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class Tasa_USD {
    conectate con;
    public Tasa_USD(){
        con = new conectate();
    }
    
    public int obtenerRegistros(){
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS (TASAS) EN LA TABLA DE TASAS_USD
        try{
          PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_USD");
          ResultSet res = pstm.executeQuery();
          res.next();
          registros = res.getInt("total");
          res.close();
        }catch(SQLException ex){
          Logger.getLogger(Tasa_USD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS (TASAS) EN LA TABLA DE TASAS_USD
        try{
          PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_USD");
          ResultSet res = pstm.executeQuery();
          res.next();
          registros = res.getInt("total");
          res.close();
        }catch(SQLException ex){
          Logger.getLogger(Tasa_USD.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] data = new Object[registros][5];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                  " Cod_Tasa, Fecha_I, Fecha_F, Semana, Monto " + 
                  " FROM Tasa_USD " + 
                  " ORDER BY Cod_Tasa");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCod_Tasa = res.getInt("Cod_Tasa");
                String estFecha_I = res.getString("Fecha_I");
                String estFecha_F = res.getString("Fecha_F");
                String estSemana = res.getString("Semana");
                double estMonto = res.getDouble("Monto");
                data[i][0] = estCod_Tasa;
                data[i][1] = estFecha_I;
                data[i][2] = estFecha_F;
                data[i][3] = estSemana;
                data[i][4] = estMonto;
                i++;
            }
        }catch(SQLException ex){
          Logger.getLogger(Tasa_USD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    
}
