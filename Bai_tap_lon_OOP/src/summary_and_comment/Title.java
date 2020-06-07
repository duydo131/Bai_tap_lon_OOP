package summary_and_comment;

import java.text.SimpleDateFormat;
import java.util.Date;

import changing_sentence.Sentence;

public abstract class Title extends Sentence{
	
	protected static SimpleDateFormat formats = new SimpleDateFormat("dd/MM/yyyy");
	protected Date date;
	protected String adverb;
	
	public Title(Date date) {
		this.date = date;
		this.adverb = "Thị trường chứng khoán ngày " + formats.format(date) + ": ";
	}
}
