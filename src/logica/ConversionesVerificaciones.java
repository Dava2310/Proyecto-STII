package logica;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConversionesVerificaciones {
    
    public String conversionDMY_YMD(String date, String initDateFormat, String endDateFormat) throws ParseException{
        /*
            String fecha = DiaTXT.getText();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date data;
                    String dateFinal = "";
                    try {
                        data = sdf.parse(fecha);
                        dateFinal = output.format(data);
                    } catch (ParseException ex) {
                        Logger.getLogger(TasaBsUSD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    String semana = Semanatxt.getText();
        */
        return "";
    }
    
    public String conversionDecimalFormat(){
        
        double estMonto = 0111000;
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
        String monto = df.format(estMonto);
        
        return "";
    }
    
}
