package logica;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado)
    throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO beneficiarios(Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado) " +
                    " values(?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, name_beneficiario);
            pstm.setString(2, id_beneficiario);
            pstm.setString(3, mail_beneficiario);
            pstm.setString(4, banco);
            pstm.setString(5, num_cuenta);
            pstm.setString(6, tipo_cuenta);
            pstm.setString(7, mod_cuenta);
            pstm.setString(8, nombre_autorizado);
            pstm.setString(9, id_autorizado);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public int cantidadRegistros(){
        int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM beneficiarios");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    public Object[][] getDatos(){
        int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM beneficiarios");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[][] data = new Object[registros][10];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Beneficiario, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado " +
                    " FROM beneficiarios " +
                    " ORDER BY Cod_Beneficiario");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCod_Beneficiario = res.getInt("Cod_Beneficiario");
                String estName_Beneficiario = res.getString("Name_Beneficiario");
                String estID_Beneficiario = res.getString("ID_Beneficiario");
                String estMail_Beneficiario = res.getString("Mail_Beneficiario");
                String estBanco = res.getString("Banco");
                String estNum_Cuenta = res.getString("Num_Cuenta");
                String estTipo_Cuenta = res.getString("Tipo_Cuenta");
                String estMOD_Cuenta = res.getString("MOD_Cuenta");
                String estNombre_Autorizado = res.getString("Nombre_Autorizado");
                String estID_Autorizado = res.getString("ID_Autorizado");
                data[i][0] = estCod_Beneficiario;
                data[i][1] = estName_Beneficiario;
                data[i][2] = estID_Beneficiario;
                data[i][3] = estMail_Beneficiario;
                data[i][4] = estBanco;
                data[i][5] = estNum_Cuenta;
                data[i][6] = estTipo_Cuenta;
                data[i][7] = estMOD_Cuenta;
                data[i][8] = estNombre_Autorizado;
                data[i][9] = estID_Autorizado;
                i++;
            }
        }catch(SQLException ex){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public boolean buscarBeneficiario(String identificacion){
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM beneficiarios WHERE ID_Beneficiario = ?");
            pstm.setString(1, identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return encontrado;
    }
    
    public int codigoSiguiente() throws SQLException{
        int codigo = 1;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Beneficiario from beneficiarios ORDER BY Cod_Beneficiario DESC");
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Cod_Beneficiario");
            }
            res.close();
        }catch(SQLException ex){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
    
    public int retornaCodigo(String identificacion){
        int codigo = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Beneficiario FROM beneficiarios WHERE ID_Beneficiario = ?");
            pstm.setString(1, identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Cod_Beneficiario");
            }
            res.close();
        }catch(SQLException e){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, e);
        }
        return codigo;
    }
    
    public void updateBeneficiario(int Cod_Beneficiario, String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE beneficiarios " + 
                    " set Name_Beneficiario = ? , " + 
                    " ID_Beneficiario = ? , " + 
                    " Mail_Beneficiario = ? , " + 
                    " Banco = ? , " + 
                    " Num_Cuenta = ? , " + 
                    " Tipo_Cuenta = ? , " + 
                    " MOD_Cuenta = ? , " +
                    " Nombre_Autorizado = ? , " + 
                    " ID_Autorizado = ? " + 
                    " where Cod_Beneficiario = ?");
            pstm.setString(1, name_beneficiario);
            pstm.setString(2, id_beneficiario);
            pstm.setString(3, mail_beneficiario);
            pstm.setString(4, banco);
            pstm.setString(5, num_cuenta);
            pstm.setString(6, tipo_cuenta);
            pstm.setString(7, mod_cuenta);
            pstm.setString(8, nombre_autorizado);
            pstm.setString(9, id_autorizado);
            pstm.setInt(10, Cod_Beneficiario);
            pstm.execute();
            pstm.close();
        }catch(SQLException ex){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[] informacionBeneficiario_ParaODP(int codigo_proveedor){
        Object[] data = new Object[4];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT proveedor.Codigo, beneficiarios.Cod_Beneficiario, beneficiarios.ID_Beneficiario, beneficiarios.Name_Beneficiario, beneficiarios.Banco, beneficiarios.Num_cuenta, Relacion_Proveedor_Beneficiario.Cod_Bnf, Relacion_Proveedor_Beneficiario.Cod_Proveedor "
                    + " FROM beneficiarios, Relacion_Proveedor_Beneficiario, proveedor "
                    + " WHERE Relacion_Proveedor_Beneficiario.Cod_Bnf = beneficiarios.Cod_Beneficiario "
                    + " AND proveedor.Codigo = Relacion_Proveedor_Beneficiario.Cod_Proveedor "
                    + " AND proveedor.Codigo = ?");
            pstm.setInt(1, codigo_proveedor);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                String estID_Beneficiario = res.getString("ID_Beneficiario");
                String estName_Beneficiario = res.getString("Name_Beneficiario");
                String estBanco = res.getString("Banco");
                String estNum_cuenta = res.getString("Num_cuenta");
                data[0] = estID_Beneficiario;
                data[1] = estName_Beneficiario;
                data[2] = estBanco;
                data[3] = estNum_cuenta;
            } else {
                data[0] = " ";
                data[1] = " ";
                data[2] = " ";
                data[3] = " ";
            }
        }catch(SQLException ex){
            Logger.getLogger(beneficiarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
