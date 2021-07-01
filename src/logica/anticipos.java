package logica;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class anticipos {
    conectate con;
    
    public anticipos(){
        con = new conectate();
    }
    
    //
    public void NuevoAnticipo(String motivo_anticipo, String fecha, String semana, double monto_bs, double monto_ds, String aprobacion, String observaciones, String DescontarODP, int codigo_proveedor, int cod_tasa)
    throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("insert into" +
                    " anticipos(Motivo_Anticipo, Fecha, Semana, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Codigo_Tasa)" + 
                    " values(?,?,?,?,?,?,?,?,?,?)");
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
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    //FUNCION PARA OBTENER DATOS DE TODOS LOS ANTICIPOS REALIZADOS
    public Object[][] getDatos() throws SQLException{
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
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
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
            Logger.getLogger(proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
    
    
    public void deleteAnticipo(String num_anticipo) throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from anticipos where Num_Anticipo = ?");
            pstm.setString(1, num_anticipo);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA ACTUALIZAR DATOS DE ANTICIPO
    public void updateAnticipo (String motivo_anticipo, String fecha, String semana, double monto_bs, double monto_ds, String aprobacion, String observaciones, String DescontarODP, int codigo_proveedor, int cod_tasa, int num_anticipo)
    throws SQLException{
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE anticipos" +
                    " set anticipos(Motivo_Anticipo, Fecha, Semana, Monto_BS, Monto_DS, Aprobacion, Observaciones, DescontarODP, Codigo_Proveedor, Codigo_Tasa)" + 
                    " values(?,?,?,?,?,?,?,?,?,?,?)" + " where Num_anticipo = ?");
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
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //FUNCION PARA REALIZAR UNA BUSQUEDA DEL ANTICIPO
    //UNICAMENTE DEVUELVE UN TRUE O FALSE DEPENDIENDO SI CONSIGUIO EL ANTICIPO
    public boolean buscarAnticipo(int num_anticipo) throws SQLException{
        boolean encontrado = false;
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM anticipos where Num_Anticipo = ?");
            pstm.setInt(1, num_anticipo);
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
        }catch(SQLException e){
            System.out.println(e);
        }
        return data2;
    }
    
    public Object[] informacion(ResultSet res, Object[] data){
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
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    
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
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                montos_anticipo[0] += res.getDouble("Monto_BS");
                montos_anticipo[1] += res.getDouble("Monto_DS");  
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return montos_anticipo;
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
