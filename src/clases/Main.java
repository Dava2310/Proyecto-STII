package clases;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.conectate;
import logica.proveedor;

public class Main {
    public static void main(String args[]){
        proveedor p = new proveedor();
        conectate con = new conectate();
        Object[][] sc;
        try {
            sc = p.getDatos();
            for(int i = 0; i < sc.length; i++){
            System.out.println("> " + sc[i][0] + " - " + sc[i][1] + " - " + sc[i][2] +
                    " - " + sc[i][3] + " - " + sc[i][4] + " - " + sc[i][5] + " - " + sc[i][6] +
                    " - " + sc[i][7] + " - " + sc[i][8] + " - " + sc[i][9] + " - " + sc[i][10] +
                    " - " + sc[i][11] + " - " + sc[i][12] + " - " + sc[i][13] + " - " + sc[i][14] + 
                    " - " + sc[i][15]); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectar();        
    }
}
