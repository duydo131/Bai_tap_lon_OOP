package Sentence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import Input.*;

public class DaysTitle {
	
	protected static Date date1;
	protected static Date date2;
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected String status;	
	protected static int days = date1.getDay() - date2.getDay();
	
	public DaysTitle(Date date1, Date date2) {
		this.date1 = date1;
		this.date2 = date2;
	}
}
