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
    
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM Tarifa_Estandar");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] data = new Object[registros][8];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Cod_Tarifa, Cuadrilla, Flete, Peaje, Materia_Prima, Fecha_Inicio, Fecha_Final, Estado " + 
                    " FROM Tarifa_Estandar " +
                    " ORDER BY Cod_Tarifa");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCod_Tarifa = res.getInt("Cod_Tarifa");
                float estCuadrilla = res.getFloat("Cuadrilla");
                float estFlete = res.getFloat("Flete");
                int estPeaje = res.getInt("Peaje");
                String estMateria_Prima = res.getString("Materia_Prima");
                String estFecha_Inicio = res.getString("Fecha_Inicio");
                String estFecha_Final = res.getString("Fecha_Final");
                String estEstado = res.getString("Estado");
                //INGRESAMOS TODOS LOS DATOS EN LA MATRIZ OBJECT[][]
                data[i][0] = estCod_Tarifa;
                data[i][1] = estCuadrilla;
                data[i][2] = estFlete;
                data[i][3] = estPeaje;
                data[i][4] = estMateria_Prima;
                data[i][5] = estFecha_Inicio;
                data[i][6] = estFecha_Final;
                data[i][7] = estEstado;
                i++;
            }
        }catch(SQLException ex){
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
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
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deshacerVigencia(String fecha) throws SQLException{
        try {
            PreparedStatement pstm_busqueda = con.getConnection().prepareStatement("SELECT Estado FROM Tarifa_Estandar where Estado = ?");
            pstm_busqueda.setString(1, "VIGENTE");
            ResultSet res = pstm_busqueda.executeQuery();
            if(res.next()){
                PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Tarifa_Estandar set Estado = ?, Fecha_Final = ? where Estado = ?");
                pstm.setString(1, "NO VIGENTE");
                pstm.setString(2, fecha);
                pstm.setString(3, "VIGENTE");
                pstm.execute();
                pstm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] obtenerUltimaTarifa(){
        Object[] data = new Object[4];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Tarifa, Cuadrilla, Flete, Peaje FROM Tarifa_Estandar where Estado = ?");
            pstm.setString(1, "VIGENTE");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                data[0] = res.getInt("Cod_Tarifa");
                data[1] = res.getFloat("Cuadrilla");
                data[2] = res.getFloat("Flete");
                data[3] = res.getInt("Peaje");
            }
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(Tarifa_Estandar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
