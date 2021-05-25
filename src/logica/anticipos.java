package logica;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class anticipos {
    conectate con;
    
    public anticipos(){
        con = new conectate();
    }
    
    //
    public void NuevoAnticipo(String motivo_anticipo, String fecha, String monto_bs, String monto_ds, String aprobacion, String observaciones, String DescontarODP, String codigo_proveedor, String recien_creado){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " anticipos(Motivo_Anticipo, Fecha, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Recien_Creado)" + 
                    " values(?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, motivo_anticipo);
            pstm.setString(2, fecha);
            pstm.setString(3, monto_bs);
            pstm.setString(4, monto_ds);
            pstm.setString(5, aprobacion);
            pstm.setString(6, observaciones);
            pstm.setString(7, DescontarODP);
            pstm.setString(8, codigo_proveedor);
            pstm.setString(9, recien_creado);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    //FUNCION PARA OBTENER DATOS DE TODOS LOS ANTICIPOS REALIZADOS
    public Object[][] getDatos(){
        int registros = 0;
        //SE OBTIENEN LA CANTIDAD DE REGISTROS EXISTENTES EN LA TABLA DE ANTICIPOS
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM anticipos");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Object[][] data = new String[registros][10];
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
                    " Num_Anticipo, Motivo_Anticipo, Fecha, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Recien_Creado " +
                    " FROM anticipos "+
                    " ORDER BY Num_Anticipo");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estNum_Anticipo = res.getString("Num_Anticipo");
                String estMotivo_Anticipo = res.getString("Motivo_Anticipo");
                String estFecha = res.getString("Fecha");
                String estMonto_BS = res.getString("Monto_BS");
                String estMonto_DS = res.getString("Monto_DS");
                String estAprobacion = res.getString("Aprobacion");
                String estObservaciones = res.getString("Observaciones");
                String estDescontarODP = res.getString("DescontarODP");
                String estCodigo_Proveedor = res.getString("Codigo_Proveedor");
                String estRecien_Creado = res.getString("Recien_Creado");
                //SE INGRESAN LOS DATOS EN LA POSICION i del vector
                //TODAS LAS DEMAS POSICIONES REPRESENTAN LOS DATOS DE LOS PROVEEDORES
                data[i][0] = estNum_Anticipo;
                data[i][1] = estMotivo_Anticipo;
                data[i][2] = estFecha;
                data[i][3] = estMonto_BS;
                data[i][4] = estMonto_DS;
                data[i][5] = estAprobacion;
                data[i][6] = estObservaciones;
                data[i][7] = estDescontarODP;
                data[i][8] = estCodigo_Proveedor;       
                data[i][9] = estRecien_Creado;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    
    public void deleteAnticipo(String num_anticipo){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from anticipos where Num_Anticipo = ?");
            pstm.setString(1, num_anticipo);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA RETORNAR EL CODIGO DEL ANTICIPO RECIEN CREADO
    public String codigo_RecienCreado(){
        String num_anticipo = "";
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Num_Anticipo, Recien_Creado FROM anticipos" + 
                    " WHERE Recien_Creado = ?");
            pstm.setString(1,"SI");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                num_anticipo = res.getString("Num_Anticipo");
            }
        }catch(SQLException e){
            System.out.println(e);
            //System.out.println("Aqui fue el error");
        }
        return num_anticipo;
    }
    
    //FUNCION PARA ACTUALIZAR DATOS DE ANTICIPO
    public void updateAnticipo (String motivo_anticipo, String fecha, String monto_bs, String monto_ds, String aprobacion, String observaciones, String DescontarODP, String codigo_proveedor, String num_anticipo){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE anticipos" +
                    " set anticipos(Motivo_Anticipo, Fecha, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Recien_Creado)" + 
                    " values(?,?,?,?,?,?,?,?,?)" + "where Num_anticipo = ?");
            pstm.setString(1, motivo_anticipo);
            pstm.setString(2, fecha);
            pstm.setString(3, monto_bs);
            pstm.setString(4, monto_ds);
            pstm.setString(5, aprobacion);
            pstm.setString(6, observaciones);
            pstm.setString(7, DescontarODP);
            pstm.setString(8, codigo_proveedor);
            pstm.setString(9, num_anticipo);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA CAMBIAR EL ESTADO DEL ANTICIPO DE RECIEN CREADO
    public void updateEstado(String num_anticipo){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE anticipos set Recien_Creado = ? WHERE Num_Anticipo = ?");
            pstm.setString(1, "NO");
            pstm.setString(2, num_anticipo);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Aqui fue el error 2");
            System.out.println(e);
        }
    }
    
    //FUNCION PARA REALIZAR UNA BUSQUEDA DEL ANTICIPO
    //UNICAMENTE DEVUELVE UN TRUE O FALSE DEPENDIENDO SI CONSIGUIO EL ANTICIPO
    public boolean buscarAnticipo(String num_anticipo){
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM anticipos where Num_Anticipo = ?");
            pstm.setString(1, num_anticipo);
            ResultSet res = pstm.executeQuery();
            if(res.next()){
                encontrado = true;
            } else {
                encontrado = false;
            }
            res.close();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return encontrado;
    }
    
    //ESTA FUNCION ES PARA RETORNAR LOS DATOS DEL ANTICIPO EN ESPECIFICO
    public Object[] conseguirDatos(String num_anticipo){
        Object[] data = new Object[10];
        Object[] data2 = new Object[10];
        PreparedStatement pstm;
        ResultSet res;
        try{
            //CONSEGUIR LOS DATOS A TRAVES DEL NUM_ANTICIPO
            pstm = con.getConnection().prepareStatement("SELECT " + 
            " Num_Anticipo, Motivo_Anticipo, Fecha, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Recien_Creado " +
            " FROM anticipos " +
            " WHERE Num_Anticipo = ?");
            pstm.setString(1, num_anticipo);
            res = pstm.executeQuery();
            data2 = informacion(res, data);
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return data2;
    }
    
    public Object[] informacion(ResultSet res, Object[] data){
        try{
            while(res.next()){
                String estNum_Anticipo = res.getString("Num_Anticipo");
                String estMotivo_Anticipo = res.getString("Motivo_Anticipo");
                String estFecha = res.getString("Fecha");
                String estMonto_BS = res.getString("Monto_BS");
                String estMonto_DS = res.getString("Monto_DS");
                String estAprobacion = res.getString("Aprobacion");
                String estObservaciones = res.getString("Observaciones");
                String estDescontarODP = res.getString("DescontarODP");
                String estCodigo_Proveedor = res.getString("Codigo_Proveedor");
                String estRecien_Creado = res.getString("Recien_Creado");
                //INGRESANDO TODOS LOS DATOS EN EL VECTOR DATA[]
                data[0] = estNum_Anticipo;
                data[1] = estMotivo_Anticipo;
                data[2] = estFecha;
                data[3] = estMonto_BS;
                data[4] = estMonto_DS;
                data[5] = estAprobacion;
                data[6] = estObservaciones;
                data[7] = estDescontarODP;
                data[8] = estCodigo_Proveedor;
                data[9] = estRecien_Creado;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public int motivoAnticipo(String motivo){
        int index = 0;
        if(motivo.equals("Materia Prima")){
            index = 0;
        } else if(motivo.equals("Adicional")){
            index = 1;
        } else if(motivo.equals("Peaje")){
            index = 2;
        } else if(motivo.equals("Otros")){
            index = 3;
        }
        return index;
    }
    
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
