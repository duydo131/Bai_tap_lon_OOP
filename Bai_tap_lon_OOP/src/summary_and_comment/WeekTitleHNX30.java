package summary_and_comment;

import java.util.ArrayList;
import java.util.Date;

public class WeekTitleHNX30 extends WeekTitleStockClass{
	
	public WeekTitleHNX30(Date date) {
		super(date);
		this.subject = "HNX30";
	}
	
	@Override
	public ArrayList<String> getTag() {
		return listTag;
	}

	@Override
	public String get() {
		this.setVerb(subject);
		this.setComplement(subject);
		this.setAdverb();
		return adverb + subject + " " + verb + ", " + complement;
	}
	
	@Override
	public void setTag() {
		listTag.add("title");
		listTag.add("HNX30");
	}
}
