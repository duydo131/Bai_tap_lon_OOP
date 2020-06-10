package changing_sentence;

import java.text.SimpleDateFormat;
import java.util.Date;

import input.InputData;
import input.Tool;

public abstract class OverAllWeek extends Sentence{
	
	protected Date date1;
	protected Date date2;
	protected Date date;
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected String status;	
	
	public OverAllWeek(Date date) {
		this.date = date;
		this.date1 = Sentence.getWeek(date)[0];
		this.date2 = Sentence.getWeek(date)[1];
	}
	
	protected int weekendCounter() {
		int counter = 0;
		while (date2 != date1)
		if (InputData.isWeekend(date2)) {
			counter++;
			date2 = Tool.getDate(date2, -1);
		}
		return counter;
	}
}
