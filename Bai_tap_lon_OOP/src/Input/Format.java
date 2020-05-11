package Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Format {
	public static double formatsDouble(double d) {
		return (double)Math.round(d*100)/100;
	}
	
	public static Date getDate(Date date, int number) {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		int change = number;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int temp = calendar.get(Calendar.DAY_OF_YEAR) + number;
		if(temp < 0 ) {
			try {
				calendar.setTime(formats.parse("31/12/" + (calendar.get(Calendar.YEAR) - 1)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			change = temp;
		}else if(temp > testYear(calendar.get(Calendar.YEAR))){
			try {
				calendar.setTime(formats.parse("01/01/" + (calendar.get(Calendar.YEAR) + 1)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			change = temp - testYear(calendar.get(Calendar.YEAR)) - 2;
		}
		calendar.roll(Calendar.DAY_OF_YEAR, change);
		return calendar.getTime();
	}
	
	private static int testYear(int year) {
		boolean test = false;
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					test = true;
				}
			}else {
				test = true;
			}
		}
		return test ? 366 : 365;
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
