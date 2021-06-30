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
    public void NuevoProveedor(int codigo, String identificacion, String razon_social, String direccion, String municipio, String telefono, String email, String materia_prima, float MP_acordado, float cuadrilla, float flete, int peaje, int Cod_Tarifa, boolean tarifa) 
            throws SQLException{
        System.out.println(codigo);
        System.out.println(identificacion);
        System.out.println(razon_social);
        if(tarifa){
            try{
                PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                        " proveedor(Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Cuadrilla, Flete, Peaje, Materia_Prima, MP_acordado, Cod_Tarifa)" + 
                        " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstm.setInt(1, codigo);
                pstm.setString(2, identificacion);
                pstm.setString(3, razon_social);
                pstm.setString(4, direccion);
                pstm.setString(5, municipio);
                pstm.setString(6, telefono);
                pstm.setString(7, email);
                pstm.setFloat(8, cuadrilla);
                pstm.setFloat(9, flete);
                pstm.setInt(10, peaje);
                pstm.setString(11, materia_prima);
                pstm.setFloat(12, MP_acordado);
                pstm.setInt(13, Cod_Tarifa);
                pstm.execute();
                pstm.close();
            }catch(SQLException e){
                Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            try{
                PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                        " proveedor(Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Cuadrilla, Flete, Peaje, Materia_Prima, MP_acordado, Cod_Tarifa)" + 
                        " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstm.setInt(1, codigo);
                pstm.setString(2, identificacion);
                pstm.setString(3, razon_social);
                pstm.setString(4, direccion);
                pstm.setString(5, municipio);
                pstm.setString(6, telefono);
                pstm.setString(7, email);
                pstm.setFloat(8, cuadrilla);
                pstm.setFloat(9, flete);
                pstm.setInt(10, peaje);
                pstm.setString(11, materia_prima);
                pstm.setFloat(12, MP_acordado);
                pstm.setInt(13,0);
                pstm.execute();
                pstm.close();
            }catch(SQLException e){
                Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
            }
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
        int codigo;
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
        Object[][] data = new Object[registros][23];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Cuadrilla, Flete, Peaje, Materia_Prima, MP_acordado, Cod_Tarifa, Estado_Actividad " + 
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
                float estCuadrilla = res.getFloat("Cuadrilla");
                float estFlete = res.getFloat("Flete");
                int estPeaje = res.getInt("Peaje");
                String estMateriaPrima = res.getString("Materia_Prima");
                float estMP_acordado = res.getFloat("MP_acordado");
                int estCodigo_Tarifa = res.getInt("Cod_Tarifa");
                String estActividad = res.getString("Estado_Actividad");
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT " + 
                        " beneficiarios.Name_Beneficiario, beneficiarios.ID_Beneficiario, beneficiarios.Mail_Beneficiario, beneficiarios.Banco, beneficiarios.Num_Cuenta, beneficiarios.Tipo_Cuenta, beneficiarios.MOD_Cuenta, beneficiarios.Nombre_Autorizado, beneficiarios.ID_Autorizado " +
                        " FROM beneficiarios, Relacion_Proveedor_Beneficiario " +
                        " WHERE Relacion_Proveedor_Beneficiario.Cod_Proveedor = " + estCodigo + 
                        " AND beneficiarios.Cod_Beneficiario = Relacion_Proveedor_Beneficiario.Cod_Bnf");
                ResultSet res2 = pstm2.executeQuery();
                //Ingresando todos los datos
                data[i][0] = estCodigo;
                data[i][1] = estIdentificacion;
                data[i][2] = estRazon_Social;
                data[i][3] = estDireccion;
                data[i][4] = estMunicipio;
                data[i][5] = estTelefono;
                data[i][6] = estEmail;
                data[i][7] = estCuadrilla;
                data[i][8] = estFlete;
                data[i][9] = estPeaje;
                data[i][10] = estMateriaPrima;
                data[i][11] = estMP_acordado;
                data[i][12] = estCodigo_Tarifa;
                if(res2.next()){
                    String estName_Beneficiario = res2.getString("Name_Beneficiario");
                    String estID_Beneficiario = res2.getString("ID_Beneficiario");
                    String estMail_Beneficiario = res2.getString("Mail_Beneficiario");
                    String estBanco = res2.getString("Banco");
                    String estNum_Cuenta = res2.getString("Num_Cuenta");
                    String estTipo_Cuenta = res2.getString("Tipo_Cuenta");
                    String estMOD_Cuenta = res2.getString("MOD_Cuenta");
                    String estNombre_Autorizado = res2.getString("Nombre_Autorizado");
                    String estID_Autorizado = res2.getString("ID_Autorizado");
                    data[i][13] = estName_Beneficiario;
                    data[i][14] = estID_Beneficiario;
                    data[i][15] = estMail_Beneficiario;
                    data[i][16] = estBanco;
                    data[i][17] = estNum_Cuenta;
                    data[i][18] = estTipo_Cuenta;
                    data[i][19] = estMOD_Cuenta;
                    data[i][20] = estNombre_Autorizado;
                    data[i][21] = estID_Autorizado;
                }
                data[i][22] = estActividad;
                i++;        
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] conseguirDatosPrincipales_Total(){
        int registros = 0;
        int codigo;
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
        Object[][] data = new Object[registros][3];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo, Razon_Social, Identificacion FROM proveedor");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                int estCodido = res.getInt("Codigo");
                String estIdentificacion = res.getString("Identificacion");
                String estRazon_Social = res.getString("Razon_Social");
                data[i][0] = estCodido;
                data[i][1] = estIdentificacion;
                data[i][2] = estRazon_Social;
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
    public void updateProveedorCodigo(int codigo, String identificacion, String razon_social, String direccion, String municipio, String telefono, String email, String materia_prima, float MP_acordado, float Cuadrilla, float Flete, int Peaje, int cod_tarifa, boolean tarifa)
    throws SQLException{
        
        //SE REALIZA LA QUERY EN SQL PARA ACTUALIZAR LOS DATOS DEL PROVEEDOR
        try{
            if(tarifa){
                PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor " + 
                " set Identificacion = ? ," +
                " Razon_Social = ? , " + 
                " Direccion = ? , " + 
                " Municipio = ? , " +
                " Telefono = ? , " +
                " Email = ? , " + 
                " Cuadrilla = ? , " +
                " Flete = ? , " +
                " Peaje = ? , " +   
                " Materia_Prima = ? , " +
                " MP_acordado = ? , " +   
                " Cod_Tarifa = ?  " +        
                " where Codigo = ?");
                pstm.setString(1, identificacion);
                pstm.setString(2, razon_social);
                pstm.setString(3, direccion);
                pstm.setString(4, municipio);
                pstm.setString(5, telefono);
                pstm.setString(6, email);
                pstm.setFloat(7, Cuadrilla);
                pstm.setFloat(8, Flete);
                pstm.setInt(9, Peaje);
                pstm.setString(10, materia_prima);
                pstm.setFloat(11, MP_acordado);
                pstm.setInt(12, cod_tarifa);
                pstm.setInt(13, codigo);
                pstm.execute();
                pstm.close();
            } else if(!tarifa){
                PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE proveedor " + 
                " set Identificacion = ? ," +
                " Razon_Social = ? , " + 
                " Direccion = ? , " + 
                " Municipio = ? , " +
                " Telefono = ? , " +
                " Email = ? , " + 
                " Cuadrilla = ? , " +
                " Flete = ? , " +
                " Peaje = ? , " +   
                " Materia_Prima = ? , " +
                " MP_acordado = ? , " +   
                " Cod_Tarifa = ?  " +        
                " where Codigo = ?");
                pstm.setString(1, identificacion);
                pstm.setString(2, razon_social);
                pstm.setString(3, direccion);
                pstm.setString(4, municipio);
                pstm.setString(5, telefono);
                pstm.setString(6, email);
                pstm.setFloat(7, Cuadrilla);
                pstm.setFloat(8, Flete);
                pstm.setInt(9, Peaje);
                pstm.setString(10, materia_prima);
                pstm.setFloat(11, MP_acordado);
                pstm.setInt(12, 0);
                pstm.setInt(13, codigo);
                pstm.execute();
                pstm.close();
            }
        }catch(SQLException e){
             Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
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
        Object[] data = new Object[23];
        Object[] data2 = new Object[23];
        PreparedStatement pstm;
        ResultSet res;
        try{
            if (modo == 2){
                //BUSQUEDA POR IDENTIFICACION
                pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Cuadrilla, Flete, Peaje, Materia_Prima, MP_acordado, Cod_Tarifa, Estado_Actividad " + 
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
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Cuadrilla, Flete, Peaje, Materia_Prima, MP_acordado, Cod_Tarifa, Estado_Actividad " + 
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
                Float estCuadrilla = res.getFloat("Cuadrilla");
                Float estFlete = res.getFloat("Flete");
                int estPeaje = res.getInt("Peaje");
                String estMateriaPrima = res.getString("Materia_Prima");
                float estMP_acordado = res.getFloat("MP_acordado");
                int estCod_Tarifa = res.getInt("Cod_Tarifa");
                String estActividad = res.getString("Estado_Actividad");
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT " + 
                        " beneficiarios.Name_Beneficiario, beneficiarios.ID_Beneficiario, beneficiarios.Mail_Beneficiario, beneficiarios.Banco, beneficiarios.Num_Cuenta, beneficiarios.Tipo_Cuenta, beneficiarios.MOD_Cuenta, beneficiarios.Nombre_Autorizado, beneficiarios.ID_Autorizado " +
                        " FROM beneficiarios, Relacion_Proveedor_Beneficiario " +
                        " WHERE Relacion_Proveedor_Beneficiario.Cod_Proveedor = " + estCodigo + 
                        " AND beneficiarios.Cod_Beneficiario = Relacion_Proveedor_Beneficiario.Cod_Bnf");
                ResultSet res2 = pstm2.executeQuery();
                //Ingresando todos los datos
                data[0] = estCodigo;
                data[1] = estIdentificacion;
                data[2] = estRazon_Social;
                data[3] = estDireccion;
                data[4] = estMunicipio;
                data[5] = estTelefono;
                data[6] = estEmail;
                data[7] = estCuadrilla;
                data[8] = estFlete;
                data[9] = estPeaje;
                data[10] = estMateriaPrima;
                data[11] = estMP_acordado;
                data[12] = estCod_Tarifa;
                if(res2.next()){
                    String estName_Beneficiario = res2.getString("Name_Beneficiario");
                    String estID_Beneficiario = res2.getString("ID_Beneficiario");
                    String estMail_Beneficiario = res2.getString("Mail_Beneficiario");
                    String estBanco = res2.getString("Banco");
                    String estNum_Cuenta = res2.getString("Num_Cuenta");
                    String estTipo_Cuenta = res2.getString("Tipo_Cuenta");
                    String estMOD_Cuenta = res2.getString("MOD_Cuenta");
                    String estNombre_Autorizado = res2.getString("Nombre_Autorizado");
                    String estID_Autorizado = res2.getString("ID_Autorizado");
                    data[13] = estName_Beneficiario;
                    data[14] = estID_Beneficiario;
                    data[15] = estMail_Beneficiario;
                    data[16] = estBanco;
                    data[17] = estNum_Cuenta;
                    data[18] = estTipo_Cuenta;
                    data[19] = estMOD_Cuenta;
                    data[20] = estNombre_Autorizado;
                    data[21] = estID_Autorizado;
                }
                data[22] = estActividad;
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
            //Conseguir datos habiendo buscado por identificacion
            if (modo == 2){
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
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo from proveedor ORDER BY Codigo DESC");
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
    
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //SE BUSCA INFO PRINCIAL A PARTIR DEL CODIGO
    public Object[] InfoPrincipalXcodigo(int codigo) throws SQLException{
        Object[] data = new Object[3];
        Object[] data2 = new Object[3];
        PreparedStatement pstm;
        ResultSet res;
        
        try {
            pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social" +
                    " FROM proveedor " +
                    " WHERE Codigo = ?");
            pstm.setInt(1, codigo);
            res = pstm.executeQuery();
            data2 = informacionPrincipal(res, data);
            res.close();
            
        } catch (SQLException e) {
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, e);
        }
        return data2;
    }
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
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
        } else if ('J' == tipo) {
            index = 2;
        } else if ('P' == tipo) {
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
