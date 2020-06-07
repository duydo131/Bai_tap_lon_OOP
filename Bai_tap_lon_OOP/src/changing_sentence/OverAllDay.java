package changing_sentence;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class OverAllDay extends Sentence {
	
	protected Date date;
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");

	public OverAllDay(Date date) {
		this.date = date;
	}
}
