package batcommsystem.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ConverterDataTester {

	@Test
	public void test() {

		Calendar calendar = Calendar.getInstance();

		String string = "10/06/1981 17:55";
		Date dateTime = new Date();

		// Spliting Date

		calendar.setTime(dateTime);
		
		// Separando dia e mes e ano+hora
		String[] split = string.split("/");
		// Separando Ano e hora
		String[] split_year_time = split[2].split(" ");
		// Separando HORA e MINUTO
		String[] split_hora_min = split_year_time[1].split(":");
	
		/*
		System.out.println("ANO:" + split_year_time[0]);
		System.out.println("MES:" + split[1]);
		System.out.println("DIA:" + split[0]);
		System.out.println("HORA:" + split_hora_min[0]);
		System.out.println("MINUTO:" + split_hora_min[1]);
		*/

		// calendar.set(year, month, date, hourOfDay, minute, second);
		calendar.set(Integer.valueOf(split_year_time[0]),
				(Integer.valueOf(split[1])-1), //Começa com MÊS em 0 a 11
				Integer.valueOf(split[0]),
				Integer.valueOf(split_hora_min[0]),
				Integer.valueOf(split_hora_min[1]));

		dateTime.setTime(calendar.getTimeInMillis());
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println(df.format(dateTime));

	}

}
