package Sentence;

import java.text.SimpleDateFormat;
import java.util.Date;

import Input.*;

public class OverAllDay extends Sentence {
	
	protected static Date date;
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");

	public OverAllDay(Date day) {
		date = day;
	}
}
