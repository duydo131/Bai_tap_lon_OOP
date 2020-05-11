package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDay {
	public static boolean testDay(Date date) {
		SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
		Date dateBefore = new Date();
		Date dateAfter = new Date();
		try {
			dateBefore = formats.parse("01/10/2019");
			dateAfter = formats.parse("28/02/2020");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateBefore.getTime() <= date.getTime() && dateAfter.getTime() >= date.getTime();
	}
}
