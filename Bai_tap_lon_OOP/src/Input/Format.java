package Input;

import java.util.Calendar;
import java.util.Date;

public class Format {
	public static double formatsDouble(double d) {
		return (double)Math.round(d*100)/100;
	}
	
	public static Date getDate(Date date, int number) {
		long oneDay = 24*60*60*1000;
		return new Date(date.getTime() + number*oneDay);
	}
	
	public static String formatLong(Long number) {
		return number > 1000000 ? Format.formatsDouble(number*1.0/1000000) + " triệu" : String.valueOf(number);
	}
	
	public static long formatMoney(double money) {
		return 10*(long)(Format.formatsDouble(money)*100) ;
	}
	
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}
}
