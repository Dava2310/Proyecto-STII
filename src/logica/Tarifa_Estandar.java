package logica;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Tarifa_Estandar {
    conectate con;
    
    public Tarifa_Estandar(){
        // CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    public void crearTarifa(float Cuadrilla, float Flete, int Peaje, String Materia_Prima, String Fecha_I, String Fecha_F) throws SQLException{
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO Tarifa_Estandar(Cuadrilla, Flete, Peaje, Materia_Prima, Fecha_Inicio, Fecha_Final) values(?,?,?,?,?,?)");
            pstm.setFloat(1, Cuadrilla);
            pstm.setFloat(2, Flete);
            pstm.setInt(3, Peaje);
            pstm.setString(4, Materia_Prima);
            pstm.setString(5, Fecha_I);
            pstm.setString(6, Fecha_F);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deshacerVigencia(){
        try {
            PreparedStatement pstm_busqueda = con.getConnection().prepareStatement("SELECT Estado FROM Tarifa_Estandar where Estado = ?");
            pstm_busqueda.setString(1, "VIGENTE");
            ResultSet res = pstm_busqueda.executeQuery();
            if(res.next()){
                PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tarifa_Estandar set Estado = ? where Estado = ?");
                pstm.setString(1, "NO VIGENTE");
                pstm.setString(2, "VIGENTE");
                pstm.execute();
                pstm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
