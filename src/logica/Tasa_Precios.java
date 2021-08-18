package logica;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de la tabla de Tasa de Precios.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */
public class Tasa_Precios {
    /**
     * El objeto conectate nos permite tener una conexión con la base de datos.
     */
    private final conectate con;
    
    /**
     * Constructor de la clase Tasa_Precios. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public Tasa_Precios(){
        con = new conectate();
    }
    
    /**
     * Este método permite añadir un nuevo registro de montos en la tabla de Tasa_Precios en la base de datos.
     * @param Materia_Seca. Parámetro del porcentaje de materia seca.
     * @param Planta. El monto en planta.
     * @param Corte. El monto en corte.
     * @throws SQLException 
     */
    public void NuevaTasaPrecios(int Materia_Seca, float Planta, float Corte) throws SQLException {
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into" + 
                    " Tasa_Precios(Materia_Seca, En_Planta, En_Corte)" + " values(?,?,?)")) {
                pstm.setInt(1, Materia_Seca);
                pstm.setFloat(2, Planta);
                pstm.setFloat(3, Corte);
                pstm.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    /**
     * Este método permite actualizar los datos de una cierta equivalencia de un registro de la tabla Tasa_Precios en la base de datos.
     * @param Planta. Monto en Planta.
     * @param Corte. Monto en Corte.
     * @param Materia_Seca. Monto del porcentaje de materia seca.
     * @throws SQLException 
     */
    public void updateTasaPrecios(float Planta, float Corte, int Materia_Seca) throws SQLException{
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tasa_Precios " +
                    " set En_Planta = ?, En_Corte = ? WHERE Materia_Seca = ?")) {
                pstm.setFloat(1, Planta);
                pstm.setFloat(2, Corte);
                pstm.setInt(3, Materia_Seca);
                pstm.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Permite saber cuántos registros totales hay en la tabla de Tasa_Precios en la base de datos.
     * @return Devuelve un <i>entero</i> que guarda la cantidad de registros totales.
     */
    public int cantidad_tasas (){
        int registro = 0;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_Precios");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registro = res.getInt("total");
            }                                
        } catch (SQLException ex) {
            //Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);    
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return registro;
    }
    
    /**
     * Esta función nos permite recoger todos los datos de todos los registros en la tabla Tasa_Precios de la base de datos.
     * @return Devuelve una <i>matriz</i> de tipo <i>Objeto</i>, la cual aloja todos los datos de los registros.
     * @throws SQLException 
     */
    public Object[][] getDatos() throws SQLException{
        int registro = 0;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_Precios");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registro = res.getInt("total");
            }                                
        } catch (SQLException ex) {
            //Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);    
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
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
        } catch (SQLException ex) {
            //Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);    
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    /**
     * Esta función nos permite saber si un monto de materia seca está ingresado en la tabla de Tasa_Precios.
     * @param Materia_Seca. Monto del porcentaje de materia seca que se desea buscar.
     * @return Devuelve <i>true</i> si el porcentaje de materia seca se encontró en la tabla de la base de datos, de lo contrario devuelve <i>false</i>
     */
    public boolean encontrarMS(int Materia_Seca){
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Materia_Seca FROM Tasa_Precios WHERE Materia_Seca = ?");
            pstm.setInt(1, Materia_Seca);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            }
        }catch(SQLException ex){
            //Logger.getLogger(Tasa_Precios.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return encontrado;
    }
    
}
