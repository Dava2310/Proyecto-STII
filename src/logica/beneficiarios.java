package logica;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de la tabla de Beneficiarios.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */
public class beneficiarios {
    
    /**
     * El objeto conectate nos permite tener una conexión con la base de datos.
     */
    private final conectate con;
    
    /**
     * Constructor de la clase beneficiarios. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public beneficiarios(){
        con = new conectate();
    }
    
    /**
     * Este método permite añadir un nuevo registro de beneficiario en la tabla de beneficiarios en la Base de Datos.
     * @param name_beneficiario
     * @param id_beneficiario
     * @param mail_beneficiario
     * @param banco
     * @param num_cuenta
     * @param tipo_cuenta
     * @param mod_cuenta
     * @param nombre_autorizado
     * @param id_autorizado
     * @throws SQLException 
     */
    public void NuevoBeneficiario(String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado)
    throws SQLException{
        try{
            try (PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO beneficiarios(Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado) " +
                    " values(?,?,?,?,?,?,?,?,?)")) {
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
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Esta función nos permite saber cuántos registros existen en total en la Base de Datos en la tabla de beneficiarios.
     * @return Devuelve un <i>Entero</i> que aloja la cantidad de registros existentes.
     */
    public int cantidadRegistros(){
        int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM beneficiarios");
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
     * Esta función nos permite buscar todos los datos de todos los registros de la tabla de beneficiarios.
     * @return Devuelve una <i>Matriz</i> de tipo <i>Objeto</i> donde se guardan los datos.
     */
    public Object[][] getDatos(){
        int registros = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM beneficiarios");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    /**
     * Esta función nos permite buscar un beneficiario según su cédula o identificación.
     * @param identificacion
     * @return Devuelve <i>true</i> si el beneficiario ha sido encontrado, de lo contrario devuelve <i>false</i>.
     */
    public boolean buscarBeneficiario(String identificacion){
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM beneficiarios WHERE ID_Beneficiario = ?");
            pstm.setString(1, identificacion);
            try (ResultSet res = pstm.executeQuery()) {
                if(res.next()){
                    encontrado = true;
                    //System.out.println("lo encontro");
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return encontrado;
    }
    
    /**
     * Esta función nos permite guardar el siguiente código disponible para guardar a un nuevo registro en la tabla de beneficiarios.
     * @return Devuelve un <i>Entero</i> en dónde se aloja el código disponible.
     * @throws SQLException 
     */
    public int codigoSiguiente() throws SQLException{
        int codigo = 1;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Beneficiario from beneficiarios ORDER BY Cod_Beneficiario DESC");
            try (ResultSet res = pstm.executeQuery()) {
                if(res.next()){
                    codigo = res.getInt("Cod_Beneficiario");
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return codigo;
    }
    
    /**
     * Esta función nos permite saber qué codigo asignado tiene un beneficiario según la identificación.
     * @param identificacion
     * @return Devuelve el código del beneficiario si lo encontró, de lo contrario devuelve 0.
     */
    public int retornaCodigo(String identificacion){
        int codigo = 0;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Cod_Beneficiario FROM beneficiarios WHERE ID_Beneficiario = ?");
            pstm.setString(1, identificacion);
            try (ResultSet res = pstm.executeQuery()) {
                if(res.next()){
                    codigo = res.getInt("Cod_Beneficiario");
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return codigo;
    }
    
    /**
     * Este método nos permite hacer una actualización de todos los datos de un beneficiario en específico, usando su código en la búsqueda.
     * @param Cod_Beneficiario
     * @param name_beneficiario
     * @param id_beneficiario
     * @param mail_beneficiario
     * @param banco
     * @param num_cuenta
     * @param tipo_cuenta
     * @param mod_cuenta
     * @param nombre_autorizado
     * @param id_autorizado 
     */
    public void updateBeneficiario(int Cod_Beneficiario, String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado){
        try{
            try (PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE beneficiarios " + 
                    " set Name_Beneficiario = ? , " +
                    " ID_Beneficiario = ? , " +
                    " Mail_Beneficiario = ? , " +
                    " Banco = ? , " +
                    " Num_Cuenta = ? , " +
                    " Tipo_Cuenta = ? , " + 
                    " MOD_Cuenta = ? , " +
                    " Nombre_Autorizado = ? , " +
                    " ID_Autorizado = ? " +
                    " where Cod_Beneficiario = ?")) {
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
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Devuelve la información principal de un solo beneficiario, cédula, nombre, banco y numero de cuenta, correspondiente a un cierto código de proveedor.
     * @param codigo_proveedor
     * @return 
     */
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
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
}
