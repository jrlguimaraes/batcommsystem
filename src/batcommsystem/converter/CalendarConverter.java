package batcommsystem.converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("CalendarConverter")
public class CalendarConverter implements Converter  {
	
private static Date dateTime = new Date();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    	
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
    	System.out.println(string);
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
                
    	Calendar calendar = Calendar.getInstance();

		Date dateTime = new Date();

		calendar.setTime(dateTime);
		
		// Separando dia e mes e ano+hora
		String[] split = string.split("/");
		// Separando Ano e hora
		String[] split_year_time = split[2].split(" ");
		// Separando HORA e MINUTO
		String[] split_hora_min = split_year_time[1].split(":");


		// calendar.set(year, month, date, hourOfDay, minute, second);
		calendar.set(Integer.valueOf(split_year_time[0]),
				(Integer.valueOf(split[1])-1), //Começa com MÊS em 0 a 11
				Integer.valueOf(split[0]),
				Integer.valueOf(split_hora_min[0]),
				Integer.valueOf(split_hora_min[1]));

		dateTime.setTime(calendar.getTimeInMillis());
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println(df.format(dateTime));
        
        return dateTime;
        
    }//end method

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
                        
        return o.toString();
        
    }//end method
	

}
