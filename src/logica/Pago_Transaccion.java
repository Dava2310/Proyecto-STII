package logica;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pago_Transaccion {
    conectate con;
    
    public Pago_Transaccion(){
        con = new conectate();
    }
    
    public void crearRelacion(int Codigo_ODP, int ID_Transaccion){
        try (PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO Pago_Transaccion(Codigo_ODP, Codigo_Transaccion) values(?,?)")) {
            pstm.setInt(1, Codigo_ODP);
            pstm.setInt(2, ID_Transaccion);
            pstm.execute();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);       
        }
    }
}
