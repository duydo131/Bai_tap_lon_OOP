package Input;

import java.util.Calendar;
import java.util.Date;

public class Format {
	public static double formatsDouble(double d) {
		return (double)Math.round(d*100)/100;
	}
	
	public static Date getDate(Date date, int number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.roll(Calendar.DAY_OF_YEAR, number);
		return calendar.getTime();
	}
	
	public static String formatLong(Long number) {
		return number > 1000000 ? Format.formatsDouble(number*1.0/1000000) + " triệu" : String.valueOf(number);
	}
	
}
