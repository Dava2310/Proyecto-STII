package logica;
import java.sql.*;
/**
 *
 * @author DANIEL
 */
public class beneficiarios {
    conectate con;
    
    public beneficiarios(){
        con = new conectate();
    }
    
    public void NuevoBeneficiario(String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado, int cod_proveedor)
    throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO beneficiarios(Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado, Cod_Proveedor) " +
                    " values(?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, name_beneficiario);
            pstm.setString(2, id_beneficiario);
            pstm.setString(3, mail_beneficiario);
            pstm.setString(4, banco);
            pstm.setString(5, num_cuenta);
            pstm.setString(6, tipo_cuenta);
            pstm.setString(7, mod_cuenta);
            pstm.setString(8, nombre_autorizado);
            pstm.setString(9, id_autorizado);
            pstm.setInt(10, cod_proveedor);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
