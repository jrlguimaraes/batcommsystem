package batcommsystem.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class CalendarTestCase {

	@Test
	public void test() {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(df.format(calendar.getTime()));
		calendar.set(1981, 6-1 , 10);
		
		System.out.println(df.format(calendar.getTime()));
		calendar.set(Calendar.DAY_OF_MONTH, 22);
		System.out.println(df.format(calendar.getTime()));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		System.out.println(df.format(calendar.getTime()));
		
		
		calendar.clear();
		System.out.println(df.format(calendar.getTime()));
	}

}
