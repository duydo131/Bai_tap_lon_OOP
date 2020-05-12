package ledung;

import java.text.SimpleDateFormat;
import java.util.Date;

import Input.InputData;

public class OverAllDays extends Sentence{
	
	protected Date date1;
	protected Date date2;
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected String status;	
	
	public OverAllDays(Date date1, Date date2) {
		this.date1 = date1;
		this.date2 = date2;
	}
	
	protected int weekendCounter() {
		int counter = 0;
		while (date2 != date1)
		if (InputData.isWeekend(date2)) {
			counter++;
			date2 = InputData.getYesterday(date2);
		}
		return counter;
	}
}
