package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test2 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date date = formats.parse("20/02/2020");
		
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		
		calendar.roll(Calendar.DAY_OF_MONTH, -1);
		
		
		Date date1 = calendar.getTime();
		
		System.out.println(date1);
		
	}
}

