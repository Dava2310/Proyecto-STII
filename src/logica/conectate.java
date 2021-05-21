package logica;

import com.sun.istack.internal.logging.Logger;
import java.sql.*;
import java.util.logging.Level;

public class conectate {
    Connection con; //La "instacia" de la BD
    
    public conectate(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //CJ ES POR MySQL WorkBench y su libreria
            con = DriverManager.getConnection("jdbc:mysql://localhost/proveedor","root","1234");
            System.out.println("Conexion exitosa. ❤");
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Conexion fallida. 😪");
        }
    }
    public Connection getConnection(){
        return con;
    }
    
    public void desconectar(){
        try{
            System.out.println("Desconexion exitosa.");
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
