package logica;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class proveedor {
    conectate con;
    
    public proveedor(){
        //CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    //ESTA FUNCION NOS PERMITE CREAR UN NUEVO PROVEEDOR EN LA BASE DE DATOS
    public void NuevoProveedor(int codigo, String identificacion, String razon_social, String direccion, String municipio, String telefono, String email, String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado, String materia_prima, float cuadrilla, float flete, int peaje) 
            throws SQLException{
        
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " proveedor(Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_cuenta, Tipo_cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado, Materia_Prima, Cuadrilla, Flete, Peaje)" + 
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, codigo);
            pstm.setString(2, identificacion);
            pstm.setString(3, razon_social);
            pstm.setString(4, direccion);
            pstm.setString(5, municipio);
            pstm.setString(6, telefono);
            pstm.setString(7, email);
            pstm.setString(8, name_beneficiario);
            pstm.setString(9, id_beneficiario);
            pstm.setString(10, mail_beneficiario);
            pstm.setString(11, banco);
            pstm.setString(12, num_cuenta);
            pstm.setString(13, tipo_cuenta);
            pstm.setString(14, mod_cuenta);
            pstm.setString(15,nombre_autorizado);
            pstm.setString(16,id_autorizado);
            pstm.setString(17, materia_prima);
            pstm.setFloat(18, cuadrilla);
            pstm.setFloat(19, flete);
            pstm.setInt(20, peaje);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public int cantidadProveedores() throws SQLException{
        int registros = 0;
        //OBTENEMOS LA CANTIDAD DE REGISTROS EXISTENTES EN TODA LA TABLA
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM proveedor");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return registros;
    }
    
    //FUNCION PARA OBTENER DATOS DE TODOS LOS PROVEEDORES
    public Object[][] getDatos() throws SQLException{
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
        Object[][] data = new Object[registros][21];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado, Materia_Prima, Cuadrilla, Flete, Peaje, Estado_Actividad " + 
                    " FROM proveedor " +
                    " ORDER BY Codigo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCodigo = res.getInt("Codigo");
                String estIdentificacion = res.getString("Identificacion");
                String estRazon_Social = res.getString("Razon_Social");
                String estDireccion = res.getString("Direccion");
                String estMunicipio = res.getString("Municipio");
                String estTelefono = res.getString("Telefono");
                String estEmail = res.getString("Email");
                String estName_Beneficiario = res.getString("Name_Beneficiario");
                String estID_Beneficiario = res.getString("ID_Beneficiario");
                String estMail_Beneficiario = res.getString("Mail_Beneficiario");
                String estBanco = res.getString("Banco");
                String estNum_Cuenta = res.getString("Num_Cuenta");
                String estTipo_Cuenta = res.getString("Tipo_Cuenta");
                String estMOD_Cuenta = res.getString("MOD_Cuenta");
                String estNombre_Autorizado = res.getString("Nombre_Autorizado");
                String estID_Autorizado = res.getString("ID_Autorizado");
                String estMateriaPrima = res.getString("Materia_Prima");
                Float estCuadrilla = res.getFloat("Cuadrilla");
                Float estFlete = res.getFloat("Flete");
                int estPeaje = res.getInt("Peaje");
                String estActividad = res.getString("Estado_Actividad");
                //Ingresando todos los datos
                data[i][0] = estCodigo;
                data[i][1] = estIdentificacion;
                data[i][2] = estRazon_Social;
                data[i][3] = estDireccion;
                data[i][4] = estMunicipio;
                data[i][5] = estTelefono;
                data[i][6] = estEmail;
                data[i][7] = estName_Beneficiario;
                data[i][8] = estID_Beneficiario;
                data[i][9] = estMail_Beneficiario;
                data[i][10] = estBanco;
                data[i][11] = estNum_Cuenta;
                data[i][12] = estTipo_Cuenta;
                data[i][13] = estMOD_Cuenta;
                data[i][14] = estNombre_Autorizado;
                data[i][15] = estID_Autorizado;
                data[i][16] = estMateriaPrima;
                data[i][17] = estCuadrilla;
                data[i][18] = estFlete;
                data[i][19] = estPeaje;
                data[i][20] = estActividad;
                i++;        
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    //FUNCION PARA INHABILITAR AL PROVEEDOR
    public void deleteProveedor(int cod) throws SQLException{       
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor set Estado_Actividad = ? where Codigo = ?");
            pstm.setString(1, "Inactivo");
            pstm.setInt(2, cod);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void habilitarProveedor(int cod) throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor set Estado_Actividad = ? where Codigo = ?");
            pstm.setString(1, "Activo");
            pstm.setInt(2, cod);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    //FUNCION PARA ACTUALIZAR LOS DATOS DE UN PROVEEDOR
    public void updateProveedorCodigo(int codigo, String identificacion, String razon_social, String direccion, String municipio, String telefono, String email, String name_beneficiario, String id_beneficiario,
            String mail_beneficiario, String banco, String num_cuenta, String tipo_cuenta, String mod_cuenta, String nombre_autorizado, String id_autorizado, String materia_prima, float Cuadrilla, float Flete, int Peaje)
    throws SQLException{
        
        //SE REALIZA LA QUERY EN SQL PARA ACTUALIZAR LOS DATOS DEL PROVEEDOR
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor " + 
            " set Identificacion = ? ," +
            " Razon_Social = ? , " + 
            " Direccion = ? , " + 
            " Municipio = ? , " +
            " Telefono = ? , " +
            " Email = ? , " + 
            " Name_Beneficiario = ? , " +
            " ID_Beneficiario = ? , " + 
            " Mail_Beneficiario = ? , " + 
            " Banco = ? , " + 
            " Num_Cuenta = ? , " +
            " Tipo_Cuenta = ? , " + 
            " MOD_Cuenta = ? , " + 
            " Nombre_Autorizado = ? , " +
            " ID_Autorizado = ? , " +
            " Materia_Prima = ? , " +
            " Cuadrilla = ? , " +
            " Flete = ? , " +
            " Peaje = ? " +        
            " where Codigo = ?");
            pstm.setString(1, identificacion);
            pstm.setString(2, razon_social);
            pstm.setString(3, direccion);
            pstm.setString(4, municipio);
            pstm.setString(5, telefono);
            pstm.setString(6, email);
            pstm.setString(7, name_beneficiario);
            pstm.setString(8, id_beneficiario);
            pstm.setString(9, mail_beneficiario);
            pstm.setString(10, banco);
            pstm.setString(11, num_cuenta);
            pstm.setString(12, tipo_cuenta);
            pstm.setString(13, mod_cuenta);
            pstm.setString(14, nombre_autorizado);
            pstm.setString(15, id_autorizado);
            pstm.setString(16, materia_prima);
            pstm.setFloat(17, Cuadrilla);
            pstm.setFloat(18, Flete);
            pstm.setInt(19, Peaje);
            pstm.setInt(20, codigo);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA ENCONTRAR A UN PROVEEDOR SEGUN SU CEDULA
    //MANDA UN MENSAJE DE ERROR SI LOGRA ENCONTRAR A UN PROVEEDOR CON DICHA IDENTIFICACION
    //SIRVE UNICAMENTE PARA AGREGAR A UN PROVEEDOR
    public boolean buscarIdentificacion(String identificacion) throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        try {
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Identificacion = ?");
            pstm.setString(1,identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){ 
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
    public boolean buscarIdentificacion2(String identificacion) throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        try {
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Identificacion = ?");
            pstm.setString(1,identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else {
                encontrado = false;
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encontrado;
    }
    
    public boolean buscarProveedorActivo(String identificacion) throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        try{
            pstm = con.getConnection().prepareStatement("SELECT Estado_Actividad FROM proveedor where Identificacion = ?");
            pstm.setString(1,identificacion);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                //HAY QUE BUSCAR SU ESTADO ACTIVIDAD
                String actividad = res.getString("Estado_Actividad");
                if(actividad.equals("Activo")){
                    encontrado = true;
                }
            } else{
                encontrado = false;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return encontrado;
    }
    
    //FUNCION PARA BUSCAR A UN PROVEEDOR SEGUN SU CODIGO
    //MANDA UN MENSAJE DE ERROR SI NO LO ENCUENTRA
    //FUNCIONA TANTO PARA LA PANTALLA DE BUSQUEDA, COMO MODIFICAR Y ELIMINAR
    public boolean buscarCodigo(int codigo) throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        try{
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Codigo = ?");
            pstm.setInt(1, codigo);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else{
                encontrado = false;
            }
            res.close();
        }catch(SQLException e){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        return encontrado;
    }
    
    //FUNCION PARA BUSCAR A UN PROVEEDOR SEGUN SU RAZON SOCIAL
    //FUNCIONA TANTO PARA LAS PANTALLAS DE BUSQUEDA, COMO DE MODIFICAR Y ELIMINAR
    public boolean buscarRazonSocial(String RS) throws SQLException{
        boolean encontrado = false;
        PreparedStatement pstm;
        try{
            pstm = con.getConnection().prepareStatement("SELECT * FROM proveedor where Razon_Social = ?");
            pstm.setString(1, RS);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else {  
                encontrado = false;
            }
            res.close();
        }catch(SQLException e){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        return encontrado;
    }
    
    //FUNCION PARA CONSEGUIR LOS DATOS DE UN ÚNICO PROVEEDOR
    /*
        LOS MODOS PARA ESTA FUNCION SON LOS SIGUIENTES
        1- ENCONTRAR LOS DATOS GRACIAS AL CODIGO DEL PROVEEDOR
        2- ENCONTRAR LOS DATOS GRACIAS A LA IDENTIFICACION
        3- ENCONTRAR LOS DATOS GRACIAS A LA RAZON SOCIAL
    */
    public Object[] conseguirDatos(int codigo, String identificacion, String Razon_Social, int modo) throws SQLException{
        Object[] data = new Object[21];
        Object[] data2 = new Object[21];
        PreparedStatement pstm;
        ResultSet res;
        try{
            //Conseguir datos habiendo buscado por codigo
            if(modo == 1){
               pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado, Materia_Prima, Cuadrilla, Flete, Peaje, Estado_Actividad " + 
                    " FROM proveedor " +
                    " WHERE Codigo = ?");
               pstm.setInt(1, codigo); 
               res = pstm.executeQuery();
               data2 = informacion(res,data);
               res.close();
               //Conseguir datos habiendo buscado por identificacion
            } else if (modo == 2){
                //BUSQUEDA POR IDENTIFICACION
                pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado, Materia_Prima, Cuadrilla, Flete, Peaje, Estado_Actividad " + 
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
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Name_Beneficiario, ID_Beneficiario, Mail_Beneficiario, Banco, Num_Cuenta, Tipo_Cuenta, MOD_Cuenta, Nombre_Autorizado, ID_Autorizado, Materia_Prima, Cuadrilla, Flete, Peaje, Estado_Actividad " + 
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
    
    /*
        FUNCION QUE LE SIRVE a conseguirDatos() PARA DEVOLVER CADA UNO DE LOS DATOS
        SE LE INGRESA EL OBJETO VECTOR DATA PARA GUARDAR ALLÍ LOS DATOS
        Y LA RESULTSET QUE ES DONDE SE GUARDA EL RESULTADO DE LA QUERY DE SQL
    */
    public Object[] informacion(ResultSet res, Object[] data){
        try {
            while(res.next()){
                int estCodigo = res.getInt("Codigo");
                String estIdentificacion = res.getString("Identificacion");
                String estRazon_Social = res.getString("Razon_Social");
                String estDireccion = res.getString("Direccion");
                String estMunicipio = res.getString("Municipio");
                String estTelefono = res.getString("Telefono");
                String estEmail = res.getString("Email");
                String estName_Beneficiario = res.getString("Name_Beneficiario");
                String estID_Beneficiario = res.getString("ID_Beneficiario");
                String estMail_Beneficiario = res.getString("Mail_Beneficiario");
                String estBanco = res.getString("Banco");
                String estNum_Cuenta = res.getString("Num_Cuenta");
                String estTipo_Cuenta = res.getString("Tipo_Cuenta");
                String estMOD_Cuenta = res.getString("MOD_Cuenta");
                String estNombre_Autorizado = res.getString("Nombre_Autorizado");
                String estID_Autorizado = res.getString("ID_Autorizado");
                String estMateriaPrima = res.getString("Materia_Prima");
                Float estCuadrilla = res.getFloat("Cuadrilla");
                Float estFlete = res.getFloat("Flete");
                int estPeaje = res.getInt("Peaje");
                String estActividad = res.getString("Estado_Actividad");
                //Ingresando todos los datos
                data[0] = estCodigo;
                data[1] = estIdentificacion;
                data[2] = estRazon_Social;
                data[3] = estDireccion;
                data[4] = estMunicipio;
                data[5] = estTelefono;
                data[6] = estEmail;
                data[7] = estName_Beneficiario;
                data[8] = estID_Beneficiario;
                data[9] = estMail_Beneficiario;
                data[10] = estBanco;
                data[11] = estNum_Cuenta;
                data[12] = estTipo_Cuenta;
                data[13] = estMOD_Cuenta;
                data[14] = estNombre_Autorizado;
                data[15] = estID_Autorizado;
                data[16] = estMateriaPrima;
                data[17] = estCuadrilla;
                data[18] = estFlete;
                data[19] = estPeaje;
                data[20] = estActividad;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /*
        FUNCION PARA OBTENER UNICAMENTE LOS DATOS PRINCIPALES DEL PROVEEDOR (CODIGO, IDENTIFICACION, RAZON_SOCIAL)
        LOS MODOS PARA ESTA FUNCION SON LOS SIGUIENTES
        1- ENCONTRAR LOS DATOS GRACIAS AL CODIGO DEL PROVEEDOR
        2- ENCONTRAR LOS DATOS GRACIAS A LA IDENTIFICACION
        3- ENCONTRAR LOS DATOS GRACIAS A LA RAZON SOCIAL
    */
    public Object[] conseguirDatosPrincipales(int codigo, String identificacion, String razon_social, int modo) throws SQLException{
        Object[] data = new Object[3];
        Object[] data2 = new Object[3];
        PreparedStatement pstm;
        ResultSet res;
        try{
            //Conseguir datos habiendo buscado por codigo
            if(modo == 1){
               pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social" + 
                    " FROM proveedor " +
                    " WHERE Codigo = ?");
               pstm.setInt(1, codigo); 
               res = pstm.executeQuery();
               data2 = informacionPrincipal(res,data);
               res.close();
               //Conseguir datos habiendo buscado por identificacion
            } else if (modo == 2){
                //BUSQUEDA POR IDENTIFICACION
                pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social" + 
                    " FROM proveedor " +
                    " WHERE Identificacion = ?");
                pstm.setString(1, identificacion);
                res = pstm.executeQuery();
                data2 = informacionPrincipal(res,data);
                res.close();
                //Conseguir datos habiendo buscado por razon social
            } else if (modo == 3){
                //BUSQUEDA POR RAZON_SOCIAL
                pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social" + 
                    " FROM proveedor " +
                    " WHERE Razon_Social = ?");
                pstm.setString(1, razon_social);
                res = pstm.executeQuery();
                data2 = informacionPrincipal(res, data);
                res.close();
            }   
        }catch(SQLException e){
            System.out.println(e);
        }
        return data2;
    }
    
    public int codigoSiguiente() throws SQLException{
        int codigo = 1;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo from proveedor ORDER BY CODIGO DESC");
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                codigo = res.getInt("Codigo");
                codigo++;
            }
        }catch(SQLException ex){
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
    
    /*  FUNCION QUE LE SIRVE a conseguirDatosPrincipales() PARA DEVOVLER CADA UNO DE LOS DATOS
        SE LE INGRESA EL OBJETO VECTOR DATA PARA GUARDAR ALLÍ LOS DATOS
        Y LA RESULTSET QUE ES DONDE SE GUARDA EL RESULTADO DE LA QUERY DE SQL
    */
    public Object[] informacionPrincipal(ResultSet res, Object[] data) throws SQLException{
        try {
            while(res.next()){
                int estCodigo = res.getInt("Codigo");
                String estIdentificacion = res.getString("Identificacion");
                String estRazon_Social = res.getString("Razon_Social");
                //Ingresando todos los datos
                data[0] = estCodigo;
                data[1] = estIdentificacion;
                data[2] = estRazon_Social;
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
   
    public boolean comprobacionIdentificacion(String identificacion){
        boolean valido = true;
        for(int i = 0, cantidad_caracteres = identificacion.length(); i < cantidad_caracteres && valido; i++){
                //En cada iteracion preguntamos si es un digito numerico
                //En el momento que no lo sea, el ciclo terminara y no dejara pasar a los demas procedimientos
                char caracter = identificacion.charAt(i);
                if(!Character.isDigit(caracter)){
                    valido = false;
                }
        }
        return valido;
    }
    
    public boolean comprobacionFlotante(float F){
        boolean valido = true;
        String numero = String.valueOf(F);
        for(int i = 0, cantidad_caracteres = numero.length(); i < cantidad_caracteres && valido; i++){
                //En cada iteracion preguntamos si es un digito numerico
                //En el momento que no lo sea, el ciclo terminara y no dejara pasar a los demas procedimientos
                char caracter = numero.charAt(i);
                if(!Character.isDigit(caracter) && caracter != '.'){
                    valido = false;
                }
        }
        return valido;
    }
    
    public boolean comprobacionEntero(int I){
        boolean valido = true;
        String numero = String.valueOf(I);
        for(int i = 0, cantidad_caracteres = numero.length(); i < cantidad_caracteres && valido; i++){
                //En cada iteracion preguntamos si es un digito numerico
                //En el momento que no lo sea, el ciclo terminara y no dejara pasar a los demas procedimientos
                char caracter = numero.charAt(i);
                if(!Character.isDigit(caracter) && caracter != '.'){
                    valido = false;
                }
        }
        return valido;
    }
}
