package logica;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de la tabla de Tasa de Dolar.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */
public class Tasa_USD {
    /**
     * El objeto conectate nos permite tener una conexión con la base de datos.
     */
    private final conectate con;
    
    /**
     * Constructor de la clase Tasa_USD. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public Tasa_USD(){
        con = new conectate();
    }
    
    /**
     * Este método permite ingresar un nuevo registro en la tabla de Tasa_USD en la Base de Datos.
     * @param Semana. Parámetro de la semana.
     * @param Monto. Parámetro del monto en BS que representa 1$ USD
     * @throws SQLException 
     */
    public void NuevaTasa(String Semana, double Monto ) throws SQLException{
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into" + 
                    " Tasa_USD(Semana, Monto)" + " values(?,?)")) {
                pstm.setString(1, Semana);
                pstm.setDouble(2, Monto);
                pstm.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    /**
     * Este método permite encontrar cuál es el valor de 1$ USD según la última tasa de la Base de Datos.
     * @return Devuelve un <i>double</i> que contiene el monto de la tasa.
     */
    public double valorUltimaTasa(){
        double valor = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM Tasa_USD ORDER BY Cod_Tasa DESC");
            ResultSet res = pstm.executeQuery();
            res.next();
            valor = res.getDouble("Monto");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return valor;
    }
    
    /**
     * Permite encontrar el monto de una según una específica semana.
     * @param semana. Parámetro para la semana de la tasa.
     * @return Devuelve un <i>double</i> que contiene el monto de la tasa.
     */
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return valor;
    }
    
    /**
     * Este método permite actualizar el monto de una tasa.
     * @param Monto. Monto nuevo deseado.
     * @param Cod_Tasa. Código de la tasa a la cual se le modificará el monto.
     */
    public void UpdateTasa(double Monto, int Cod_Tasa){
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tasa_USD set Monto = ? where Cod_Tasa = ?")) {
                pstm.setDouble(1, Monto);
                pstm.setInt(2, Cod_Tasa);
                pstm.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Esta función permite obtener la cantidad de cuántos registros hay existentes en la base de datos en la tabla de Tasa_USD.
     * @return Devuelve un <i>Entero</i> que guarda la cantidad de registros.
     */
    public int obtenerRegistros(){
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS (TASAS) EN LA TABLA DE TASAS_USD
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_USD");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return registros;
    }
    
    /**
     * Esta función permite retornar el código siguiente disponible que se puede usar para un nuevo registro en la tabla de Tasa_USD.
     * @return Devuelve un <i>Entero</i> donde se aloja el siguiente código entero disponible.
     * @throws SQLException 
     */
    public int codigoSiguiente() throws SQLException{
        int codigo = 1;
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_tasa from Tasa_USD ORDER BY Cod_tasa DESC");
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Cod_tasa");
                codigo++;
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         return codigo;
    }
    
    /**
     * Permite obtener todos los datos existentes de los registros en la tabla Tasa_USD de la base de datos.
     * @return Devuelve una <i>Matriz</i> de tipo <i>Objeto</i> en dónde se alojan todos los datos de los registros existentes.
      * @throws SQLException 
     */
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS (TASAS) EN LA TABLA DE TASAS_USD
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tasa_USD");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
}
