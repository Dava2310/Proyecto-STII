package logica;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de la tabla de Anticipos.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */
public class anticipos {
    
    /**
     * El objeto conectate nos permite tener una conexión con la base de datos.
     */
    private final conectate con;
    
    /**
     * Constructor de la clase Anticipos. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public anticipos(){
        con = new conectate();
    }
    
    /**
     * Este método permite ingresar un nuevo registro en la tabla Anticipos dentro de la Base de Datos.
     * @param motivo_anticipo
     * @param fecha
     * @param semana
     * @param monto_bs
     * @param monto_ds
     * @param aprobacion
     * @param observaciones
     * @param DescontarODP
     * @param codigo_proveedor
     * @param cod_tasa
     * @throws SQLException 
     */
    public void NuevoAnticipo(String motivo_anticipo, String fecha, String semana, double monto_bs, double monto_ds, String aprobacion, String observaciones, String DescontarODP, int codigo_proveedor, int cod_tasa)
    throws SQLException{
        try{
            try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " anticipos(Motivo_Anticipo, Fecha, Semana, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Codigo_Tasa)" +
                    " values(?,?,?,?,?,?,?,?,?,?)")) {
                pstm.setString(1, motivo_anticipo);
                pstm.setString(2, fecha);
                pstm.setString(3, semana);
                pstm.setDouble(4, monto_bs);
                pstm.setDouble(5, monto_ds);
                pstm.setString(6, aprobacion);
                pstm.setString(7, observaciones);
                pstm.setString(8, DescontarODP);
                pstm.setInt(9, codigo_proveedor);
                pstm.setInt(10, cod_tasa);
                pstm.execute();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Esta función permite saber cuántos registros existen en la base de datos dentro de la tabla Anticipos.
     * @return Devuelve un <i>Entero</i> que aloja la cantidad de registros.
     */
    public int Cantidad_ANT(){
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS EXISTENTES EN LA TABLA DE ANTICIPOS
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM anticipos");
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
     * Función para obtener datos de todos los anticipos realizados en la Base de Datos.
     * @return Devuelve una <i>Matriz</i> de tipo <i>Objeto</i> donde se alojan todos los datos de los registros de anticipos.
     * @throws SQLException 
     */
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS EXISTENTES EN LA TABLA DE ANTICIPOS
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM anticipos");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        Object[][] data = new Object[registros][13];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
                    " Num_Anticipo, Motivo_Anticipo, Fecha, Semana, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Codigo_Tasa " +
                    " FROM anticipos "+
                    " ORDER BY Num_Anticipo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estNum_Anticipo = res.getInt("Num_Anticipo");
                String estMotivo_Anticipo = res.getString("Motivo_Anticipo");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                double estMonto_BS = res.getDouble("Monto_BS");
                double estMonto_DS = res.getDouble("Monto_DS");
                String estAprobacion = res.getString("Aprobacion");
                String estObservaciones = res.getString("Observaciones");
                String estDescontarODP = res.getString("DescontarODP");
                int estCodigo_Proveedor = res.getInt("Codigo_Proveedor");
                int estCodigo_Tasa = res.getInt("Codigo_Tasa");
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT proveedor.Razon_Social, proveedor.Identificacion, proveedor.Codigo " +
                        " FROM anticipos, proveedor " + 
                        " WHERE proveedor.Codigo = " + estCodigo_Proveedor);
                ResultSet res2 = pstm2.executeQuery();
                //SE INGRESAN LOS DATOS EN LA POSICION i del vector
                //TODAS LAS DEMAS POSICIONES REPRESENTAN LOS DATOS DE LOS PROVEEDORES
                data[i][0] = estNum_Anticipo;
                data[i][1] = estMotivo_Anticipo;
                data[i][2] = estFecha;
                data[i][3] = estSemana;
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(10);
                data[i][4] = df.format(estMonto_BS);
                data[i][5] = df.format(estMonto_DS);
                data[i][6] = estAprobacion;
                data[i][7] = estObservaciones;
                data[i][8] = estDescontarODP;
                data[i][9] = estCodigo_Proveedor;  
                data[i][10] = estCodigo_Tasa;
                if(res2.next()){
                    String estRazon_Social = res2.getString("Razon_Social");
                    String estIdentificacion = res2.getString("Identificacion");
                    data[i][11] = estRazon_Social;
                    data[i][12] = estIdentificacion;
                }
                i++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    /**
     * Esta función nos permite saber cuál es el próximo código disponible para los anticipos en la base de datos, que se colocará a un nuevo registro.
     * @return Devuelve un <i>Entero</i>, dónde se aloja el código.
     * @throws SQLException 
     */
    public int codigoSiguiente() throws SQLException{
        int codigo = 1;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Num_Anticipo from anticipos ORDER BY Num_Anticipo DESC");
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Num_Anticipo");
                codigo++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return codigo;
    }
    
    /**
     * Este método nos permite eliminar éxitosamente un registro en la tabla anticipos, según su código.
     * @param num_anticipo.
     * @throws SQLException 
     */
    public void deleteAnticipo(String num_anticipo) throws SQLException{
        try{
            try (PreparedStatement pstm = con.getConnection().prepareStatement("delete from anticipos where Num_Anticipo = ?")) {
                pstm.setString(1, num_anticipo);
                pstm.execute();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Esta función nos permite hacer una actualización de todos los datos de un anticipo en específico.
     * @param motivo_anticipo
     * @param fecha
     * @param semana
     * @param monto_bs
     * @param monto_ds
     * @param aprobacion
     * @param observaciones
     * @param DescontarODP
     * @param codigo_proveedor
     * @param cod_tasa
     * @param num_anticipo. Código del anticipo al cuál se le hará la actualización de datos.
     * @throws SQLException 
     */
    public void updateAnticipo (String motivo_anticipo, String fecha, String semana, double monto_bs, double monto_ds, String aprobacion, String observaciones, String DescontarODP, int codigo_proveedor, int cod_tasa, int num_anticipo)
    throws SQLException{
        try{
            try (PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE anticipos" +
                    " set Motivo_Anticipo = ?, Fecha = ?, Semana = ?, Monto_BS = ?, Monto_DS = ?, Aprobacion = ?, Observaciones = ?, DescontarODP = ?, Codigo_Proveedor = ?, Codigo_Tasa = ? "
                    + " where Num_Anticipo = ?")) {
                pstm.setString(1, motivo_anticipo);
                pstm.setString(2, fecha);
                pstm.setString(3, semana);
                pstm.setDouble(4, monto_bs);
                pstm.setDouble(5, monto_ds);
                pstm.setString(6, aprobacion);
                pstm.setString(7, observaciones);
                pstm.setString(8, DescontarODP);
                pstm.setInt(9, codigo_proveedor);
                pstm.setInt(10, cod_tasa);
                pstm.setInt(11, num_anticipo);
                pstm.execute();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Función para realizar una busqueda de un anticipo. 
     * @param num_anticipo
     * @return Únicamente devuelve <i>true</i> si encontró el anticipo con el parámetro ingresado, de lo contrario devuelve <i>false</i>.
     * @throws SQLException 
     */
    public boolean buscarAnticipo(int num_anticipo) throws SQLException{
        boolean encontrado = false;
        try{
            try (PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM anticipos where Num_Anticipo = ?")) {
                pstm.setInt(1, num_anticipo);
                try (ResultSet res = pstm.executeQuery()) {
                    if(res.next()){
                        encontrado = true;
                    }
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return encontrado;
    }
    
    /**
     * Esta función es para retornar los datos del anticipo en específico.
     * @param num_anticipo. Código del anticipo.
     * @return Devuelve un <i>vector</i> de tipo <i>Objeto</i>, en el cual se alojan todos los datos del anticipo que se haya encontrado.
     * @throws SQLException 
     */
    //
    public Object[] conseguirDatos(int num_anticipo) throws SQLException{
        Object[] data = new Object[13];
        Object[] data2 = new Object[13];
        PreparedStatement pstm;
        ResultSet res;
        try{
            //CONSEGUIR LOS DATOS A TRAVES DEL NUM_ANTICIPO
            pstm = con.getConnection().prepareStatement("SELECT " + 
            " Num_Anticipo, Motivo_Anticipo, Fecha, Semana, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Codigo_Tasa " +
            " FROM anticipos " +
            " WHERE Num_Anticipo = ?");
            pstm.setInt(1, num_anticipo);
            res = pstm.executeQuery();
            data2 = informacion(res, data);
            res.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data2;
    }
    
    /**
     * Función que le sirve a conseguirDatos para alojar en un vector todos los datos de la coincidencia de búsqueda en la base de datos.
     * @param res. ResultSet dónde se guarda el registro buscado.
     * @param data. El vector dónde se guardarán los datos. 
     * @return Devuelve el vector con los datos.
     */
    private Object[] informacion(ResultSet res, Object[] data){
        try{
            while(res.next()){
                int estNum_Anticipo = res.getInt("Num_Anticipo");
                String estMotivo_Anticipo = res.getString("Motivo_Anticipo");
                String estFecha = res.getString("Fecha");
                String estSemana = res.getString("Semana");
                String estMonto_BS = res.getString("Monto_BS");
                String estMonto_DS = res.getString("Monto_DS");
                String estAprobacion = res.getString("Aprobacion");
                String estObservaciones = res.getString("Observaciones");
                String estDescontarODP = res.getString("DescontarODP");
                int estCodigo_Proveedor = res.getInt("Codigo_Proveedor");
                int estCodigo_Tasa = res.getInt("Codigo_Tasa");
                //INGRESANDO TODOS LOS DATOS EN EL VECTOR DATA[]
                data[0] = estNum_Anticipo;
                data[1] = estMotivo_Anticipo;
                data[2] = estFecha;
                data[3] = estSemana;
                data[4] = estMonto_BS;
                data[5] = estMonto_DS;
                data[6] = estAprobacion;
                data[7] = estObservaciones;
                data[8] = estDescontarODP;
                data[9] = estCodigo_Proveedor;
                data[10] = estCodigo_Tasa;
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT proveedor.Razon_Social, proveedor.Identificacion, proveedor.Codigo " +
                        " FROM anticipos, proveedor " + 
                        " WHERE proveedor.Codigo = " + estCodigo_Proveedor);
                ResultSet res2 = pstm2.executeQuery();
                if(res2.next()){
                    String estRazon_Social = res2.getString("Razon_Social");
                    String estIdentificacion = res2.getString("Identificacion");
                    data[11] = estRazon_Social;
                    data[12] = estIdentificacion;
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
    
    /**
     * Esta función nos permite guardar el monto tanto en BS como DS de un cierto proveedor y en una cierta semana.
     * @param semana
     * @param codigo_proveedor
     * @return Devuelve un <i>vector</i> de tipo <i>Dobule</i> en dónde se encuentran los datos. Posición 0: BS, Posición 1: DS.
     */
    public double[] anticipos_Proveedor_Semana(String semana, int codigo_proveedor){
        double[] montos_anticipo = new double[2];
        montos_anticipo[0] = 0; //BS
        montos_anticipo[1] = 0; //DS
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT anticipos.Num_Anticipo, anticipos.Monto_DS, anticipos.Monto_BS, anticipos.Codigo_Proveedor, proveedor.Codigo, anticipos.Semana, anticipos.DescontarODP "
                    + " from anticipos, proveedor "
                    + " WHERE anticipos.Codigo_Proveedor = proveedor.Codigo "
                    + " AND proveedor.Codigo = ? "
                    + " AND anticipos.Semana = ? "
                    + " AND anticipos.DescontarODP = 'SI'");
            pstm.setInt(1, codigo_proveedor);
            pstm.setString(2, semana);
            try (ResultSet res = pstm.executeQuery()) {
                while(res.next()){
                    montos_anticipo[0] += res.getDouble("Monto_BS");
                    montos_anticipo[1] += res.getDouble("Monto_DS");  
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return montos_anticipo;
    }
    
    /**
     * Nos permite saber en que index debemos colocar un ComboBox según el motivo del anticipo.
     * @param motivo
     * @return Devuelve un <i>Entero</i> en este caso el index del ComboBox correspondiente al motivo del anticipo ingreasado.
     */
    public int motivoAnticipo(String motivo){
        int index = 0;
        switch (motivo) {
            case "Materia Prima":
                index = 0;
                break;
            case "Adicional":
                index = 1;
                break;
            case "Peaje":
                index = 2;
                break;
            case "Otros":
                index = 3;
                break;
            default:
                break;
        }
        return index;
    }
    
    /**
     * Nos permite saber en que index debemos colocar un ComboBox según el dato DescontarODP.
     * @param ODP
     * @return Devuelve un <i>Entero</i> en este caso el index del ComboBox correspondiente al dato DescontarODP
     */
    public int descontarODP(String ODP){
        int index = 0;
        if(ODP.equals("SI")){
            index = 0;
        } else if(ODP.equals("NO")){
            index = 1;
        }
        return index;
    }
}
