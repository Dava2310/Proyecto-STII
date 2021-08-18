package logica;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de la Tarifa Estandar.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */
public class Tarifa_Estandar {
    /**
     * El objeto conectate nos permite tener una conexión con la base de datos.
     */
    private final conectate con;
    
    /**
     * Constructor de la clase Tarifa_Estandar. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public Tarifa_Estandar(){
        // CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    /**
     * Esta función permite saber cuántas tarifas existen en la base de datos.
     * @return Devuelve un <i>Entero</i>, que representa la cantidad de registros en la tabla de Tarifa_Estandar.
     */
    public int cantidad_tarifa(){
         int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tarifa_Estandar");
             try (ResultSet res = pstm.executeQuery()) {
                 res.next();
                 registros = res.getInt("total");
             }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    /**
     * Esta función permite buscar todos los datos de la tabla de Tarifa_Estandar en la base de datos.
     * @return Devuelve en una <i>matriz</i> de tipo <b>Objeto</b>, todos los datos de la tabla de Tarifa_Estandar
     * @throws SQLException 
     */
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tarifa_Estandar");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        }catch(SQLException ex){
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        Object[][] data = new Object[registros][7];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Cod_Tarifa, Cuadrilla, Flete, Materia_Prima, Fecha_Inicio, Fecha_Final, Estado " + 
                    " FROM Tarifa_Estandar " +
                    " ORDER BY Cod_Tarifa");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCod_Tarifa = res.getInt("Cod_Tarifa");
                float estCuadrilla = res.getFloat("Cuadrilla");
                float estFlete = res.getFloat("Flete");
                String estMateria_Prima = res.getString("Materia_Prima");
                String estFecha_Inicio = res.getString("Fecha_Inicio");
                String estFecha_Final = res.getString("Fecha_Final");
                String estEstado = res.getString("Estado");
                //INGRESAMOS TODOS LOS DATOS EN LA MATRIZ OBJECT[][]
                data[i][0] = estCod_Tarifa;
                data[i][1] = estCuadrilla;
                data[i][2] = estFlete;
                data[i][3] = estMateria_Prima;
                data[i][4] = estFecha_Inicio;
                data[i][5] = estFecha_Final;
                data[i][6] = estEstado;
                i++;
            }
        }catch(SQLException ex){
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    /**
     * Este método permite crear en la base de datos un nuevo registro en la tabla de Tarifa_Estandar.
     * @param Cuadrilla. Parámetro del monto de cuadrilla.
     * @param Flete. Parámetro del monto de flete.
     * @param Materia_Prima. Parámetro del monto de materia prima.
     * @param Fecha_I. Parámetro de la fecha de inicio cuándo se creó la tarifa.
     * @param Fecha_F. Parámetro de la fecha final dónde termina la validez de esta tarifa. Por default, la asigna en 00:00:00.
     * @throws SQLException 
     */
    public void crearTarifa(float Cuadrilla, float Flete, String Materia_Prima, String Fecha_I, String Fecha_F) throws SQLException{
        try {
            try (PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO Tarifa_Estandar(Cuadrilla, Flete, Materia_Prima, Fecha_Inicio, Fecha_Final) values(?,?,?,?,?)")) {
                pstm.setFloat(1, Cuadrilla);
                pstm.setFloat(2, Flete);
                pstm.setString(3, Materia_Prima);
                pstm.setString(4, Fecha_I);
                pstm.setString(5, Fecha_F);
                pstm.execute();
            }
            actualizarTarifas_Proveedores();
        } catch (SQLException ex) {
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Este método permite actualizar la tarifa estandar a todos aquellos proveedores que estén asignados a la tarifa estándar.
     */
    private void actualizarTarifas_Proveedores(){
        Object[] data;
        try {
            data = obtenerUltimaTarifa();
            try (PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor set Cuadrilla = ?, Flete = ?, Cod_Tarifa = ? where Cod_Tarifa != ?")) {
                pstm.setFloat(1, Float.parseFloat(data[1].toString()));
                pstm.setFloat(2, Float.parseFloat(data[2].toString()));
                pstm.setInt(3, Integer.parseInt(data[0].toString()));
                pstm.setInt(4, 0);
                pstm.execute();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Este método permite hacer que la última tarifa estándar vigente ya no sea vigente, al momento de haber creado una nueva.
     * @param fecha. Parámetro de la fecha final.
     * @throws SQLException 
     */
    public void deshacerVigencia(String fecha) throws SQLException{
        try {
            PreparedStatement pstm_busqueda = con.getConnection().prepareStatement("SELECT Estado FROM Tarifa_Estandar where Estado = ?");
            pstm_busqueda.setString(1, "VIGENTE");
            ResultSet res = pstm_busqueda.executeQuery();
            if(res.next()){
                try (PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tarifa_Estandar set Estado = ?, Fecha_Final = ? where Estado = ?")) {
                    pstm.setString(1, "NO VIGENTE");
                    pstm.setString(2, fecha);
                    pstm.setString(3, "VIGENTE");
                    pstm.execute();
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Esta función permite obtener los datos de la ultima tarifa estándar creada y vigente en el sistema.
     * @return Devuelve en un <i>vector</i> de tipo <i>Objeto</i>, los datos de la última tarifa vigente, únicamente los montos y su código.
     */
    public Object[] obtenerUltimaTarifa(){
        Object[] data = new Object[3];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Tarifa, Cuadrilla, Flete FROM Tarifa_Estandar where Estado = ?");
            pstm.setString(1, "VIGENTE");
            try (ResultSet res = pstm.executeQuery()) {
                while(res.next()){
                    data[0] = res.getInt("Cod_Tarifa");
                    data[1] = res.getFloat("Cuadrilla");
                    data[2] = res.getFloat("Flete");
                }
            }
        }catch(SQLException ex){
            //Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    
}
