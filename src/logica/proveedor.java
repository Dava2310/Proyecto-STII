package logica;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene todos las consultas SQL y otros metodos que ayudan a manejar la informacion de proveedor.
 * @author Proyecto STII - SARP
 * @version 16/07/2021
 */

public class proveedor {
    /**
     * El objeto conectate nos permite tener una conexión con la base de datos.
     */
    public conectate con;
    
    /**
     * Constructor de la clase proveedor. Únicamente inicializamos el objeto de conexión con la base de datos.
     */
    public proveedor(){
        //CONEXION CON LA BASE DE DATOS
        con = new conectate();
    }
    
    /**
     * Este método permite crear en la BD un nuevo proveedor con todos los datos ingresados por parámetros.
     * @param codigo. Parámetro del Codigo del proveedor.
     * @param identificacion. Parámetro de la Identificación o cédula.
     * @param razon_social. Parámetro de la Razón Social o nombre.
     * @param direccion. Parámetro de la dirección.
     * @param municipio. Parámetro del municipio.
     * @param telefono. Parámetro del teléfono.
     * @param email. Parámetro del email.
     * @param materia_prima. Parámetro para definir si la Materia Prima se basa en la Tabla de Precios o es acordada.
     * @param MP_acordado. Parámetro para guardar el monto de la Materia Prima acordada.
     * @param cuadrilla. Parámetro para guardar el monto de cuadrilla.
     * @param flete. Parámetro para guardar el monto de flete.
     * @param peaje. Parámetro para guardar el monto de peaje.
     * @param Cod_Tarifa. Parámetro para guardar el código de la Tarifa Estándar si es que pertenece a alguna. Si es distinto de 0, significa que pertenece a una tarifa.
     * @param tarifa. Parámetro <b>booleano</b> para saber si es que pertenece o no a una tarifa.
     * @throws SQLException 
     */
    //ESTA FUNCION NOS PERMITE CREAR UN NUEVO PROVEEDOR EN LA BASE DE DATOS
    public void NuevoProveedor(int codigo, String identificacion, String razon_social, String direccion, String municipio, String telefono, String email, String materia_prima, float MP_acordado, float cuadrilla, float flete, int peaje, int Cod_Tarifa, boolean tarifa) 
            throws SQLException{
        //En caso de tener una tarifa, llamamos en la SQL a ingresar un codigo de tarifa.
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
            //En caso de no pertenecer a una tarifa, mandamos a colocar 0 en el codigo de la tarifa.
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
    }//Cierre del metodo de nuevo proveedor.
    
    /**
     * 
     * @return Devuelve la cantidad de registros de proveedores existentes en toda la BD.
     * @throws SQLException 
     */
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
    }//Cierre del método cantidadProveedores()
    
    /**
     * 
     * @return Devuelve en una <i>matriz</i> de tipo <b>Objeto</b>, todos los datos de todos los registros de proveedores más los beneficiarios que tenga cada proveedor.
     * @throws SQLException 
     */
    //FUNCION PARA OBTENER DATOS DE TODOS LOS PROVEEDORES
    public Object[][] getDatos() throws SQLException{
        int registros = 0;
        int codigo;
        //Obtenemos la cantidad de registros existentes en la tabla
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM proveedor");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new Object[registros][23]; //Declaramos la matriz objeto segun los registros obtenidos. (23 significa la cantidad de columnas de toda la tabla)
        try{
            //Buscamos los datos de todos los proveedores.
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " + 
                    " Codigo, Identificacion, Razon_Social, Direccion, Municipio, Telefono, Email, Cuadrilla, Flete, Peaje, Materia_Prima, MP_acordado, Cod_Tarifa, Estado_Actividad " + 
                    " FROM proveedor " +
                    " ORDER BY Codigo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            //Realizamos un ciclo en donde por cada proveedor, recogemos los datos, y despues los ingresamos en la matriz.
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
                //Para este mismo proveedor, buscamos según la tabla de Relacion_Proveedor_Beneficiario, que Beneficiario tiene asignado
                //Para después si tiene Beneficiario, recoger todos los datos del beneficiario e ingresarlos en la matriz, en la misma línea del proveedor actual.
                PreparedStatement pstm2 = con.getConnection().prepareStatement("SELECT " + 
                        " beneficiarios.Name_Beneficiario, beneficiarios.ID_Beneficiario, beneficiarios.Mail_Beneficiario, beneficiarios.Banco, beneficiarios.Num_Cuenta, beneficiarios.Tipo_Cuenta, beneficiarios.MOD_Cuenta, beneficiarios.Nombre_Autorizado, beneficiarios.ID_Autorizado " +
                        " FROM beneficiarios, Relacion_Proveedor_Beneficiario " +
                        " WHERE Relacion_Proveedor_Beneficiario.Cod_Proveedor = " + estCodigo + 
                        " AND beneficiarios.Cod_Beneficiario = Relacion_Proveedor_Beneficiario.Cod_Bnf");
                ResultSet res2 = pstm2.executeQuery();
                //Ingresando todos los datos del proveedor.
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
                    //Ingresando todos los datos del beneficiario asignado a este proveedor.
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
        return data; //Se retorna la matriz al final.
    }//Cierre del metodo getDatos()
    
    /**
     * Esta matriz tiene tres valores en su <i>segunda dimension </i>: <b>Codigo [][0], Identifacion[][1], Razon Social[][2]</b>
     * Y la primera dimension sera cada registro encontrado en la BD en la tabla de proveedores.
     * @return Devuelve una <i>matriz</i> de tipo <b>Objeto</b> con todos los proveedores, con sus datos principales.
     */
    public Object[][] conseguirDatosPrincipales_Total(){
        int registros = 0;
        int codigo;
        //Obtenemos la cantidad de registros existentes en la tabla
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM proveedor");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch(SQLException e){
            System.out.println(e);
        }
        //Definimos una matriz, el tamaño de la primera dimensión es la cantidad de proveedores encontrados, la segunda es la cantidad de columnas.
        Object[][] data = new Object[registros][3];
        try{
            //Mandamos una Query únicamente pidiendo el Código, Razon Social e Identificación
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Codigo, Razon_Social, Identificacion FROM proveedor");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                //En cada iteracion, recojemos la informacion de este registro.
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
    }//Cierre del metodo conseguirDatosPrincipales.
    
    /**
     * Función que permite <b>deshabilitar</b> al proveedor en la BD únicamente llamado desde la tabla de proveedores, si el proveedor está <b>activo</b>.
     * @param cod. Parámetro que guarda el código del proveedor.
     * @throws SQLException 
     */
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
    }//Cierre del metodo deleteProveedor.
    
    /**
     * Función que permite <b>habilitar</b> al proveedor en la BD únicamente llamado desde la tabla de proveedores, si el proveedor está <b>inactivo</b>.
     * @param cod. Parámetro que guarda el código del proveedor.
     * @throws SQLException 
     */
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
    }//Cierre del metodo habilitarProveedor.
    
    /**
     * Este método permite <b>actualizar</b> los datos de un proveedor, con todos los parámetros ingresados al método.
     * @param codigo. Parámetro importante para guardar a que proveedor se le hará la modificación.
     * @param identificacion
     * @param razon_social
     * @param direccion
     * @param municipio
     * @param telefono
     * @param email
     * @param materia_prima
     * @param MP_acordado
     * @param Cuadrilla
     * @param Flete
     * @param Peaje
     * @param cod_tarifa
     * @param tarifa. Parámetro <i>booleano</i> que permite saber si el proveedor en este momento pertenece o no a la Tárifa Estándar.
     * @throws SQLException 
     */
    public void updateProveedorCodigo(int codigo, String identificacion, String razon_social, String direccion, String municipio, String telefono, String email, String materia_prima, float MP_acordado, float Cuadrilla, float Flete, int Peaje, int cod_tarifa, boolean tarifa)
    throws SQLException{
        //SE REALIZA LA QUERY EN SQL PARA ACTUALIZAR LOS DATOS DEL PROVEEDOR
        try{
            //Se hace la misma pregunta si tiene existente una tarifa. En caso de ahora tenerla, se modifica el dato. Si ahora no pertenece, se le coloca 0.
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
    }//Cierre del metodo updateProveedorCodigo.
    
    /**
     * Funcion para encontrar a un proveedor segun su <b>cedula</b>.
     * Usada <i>únicamente</i> desde la sección de creación de proveedor.
     * @param identificacion
     * @return Devuelve true si la función encontró al proveedor, devuelve false si no lo encontró.
     * @throws SQLException 
     */
    
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
    
    /**
     * Función para buscar si un proveedor con una identificación o cédula está activo en la BD.
     * @param identificacion. Cédula o Identificación del proveedor.
     * @return Devuelve true si hay un proveedor activo registrado en la BD con esta identificación. Devuelve false si no lo encontró o no está activo.
     * @throws SQLException 
     */
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
    /**
     * Función para buscar a un proveedor según su código de proveedor.
     * @param codigo. Código del proveedor.
     * @return Devuelve true si encontró al proveedor con ese código, devuelve false si no lo encontró.
     * @throws SQLException 
     */
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
    
    /**
     * Función para buscar a un proveedor en la BD según su razón social.
     * @param RS. Parámetro de la razón social para hacer la búsqueda.
     * @return Devuelve true si encontró al proveedor, devuelve false si no lo encontró.
     * @throws SQLException 
     */
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
    
    /**
     * Esta función permite hacer una búsqueda de un único proveedor según su código, identificación o razón social (dependiendo del modo), para después devolver en un vector de tipo Objeto todos sus datos.
     * @param codigo. Código del proveedor.
     * @param identificacion. Identificación del proveedor.
     * @param Razon_Social. Razon Social o Nombre del proveedr.
     * @param modo. Este modo será: 1- Buscar con el código. 2- Buscar con la identificación. 3- Buscar con la razón social.
     * @return Devuelve un vector Objeto con toda la información del proveedor más su beneficiario.
     * @throws SQLException 
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
    
    /**
     * Esta función es llamada desde conseguirDatos() para devolver todos los datos del proveedor.
     * @param res. Se le ingresa el resultSet donde se encuentra el registro del proveedor en la BD.
     * @param data. Se le ingresa un vector de tipo objeto para alojar los datos.
     * @return 
     */
    private Object[] informacion(ResultSet res, Object[] data){
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
                //Ingresando todos los datos del proveedor.
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
                    //Ingresando todos los datos del beneficiario asignado a este proveedor.
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
    
    /**
     * Función para obtener únicamente los datos principales (Código[0], Identificación[1], Razón Social[2]) de un único proveedor.
     * @param codigo. Código del Proveedor.
     * @param identificacion. Identificación o Cédula del proveedor.
     * @param razon_social. Razón Social o nombre del proveedor.
     * @param modo. Este modo será: 1- Buscar con el código. 2- Buscar con la identificación. 3- Buscar con la razón social.
     * @return Devuelve un vector de tipo objeto donde se alojan los datos principales del proveedor.
     * @throws SQLException 
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
    
    /**
     * Permite devolver el código del siguiente proveedor que se puede crear, de manera que el código de proveedor es auto incrementable.
     * @return Devuelve el próximo código disponible.
     * @throws SQLException 
     */
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
    
    /**
     * Función para obtener la información principal únicamente gracias al Código del proveedor.
     * @param codigo. Código del proveedor.
     * @return Devuelve un vector de tipo objeto con los datos principales. Codigo[0], Identificación[1], Razon Social[2]
     * @throws SQLException 
     */
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
    
    /**
     * Función llamada desde conseguirDatosPrincipales() y InfoPrincipalXcodigo, para devolver los datos principales de un único proveedor.
     * @see <b>conseguirDatosPrincipales()</b>
     * @param res. Aquí guardamos en específico el registro encontrado del proveedor.
     * @param data. Este es un vector de tipo <b>objeto</b> para alojar los datos.
     * @return Devuelve el <i>vector objeto</i> con la información del proveedor.
     * @throws SQLException 
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
    
    /**
     * Función que permite a través del modo de cuenta, determinar en que ítem del ComboBox se debe posicionar el registro.
     * @param mod. Módo de cuenta del proveedor (beneficiario).
     * @return Devuelve el índex (int) del ComboBox para el modo de cuenta.
     */
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
    
    
    /**
     * Función que permite a través del tipo de cuenta, determinar en que ítem del ComboBox se debe posicionar el registro.
     * @param tipo. Tipo de cuenta del proveedor (beneficiario).
     * @return Devuelve el índex (int) del ComboBox para el Tipo de Cuenta.
     */
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
    
    /**
     * Función que permite a través del tipo de Identificación o Documento legar, determinar en que ítem del ComboBox se debe posicionar el registro.
     * @param tipo. Tipo de Identificación del proveedor. (V,E,J,P,G)
     * @return Devuelve el índex (int) del ComboBox para el tipo de identificación.
     */
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
    
    /**
     * Función que permite a través del banco, determinar en que ítem del registro se debe posicionar.
     * @param banco. Banco del proveedor (beneficiario).
     * @return Devuelve el índex (int) del ComboBox para el banco.
     */
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
   
    /**
     * Función que permite identificar si la identificación es válida, es decir, que únicamente sean dígitos numéricos.
     * @param identificacion. Identificación del proveedor.
     * @return Devuelve 
     */
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
    
    public boolean comprobacionFlotante(String F){
        boolean valido = true;
        String numero = F;
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
    
    public boolean comprobacionEntero(String I){
        boolean valido = true;
        String numero = I;
        for(int i = 0, cantidad_caracteres = numero.length(); i < cantidad_caracteres && valido; i++){
                //En cada iteracion preguntamos si es un digito numerico
                //En el momento que no lo sea, el ciclo terminara y no dejara pasar a los demas procedimientos
                char caracter = numero.charAt(i);
                if(!Character.isDigit(caracter)){
                    valido = false;
                }
        }
        return valido;
    }
}
