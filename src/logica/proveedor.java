package logica;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class proveedor {
    conectate con;
    
    public proveedor(){
        con = new conectate();
    }
    
    public void NuevoProveedor(String codigo, String identificacion, String razon_social, String direccion, String telefono, String email, String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String moneda, String nombre_autorizado, String id_autorizado){
        
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " proveedor(Codigo, Identificacion, Razon_Social, Direccion, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_cuenta, Tipo_cuenta, MOD_Cuenta, Moneda, Nombre_Autorizado, ID_Autorizado)" + 
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, codigo);
            pstm.setString(2, identificacion);
            pstm.setString(3, razon_social);
            pstm.setString(4, direccion);
            pstm.setString(5, telefono);
            pstm.setString(6, email);
            pstm.setString(7, name_beneficiario);
            pstm.setString(8, id_beneficiario);
            pstm.setString(9, mail_beneficiario);
            pstm.setString(10, banco);
            pstm.setString(11, num_cuenta);
            pstm.setString(12, tipo_cuenta);
            pstm.setString(13, mod_cuenta);
            pstm.setString(14, moneda);
            pstm.setString(15,nombre_autorizado);
            pstm.setString(16,id_autorizado);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA OBTENER DATOS DE TODOS LOS PROVEEDORES
    public Object[][] getDatos(){
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM proveedor");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new String[registros][16];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Moneda, Nombre_Autorizado, ID_Autorizado " + 
                    " FROM proveedor " +
                    " ORDER BY Codigo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estCodigo = res.getString("Codigo");
                String estIdentificacion = res.getString("Identificacion");
                String estRazon_Social = res.getString("Razon_Social");
                String estDireccion = res.getString("Direccion");
                String estTelefono = res.getString("Telefono");
                String estEmail = res.getString("Email");
                String estName_Beneficiario = res.getString("Name_Beneficiario");
                String estID_Beneficiario = res.getString("ID_Beneficiario");
                String estMail_Beneficiario = res.getString("Mail_Beneficiario");
                String estBanco = res.getString("Banco");
                String estNum_Cuenta = res.getString("Num_Cuenta");
                String estTipo_Cuenta = res.getString("Tipo_Cuenta");
                String estMOD_Cuenta = res.getString("MOD_Cuenta");
                String estMoneda = res.getString("Moneda");
                String estNombre_Autorizado = res.getString("Nombre_Autorizado");
                String estID_Autorizado = res.getString("ID_Autorizado");
                //Ingresando todos los datos
                data[i][0] = estCodigo;
                data[i][1] = estIdentificacion;
                data[i][2] = estRazon_Social;
                data[i][3] = estDireccion;
                data[i][4] = estTelefono;
                data[i][5] = estEmail;
                data[i][6] = estName_Beneficiario;
                data[i][7] = estID_Beneficiario;
                data[i][8] = estMail_Beneficiario;
                data[i][9] = estBanco;
                data[i][10] = estNum_Cuenta;
                data[i][11] = estTipo_Cuenta;
                data[i][12] = estMOD_Cuenta;
                data[i][13] = estMoneda;
                data[i][14] = estNombre_Autorizado;
                data[i][15] = estID_Autorizado;
                i++;        
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    //FUNCION PARA ELIMINAR AL PROVEEDOR
    public void deleteProveedor(String cod){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from proveedor where Codigo = ?");
            pstm.setString(1, cod);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA ACTUALIZAR LOS DATOS DE UN PROVEEDOR
    public void updateProveedorCodigo(String codigo, String identificacion, String razon_social, String direccion, String telefono, String email, String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String moneda, String nombre_autorizado, String id_autorizado){
        
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor " + 
            " set Razon_Social = ? , " + 
            " Direccion = ? , " +
            " Telefono = ? , " +
            " Email = ? , " + 
            " Name_Beneficiario = ? , " +
            " ID_Beneficiario = ? , " + 
            " Mail_Beneficiario = ? , " + 
            " Banco = ? , " + 
            " Num_Cuenta = ? , " +
            " Tipo_Cuenta = ? , " + 
            " MOD_Cuenta = ? , " + 
            " Moneda = ? , " + 
            " Nombre_Autorizado = ? , " +
            " ID_Autorizado = ? " + 
            " where Codigo = ?");
            pstm.setString(1, razon_social);
            pstm.setString(2, direccion);
            pstm.setString(3, telefono);
            pstm.setString(4, email);
            pstm.setString(5, name_beneficiario);
            pstm.setString(6, id_beneficiario);
            pstm.setString(7, mail_beneficiario);
            pstm.setString(8, banco);
            pstm.setString(9, num_cuenta);
            pstm.setString(10, tipo_cuenta);
            pstm.setString(11, mod_cuenta);
            pstm.setString(12, moneda);
            pstm.setString(13, nombre_autorizado);
            pstm.setString(14, id_autorizado);
            pstm.setString(15, codigo);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA ENCONTRAR A UN PROVEEDOR SEGUN SU CEDULA
    //MANDA UN MENSAJE DE ERROR SI LOGRA ENCONTRAR A UN PROVEEDOR CON DICHA IDENTIFICACION
    //SIRVE UNICAMENTE PARA AGREGAR A UN PROVEEDOR
    public boolean buscarIdentificacion(String identificacion){
        boolean encontrado = false;
        PreparedStatement pstm;
        try {
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Identificacion = ?");
            pstm.setString(1,identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                JOptionPane.showMessageDialog(null, "YA EXISTE UN PROVEEDOR CON ESTA IDENTIFICACION", "BUSQUEDA DE PROVEEDOR", JOptionPane.PLAIN_MESSAGE);
                encontrado = true;
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado;
    }
    
    //FUNCION PARA BUSCAR A UN PROVEEDOR SEGUN SU IDENTIFICACION
    //MANDA UN MENSAJE DE ERROR SI NO LO ENCONTRO Y DEVUELVE FALSE
    //DEVUELVE TRUE SI LO ENCONTRO
    //SIRVE PARA HACER BUSQUEDAS, MODIFICAR O ELIMINAR
    public boolean buscarIdentificacion2(String identificacion){
        boolean encontrado = false;
        PreparedStatement pstm;
        try {
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Identificacion = ?");
            pstm.setString(1,identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE UN PROVEEDOR CON ESTA IDENTIFICACION", "BUSQUEDA DE PROVEEDOR", JOptionPane.PLAIN_MESSAGE);
                encontrado = false;
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado;
    }
    
    //FUNCION PARA BUSCAR A UN PROVEEDOR SEGUN SU CODIGO
    //MANDA UN MENSAJE DE ERROR SI NO LO ENCUENTRA
    //FUNCIONA TANTO PARA LA PANTALLA DE BUSQUEDA, COMO MODIFICAR Y ELIMINAR
    public boolean buscarCodigo(String codigo){
        boolean encontrado = false;
        PreparedStatement pstm;
        try{
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Codigo = ?");
            pstm.setString(1, codigo);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else{
                JOptionPane.showMessageDialog(null, "NO EXISTE NINGN PROVEEDOR CON ESTE CODIGO", "BUSQUEDA DE PROVEEDOR", JOptionPane.PLAIN_MESSAGE);
            }
            res.close();
        }catch(SQLException e){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        return encontrado;
    }
    
    //FUNCION PARA BUSCAR A UN PROVEEDOR SEGUN SU RAZON SOCIAL
    //FUNCIONA TANTO PARA LAS PANTALLAS DE BUSQUEDA, COMO DE MODIFICAR Y ELIMINAR
    public boolean buscarRazonSocial(String RS){
        boolean encontrado = false;
        PreparedStatement pstm;
        try{
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Razon_Social = ?");
            pstm.setString(1, RS);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE NINGN PROVEEDOR CON ESTA RAZON SOCIAL", "BUSQUEDA DE PROVEEDOR", JOptionPane.PLAIN_MESSAGE);
            }
            res.close();
        }catch(SQLException e){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        return encontrado;
    }
    
    //FUNCION PARA CONSEGUIR LOS DATOS DE UN ÚNICO PROVEEDOR
    public Object[] conseguirDatos(String codigo, String identificacion, String Razon_Social, int modo){
        Object[] data = new Object[16];
        Object[] data2 = new Object[16];
        PreparedStatement pstm;
        ResultSet res;
        try{
            //Conseguir datos habiendo buscado por codigo
            if(modo == 1){
               pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Moneda, Nombre_Autorizado, ID_Autorizado " + 
                    " FROM proveedor " +
                    " WHERE Codigo = ?");
               pstm.setString(1, codigo); 
               res = pstm.executeQuery();
               data2 = informacion(res,data);
               res.close();
               //Conseguir datos habiendo buscado por identificacion
            } else if (modo == 2){
                //BUSQUEDA POR IDENTIFICACION
                pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Moneda, Nombre_Autorizado, ID_Autorizado " + 
                    " FROM proveedor " +
                    " WHERE Identificacion = ?");
                pstm.setString(1, identificacion);
                res = pstm.executeQuery();
                data2 = informacion(res,data);
                res.close();
                //Conseguir datos habiendo buscado por razon social
            } else if (modo == 3){
                //BUSQUEDA POR RAZON_SOCIAL
                pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Moneda, Nombre_Autorizado, ID_Autorizado " + 
                    " FROM proveedor " +
                    " WHERE Razon_Social = ?");
                pstm.setString(1, Razon_Social);
                res = pstm.executeQuery();
                data2 = informacion(res, data);
                res.close();
            }   
        }catch(SQLException e){
            System.out.println(e);
        }
        return data2;
    }
    
    //FUNCION QUE LE SIRVE a conseguirDatos() PARA DEVOVLER CADA UNO DE LOS DATOS
    //SE LE INGRESA EL OBJETO VECTOR DATA PARA GUARDAR ALLÍ LOS DATOS
    //Y LA RESULTSET QUE ES DONDE SE GUARDA EL RESULTADO DE LA QUERY DE SQL
    public Object[] informacion(ResultSet res, Object[] data){
        try {
            while(res.next()){
                String estCodigo = res.getString("Codigo");
                String estIdentificacion = res.getString("Identificacion");
                String estRazon_Social = res.getString("Razon_Social");
                String estDireccion = res.getString("Direccion");
                String estTelefono = res.getString("Telefono");
                String estEmail = res.getString("Email");
                String estName_Beneficiario = res.getString("Name_Beneficiario");
                String estID_Beneficiario = res.getString("ID_Beneficiario");
                String estMail_Beneficiario = res.getString("Mail_Beneficiario");
                String estBanco = res.getString("Banco");
                String estNum_Cuenta = res.getString("Num_Cuenta");
                String estTipo_Cuenta = res.getString("Tipo_Cuenta");
                String estMOD_Cuenta = res.getString("MOD_Cuenta");
                String estMoneda = res.getString("Moneda");
                String estNombre_Autorizado = res.getString("Nombre_Autorizado");
                String estID_Autorizado = res.getString("ID_Autorizado");
                //Ingresando todos los datos
                data[0] = estCodigo;
                data[1] = estIdentificacion;
                data[2] = estRazon_Social;
                data[3] = estDireccion;
                data[4] = estTelefono;
                data[5] = estEmail;
                data[6] = estName_Beneficiario;
                data[7] = estID_Beneficiario;
                data[8] = estMail_Beneficiario;
                data[9] = estBanco;
                data[10] = estNum_Cuenta;
                data[11] = estTipo_Cuenta;
                data[12] = estMOD_Cuenta;
                data[13] = estMoneda;
                data[14] = estNombre_Autorizado;
                data[15] = estID_Autorizado;  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    //FUNCION PARA IDENTIFICAR EL MODO_CUENTA DE USUARIO
    public int indexmod_Cuenta(String mod){
        int index = 0;
        if(mod.equals("Cuenta Propia")){
            index = 0;
        }else if(mod.equals("Cuenta Nueva")){
            index = 1;
        }else if(mod.equals("Cuenta Autorizada")){
            index = 2;
        }
        return index;
    }
    
    //FUNCION PARA IDENTIFICAR EL TIPO DE NUMERO TELEFONICO
    public int tipoNumeroTlf(String postal) {
        int index = 0;
        if (postal.equals("0412")) {
            index = 0;
        } else if (postal.equals("0414")) {
            index = 1;
        } else if (postal.equals("0416")) {
            index = 2;
        } else if (postal.equals("0424")) {
            index = 3;
        } else if (postal.equals("0426")) {
            index = 4;
        }
        return index;
    }
    
    //FUNCION PARA CAPTURAR EL TIPO DE CUENTA DE BANCO
    public int indexTipoCuenta(String tipo){
        int index = 0;
        if(tipo.equals("Cuenta Ahorros")){
            index = 0;
        }else if(tipo.equals("Cuenta Corriente")){
            index = 1;
        }else if(tipo.equals("Cuenta Maxima")){
            index = 2;
        }else if(tipo.equals("Cuenta Moneda Extranjera")){
            index = 3;
        }
        return index;
    }
    
    //FUNCION PARA CAPTURAR EL TIPO DE IDENTIFICACION
    public int indexIdentificacion(char tipo) {
        int index = 0;
        if ('V' == tipo) {
            index = 0;
        } else if ('E' == tipo) {
            index = 1;
        } else if ('P' == tipo) {
            index = 2;
        } else if ('J' == tipo) {
            index = 3;
        } else if ('G' == tipo) {
            index = 4;
        }
        return index;
    }
    
    //FUNCION PARA CAPTURAR EL INDEX DEL BANCO EN EL COMBOBOX
    public int getindexBanco(String banco) {
        int index = 0;
        //VIENDO CUAL ES EL BANCO
        if (banco.equals("MERCANTIL BANCO UNIVERSAL")) {
            index = 0;
        } else if (banco.equals("BANCO DE VENEZUELA S.A BANCO UNIVERSAL")) {
            index = 1;
        } else if (banco.equals("VENEZOLANO DE CREDITO S.A BANCO UNIVERSAL")) {
            index = 2;
        } else if (banco.equals("BANCO PROVINCIAL S.A BANCO UNIVERSAL")) {
            index = 3;
        } else if (banco.equals("BANCO DEL CARIBE S.A C.A")) {
            index = 4;
        } else if (banco.equals("BANCO EXTERIOR S.A")) {
            index = 5;
        } else if (banco.equals("BANCO OCCIDENTAL DE DESCUENTO S.A C.A")) {
            index = 6;
        } else if (banco.equals("BANCO CARONI C.A BANCO UNIVERSAL")) {
            index = 7;
        } else if (banco.equals("BANESCO BANCO UNIVERSAL")) {
            index = 8;
        } else if (banco.equals("BANCO SOFITASA")) {
            index = 9;
        } else if (banco.equals("BANCO PLAZA")) {
            index = 10;
        } else if (banco.equals("BANCO DE COMERCIO EXTERIOR")) {
            index = 11;
        } else if (banco.equals("FONDO COMUN C.A BANCO UNIVERSAL")) {
            index = 12;
        } else if (banco.equals("100% BANCO, BANCO UNIVERSAL C.A")) {
            index = 13;
        } else if (banco.equals("DEL SUR BANCO UNIVERSAL, C.A")) {
            index = 14;
        } else if (banco.equals("BANCO DEL TESORO")) {
            index = 15;
        } else if (banco.equals("BANCO AGRICOLA DE VENEZUELA C.A")) {
            index = 16;
        } else if (banco.equals("BANCRECER S.A BANCO MICROFINANCIERO")) {
            index = 17;
        } else if (banco.equals("MIBANCO BANCO DE DESARROLLO")) {
            index = 18;
        } else if (banco.equals("BANCO ACTIVO C.A")) {
            index = 19;
        } else if (banco.equals("BANCA AMIGA BANCO MICROFINANCIERO")) {
            index = 20;
        } else if (banco.equals("BANCO BICENTENARIO BANCO UNIVERSAL C.A")) {
            index = 21;
        } else if (banco.equals("BANCO DE LA FUERZA ARMADA NACIONAL BOLIVARIANA")) {
            index = 22;
        } else if (banco.equals("BANCO NACIONAL DE CREDITO ")) {
            index = 23;
        }
        return index;
    }
}
