package logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class Tasa_Precios {
    conectate con;
    public Tasa_Precios(){
        con = new conectate();
    }
    
    public void NuevaTasaPrecios(int Materia_Seca, float Planta, float Corte) throws SQLException {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" + 
                    " Tasa_Precios(Materia_Seca, En_Planta, En_Corte)" + " values(?,?,?)");
            pstm.setInt(1, Materia_Seca);
            pstm.setFloat(2, Planta);
            pstm.setFloat(3, Corte);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public void updateTasaPrecios(float Planta, float Corte, int Materia_Seca) throws SQLException{
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tasa_Precios " +
                    " set En_Planta = ?, En_Corte = ? WHERE Materia_Seca = ?");
            pstm.setFloat(1, Planta);
            pstm.setFloat(2, Corte);
            pstm.setInt(3, Materia_Seca);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public int cantidad_tasas (){
        int registro = 0;
        
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_Precios");
            ResultSet res = pstm.executeQuery();
            res.next();
            registro = res.getInt("total");
            res.close();                                
        } catch (SQLException e) {
            Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);    
        }
        return registro;
    }
    public Object[][] getDatos() throws SQLException{
        int registro = 0;
        
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_Precios");
            ResultSet res = pstm.executeQuery();
            res.next();
            registro = res.getInt("total");
            res.close();                                
        } catch (SQLException e) {
            Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);    
        }
        
        Object[][] data = new Object[registro][3];
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
                    " Materia_Seca, En_Planta, En_Corte " +
                    " FROM Tasa_Precios " +
                    " ORDER BY Materia_Seca ASC");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estMateria_Seca = res.getInt("Materia_Seca");
                float estEn_Planta = res.getFloat("En_Planta");
                float estEn_Corte = res.getFloat("En_Corte");
                data[i][0] = estMateria_Seca;
                data[i][1] = estEn_Planta;
                data[i][2] = estEn_Corte;
                i++;
            }
               
        } catch (SQLException e) {
            Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);    
        }
        return data;
    }
    
    public boolean encontrarMS(int Materia_Seca){
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Materia_Seca FROM Tasa_Precios WHERE Materia_Seca = ?");
            pstm.setInt(1, Materia_Seca);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            }
        }catch(SQLException e){
            Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);
        }
        return encontrado;
    }
    
}
