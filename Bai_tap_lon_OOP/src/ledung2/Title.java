package ledung;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Title extends Sentence{
	
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected Date date;
	protected String adverb;
	
	public Title(Date date) {
		this.date = date;
		this.adverb = "Thị trường chứng khoán ngày " + formats.format(date) + ": ";
	}
}
