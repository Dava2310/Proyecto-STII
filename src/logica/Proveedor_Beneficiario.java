package logica;
import java.sql.*;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de la tabla de proveedor y beneficiario juntas.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */
public class Proveedor_Beneficiario {
    /**
     * El objecto conectate nos permite tener una conexión con la base de datos.
     */
    conectate con;
    
    /**
     * Constructor de la clase Proveedor_Beneficiario. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public Proveedor_Beneficiario(){
        con = new conectate();
    }
    
    /**
     * Este método permite crear una relación entre proveedor y beneficiario según sus códigos.
     * @param codigo_proveedor. Parámetro que aloja el código del proveedor.
     * @param cod_beneficiario. Parámetro que aloja el código del beneficiario.
     */
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
    
    /**
     * Esta función permite saber si se encuentra un proveedor en la tabla de Proveedor_Beneficiario.
     * @param codigo. Código del proveedor con el cuál se desea realizar la búsqueda.
     * @return Devuelve <i>true</i> si el proveedor ha sido encontrado, de lo contrario devuelve <i>false</i>
     */
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
    
    /**
     * Este método permite sobre escribir una relación en la tabla de proveedor_beneficiaario. Más exactamente, cambia al beneficiario de un proveedor.
     * @param codigo_proveedor. Código del proveedor.
     * @param cod_beneficiario,. Código del beneficiario.
     */
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
