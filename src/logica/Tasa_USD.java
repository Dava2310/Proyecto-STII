package logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.DecimalFormat;
public class Tasa_USD {
    conectate con;
    public Tasa_USD(){
        con = new conectate();
    }
    
    public void NuevaTasa(String Semana, double Monto ) throws SQLException{
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" + 
                    " Tasa_USD(Semana, Monto)" + " values(?,?)");
            pstm.setString(1, Semana);
            pstm.setDouble(2, Monto);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }    
    }
    
    public double valorUltimaTasa(){
        double valor = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM Tasa_USD ORDER BY Cod_Tasa DESC");
            ResultSet res = pstm.executeQuery();
            res.next();
            valor = res.getDouble("Monto");
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return valor;
    }
    
    public double tasaSemana(String semana){
        double valor = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Monto FROM Tasa_USD WHERE Semana = ?");
            pstm.setString(1, semana);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                valor = res.getDouble("Monto");
                res.close();
            }
        }catch(SQLException ex){
            Logger.getLogger(Tasa_USD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
    public void UpdateTasa(double Monto, int Cod_Tasa){
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tasa_USD set Monto = ? where Cod_Tasa = ?");
            pstm.setDouble(1, Monto);
            pstm.setInt(2, Cod_Tasa);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
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
    
    public int codigoSiguiente() throws SQLException{
        int codigo = 1;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_tasa from Tasa_USD ORDER BY Cod_tasa DESC");
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Cod_tasa");
                codigo++;
            }
        } catch (Exception ex) {
            Logger.getLogger(Tasa_USD.class.getName()).log(Level.SEVERE, null, ex);
        }
         return codigo;
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
        Object[][] data = new Object[registros][3];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                  " Cod_Tasa, Semana, Monto " + 
                  " FROM Tasa_USD " + 
                  " ORDER BY Cod_Tasa DESC");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCod_Tasa = res.getInt("Cod_Tasa");
                String estSemana = res.getString("Semana");
                double estMonto = res.getDouble("Monto");
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(10);
                String monto = df.format(estMonto);
                System.out.println(monto);
                data[i][0] = estCod_Tasa;
                data[i][1] = estSemana;
                data[i][2] = monto;
                i++;
            }
        }catch(SQLException ex){
          Logger.getLogger(Tasa_USD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    
}
