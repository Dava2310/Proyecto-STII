package logica;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class transacciones {
    conectate con;
    
    public transacciones(){
        //CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    public void NuevaTransaccion(String Num_Boleto, String semana,
            String Materia_Prima, String Cuadrilla, String Flete, String Peaje, String Estado_Transaccion,  
            String Observaciones, String Codigo_Proveedor) throws SQLException {
        
        //INICIO DE LA FUNCION Y QUERY
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " transacciones(Num_Boleto, Semana, Materia_Prima, Cuadrilla, Flete, Peaje, Estado_Transaccion, Observaciones, Codigo_Proveedor)" + 
                    " values(?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, Num_Boleto);
            pstm.setString(2, semana);
            pstm.setString(3, Materia_Prima);
            pstm.setString(4, Cuadrilla);
            pstm.setString(5, Flete);
            pstm.setString(6, Peaje);
            pstm.setString(7, Estado_Transaccion);
            pstm.setString(8, Observaciones);
            pstm.setString(9, Codigo_Proveedor);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA OBTENER DATOS DE TODAS LAS TRANSACCIONES
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        //OBTENEMOS LA CANTIDAD DE REGISTROS EXISTENTES EN LA TABLA DE TRANSACCIONES
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM transacciones");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new String[registros][9];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Num_Boleto, Semana, Materia_Prima, Cuadrilla, Flete, Peaje, Estado_Transaccion, Observaciones, Codigo_Proveedor " + 
                    " FROM transacciones " + 
                    " ORDER BY Num_Boleto");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estNum_Transaccion = res.getString("Num_Boleto");
                String estSemana = res.getString("Semana");
                String estMateria_Prima = res.getString("Materia_Prima");
                String estCuadrilla = res.getString("Cuadrilla");
                String estFlete = res.getString("Flete");
                String estPeaje = res.getString("Peaje");
                String estEstado = res.getString("Estado_Transaccion");
                String estObservaciones = res.getString("Observaciones");
                String estCodigo_Proveedor = res.getString("Codigo_Proveedor");
                //Ingresando todos los datos en el object[][] data.
                data[i][0] = estNum_Transaccion;
                data[i][1] = estSemana;
                data[i][2] = estMateria_Prima;
                data[i][3] = estCuadrilla;
                data[i][4] = estFlete;
                data[i][5] = estPeaje;
                data[i][6] = estEstado;
                data[i][7] = estObservaciones;
                data[i][8] = estCodigo_Proveedor;
                i++;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    //FUNCION PARA BUSCAR UNA TRANSACCION CON EL DATO DE Num_Transaccion EN LA BASE DE DATOS
    //RETORNA UN TRUE SI ENCONTRO, RETORNA UN FALSE SI NO ENCONTRO
    //FUNCIONA PARA QUE PODAMOS AGREGAR UNA NUEVA TRANSACCION CON UN CODIGO DISTINTO
    public boolean buscarTransaccion(String Num_Transaccion) throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        try{
            pstm = con.getConnection().prepareStatement("SELECT * FROM transacciones where Num_Boleto = ?");
            pstm.setString(1, Num_Transaccion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } 
            res.close();
        }catch(SQLException e){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        return encontrado;
    }
    
    /*
        La busqueda por ahora sera estatica.
	Esto quiere decir que se va a buscar un boleto que tenga todos siguientes datos:
	Codigo de Proveedor.
	Identificacion de Proveedor.
        Razon social de proveedor.
	Numero de Boleto.
	Fecha de boleto.
	Semana de boleto.
    */
    public Object[] busquedaEstatica(String CodigoProveedor, String ID_Proveedor, String Razon_Social, String Num_Boleto, String Fecha_Boleto, String Semana_Boleto)
    throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        Object[] data = new Object[10];
        Object[] data2 = new Object[10];
        try{
            //Podemos usar primero una busqueda por el Numero de Boleto para saber si hay alguno
            pstm = con.getConnection().prepareStatement("SELECT * FROM transacciones where Num_Boleto = ?");
            pstm.setString(1, Num_Boleto);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } 
            res.close();          
        }catch(SQLException e){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        if(encontrado){
            try {
                pstm = con.getConnection().prepareStatement("SELECT * FROM transacciones where" +
                        " Num_Boleto = ? and" +
                        " Fecha = ? and" +
                        " Semana = ? and "+
                        " Codigo_Proveedor = ?");
                pstm.setString(1, Num_Boleto);
                pstm.setString(2, Fecha_Boleto);
                pstm.setString(3, Semana_Boleto);
                pstm.setString(4, CodigoProveedor);
                ResultSet res2 = pstm.executeQuery();
                data2 = informacion(res2, data);
                res2.close();
            } catch (SQLException ex) {
                Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data2;
    }
    
    /*
        FUNCION QUE LE SIRVE A BUSQUEDA ESTATICA PARA DEVOLVER TODOS LOS DATOS DE LA TRANSACCION BUSCADA
        SE LE INGRESA EL OBJETO VECTOR DATA PARA GUARDAR ALLÍ LOS DATOS
        Y LA RESULTSET QUE ES DONDE SE GUARDA EL RESULTADO DE LA QUERY DE SQL
    */
    public Object[] informacion(ResultSet res, Object[] data){
        try{
            while(res.next()){
                String estID_Transaccion = res.getString("ID_Transaccion");
                String estNum_Transaccion = res.getString("Num_Boleto");
                String estSemana = res.getString("Semana");
                String estMateria_Prima = res.getString("Materia_Prima");
                String estCuadrilla = res.getString("Cuadrilla");
                String estFlete = res.getString("Flete");
                String estPeaje = res.getString("Peaje");
                String estEstado = res.getString("Estado_Transaccion");
                String estObservaciones = res.getString("Observaciones");
                String estCodigo_Proveedor = res.getString("Codigo_Proveedor");
                //INGRESANDO TODOS LOS DATOS EN EL VECTOR DATA[]
                data[0] = estID_Transaccion;
                data[1] = estNum_Transaccion;
                data[2] = estSemana;
                data[3] = estMateria_Prima;
                data[4] = estCuadrilla;
                data[5] = estFlete;
                data[6] = estPeaje;
                data[7] = estEstado;
                data[8] = estObservaciones;
                data[9] = estCodigo_Proveedor;
            }
        }catch(SQLException ex){
            Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /*
        QUERY PARA RETORNAR UN TRUE O FALSE SI DE UN CIERTO BOLETO
        SE ENCUENTRA UNA TRANSACION DE CUADRILLA
    */
    public boolean transaccionCuadrilla(String codigo_boleto) throws SQLException{
        boolean transaccionEncontrada = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.Cuadrilla "
                    + " FROM transacciones "
                    + " WHERE transacciones.Num_Boleto = ?");
            pstm.setString(1, codigo_boleto);
            ResultSet res = pstm.executeQuery();
            while(res.next() && !transaccionEncontrada){
                String verificacionCuadrilla = res.getString("Cuadrilla");
                if(verificacionCuadrilla.equals("SI")){
                    transaccionEncontrada = true;
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionEncontrada;
    }
    
    /*
        QUERY PARA RETORNAR UN TRUE O FALSE SI DE UN CIERTO BOLETO
        SE ENCUENTRA UNA TRANSACION DE MATERIA_PRIMA
    */
    public boolean transaccionMateria_Prima(String codigo_boleto) throws SQLException{
        boolean transaccionEncontrada = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.Materia_Prima "
                    + " FROM transacciones "
                    + " WHERE transacciones.Num_Boleto = ?");
            pstm.setString(1, codigo_boleto);
            ResultSet res = pstm.executeQuery();
            while(res.next() && !transaccionEncontrada){
                String verificacionCuadrilla = res.getString("Materia_Prima");
                if(verificacionCuadrilla.equals("SI")){
                    transaccionEncontrada = true;
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionEncontrada;
    }
    
    /*
        QUERY PARA RETORNAR UN TRUE O FALSE SI DE UN CIERTO BOLETO
        SE ENCUENTRA UNA TRANSACION DE FLETE
    */
    public boolean transaccionFlete(String codigo_boleto) throws SQLException{
        boolean transaccionEncontrada = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.Flete "
                    + " FROM transacciones "
                    + " WHERE transacciones.Num_Boleto = ?");
            pstm.setString(1, codigo_boleto);
            ResultSet res = pstm.executeQuery();
            while(res.next() && !transaccionEncontrada){
                String verificacionCuadrilla = res.getString("Flete");
                if(verificacionCuadrilla.equals("SI")){
                    transaccionEncontrada = true;
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionEncontrada;
    }
    
    /*
        QUERY PARA RETORNAR UN TRUE O FALSE SI DE UN CIERTO BOLETO
        SE ENCUENTRA UNA TRANSACION DE PEAJE
    */
    public boolean transaccionPeaje(String codigo_boleto) throws SQLException{
        boolean transaccionEncontrada = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT transacciones.Peaje "
                    + " FROM transacciones "
                    + " WHERE transacciones.Num_Boleto = ?");
            pstm.setString(1, codigo_boleto);
            ResultSet res = pstm.executeQuery();
            while(res.next() && !transaccionEncontrada){
                String verificacionCuadrilla = res.getString("Peaje");
                if(verificacionCuadrilla.equals("SI")){
                    transaccionEncontrada = true;
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(transacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transaccionEncontrada;
    }
}
