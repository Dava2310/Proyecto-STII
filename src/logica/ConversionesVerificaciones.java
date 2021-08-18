package logica;

/*
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
*/

public class ConversionesVerificaciones {
    
    /**
     * Esta función permite quitarle los espacios en blanco de antes, entre medias, y después de la cadena.
     * @param cadena. Cadena para quitarle los espacios.
     * @return Devuelve un String (la cadena de texto) sin espacios en blanco.
     */
    public String quitarEspacios(String cadena){
        String cadenaBuena = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ' && cadena.charAt(i) != '\n') {
                cadenaBuena = cadenaBuena + cadena.charAt(i);
            }
        }
        return cadenaBuena;
    }
    
    /*
    public String conversionDMY_YMD(String date, String initDateFormat, String endDateFormat) throws ParseException{
        String fecha = DiaTXT.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date data;
        String dateFinal = "";
        try {
            data = sdf.parse(Fecha);
            dateFinal = output.format(data);
        } catch (ParseException ex) {
            Logger.getLogger(TasaBsUSD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String semana = Semanatxt.getText();
        
        return "";
    }
    */
    
    /*
    public String conversionDecimalFormat(){
        
        double estMonto = 0111000;
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(10);
        String monto = df.format(estMonto);
        return "";
    }
    */
}
