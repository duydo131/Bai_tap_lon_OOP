package Sentence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Input.*;

public class DayTitle {
	
	protected String status = null;
	protected Date date = null;
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	
	public DayTitle(Date date) {
		this.date = date;
	}
}
