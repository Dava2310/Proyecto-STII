package logica;
import java.sql.*;
public class Proveedor_Beneficiario {
    conectate con;
    
    public Proveedor_Beneficiario(){
        con = new conectate();
    }
    
    public void crear_relacion(int codigo_proveedor, int cod_beneficiario){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO Relacion_Proveedor_Beneficiario(Cod_Bnf, Cod_Proveedor) values(?,?)");
            pstm.setInt(1, cod_beneficiario);
            pstm.setInt(2, codigo_proveedor);
            pstm.execute();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
