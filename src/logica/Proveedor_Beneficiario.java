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
            pstm.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public boolean encontrarProveedor(int codigo){
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Proveedor from Relacion_Proveedor_Beneficiario where Cod_Proveedor = ?");
            pstm.setInt(1, codigo);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            }
            res.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return encontrado;
    }
    
    public void updateRelacion(int codigo_proveedor, int cod_beneficiario){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE Relacion_Proveedor_Beneficiario set Cod_Bnf = ? where Cod_Proveedor = ?");
            pstm.setInt(1, cod_beneficiario);
            pstm.setInt(2, codigo_proveedor);
            pstm.execute();
            pstm.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
